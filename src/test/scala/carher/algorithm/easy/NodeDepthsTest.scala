package carher.algorithm.easy

import carher.algorithm.UnitSpec
import carher.algorithm.tree.{Node, Empty}

class NodeDepthsTest extends UnitSpec {

  "Sum of its nodes' depths" should "return 16" in {
    //   BINARY TREE IN TEST
    //         1
    //       /    \
    //      2      3
    //     / \    / \
    //    4   5  6   7
    //   / \
    //  8   9

    val node7: Node[Int] = Node(1, Empty(), Empty())
    val node6: Node[Int] = Node(2, Empty(), Empty())
    val node3: Node[Int] = Node(3, node6, node7)
    val node5: Node[Int] = Node(5, Empty(), Empty())
    val node9: Node[Int] = Node(9, Empty(), Empty())
    val node8: Node[Int] = Node(8, Empty(), Empty())
    val node4: Node[Int] = Node(4, node8, node9)
    val node2: Node[Int] = Node(2, node4, node5)
    val node1: Node[Int] = Node(1, node2, node3)

    val result: Int = NodeDepths.nodeDepths(node1)

    result shouldBe 16
  }

}
