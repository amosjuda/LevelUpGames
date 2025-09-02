package br.com.amos.leveupgames.main

import br.com.amos.leveupgames.model.Period
import br.com.amos.leveupgames.model.SignaturePlan
import br.com.amos.leveupgames.services.ApiConsumption
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main(){
    val consumption = ApiConsumption()
    val gamersList = consumption.gamersSearch()
    val listJsonGame = consumption.searchGameJson()

//    println(gamersList)
//    println(listJsonGame)

    val gamerCaroline = gamersList[3]
    val gameResidentVillage = listJsonGame[10]
    val gameSpiderman = listJsonGame[13]
    val gameTheLastofUsPartI = listJsonGame[2]
    val gameDandara = listJsonGame[5]
    val gameAssassins = listJsonGame[4]
    val gameCyber = listJsonGame[6]
    val gameGod = listJsonGame[7]
    val gameSkyrim = listJsonGame[18]

//    println(gamerCaroline)
//    println(gameResidentVillage)

    val period1 = Period(LocalDate.now(), LocalDate.now().plusDays(7))
    val period2 = Period(LocalDate.now(), LocalDate.now().plusDays(3))
    val period3 = Period(LocalDate.now(), LocalDate.now().plusDays(10))

    gamerCaroline?.gameRent(gameResidentVillage, period1)
    gamerCaroline?.gameRent(gameSpiderman, period2)
    gamerCaroline?.gameRent(gameTheLastofUsPartI, period3)
//    println(gamerCaroline?.rentedGames)

    val gamerCamila = gamersList.get(5)
    gamerCamila?.plan = SignaturePlan("PRATA", 9.90, 3, 0.15)

    gamerCamila?.gameRent(gameResidentVillage, period1)
    gamerCamila?.gameRent(gameSpiderman, period2)
    gamerCamila?.gameRent(gameTheLastofUsPartI, period3)
    gamerCamila?.gameRent(gameTheLastofUsPartI, period3)
//    println(gamerCamila?.rentedGames)

    gamerCamila?.recommended(7)
    gamerCamila?.recommended(10)
    gamerCamila?.recommended(8)
//    println(gamerCamila)

    gamerCamila?.gameRent(gameResidentVillage, period1)
//    println(gamerCamila?.rentedGames)

//    gamerCamila?.recomendGame(gameResidentVillage, 7)
//    gamerCamila?.recomendGame(gameTheLastofUsPartI, 10)
//
//    gamerCaroline?.recomendGame(gameResidentVillage, 8)
//    gamerCaroline?.recomendGame(gameTheLastofUsPartI, 9)
//
//    println("Camila and Caroline Recommendations -")
//    println(gamerCamila?.recommendedGames)
//    println(gamerCaroline?.recommendedGames)

    gamerCamila?.recomendGame(gameResidentVillage, 7)
    gamerCamila?.recomendGame(gameTheLastofUsPartI, 10)
    gamerCamila?.recomendGame(gameAssassins, 8)
    gamerCamila?.recomendGame(gameCyber, 7)
    gamerCamila?.recomendGame(gameGod, 10)
    gamerCamila?.recomendGame(gameDandara, 8)
    gamerCamila?.recomendGame(gameSkyrim, 8)
    gamerCamila?.recomendGame(gameSpiderman, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serialization = gson.toJson(gamerCamila?.recommendedGames)
    println(serialization)

    val file = File("RecommendedGames-${gamerCamila?.name}.json")
    file.writeText(serialization)
    println(file.absolutePath)
}