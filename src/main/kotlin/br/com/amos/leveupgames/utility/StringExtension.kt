package br.com.amos.leveupgames.utility

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformIntoAge(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var age = 0
    val birthdate = LocalDate.parse(this, formatter)
    val today = LocalDate.now()
    age = Period.between(birthdate, today).years

    return age
}