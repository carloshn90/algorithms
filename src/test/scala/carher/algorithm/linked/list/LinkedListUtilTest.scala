package carher.algorithm.linked.list

import carher.algorithm.UnitSpec

class LinkedListUtilTest extends UnitSpec {

  "Reverse empty LinkedList" should "return empty LinkedList" in {

    val result = LinkedListUtil.reverse(Nil)
    result shouldBe Nil
  }

  "Reverse LinkedList" should "return LinkedList reversed" in {

    val linkedList: LinkedList[Int] = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
    val linkedListReversed: LinkedList[Int] = 5 :: 4 :: 3 :: 2 :: 1 :: Nil

    val result = LinkedListUtil.reverse[Int](linkedList)
    result shouldBe linkedListReversed
  }

}
