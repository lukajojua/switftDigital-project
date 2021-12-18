import java.util.*

fun main() {

    // task 1
    println(isPalindrome("12321"))

    // task 2
    println(minSplit(100))

    // task 3
    println(arrayOf(1, 2, 3).notContains())

    // task 4
    println(isProperly("()()()"))

    // task 5
    println(countWays(8))

    // task 6
    val list = mutableListOf(0, 1, 2, 3, 4, 5)
    val obj = CustomStructure(list)

    obj.remove(3)
    println(obj.list)

}

/** task 1 **/
fun isPalindrome(str: String) = (str == str.reversed())


/** task 2 **/
fun minSplit(int: Int): Int {
    var quantity = int
    var amount = 0
    val coins = listOf(50, 20, 10, 5, 1)
    coins.forEach { coin ->
        amount += quantity / coin
        quantity -= quantity / coin * coin

    }
    return amount
}

/** task 3 **/
fun Array<Int>.notContains(): Int? {
    return if (any()) {
        var integer = 1
        forEach { numbers ->
            if (numbers == integer) {
                integer++
            }
        }
        integer
    } else null
}

/** task 4 **/
fun isProperly(str: String): Boolean {
    val result: Boolean

    if (str.length % 2 == 0 && !str.startsWith(')') && !str.endsWith('(')) {
        var temp = str
        while (temp.startsWith('(') == temp.endsWith(')') || temp.startsWith(')') == temp.endsWith('(')) {
            temp = temp.drop(1)
            temp = temp.dropLast(1)
            if (temp.isBlank())
                break
        }
        return temp.isBlank()
    } else {
        result = false
    }
    return result
}

/** task 5 **/
fun fib(stairCount: Int): Int {
    return if (stairCount <= 1)
        stairCount
    else fib(stairCount - 1) + fib(stairCount - 2)
}

fun countWays(s: Int) = fib(s + 1)

/** task 6 **/
class CustomStructure(var list: MutableList<Int>) {

    private var map: MutableMap<Int, Int> = HashMap()

    init {
        for ((key, value) in list.withIndex()) {
            map[key] = value
        }
    }


    fun remove(pos: Int): Boolean {
        val index = map.remove(pos) ?: return false

        if (index != list.size - 1) {
            val elem = list[list.size - 1]
            list[index] = elem
            map[elem] = index
        }
        list.removeAt(list.size - 1)
        return true
    }

}
