package br.com.amos.leveupgames.utility

import br.com.amos.leveupgames.model.Gamer
import br.com.amos.leveupgames.model.InfoGamerJson

fun InfoGamerJson.createGamer(): Gamer? {
    return if (this.name != null && this.email != null) {
        Gamer(
            name = this.name,
            email = this.email,
            birthDate = this.birthDate ?: "",
            user = this.user ?: ""
        )
        } else {
            null
        }
}