package br.com.amos.leveupgames.model

import com.google.gson.annotations.Expose
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "games")
data class Game (@Expose var title: String? = null, @Expose var cover: String? = null): Recommended {
    var description: String? = null
    var price = 0.0

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Transient
    private val gradeList = mutableListOf<Int>()

    override val media: Double
        get() = gradeList.average()

    override fun recommended(grade: Int) {
        gradeList.add(grade)
    }

    constructor(
        title: String?,
        cover: String?,
        price: Double,
        description: String?
    ) : this(title, cover) {
        this.price = price
        this.description = description
    }
}