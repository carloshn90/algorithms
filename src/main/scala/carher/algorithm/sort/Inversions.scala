package carher.algorithm.sort

import scala.annotation.tailrec

object Inversions {

//  Counting inversions using Merge sort algorithm
  def count(values: Array[Double]): Long = {
    this.findInversions(values)._2
  }

  private def findInversions(values: Array[Double]): (Array[Double], Long) = {
    val (left: Array[Double], right: Array[Double]) = this.divideArrayMiddle(values)
    if (values.length <= 2) {
      this.merge(left, right)
    } else {
      val (leftSorted: Array[Double], leftInv: Long) = this.findInversions(left)
      val (rightSorted: Array[Double], rightInv: Long) = this.findInversions(right)
      this.merge(leftSorted, rightSorted, Array(), leftInv + rightInv)
    }
  }


  private def divideArrayMiddle(values: Array[Double]): (Array[Double], Array[Double]) = {
    val middle: Int = Math.floor((values.length - 1) / 2).toInt
    val left: Array[Double] = values.slice(0, middle + 1)
    val right: Array[Double] = values.slice(middle + 1, values.length)

    (left, right)
  }

  @tailrec // We are going to sort 100 thousand values for this reason is necessary to reuse memory in the recursion
  private def merge(left: Array[Double], right: Array[Double], sorted: Array[Double] = Array(), inv: Long = 0)
  : (Array[Double], Long) = (left, right) match {
    case (Array(), Array())                                 => (sorted, inv)
    case (lValues, Array())                                 => merge(lValues.tail, Array(), sorted :+ lValues.head, inv)
    case (Array(), rValues)                                 => merge(Array(), rValues.tail, sorted :+ rValues.head, inv)
    case (lValues, rValues) if rValues.head >= lValues.head => merge(lValues.tail, rValues, sorted :+ lValues.head, inv)
    case (lValues, rValues) if lValues.head >= rValues.head => merge(lValues, rValues.tail, sorted :+ rValues.head, inv + lValues.length)
    case _                                                  => (sorted, inv)
  }

}
