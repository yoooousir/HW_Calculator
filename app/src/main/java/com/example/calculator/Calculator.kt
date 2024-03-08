package com.example.calculator

open class Calculator(open var num1: Double, open var num2: Double){
    open fun add(): Double = num1+num2
    open fun sub(): Double = num1-num2
    open fun mul(): Double = num1*num2
    open fun div(): Double {
        while(num2==0.0) {
            println("나누는 수는 0이 될 수 없습니다. num2를 다시 입력해주세요:")
            num2=readln().toDouble()
        }
        return num1/num2
    }
    open fun rem(): Double = num1%num2
}
open class Calc(open var num1:Double, open var num2:Double){
    open fun calculate():Double{
        return num1+num2
    }
}

class Add(override var num1:Double, override var num2:Double):Calc(num1,num2){
    override fun calculate(): Double {
        return num1+num2
    }
}
class Sub(override var num1:Double, override var num2:Double):Calc(num1,num2){
    override fun calculate(): Double {
        return num1-num2
    }
}
class Mul(override var num1:Double, override var num2:Double):Calc(num1,num2){
    override fun calculate(): Double {
        return num1*num2
    }
}
class Div(override var num1:Double, override var num2:Double):Calc(num1,num2){
    override fun calculate(): Double {
        while(num2==0.0) {
            println("나누는 수는 0이 될 수 없습니다. num2를 다시 입력해주세요:")
            num2=readln().toDouble()
        }
        return num1/num2
    }
}
class Rem(override var num1:Double, override var num2:Double):Calc(num1,num2){
    override fun calculate(): Double {
        return num1%num2
    }
}

