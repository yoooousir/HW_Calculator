package com.example.calculator

fun main(){
    var testOn = true
    while(true){
        println("테스트하고 싶으신 레벨 숫자(1~3)를 입력해주세요. 이 외 숫자 입력 시 종료됩니다. ")
        when(readln().toInt()){
            1->Calculator().cal1()
            2->Calculator().cal2()
            3->Calculator()
            else->testOn=false
        }
    }
}