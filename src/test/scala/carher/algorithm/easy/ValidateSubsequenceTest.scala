package carher.algorithm.easy

import carher.algorithm.UnitSpec

class ValidateSubsequenceTest extends UnitSpec {

  "Valid subsequence" should "return true" in {
    val array: Array[Int] = Array(5, 1, 22, 25, 6, -1, 8, 10)
    val sequence: Array[Int] = Array(1, 6, -1, 10)

    val result: Boolean = ValidateSubsequence.isValidSubsequence(array, sequence)
    result shouldBe true
  }

  "Invalid subsequence" should "false" in {
    val array: Array[Int] = Array(5, 1, 22, 25, 6, -1, 8, 10)
    val sequence: Array[Int] = Array(5, 1, 22, 25, 6, -1, 8, 10, 12)

    val result: Boolean = ValidateSubsequence.isValidSubsequence(array, sequence)
    result shouldBe false
  }

}
