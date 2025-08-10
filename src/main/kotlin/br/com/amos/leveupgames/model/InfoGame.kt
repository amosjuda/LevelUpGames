package br.com.amos.leveupgames.model

data class InfoGame(val info: InfoApiSharck) {
    override fun toString() = info.toString()
}