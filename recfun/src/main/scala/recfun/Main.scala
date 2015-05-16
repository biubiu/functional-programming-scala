package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * The following pattern of numbers is called Pascal’s triangle.
   *
   *       1
   *      1 1
   *     1 2 1
   *    1 3 3 1
   *   1 4 6 4 1
   *     ...
   * The numbers at the edge of the triangle are all 1,
   *  and each number inside the triangle is the sum of the two numbers above it.
   * Write a function that computes the elements of Pascal’s triangle by means of a recursive process.
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 )1
    else pascal(c - 1, r) + pascal(c - 1, r -1 )
  }

  /**
   * Exercise 2
   * Write a recursive function which verifies the balancing of parentheses in a string, which we represent as a List[Char] not a String. For example, the function should return true for the following strings:
   *
   * (if (zero? x) max (/ 1 x))
   * I told him (that it’s not (yet) done). (But he wasn’t listening)
   * The function should return false for the following strings:
   *     :-)
   *     ())(
   */
  def balance(chars: List[Char]): Boolean ={
    def balance0(chars:List[Char], count:Int):Boolean = {
       if(chars.isEmpty) {
         count == 0
       }
        else {
         chars.head match {
           case '(' => balance0(chars.tail,count + 1)
           case ')' => (count > 0) && balance0(chars.tail,count - 1)
           case _ => balance0(chars.tail,count)
         }
       }
    }
    balance0(chars,0)
  }

  /**
   * Exercise 3
   * Write a recursive function that counts how many different ways you can make change for an amount,
   * given a list of coin denominations. For example,
   * there are 3 ways to give change for 4 if you have coins with denomiation 1 and 2: 1+1+1+1, 1+1+2, 2+2.
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    println(money, coins)
    if(money == 0) 1
    else if(money < 0 || coins.isEmpty) 0
    else countChange(money, coins.tail) + countChange(money-coins.head,coins)
  }

}
