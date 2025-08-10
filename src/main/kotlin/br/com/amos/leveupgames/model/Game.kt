package br.com.amos.leveupgames.model

data class Game (val title: String?, val cover: String?) {
    var description:String? = null
    var price = 0.0
    constructor(title: String?, cover: String, price: Double, description: String):
            this(title, cover) {
        this.price = price
        this.description = description
    }

    override fun toString(): String {
        return "My Game: \n" +
                "Title: $title \n" +
                "Cover: $cover \n" +
                "Description: $description\n" +
                "Price: $price"
    }   }