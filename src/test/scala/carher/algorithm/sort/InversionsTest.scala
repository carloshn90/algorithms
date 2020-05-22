package carher.algorithm.sort

import carher.algorithm.UnitSpec

class InversionsTest extends UnitSpec {

  "Find inversion in array" should "return 6 inversions" in {
    val values: Array[Double] = Array(8, 4, 2, 1)
    Inversions.count(values) shouldBe 6
  }

  "Find inversion in array from file" should "return 2407905288 inversions" in {
    val bufferedSource = io.Source.fromFile("src/test/resources/IntegerArray.txt")
    val lines: Array[Double] = (for (line <- bufferedSource.getLines()) yield line).toArray.map(l => l.toDouble)
    bufferedSource.close()
    Inversions.count(lines) shouldBe 2407905288L
  }
}
