package com.example.calculator

open class Calculator(){
    fun cal1(){
        var flag:Int=0
        if(flag==0) println("1~4 사이의 숫자를 입력하시면 숫자에 해당하는 연산자가 출력됩니다: (1: +, 2: -, 3: *, 4: /)")
        when(readln().toInt()){
            1->println("+")
            2->println("-")
            3->println("*")
            4->println("/")
            else -> {
                println("1~4에 해당하는 숫자를 입력해주세요.")
                flag=1
                cal1()
            }
        }
        println("종료되었습니다.")
    }

    fun cal2(){
        var flag:Int=0
        var num = 0
        while(true){
            if(flag==0) println("1~5 사이의 숫자를 입력하시면 숫자에 해당하는 연산자가 출력됩니다 (1: +, 2: -, 3: *, 4: /, 5: %). <-1 입력 시 종료>")
            num=readln().toInt()
            if(num==-1) {
                println("종료되었습니다.")
                break
            }
            else{
                if(num in 1..5){
                    when(num){
                        1->println("+")
                        2->println("-")
                        3->println("*")
                        4->println("/")
                        else->println("%")
                    }
                    flag=0
                }
                else{
                    println("1~5에 해당하는 숫자를 입력해주세요.")
                    flag=1
                }
            }
        }
    }
}

