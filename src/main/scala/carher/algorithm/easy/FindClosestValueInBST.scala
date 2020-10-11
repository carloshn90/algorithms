package carher.algorithm.easy

import scala.annotation.tailrec

sealed trait Tree[+A]
case class Node[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]
case class Empty[A]() extends Tree[A]

object FindClosestValueInBST {

  @tailrec
  def findClosetValueInBst(tree: Tree[Int], target: Int, cValue: Int = 0): Int = tree match {
    case Empty()                                      => cValue
    case Node(value, left, _) if (target - value) < 0 =>
      findClosetValueInBst(left, target, calculateCloset(value, target, cValue))
    case Node(value, _, right)                        =>
      findClosetValueInBst(right, target, calculateCloset(value, target, cValue))
  }

  def calculateCloset(value: Int, target: Int, cValue: Int): Int = {
    val vDiff = target - value
    val cDiff = target - cValue
    if (Math.abs(vDiff) <= Math.abs(cDiff)) value else cValue
  }
}
