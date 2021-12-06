package day6

fun main() {
    val input = largeInput
        .trim()
        .split(',')
        .map { it.toInt() }

    lanternFish(days = 80, inputFish = input)
    lanternFish(days = 256, inputFish = input)
}

private fun lanternFish(days: Int, inputFish: List<Int>) {

    // An array containing the fish population by day.
    // E.g. fish[0] is the number of fish with their internal timer at 0.
    var fish = LongArray(9)
    for (f in inputFish) {
        fish[f]++
    }

    for (day in 1..days) {
        val nextFish = LongArray(9)
        for (i in 0..5) {
            nextFish[i] = fish[i + 1]
        }
        nextFish[6] = fish[0] + fish[7]
        nextFish[7] = fish[8]
        nextFish[8] = fish[0]
        fish = nextFish
    }
    println("total fish after $days days: ${fish.sum()}")
}

const val smallInput = "3,4,3,1,2"
const val largeInput = "3,5,2,5,4,3,2,2,3,5,2,3,2,2,2,2,3,5,3,5,5,2,2,3,4,2,3,5,5,3,3,5,2,4,5,4,3,5,3,2,5,4,1,1,1,5,1,4,1,4,3,5,2,3,2,2,2,5,2,1,2,2,2,2,3,4,5,2,5,4,1,3,1,5,5,5,3,5,3,1,5,4,2,5,3,3,5,5,5,3,2,2,1,1,3,2,1,2,2,4,3,4,1,3,4,1,2,2,4,1,3,1,4,3,3,1,2,3,1,3,4,1,1,2,5,1,2,1,2,4,1,3,2,1,1,2,4,3,5,1,3,2,1,3,2,3,4,5,5,4,1,3,4,1,2,3,5,2,3,5,2,1,1,5,5,4,4,4,5,3,3,2,5,4,4,1,5,1,5,5,5,2,2,1,2,4,5,1,2,1,4,5,4,2,4,3,2,5,2,2,1,4,3,5,4,2,1,1,5,1,4,5,1,2,5,5,1,4,1,1,4,5,2,5,3,1,4,5,2,1,3,1,3,3,5,5,1,4,1,3,2,2,3,5,4,3,2,5,1,1,1,2,2,5,3,4,2,1,3,2,5,3,2,2,3,5,2,1,4,5,4,4,5,5,3,3,5,4,5,5,4,3,5,3,5,3,1,3,2,2,1,4,4,5,2,2,4,2,1,4"