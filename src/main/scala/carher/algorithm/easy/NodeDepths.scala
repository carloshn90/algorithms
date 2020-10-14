package carher.algorithm.easy

import carher.algorithm.tree.{Empty, Node, Tree}


// The distance between a node in a Binary Tree and the tree's root is called the
// node's depth.
object NodeDepths {

  def nodeDepths(tree: Tree[Int], nDistance: Int = 0): Int = tree match {
    case Node(_, Empty(), Empty())  => nDistance
    case Node(_, left, Empty())     => nDistance + nodeDepths(left, nDistance + 1)
    case Node(_, Empty(), right)    => nDistance + nodeDepths(right, nDistance + 1)
    case Node(_, left, right)       => nDistance + nodeDepths(left, nDistance + 1) + nodeDepths(right, nDistance + 1)
  }

}
