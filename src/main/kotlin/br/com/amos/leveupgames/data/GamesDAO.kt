package br.com.amos.leveupgames.data

import br.com.amos.leveupgames.model.Game
import javax.persistence.EntityManager

class GamesDAO(val em: EntityManager) {
    fun getGames(): List<Game> {
        return em.createQuery("SELECT g FROM Game g", Game::class.java).resultList
    }

    fun addGame(game: Game) {
        try {
            em.transaction.begin()
            em.persist(game)
            em.transaction.commit()
        } catch (e: Exception) {
            if (em.transaction.isActive) {
                em.transaction.rollback()
            }
            throw e
        }
    }
}