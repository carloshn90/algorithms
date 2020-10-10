package carher.algorithm.easy

import carher.algorithm.UnitSpec

class TwoNumberSumTest extends UnitSpec {

  "Two number Sum" should "return 11, -1" in {
    val values: Array[Int] = Array(3, 5, -4, 8, 11, 1, -1, 6)
    val target: Int = 10

    val result: Array[Int] = TwoNumberSum.twoNumberSum(values, target)
    result shouldBe Array(11, -1)
  }

  "Two number Sum" should "empty array" in {
    val values: Array[Int] = Array(-21, 301, 12, 4, 65, 56, 210, 356, 9, -47)
    val target: Int = 164

    val result: Array[Int] = TwoNumberSum.twoNumberSum(values, target)
    result shouldBe Array()
  }

}
