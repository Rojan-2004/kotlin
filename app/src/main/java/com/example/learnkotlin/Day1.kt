package com.example.firstapplication

fun main() {
    print("Please enter your age: ")
    val yourAge: Int = readln().toInt()

    if (yourAge < 16) {
        print("You are a child")
    } else if (yourAge < 19) {
        print("You are a teenager")
    } else if (yourAge < 35) {
        print("You are an adult")
    } else {
        print("You are a senior")
    }
    print("Please enter a day number of week : - ")
    var dayNumber: Int = readln().toInt()
    var day: String
    when (dayNumber)
    {
        1 -> day = "Sunday"
        2 -> day = "Monday"
        3 -> day = "Tuesday"
        4 -> day = "Wednesday"
        5 -> day = "Thursday"
        6 -> day = "Friday"
        7 -> day = "Saturday"
        else -> day = "Invalid  choice"
    }
    println(day)
    //for loop
    fun main() {
        println("For Loop:")
        for (i in 1..5) {
            println("Iteration: $i")
        }
    }
    //while loop
    println("While Loop:")
    var count = 1
    while (count <= 5) {
        println("Count: $count")
        count++
    }
    var age = arrayOf(1, 2, 3)
    println(age)
    println("The first Person age is " + age[0])
    println("The second Person age is " + age[1])
    println("The third Person age is " + age[2])
    println("*****************************")
    var name = arrayOf("ram", "shyam", "Hari")
    name[1] = "Niraj"
    println("The first Person name is " + name[0])
    println("The second Person name is " + name[1])
    println(name.size)

    var Name = arrayListOf<String> ("Niraj", "rojan", "shuvayu")
    Name.add ("aayush")
    Name. add (4, "Sabin")
    Name. remove ( "shuvayu")
    Name.removeAt (0)
    println (Name)
    // Immutable List
    val lst = listOf("mango", "orange", "banana")
    println("Mutable list")
    for (i in lst.indices) {
        println(lst[i])
    }
    println()
// Mutable List
    val mutableLst = mutableListOf("mango", "orange", "banana")
    mutableLst.add("grapes")
    println("Immutable list")
    for (i in mutableLst.indices) {
        println(mutableLst[i])
//for set
        val numbers = setOf(1, 2, 3, 4)
        for (elements in numbers) {
            println(elements)
        }
        val numbersBackwards = setOf(4, 3, 2, 1)
        println("The sets are equal: ${numbers == numbersBackwards}")
//for map
        val countriesCapitals = mapOf(
            "Nepal" to "Kathmandu",
            "China" to "Beijing",
            "India" to "New Delhi")
        println ("All keys : ${countriesCapitals.keys}")
        println("All values : ${countriesCapitals.values}")
        println("Capital of Nepal is : ${countriesCapitals["Nepal"]}")
    }
}

}