package com.example.caculatorapp

import android.os.Bundle
import android.text.Editable
import android.text.Selection
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.caculatorapp.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var buttons = listOf<Button>()
    private var textExpression = Constants.DEFAULT.DEFAULT_STRING_EMPTY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setItemOnClicks()
    }

    private fun setItemOnClicks() {
        with(binding) {
            buttons = listOf(
                    buttonZero,
                    buttonOne,
                    buttonTwo,
                    buttonThree,
                    buttonFour,
                    buttonFive,
                    buttonSix,
                    buttonSeven,
                    buttonEight,
                    buttonNine,
                    buttonDot,
                    buttonDivision,
                    buttonAdd,
                    buttonMultiply,
                    buttonSubtract,
                    buttonCE,
                    buttonDelete,
                    buttonBracketOpen,
                    buttonBracketClose,
                    buttonSolve)
            buttons.forEach { it.setOnClickListener(this@MainActivity) }
        }
    }
    override fun onClick(view: View?) = with(binding) {
            when (view) {
                buttonDot -> addTextCalculator(Constants.NUMBER.DOT)
                buttonZero -> addTextCalculator(Constants.NUMBER.NUMBER_ZERO)
                buttonOne -> addTextCalculator(Constants.NUMBER.NUMBER_ONE)
                buttonTwo -> addTextCalculator(Constants.NUMBER.NUMBER_TWO)
                buttonThree -> addTextCalculator(Constants.NUMBER.NUMBER_THREE)
                buttonFour -> addTextCalculator(Constants.NUMBER.NUMBER_FOUR)
                buttonFive -> addTextCalculator(Constants.NUMBER.NUMBER_FIVE)
                buttonSix -> addTextCalculator(Constants.NUMBER.NUMBER_SIX)
                buttonSeven -> addTextCalculator(Constants.NUMBER.NUMBER_SEVEN)
                buttonEight -> addTextCalculator(Constants.NUMBER.NUMBER_EIGHT)
                buttonNine -> addTextCalculator(Constants.NUMBER.NUMBER_NINE)
                buttonDivision -> addTextCalculator(Constants.OPERATOR.OPERATOR_DIV)
                buttonSubtract -> addTextCalculator(Constants.OPERATOR.OPERATOR_SUB)
                buttonAdd -> addTextCalculator(Constants.OPERATOR.OPERATOR_PLUS)
                buttonMultiply -> addTextCalculator(Constants.OPERATOR.OPERATOR_MUL)
                buttonBracketClose -> addTextCalculator(Constants.OPERATOR.BRACKET_CLOSE)
                buttonBracketOpen -> addTextCalculator(Constants.OPERATOR.BRACKET_OPEN)
                buttonCE -> clearScreen()
                buttonDelete -> delete()
                buttonSolve -> {
                    val arrayPrefix = convertPrefix(textExpression)
                    val result = calculate(arrayPrefix).toString()
                    binding.tvResult.text = result
                    textExpression = Constants.DEFAULT.DEFAULT_STRING_EMPTY
                }

            }
        }

    private fun clearScreen() {
        binding.tvCalculator.text = Constants.DEFAULT.DEFAULT_ZERO
        binding.tvResult.text = Constants.DEFAULT.DEFAULT_ZERO
        textExpression = Constants.DEFAULT.DEFAULT_STRING_EMPTY
    }

    private fun delete() {
        textExpression =textExpression.substring(0,textExpression.length-Constants.DEFAULT.DEFAULT_NUMBER_ONE)
        binding.tvCalculator.text=textExpression
    }

    private fun addTextCalculator(text: String) {
        textExpression += text
        binding.tvCalculator.text = textExpression
    }

    private fun priority(operator: String) =  when(operator) {
            Constants.OPERATOR.OPERATOR_PLUS, Constants.OPERATOR.OPERATOR_SUB -> Constants.PRIORITY.PRIORITY_ONE
            Constants.OPERATOR.OPERATOR_DIV, Constants.OPERATOR.OPERATOR_MUL -> Constants.PRIORITY.PRIORITY_TWO
            else -> Constants.PRIORITY.PRIORITY_DEFAULT
    }

    private fun checkOperator(text: String): Boolean {
        if (text == Constants.OPERATOR.OPERATOR_PLUS ||
                text == Constants.OPERATOR.OPERATOR_MUL ||
                text == Constants.OPERATOR.OPERATOR_SUB ||
                text == Constants.OPERATOR.OPERATOR_DIV
        ) return true
        return false
    }

    private fun calculate(arrayPrefix: ArrayList<String>): Double {
        val stackNumber = Stack<Double>()
        for (i in arrayPrefix) {
            val num = i.toDoubleOrNull()
            if (num != null) stackNumber.push(num)
            else {
                val number1 = stackNumber.pop().toDouble()
                val number2 = stackNumber.pop().toDouble()
                when (i) {
                    Constants.OPERATOR.OPERATOR_PLUS -> stackNumber.push(number2 + number1)
                    Constants.OPERATOR.OPERATOR_SUB -> stackNumber.push(number2 - number1)
                    Constants.OPERATOR.OPERATOR_DIV -> stackNumber.push(number2 / number1)
                    Constants.OPERATOR.OPERATOR_MUL -> stackNumber.push(number2 * number1)
                }
            }

        }
        return if (stackNumber.isNotEmpty()) stackNumber.pop().toDouble() else Constants.DEFAULT.DEFAULT_DOUBLE_ZERO
    }

    private fun convertPrefix(text: String): ArrayList<String> {
        val arrayPrefix = ArrayList<String>()
        val stackOperator = Stack<String>()
        var num = Constants.DEFAULT.DEFAULT_STRING_EMPTY
        for (i in text.indices) {
            if (!checkOperator(text[i].toString())) {
                num += text[i]
                if (i == text.length - Constants.DEFAULT.DEFAULT_NUMBER_ONE) {
                    arrayPrefix.add(num)
                    num = Constants.DEFAULT.DEFAULT_STRING_EMPTY
                }
            } else {
                arrayPrefix.add(num)
                num = Constants.DEFAULT.DEFAULT_STRING_EMPTY
                while (!stackOperator.isEmpty() && priority(text[i].toString()) <= priority(
                                stackOperator.peek()
                        )
                ) {
                    arrayPrefix.add(stackOperator.pop())
                }
                stackOperator.push(text[i].toString())
            }
        }
        while (stackOperator.isNotEmpty()) {
            arrayPrefix.add(stackOperator.pop())
        }
        if (num.isNotEmpty()) {
            arrayPrefix.add(num)
        }
        return arrayPrefix
    }
}









