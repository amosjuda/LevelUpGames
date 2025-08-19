package br.com.amos.leveupgames.model

import java.time.Period

data class Period(
    val initialDate: java.time.LocalDate,
    val finalDate: java.time.LocalDate) {
    val inDays = Period.between(initialDate, finalDate).days
}