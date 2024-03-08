package com.example.calculator
fun main(){
    var testNum:Int = 0
    while(true){
        println("테스트하고 싶으신 레벨의 숫자(1~4)를 입력해주세요. 이 외 숫자 입력 시 종료됩니다.")
        testNum = readln().toInt()
        if(testNum<1 || testNum>4) break

        var num1:Double=0.0
        var num2:Double=0.0
        var cal:Int=0

        when(testNum){
            //레벨 1
            1->{
                println("테스트하고 싶으신 연산자 번호를 입력해주세요: (더하기: 1, 빼기: 2, 곱하기: 3, 나누기: 4)")
                cal = readln().toInt()
                var invalidInputCount=0
                while((cal>4 || cal<1)&&invalidInputCount<5) {
                    println("1~4 사이의 수를 입력해주세요: (더하기: 1, 빼기: 2, 곱하기: 3, 나누기: 4) (입력 오류:${++invalidInputCount}/5(회))")
                    cal = readln().toInt()
                }
                if(invalidInputCount==5) {
                    println("입력 오류 5회로 레벨 1 테스트가 종료되었습니다. 테스트를 계속하시려면 ")
                }
                else{
                    print("숫자 1 입력: ")
                    num1 = readln().toDouble()
                    print("숫자 2 입력: ")
                    num2 = readln().toDouble()
                    val result = Calculator(num1, num2)

                    when(cal){
                        1->println("$num1 + $num2 = ${result.add()}")
                        2->println("$num1 - $num2 = ${result.sub()}")
                        3->println("$num1 * $num2 = ${result.mul()}")
                        else-> println("$num1 / $num2 = ${result.div()}")
                    }
                    print("레벨 1 테스트가 종료되었습니다. 테스트를 계속하시려면 ")
                }
            }
            //레벨 2~3
            2,3->{
                while(true){
                    println("테스트하고 싶으신 연산자 번호(1~5)를 입력해주세요: (더하기: 1, 빼기: 2, 곱하기: 3, 나누기: 4, 나머지: 5); -1 입력 시 종료됩니다.")
                    cal = readln().toInt()
                    if(cal==-1) {
                        print("레벨 $testNum 테스트가 종료되었습니다. 테스트를 계속하시려면 ")
                        break
                    }
                    else{
                        var invalidInputCount=0
                        while(cal!=-1&&(cal<1 || cal>5)&&invalidInputCount<5){
                            println("1~5 사이의 수를 입력해주세요: (더하기: 1, 빼기: 2, 곱하기: 3, 나누기: 4, 나머지: 5); -1 입력 시 종료됩니다. (입력 오류:${++invalidInputCount}/5(회))")
                            cal = readln().toInt()
                        }
                        if(cal==-1 || invalidInputCount==5) {
                            if(invalidInputCount==5) print("입력 오류 5회로 ")
                            print("레벨 $testNum 테스트가 종료되었습니다. 테스트를 계속하시려면 ")
                            break
                        }
                        print("숫자 1 입력: ")
                        num1 = readln().toDouble()
                        print("숫자 2 입력: ")
                        num2 = readln().toDouble()
                        //level 2
                        if(testNum==2){
                            val result = Calculator(num1, num2)
                            when(cal){
                                1->println("$num1 + $num2 = ${result.add()}")
                                2->println("$num1 - $num2 = ${result.sub()}")
                                3->println("$num1 * $num2 = ${result.mul()}")
                                4->println("$num1 / $num2 = ${result.div()}")
                                else->println("$num1 % $num2 = ${result.rem()}")
                            }
                        }
                        //level 3
                        else{
                            when(cal){
                                1->println("$num1 + $num2 =  ${Add(num1, num2).calculate()}")
                                2->println("$num1 - $num2 = ${Sub(num1,num2).calculate()}")
                                3->println("$num1 * $num2 = ${Mul(num1,num2).calculate()}")
                                4->println("$num1 / $num2 = ${Div(num1,num2).calculate()}")
                                else->println("$num1 % $num2 = ${Rem(num1,num2).calculate()}")
                            }
                        }
                    }
                }
            }
            //lv 4
            else->{
                println("숫자와 연산자(+, -, *, /)를 활용한 올바른 식을 띄어쓰기 없이 한 문장으로 입력해주세요 (예: -1*7+635/9-0*10):")
                var formula = readln()
                var invalidInputCount=0
                while (!isValidFormulaInput(formula) && invalidInputCount<5) {
                    println("숫자와 연산자(+, -, *, /)를 활용한 올바른 식을 띄어쓰기 없이 한 문장으로 입력해주세요. (예: -1*7+635/9-0*10) (입력 오류:${++invalidInputCount}/5(회))")
                    formula = readln()
                }
                if(invalidInputCount==5) {
                    println("입력 오류 5회로 레벨 4 테스트가 종료되었습니다. 테스트를 계속하시려면 ")
                }
                else{
                    if (formula[0]=='-')formula = "0$formula"

                    println("위 식의 결과는 ${calculate(formula)} 입니다.")
                    println("레벨 4 테스트가 종료되었습니다. 테스트를 계속하시려면 ")
                }
            }
        }
    }
}

//곱셈과 나눗셈을 덧셈과 뺄셈보다 먼저 하는 함수
fun calculate(formula: String): Double {
    // 1단계: 숫자와 연산자 나누기
    val tokens = mutableListOf<String>()
    val currentNumber = StringBuilder()

    for (char in formula) {
        if (char in "+-*/") {
            if (currentNumber.isNotEmpty()) {
                tokens.add(currentNumber.toString())
                currentNumber.clear()
            }
            tokens.add(char.toString())
        } else {
            currentNumber.append(char)
        }
    }
    if (currentNumber.isNotEmpty()) {
        tokens.add(currentNumber.toString())
    }

    // 2단계: 곱셈과 나눗셈 먼저
    var index = 0
    while (index < tokens.size) {
        when (tokens[index]) {
            "*" -> {
                tokens[index - 1]=Mul(tokens[index-1].toDouble(), tokens[index+1].toDouble()).toString()
                tokens.removeAt(index)//연산자 지우기
                tokens.removeAt(index)//다음 숫자 지우기
                index--
            }
            "/" -> {
                tokens[index - 1] = Div(tokens[index-1].toDouble(), tokens[index+1].toDouble()).toString()
                tokens.removeAt(index)
                tokens.removeAt(index)
                index--
            }
            else -> {}
        }
        index++
    }

    // 3단계: 덧셈과 뺄셈 진행
    index = 0
    while (index < tokens.size) {
        when (tokens[index]) {
            "+" -> {
                tokens[index - 1] = Add(tokens[index-1].toDouble(), tokens[index+1].toDouble()).toString()
                tokens.removeAt(index)
                tokens.removeAt(index)
                index--
            }
            "-" -> {
                tokens[index - 1] = Sub(tokens[index-1].toDouble(), tokens[index+1].toDouble()).toString()
                tokens.removeAt(index)
                tokens.removeAt(index)
                index--
            }
            else -> {}
        }
        index++
    }

    return tokens.first().toDouble()
}

fun isValidFormulaInput(formula: String): Boolean {
    val regex = Regex("^-?[0-9]+([+\\-*/]-?[0-9]+)*$")
    return regex.matches(formula)
}