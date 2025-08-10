package br.com.amos.leveupgames.main

import br.com.amos.leveupgames.model.Gamer

fun main(){
    val gamer1 = Gamer(
        "Amos",
        "amos@gmail.com"
    )
    println(gamer1)

    val gamer2 = Gamer(
        "Juda",
        "juda@gmail.com",
        "19/12/1997",
        "Juudaa"
    )
    println(gamer2)

    gamer1.let {
        it.birthDate = "18/09/2002"
        it.user = "Aamoos"
    }.also {
        println(gamer1.internId)
    }

    println(gamer1)
    gamer1.user = "Amoss"
    println(gamer1)
}