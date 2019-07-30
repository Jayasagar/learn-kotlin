package com.jay.basics

class HelloWorld {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            println("Hello Kotlin")

            val c = 10
            var d = 12

            val k: Int = 12

            var str: String? = "abe"

            println(str?.length)

            println(isOdd(12))
            println(isEven(::isOdd))

//            val sumOfNNumbers:(Int) -> Int = { n -> n*((n+1)/2) }

            val sumOfNNumbers = { n:Int -> n*((n+1)/2) }
            println("${sumOfNNumbers(3)}")

            val numbers = listOf(1,2,3,4,5)

            val numbersGreater = numbers.count { it > 3 }
            println("numbersGreater count: $numbersGreater")

            var sum = 0
//            numbers.forEach { sum += it }
            numbers.forEach { number -> sum+=number }
            println("Sum : $sum")

            val maxValue = max(numbers) { x, y -> x < y}
            println("$maxValue")

            val increasBy = fun Int.(value: Int) = this + value
        }

        fun <T> max(collection: Collection<T>, lessFun: (T, T) -> Boolean): T? {
            var max:T? = null
            for (x in collection)
                if (max == null || lessFun(max, x))
                    max = x
            return max
        }

        fun isOdd(input: Int) = input % 2 == 0

        fun isEven(f: (Int) -> Boolean) = f(4)
    }

}