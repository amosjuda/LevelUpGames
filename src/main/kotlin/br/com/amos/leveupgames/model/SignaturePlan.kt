package br.com.amos.leveupgames.model

class SignaturePlan(
    type: String,
    val monthlyFee: Double,
    val includedGames: Int,
    val percentageDiscountReputation: Double,
    id: Int = 0): Plan(type, id) {

    override fun getValue(rent: Rent): Double {
        val totalGamesInTheMonth = rent.gamer.monthGames(rent.period.initialDate.monthValue).size+1

        return if (totalGamesInTheMonth <= includedGames) {
            0.0
        } else {
            var originalValue = super.getValue(rent)
            if (rent.gamer.media > 8){
                originalValue -= originalValue * percentageDiscountReputation
            }
            originalValue
        }
    }

    override fun toString(): String {
        return "Signature plan\n" +
                "Type: $type\n" +
                "Id: $id\n" +
                "monthly fee: $monthlyFee\n" +
                "Included Games: $includedGames\n" +
                "Reputation Discount Percentage: $percentageDiscountReputation\n"
    }
}
