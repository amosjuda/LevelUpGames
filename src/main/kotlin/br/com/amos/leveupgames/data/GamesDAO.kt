package br.com.amos.leveupgames.data

import br.com.amos.leveupgames.data.DataBase.getEntityManager
import br.com.amos.leveupgames.model.Game

class GamesDAO {
    fun getGames(): List<Game> {
        val em = getEntityManager()
        return try {
            em.createQuery("SELECT g FROM Game g", Game::class.java).resultList
        } finally {
            em.close()
        }
    }

    fun addGame(game: Game) {
        val em = getEntityManager()
        try {
            em.transaction.begin()
            em.persist(game)
            em.transaction.commit()
        } catch (e: Exception) {
            if (em.transaction.isActive) {
                em.transaction.rollback()
            }
            throw e
        } finally {
            em.close()
        }
    }
}