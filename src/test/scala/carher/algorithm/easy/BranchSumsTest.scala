package carher.algorithm.easy

import carher.algorithm.UnitSpec
import carher.algorithm.tree.{Empty, Node}

class BranchSumsTest extends UnitSpec {

  "Branch sums in tree" should "sum the branches from left to right" in {
    //   BINARY TREE IN TEST
    //           1
    //       /      \
    //       2       3
    //     /   \    / \
    //    4     5  6   7
    //   /  \   /
    //  8    9 10

    val node7: Node[Int] = Node(7, Empty(), Empty())
    val node6: Node[Int] = Node(6, Empty(), Empty())
    val node9: Node[Int] = Node(9, Empty(), Empty())
    val node8: Node[Int] = Node(8, Empty(), Empty())
    val node10: Node[Int] = Node(10, Empty(), Empty())
    val node5: Node[Int] = Node(5, node10, Empty())
    val node4: Node[Int] = Node(4, node8, node9)
    val node3: Node[Int] = Node(3, node6, node7)
    val node2: Node[Int] = Node(2, node4, node5)
    val node1: Node[Int] = Node(1, node2, node3)

    val result: Array[Int] = BranchSums.branchSums(node1)

    result shouldBe Array(15, 16, 18, 10, 11)
  }

}
