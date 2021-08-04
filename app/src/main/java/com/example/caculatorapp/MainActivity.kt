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

<<<<<<< HEAD
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var buttons = listOf<Button>()
    private var textExpression = Constants.DEFAULT.DEFAULT_STRING_EMPTY

=======

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var buttons = listOf<Button>()
    private var textExpression = Constants.DEFAULT.DEFAULT_STRING_EMPTY
>>>>>>> ee04a61 (hoan thanh app caculator)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setItemOnClicks()
    }
<<<<<<< HEAD

    private fun setItemOnClicks(){
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
                buttonSolve
=======
    private fun setItemOnClicks(){
        with(binding) {
            buttons = listOf(
                btnZero,
                btnOne,
                btnTwo,
                btnThree,
                btnFour,
                btnFive,
                btnSix,
                btnSeven,
                btnEight,
                btnNine,
                btnDot,
                btnDiv,
                btnAdd,
                btnMul,
                btnSub,
                btnClear,
                btnDelete,
                btnPercent,
                btnResult
>>>>>>> ee04a61 (hoan thanh app caculator)
            )
        }
        buttons.forEach { it.setOnClickListener(this) }
    }
<<<<<<< HEAD

    override fun onClick(v: View?)= with(binding) {
        when (v) {
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
            buttonBracketClose->addTextCalculator(Constants.OPERATOR.BRACKET_CLOSE)
            buttonBracketOpen->addTextCalculator(Constants.OPERATOR.BRACKET_OPEN)
            buttonCE -> clearScreen()
            buttonDelete -> delete()
            buttonSolve -> {
                val arrayPrefix = convertPrefix(textExpression)
                val result = calculate(arrayPrefix).toString()
                binding.tvResult.text = result
=======
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_dot -> addTextCalculator(Constants.NUMBER.DOT)
            R.id.btn_zero -> addTextCalculator(Constants.NUMBER.NUMBER_ZERO)
            R.id.btn_one -> addTextCalculator(Constants.NUMBER.NUMBER_ONE)
            R.id.btn_two -> addTextCalculator(Constants.NUMBER.NUMBER_TWO)
            R.id.btn_three -> addTextCalculator(Constants.NUMBER.NUMBER_THREE)
            R.id.btn_four -> addTextCalculator(Constants.NUMBER.NUMBER_FOUR)
            R.id.btn_five -> addTextCalculator(Constants.NUMBER.NUMBER_FIVE)
            R.id.btn_six -> addTextCalculator(Constants.NUMBER.NUMBER_SIX)
            R.id.btn_seven -> addTextCalculator(Constants.NUMBER.NUMBER_SEVEN)
            R.id.btn_eight -> addTextCalculator(Constants.NUMBER.NUMBER_EIGHT)
            R.id.btn_nine -> addTextCalculator(Constants.NUMBER.NUMBER_NINE)
            R.id.btn_div -> addTextCalculator(Constants.OPERATOR.OPERATOR_DIV)
            R.id.btn_sub -> addTextCalculator(Constants.OPERATOR.OPERATOR_SUB)
            R.id.btn_add -> addTextCalculator(Constants.OPERATOR.OPERATOR_PLUS)
            R.id.btn_mul -> addTextCalculator(Constants.OPERATOR.OPERATOR_MUL)
            R.id.btn_percent -> addTextCalculator(Constants.OPERATOR.OPERATOR_Percentage)
            R.id.btn_clear -> {
                clearScreen()
            }
            R.id.btn_delete -> {
                delete()
            }
            R.id.btn_Result -> {
                val arrayPrefix = convertPrefix(textExpression)
                val result = calculate(arrayPrefix).toString()
                binding.txtResult.text = result
>>>>>>> ee04a61 (hoan thanh app caculator)
                textExpression = Constants.DEFAULT.DEFAULT_STRING_EMPTY
            }

        }
    }
<<<<<<< HEAD

    private fun clearScreen() {
        binding.tvCalculator.text = Constants.DEFAULT.DEFAULT_ZERO
        binding.tvResult.text = Constants.DEFAULT.DEFAULT_ZERO
        textExpression = Constants.DEFAULT.DEFAULT_STRING_EMPTY
    }

    private fun delete() {
        textExpression =textExpression.substring(0,textExpression.length-Constants.DEFAULT.DEFAULT_NUMBER_ONE)
        binding.tvCalculator.text=textExpression.toEditable()
    }

    private fun addTextCalculator(text: String){
            textExpression += text;
            binding.tvCalculator.text = textExpression.toEditable()
    }

    private fun priority(operator: String):Int{
        return when(operator){
            Constants.OPERATOR.OPERATOR_PLUS, Constants.OPERATOR.OPERATOR_SUB -> Constants.PRIORITY.PRIORITY_ONE
            Constants.OPERATOR.OPERATOR_DIV, Constants.OPERATOR.OPERATOR_MUL -> Constants.PRIORITY.PRIORITY_TWO
            else -> Constants.PRIORITY.PRIORITY_DEFAULT
        }
    }

=======
    private fun clearScreen() {
        binding.txtExpression.text = Constants.DEFAULT.DEFAULT_ZERO.toEditable()
        binding.txtResult.text = Constants.DEFAULT.DEFAULT_ZERO
        textExpression= Constants.DEFAULT.DEFAULT_STRING_EMPTY
        binding.txtExpression.text = textExpression.toEditable()
        binding.txtExpression.setSelection(binding.txtExpression.length());
    }
    private fun delete() {
        textExpression=binding.txtExpression.text.toString()
        if(textExpression.isNotEmpty()){
            binding.txtExpression.text=textExpression.substring(0, textExpression.length - 1).toEditable()
            textExpression=textExpression.substring(0, textExpression.length - 1)
        }

    }
    private fun addTextCalculator(text: String){
            textExpression += text;
            binding.txtExpression.text = textExpression.toEditable()
            binding.txtExpression.setSelection(binding.txtExpression.length());

    }
    private fun priority(operator: String):Int{
        return when(operator){
            Constants.OPERATOR.OPERATOR_PLUS, Constants.OPERATOR.OPERATOR_SUB -> 1
            Constants.OPERATOR.OPERATOR_DIV, Constants.OPERATOR.OPERATOR_MUL, Constants.OPERATOR.OPERATOR_Percentage -> 2
            else -> -1
        }
    }
>>>>>>> ee04a61 (hoan thanh app caculator)
    private fun checkOperator(text: String): Boolean{
        if(text == Constants.OPERATOR.OPERATOR_PLUS ||
            text == Constants.OPERATOR.OPERATOR_MUL ||
            text == Constants.OPERATOR.OPERATOR_SUB ||
<<<<<<< HEAD
            text == Constants.OPERATOR.OPERATOR_DIV) return true
        return false
    }

    private fun calculate(arrayPrefix: ArrayList<String>): Double {
        val stackNumber = Stack<Double>()
        for (i in arrayPrefix) {
            val num = i.toDoubleOrNull()
=======
            text == Constants.OPERATOR.OPERATOR_DIV||
            text == Constants.OPERATOR.OPERATOR_Percentage) return true
        return false
    }
    private fun calculate(arrayPrefix: ArrayList<String>): Double {
        val stackNumber = Stack<Double>()
        for (i in arrayPrefix) {
            val num: Double? = i.toDoubleOrNull()
>>>>>>> ee04a61 (hoan thanh app caculator)
            if (num != null) stackNumber.push(num)
            else {
                val number1 = stackNumber.pop().toDouble()
                val number2 = stackNumber.pop().toDouble()
                when (i) {
                    Constants.OPERATOR.OPERATOR_PLUS -> stackNumber.push(number2 + number1)
                    Constants.OPERATOR.OPERATOR_SUB -> stackNumber.push(number2 - number1)
                    Constants.OPERATOR.OPERATOR_DIV -> stackNumber.push(number2 / number1)
                    Constants.OPERATOR.OPERATOR_MUL -> stackNumber.push(number2 * number1)
<<<<<<< HEAD
=======
                    Constants.OPERATOR.OPERATOR_Percentage -> stackNumber.push(number2 % number1)
>>>>>>> ee04a61 (hoan thanh app caculator)
                }
            }

        }
<<<<<<< HEAD
        return if (stackNumber.isNotEmpty()) stackNumber.pop().toDouble() else Constants.DEFAULT.DEFAULT_DOUBLE_ZERO
    }

=======
        return if (!stackNumber.isEmpty()) stackNumber.pop().toDouble() else 0.0
    }
>>>>>>> ee04a61 (hoan thanh app caculator)
    private fun convertPrefix(token: String): ArrayList<String> {
        val arrayPrefix = ArrayList<String>()
        val stackOperator = Stack<String>()
        var num = " "
        for(i in token.indices){
            if (!checkOperator(token[i].toString())){
                num += token[i]
                if(i == token.length - 1){
                    arrayPrefix.add(num)
                    num = Constants.DEFAULT.DEFAULT_STRING_EMPTY
                }
            }else{
                arrayPrefix.add(num)
<<<<<<< HEAD
                num =Constants.DEFAULT.DEFAULT_STRING_EMPTY
                while(stackOperator.isNotEmpty() && priority(token[i].toString()) <= priority(
=======
                num =" "
                while(!stackOperator.isEmpty() && priority(token[i].toString()) <= priority(
>>>>>>> ee04a61 (hoan thanh app caculator)
                        stackOperator.peek()
                    )){
                    arrayPrefix.add(stackOperator.pop())
                }
                stackOperator.push(token[i].toString())
            }
        }
<<<<<<< HEAD
        while(stackOperator.isNotEmpty()){
=======
        while(!stackOperator.isEmpty()){
>>>>>>> ee04a61 (hoan thanh app caculator)
            arrayPrefix.add(stackOperator.pop())
        }
        if(num.isNotEmpty()){
            arrayPrefix.add(num)
        }
        return arrayPrefix
    }

    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

<<<<<<< HEAD
}
=======
}
>>>>>>> ee04a61 (hoan thanh app caculator)
