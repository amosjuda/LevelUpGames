package br.com.amos.leveupgames.model

import kotlin.random.Random

data class Gamer(var name:String, var email:String) {
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

    constructor(name:String, email:String, birthDate:String, user:String):
            this(name,email) {
                this.birthDate = birthDate
                this.user = user
                createInternId()
            }

    init {
        if(name.isNullOrBlank()){
            throw IllegalArgumentException("The name is blank")
        }
        this.email = emailValidate()
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', birthDate=$birthDate, user=$user, internId=$internId)"
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
}