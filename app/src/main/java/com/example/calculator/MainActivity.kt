package com.example.calculator

fun main(){
    var testNum:Int = 0
    while(true){
        println("테스트하고 싶으신 레벨의 숫자(1~3)를 입력해주세요. 이 외 숫자 입력 시 종료됩니다.")
        testNum = readln().toInt()
        if(testNum<1 || testNum>3) break

        var num1:Double=0.0
        var num2:Double=0.0
        var cal:Int=0

        when(testNum){
            1->{
                print("숫자 1: ")
                num1 = readln().toDouble()
                print("숫자 2: ")
                num2 = readln().toDouble()
                val result = Calculator(num1, num2)

                println("테스트하고 싶으신 연산자 번호를 입력해주세요: (더하기: 1, 빼기: 2, 곱하기: 3, 나누기: 4)")
                cal = readln().toInt()
                while(cal>4 || cal<1) {
                    println("1~4 사이의 수를 입력해주세요: (더하기: 1, 빼기: 2, 곱하기: 3, 나누기: 4)")
                    cal = readln().toInt()
                }
                when(cal){
                    1->println("더하기: ${result.add()}")
                    2->println("빼기: ${result.sub()}")
                    3->println("곱하기: ${result.mul()}")
                    else-> println("나누기: ${result.div()}")
                }
                print("레벨 1 테스트가 종료되었습니다. 테스트를 계속하시려면 ")
            }

            else->{
                while(true){
                    println("테스트하고 싶으신 연산자 번호(1~5)를 입력해주세요: (더하기: 1, 빼기: 2, 곱하기: 3, 나누기: 4, 나머지: 5); -1 입력 시 종료됩니다.")
                    cal = readln().toInt()
                    if(cal==-1) {
                        print("레벨 $testNum 테스트가 종료되었습니다. 테스트를 계속하시려면 ")
                        break
                    }
                    else{
                        while((cal<1 || cal>5)&&cal!=-1){
                            println("1~5 사이의 수를 입력해주세요: (더하기: 1, 빼기: 2, 곱하기: 3, 나누기: 4, 나머지: 5); -1 입력 시 종료됩니다.")
                            cal = readln().toInt()
                        }
                        if(cal==-1) {
                            print("레벨 $testNum 테스트가 종료되었습니다. 테스트를 계속하시려면 ")
                            break
                        }
                        print("숫자 1: ")
                        num1 = readln().toDouble()
                        print("숫자 2: ")
                        num2 = readln().toDouble()
                        //level 2
                        if(testNum==2){
                            val result = Calculator(num1, num2)
                            when(cal){
                                1->println("더하기: ${result.add()}")
                                2->println("빼기: ${result.sub()}")
                                3->println("곱하기: ${result.mul()}")
                                4->println("나누기: ${result.div()}")
                                else->println("나머지: ${result.rem()}")
                            }
                        }
                        //level 3
                        else{
                            when(cal){
                                1->println("더하기: ${Add(num1, num2).calculate()}")
                                2->println("빼기: ${Sub(num1,num2).calculate()}")
                                3->println("곱하기: ${Mul(num1,num2).calculate()}")
                                4->println("나누기: ${Div(num1,num2).calculate()}")
                                else->println("나머지: ${Rem(num1,num2).calculate()}")
                            }
                        }
                    }
                }
            }
        }
    }
}