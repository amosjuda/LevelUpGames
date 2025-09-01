package br.com.amos.leveupgames.model

class LoosePlan(
    type: String): Plan(type) {

    override fun getValue(rent: Rent): Double {
        var originalValue = super.getValue(rent)
        if (rent.gamer.media > 8) {
            originalValue -= originalValue * 0.1
        }
        return originalValue
    }
}