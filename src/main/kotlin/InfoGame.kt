package org.amosjuda

data class InfoGame(val info: InfoApiSharck) {
    override fun toString(): String {
        return info.toString()
    }
}