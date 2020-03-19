import java.lang.Double.POSITIVE_INFINITY
import kotlin.math.min

fun coinChange(coins: IntArray, amount: Int): Int {
    val arr = DoubleArray(amount + 1)
    for (x in 1..amount) {
        var answer = POSITIVE_INFINITY
        for (coin in coins) {
            if (coin <= x) {
                answer = min((arr[x - coin] + 1), answer)
            }
        }
        arr[x] = answer
    }
    if (arr[amount] == POSITIVE_INFINITY) {
        return -1
    }
    return arr[amount].toInt()
}


fun main() {
    println(coinChange(intArrayOf(1, 2, 5), 11))
    println(coinChange(intArrayOf(2), 3))


}

//1. які значення ми обчислюємо? дати словесну відповідь. ціль - зрозуміти які значення будуть в кеші (на позиціях a[i] або a[i][j] etc)
// a[i] -  the fewest number of coins that you need to make up that amount
// c - номинал
//2. яке рекурентне співвідношення?
// a[i] = min(a[i], a[i-c)
//3. які початкові значення? значення для елементів кеша в яких не виконується пункт 2.
//4. в якому порядку обраховувати значення? зліва направо, зверху/вниз, зіг/заг
//5. де шукати відповідь? позиція кеша