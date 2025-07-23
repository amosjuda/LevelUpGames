package org.amosjuda

data class InfoGame(val info: InfoApiSharck) {
    override fun toString() = info.toString()
}