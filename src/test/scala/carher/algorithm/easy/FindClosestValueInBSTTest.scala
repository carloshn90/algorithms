package carher.algorithm.easy

import carher.algorithm.UnitSpec
import carher.algorithm.tree.{Node, Empty}

class FindClosestValueInBSTTest extends UnitSpec {

  "Find Closet value in BST" should "return 13" in {
    //   BINARY TREE IN TEST
    //         10
    //       /    \
    //      5     15
    //     / \    / \
    //    2   5  13 22
    //   /        \
    //  1          14

    val node1: Node[Int] = Node(1, Empty(), Empty())
    val node2: Node[Int] = Node(2, node1, Empty())
    val node5L: Node[Int] = Node(5, Empty(), Empty())
    val node5R: Node[Int] = Node(5, node2, node5L)
    val node14: Node[Int] = Node(14, Empty(), Empty())
    val node13: Node[Int] = Node(13, Empty(), node14)
    val node22: Node[Int] = Node(22, Empty(), Empty())
    val node15: Node[Int] = Node(15, node13, node22)
    val node10: Node[Int] = Node(10, node5R, node15)

    val result: Int = FindClosestValueInBST.findClosetValueInBst(node10, 12)

    result shouldBe 13
  }

}
