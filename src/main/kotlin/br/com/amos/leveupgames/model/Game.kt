package br.com.amos.leveupgames.model

import com.google.gson.annotations.Expose

data class Game (@Expose val title: String?, @Expose val cover: String?): Recommended {
    var description:String? = null
    var price = 0.0
    private val gradeList = mutableListOf<Int>()

    override val media: Double
        get() = gradeList.average()

    override fun recommended(grade: Int) {
        gradeList.add(grade)
    }
    constructor(title: String?, cover: String, price: Double, description: String):
            this(title, cover) {
        this.price = price
        this.description = description
    }

    override fun toString(): String {
        return "\nMy Game: \n" +
                "Title: $title \n" +
                "Cover: $cover \n" +
                "Description: $description\n" +
                "Price: $price\n" +
                "Reputation: $media\n"
    }   }