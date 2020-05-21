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

  "Find min distant in array with more than 7 middle values" should "min distant between all the points" in {
    val points: Array[Point] = Array(
      Point(1, 1),
      Point(3, 2),
      Point(5, 1),
      Point(7, 2),
      Point(8, 3),
      Point(4, 1),
      Point(4, 2),
      Point(4, 3),
      Point(4, 4),
      Point(4, 4.8),
      Point(6, 6),
      Point(6, 7),
      Point(6, 8),
      Point(6, 9),
      Point(6, 10),
      Point(4, 11),
      Point(4, 12),
      Point(6, 13),
      Point(6, 14),
    )

    val minDist: Double = ClosestPair.findMinDistant(points)
    minDist shouldBe 0.799999 +- 0.00001
  }

  "Find min distant with only one point" should "return max double value" in {

    val minDist: Double = ClosestPair.findMinDistant(Array(Point(1, 3)))
    minDist shouldBe Double.MaxValue
  }

  "Find min distant between 2 points" should "return the distant between both points" in {

    val minDist: Double = ClosestPair.findMinDistant(Array(Point(1, 3), Point(4, 6)))
    minDist shouldBe 4.242641 +- 0.00001
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
