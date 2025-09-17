package br.com.amos.leveupgames.model

class LoosePlan(
    type: String, id: Int = 0): Plan(type, id) {

    override fun getValue(rent: Rent): Double {
        var originalValue = super.getValue(rent)
        if (rent.gamer.media > 8) {
            originalValue -= originalValue * 0.1
        }
        return originalValue
    }

    override fun toString(): String {
        return "Loose Plan\n" +
                "Type: $type\n" +
                "Id: $id\n"
    }
}