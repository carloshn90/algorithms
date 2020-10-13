package carher.algorithm.easy

import carher.algorithm.tree.{Empty, Node, Tree}


// Write a function that takes in a Binary Tree and returns a list of its branch
// sums ordered from leftmost branch sum to rightmost branch sum.
object BranchSums {

  def branchSums(tree: Tree[Int]): Array[Int] =
    calculate(tree, 0)

  private def calculate(tree: Tree[Int], branchSum: Int): Array[Int] = tree match {
    case Node(value, left, right) if left == Empty() && right == Empty()  => Array(branchSum + value)
    case Node(value, left, right) if left == Empty()                      => calculate(right, branchSum + value)
    case Node(value, left, right) if right == Empty()                     => calculate(left, branchSum + value)
    case Node(value, left, right)                                         =>
      calculate(left, branchSum + value) ++ calculate(right, branchSum + value)
  }
}
