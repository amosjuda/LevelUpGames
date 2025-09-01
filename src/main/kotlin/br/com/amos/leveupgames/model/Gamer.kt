package br.com.amos.leveupgames.model

import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name:String, var email:String): Recommended {
    var birthDate:String? = null
    var user:String? = null
        set(value) {
            field = value
            if(internId.isNullOrBlank()) {
                createInternId()
            }
        }

    var internId:String? = null
        private set

    var plan: Plan = LoosePlan("BRONZE")
    val wantedGames = mutableListOf<Game?>()
    val rentedGames = mutableListOf<Rent?>()
    private val gradeLIst = mutableListOf<Int>()

    fun monthGames(mes:Int): List<Game> {
        return rentedGames
            .filter { rent ->  rent?.period?.initialDate?.monthValue == mes}
            .map { rent -> rent?.game as Game }
    }

    override val media: Double
        get() = gradeLIst.average()

    override fun recommended(grade: Int) {
        if(grade > 10.0 || grade < 1.0) {
            println("Invalid grade. Enter a grade between 1 and 10")
        } else {
            gradeLIst.add(grade)
        }
    }

    constructor(name:String, email:String, birthDate:String, user:String):
            this(name,email) {
                this.birthDate = birthDate
                this.user = user
                createInternId()
            }

    override fun toString(): String {
        return "Gamer(name=$name\n, email=$email\n, birthDate=$birthDate\n, user=$user\n, internId=$internId\n, Reputation=$media)\n"
    }

    fun createInternId() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        internId = "$user#$tag"
    }

    fun emailValidate(): String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if(regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Invalid email")
        }
    }

    fun gameRent(game: Game, period: Period): Rent {
        val rent = Rent(this, game, period)
        rentedGames.add(rent)
        return rent
    }

    companion object {
        fun createGamer(sc: Scanner): Gamer {
            println("Welcome to LevelUpGames! Let's register. Enter your name:")
            val name = sc.nextLine()
            println("Enter your email:")
            val email = sc.nextLine()
            println("Do you want to complete your registration with your username and date of birth? (Y/N)")
            val option = sc.nextLine()

            if(option.equals("s", true)){
                println("Enter your date of birth (DD/MM/YYYY):")
                val birthDate = sc.nextLine()
                println("Enter your username:")
                val user = sc.nextLine()

                return Gamer(name, email, birthDate, user)
            } else {
                return Gamer(name, email)
            }
        }
    }
}