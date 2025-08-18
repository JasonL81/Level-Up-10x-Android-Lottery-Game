package com.example.levelup10x
import kotlin.random.Random

class LotteryMachine {

    private var firstUp = " "
    private var secondUp = " "
    private var thirdUp = " "
    private var fourthUp = " "
    private var columnPrize = " "

    private var firstUpClicked = false
    private var secondUpClicked = false
    private var thirdUpClicked = false
    private var fourthUpClicked = false
    private var columnPrizeClicked = false
    private var multiplierSet = false
    private var multipler = 1


    fun firstUpFun(): String {
        if (firstUpClicked == false) {
            firstUpClicked = true
            firstUp = prize()
            when (firstUp) {
                "2x" -> multiplierSet = true
                "5x" -> multiplierSet = true
                "10x" -> multiplierSet = true
            }
            when (firstUp) {
                "2x" -> multipler = 2
                "5x" -> multipler = 5
                "10x" -> multipler = 10
            }
        }
        return firstUp
    }


    fun secondUpFun(): String {
        if ((firstUp != "STOP") && (firstUpClicked == true && (secondUpClicked == false))) {
            secondUpClicked = true
            secondUp = prize()
            if (multiplierSet == false) {
                when (secondUp) {
                    "2x" -> multipler = 2
                    "5x" -> multipler = 5
                    "10x" -> multipler = 10
                }
                when (secondUp) {
                    "2x" -> multiplierSet = true
                    "5x" -> multiplierSet = true
                    "10x" -> multiplierSet = true
                }
            } else if (multiplierSet == true) {
                while ((secondUp == "2x") || (secondUp == "5x") || (secondUp == "10x")) {
                    secondUp = prize()
                }
            }
        }
        return secondUp
    }

    fun thirdUpFun(): String {
        if ((secondUp != "STOP") && (firstUp != "STOP") && (secondUpClicked == true) && (thirdUpClicked == false)) {
            thirdUpClicked = true
            thirdUp = prize()
            if (multiplierSet == false) {
                when (thirdUp) {
                    "2x" -> multipler = 2
                    "5x" -> multipler = 5
                    "10x" -> multipler = 10
                }
                when (thirdUp) {
                    "2x" -> multiplierSet = true
                    "5x" -> multiplierSet = true
                    "10x" -> multiplierSet = true
                }
            } else if (multiplierSet == true) {
                while ((thirdUp == "2x") || (thirdUp == "5x") || (thirdUp == "10x")) {
                    thirdUp = prize()
                }
            }
        }
        return thirdUp
    }

    fun fourthUpFun(): String {
        if ((thirdUp != "STOP") && (secondUp != "STOP") && (firstUp != "STOP") && (thirdUpClicked == true) && (fourthUpClicked == false)) {
            fourthUpClicked = true
            fourthUp = prize()
            if (multiplierSet == false) {
                when (fourthUp) {
                    "2x" -> multipler = 2
                    "5x" -> multipler = 5
                    "10x" -> multipler = 10
                }
                when (fourthUp) {
                    "2x" -> multiplierSet = true
                    "5x" -> multiplierSet = true
                    "10x" -> multiplierSet = true
                }
            } else if (multiplierSet == true) {
                while ((fourthUp == "2x") || (fourthUp == "5x") || (fourthUp == "10x")) {
                    fourthUp = prize()
                }
            }
        }
        return fourthUp
    }

    fun columnPrizeFun(): String {
        if ((fourthUp != "STOP") && (fourthUpClicked == true) && (columnPrizeClicked == false)) {
            columnPrizeClicked = true
            val randomPrize = Random.nextInt(1, 99)
            val prize = randomPrize * multipler
            columnPrize = "$$prize"
        }
        return columnPrize
    }

    private fun prize(): String {
        val prizes = arrayOf("UP", "STOP",  "2x", "5x", "10x")
        return prizes.random()
    }

    fun clear () {
        firstUp = " "
        secondUp = " "
        thirdUp = " "
        fourthUp = " "
        columnPrize = " "

        firstUpClicked = false
        secondUpClicked = false
        thirdUpClicked = false
        fourthUpClicked = false
        columnPrizeClicked = false
        multiplierSet = false
        multipler = 1
    }
}