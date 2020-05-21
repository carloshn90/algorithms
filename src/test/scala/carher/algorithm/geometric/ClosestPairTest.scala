package carher.algorithm.geometric

import carher.algorithm.UnitSpec

class ClosestPairTest extends UnitSpec {

  "Find min distant in array of points" should "min distant between all the points" in {
    val points: Array[Point] = Array(
      Point(2, 3),
      Point(12, 30),
      Point(40, 50),
      Point(5, 1),
      Point(12, 10),
      Point(3, 4),
    )

    val minDist: Double = ClosestPair.findMinDistant(points)
    minDist shouldBe 1.414214 +- 0.00001
  }

  "Find min distant in empty array" should "return -1" in {

    val minDist: Double = ClosestPair.findMinDistant(Array())
    minDist shouldBe -1
  }

  "Find min distant with null array" should "return -1" in {

    val minDist: Double = ClosestPair.findMinDistant(null)
    minDist shouldBe -1
  }
}
