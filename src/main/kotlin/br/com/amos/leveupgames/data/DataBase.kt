package br.com.amos.leveupgames.data

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object DataBase {
    private val emf: EntityManagerFactory by lazy {
        Persistence.createEntityManagerFactory("LevelUpGamesPU")
    }

    fun getEntityManager(): EntityManager {
        return emf.createEntityManager()
    }

    fun close() {
        if (emf.isOpen) {
            emf.close()
        }
    }
}