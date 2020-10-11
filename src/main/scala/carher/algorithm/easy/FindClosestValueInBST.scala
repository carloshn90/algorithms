package carher.algorithm.easy

import scala.annotation.tailrec

sealed trait Tree[+A]
case class Node[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]
case class Empty[A]() extends Tree[A]

object FindClosestValueInBST {

  @tailrec
  def findClosetValueInBst(tree: Tree[Int], target: Int, cValue: Int = 0): Int = tree match {
    case Empty()                  => cValue
    case Node(value, left, right) =>
      val vDiff = target - value
      val cDiff = target - cValue
      val newCValue = if (Math.abs(vDiff) <= Math.abs(cDiff)) value else cValue

      if (vDiff < 0) findClosetValueInBst(left, target, newCValue)
      else findClosetValueInBst(right, target, newCValue)
  }
}
