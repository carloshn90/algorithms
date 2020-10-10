package carher.algorithm.easy

import scala.annotation.tailrec
import scala.collection.immutable.HashMap


//  Write a function that takes in a non-empty array of distinct integers and an
//  integer representing a target sum. If any two numbers in the input array sum
//  up to the target sum, the function should return them in an array, in any
//  order. If no two numbers sum up to the target sum, the function should return
//  an empty array.

//  Note that the target sum has to be obtained by summing two different integers
//  in the array; you can't add a single integer to itself in order to obtain the
//  target sum.

//  You can assume that there will be at most one pair of numbers summing up to
//  the target sum.
object TwoNumberSum {

  @tailrec
  def twoNumberSum(arr: Array[Int], targetSum: Int, hashMap: HashMap[Int, Int] = new HashMap[Int,Int]()): Array[Int] = arr match {
    case Array()                                  => Array()
    case Array(head,_) if hashMap.contains(head)  => Array(hashMap(head), head)
    case hTail                                    =>
      val sumValueMap = hashMap + (targetSum - hTail.head -> hTail.head)
      twoNumberSum(hTail.tail, targetSum, sumValueMap)
  }
}
