package com.example.levelup10x
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LevelUp10xViewModel : ViewModel() {

    //Objects for each individual column
    private val firstColumn = LotteryMachine()
    private val secondColumn = LotteryMachine()
    private val thirdColumn = LotteryMachine()
    private val fourthColumn = LotteryMachine()

    //Variables and Functions for first column
    var firstUp by (mutableStateOf(" "))
    var secondUp by (mutableStateOf(" "))
    var thirdUp by (mutableStateOf(" "))
    var fourthUp by (mutableStateOf(" "))
    var columnPrize by (mutableStateOf(" "))

    //Variables and Functions for second column
    var firstUp2 by (mutableStateOf(" "))
    var secondUp2 by (mutableStateOf( " "))
    var thirdUp2 by (mutableStateOf(" "))
    var fourthUp2 by (mutableStateOf(" "))
    var columnPrize2 by (mutableStateOf(" "))

    //Variables and Functions for third column
    var firstUp3 by (mutableStateOf(" "))
    var secondUp3 by (mutableStateOf(" "))
    var thirdUp3 by (mutableStateOf(" "))
    var fourthUp3 by (mutableStateOf(" "))
    var columnPrize3 by (mutableStateOf(" "))

    //Variables and Functions for fourth column
    var firstUp4 by (mutableStateOf(" "))
    var secondUp4 by (mutableStateOf(" "))
    var thirdUp4 by (mutableStateOf(" "))
    var fourthUp4 by (mutableStateOf(" "))
    var columnPrize4 by (mutableStateOf(" "))

    //Flashing Colors
    var state by (mutableStateOf(false))

    //Variables For Blinking Buttons
    var firstUpClicked = false;
    var secondUpClicked = false;
    var thirdUpClicked = false;
    var fourthUpClicked = false;
    var columnPrizeClicked = false;

    fun playLottery(input: Int) {
        when (input) {
            //First Column
            1 -> firstUp = firstColumn.firstUpFun()
            2 -> secondUp = firstColumn.secondUpFun()
            3 -> thirdUp = firstColumn.thirdUpFun()
            4 -> fourthUp = firstColumn.fourthUpFun()
            5 -> columnPrize = firstColumn.columnPrizeFun()
            //Second Column
            6 -> firstUp2 = secondColumn.firstUpFun()
            7 -> secondUp2 = secondColumn.secondUpFun()
            8 -> thirdUp2 = secondColumn.thirdUpFun()
            9 -> fourthUp2 = secondColumn.fourthUpFun()
            10 -> columnPrize2 = secondColumn.columnPrizeFun()
            //Third Column
            11 -> firstUp3 = thirdColumn.firstUpFun()
            12 -> secondUp3 = thirdColumn.secondUpFun()
            13 -> thirdUp3 = thirdColumn.thirdUpFun()
            14 -> fourthUp3 = thirdColumn.fourthUpFun()
            15 -> columnPrize3 = thirdColumn.columnPrizeFun()
            //Fourth Column
            16 -> firstUp4 = fourthColumn.firstUpFun()
            17 -> secondUp4 = fourthColumn.secondUpFun()
            18 -> thirdUp4 = fourthColumn.thirdUpFun()
            19 -> fourthUp4 = fourthColumn.fourthUpFun()
            20 -> columnPrize4 = fourthColumn.columnPrizeFun()
        }
    }

    //Variable for clearing game
    fun clear () {
        firstColumn.clear()
        secondColumn.clear()
        thirdColumn.clear()
        fourthColumn.clear()
        firstUp = " "
        secondUp = " "
        thirdUp  = " "
        fourthUp = " "
        columnPrize = " "
        firstUp2 = " "
        secondUp2 = " "
        thirdUp2  = " "
        fourthUp2 = " "
        columnPrize2 = " "
        firstUp3 = " "
        secondUp3 = " "
        thirdUp3 = " "
        fourthUp3 = " "
        columnPrize3 = " "
        firstUp4 = " "
        secondUp4 = " "
        thirdUp4  = " "
        fourthUp4= " "
        columnPrize4 = " "

        firstUpClicked = false
        secondUpClicked = false
    }
}










