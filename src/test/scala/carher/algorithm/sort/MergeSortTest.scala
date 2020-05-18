package carher.algorithm.sort

import carher.algorithm.UnitSpec
import carher.algorithm.sort.MergeSort.sort

class MergeSortTest extends UnitSpec {

  "Sort an array of Integer" should "return a sorted array" in {
    implicit def goe(lValue: Int, rValue: Int): Boolean = lValue >= rValue
    val valuesToSort = Array(1, 5, 6, 9, 2, 3, 8, 10)
    val valuesSorted = Array(1, 2, 3, 5, 6, 8, 9, 10)

    sort(valuesToSort) shouldBe valuesSorted
  }

  "Sort an array of Double" should "return a sorted array" in {
    implicit def goe(lValue: Double, rValue: Double): Boolean = lValue >= rValue
    val valuesToSort: Array[Double] = Array(1.2, 2.6, 6.0, 2.77, 3.89, 3.9, 8.0, 8.6)
    val valuesSorted: Array[Double] = Array(1.2, 2.6, 2.77, 3.89, 3.9, 6.0, 8.0, 8.6)

    sort(valuesToSort) shouldBe valuesSorted
  }

  "Sort an empty array" should "return an empty array" in {
    implicit def goe(lValue: Double, rValue: Double): Boolean = lValue >= rValue
    val valuesToSort: Array[Double] = Array()

    sort(valuesToSort) shouldBe Array()
  }

}
