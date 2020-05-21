package carher.algorithm.geometric

import scala.annotation.tailrec

final case class Point(x: Double, y: Double)

object ClosestPair {


  def findMinDistant(points: Array[Point]): Double = {

    if (points == null || points.length == 0) return -1

    if (points.length < 3)
      this.findClosestBruteForce(points)
    else {

      val pointsSortedByX: Array[Point] = points.sortWith((p1: Point, p2: Point) => p1.x <= p2.x)

      val (leftPoints: Array[Point], rightPoints: Array[Point]) = this.splitPointsByMiddle(pointsSortedByX)

      val leftDistant: Double = this.findMinDistant(leftPoints)
      val rightDistant: Double = this.findMinDistant(rightPoints)
      val minDistant: Double = this.minDistant(leftDistant, rightDistant)

      val centerPoints: Array[Point] = this.getCenterPointsByDelta(points, minDistant)

      if (centerPoints.length == 1) return minDistant

      val centerPointsSortedByY: Array[Point] = centerPoints.sortWith((p1: Point, p2: Point) => p1.y <= p2.y)
      val centerDistant: Double = this.checkCenterPoints(centerPointsSortedByY)

      if (centerDistant <= minDistant) centerDistant else minDistant
    }
  }

  private def splitPointsByMiddle(pointArray: Array[Point]): (Array[Point], Array[Point]) = {

    val n: Int = pointArray.length
    val m2: Int = Math.ceil(n / 2).toInt

    (pointArray.slice(0, m2), pointArray.slice(m2, pointArray.length))
  }

  private def minDistant(d1: Double, d2: Double): Double =
    if (d1 <= d2) d1 else d2

  private def calculateCenter(points: Array[Point]): Double = {
    val m2 = Math.floor(points.length / 2).toInt
    points(m2).x
  }

  private def getCenterPointsByDelta(points: Array[Point], delta: Double): Array[Point] = {
    val center: Double = this.calculateCenter(points)
    val init: Double = center - delta
    val end: Double = center + delta

    points.filter(point => point.x >= init && point.x <= end)
  }

  @tailrec
  private def findClosestBruteForce(points: Array[Point], minDist: Double = Double.MaxValue): Double = points match {
    case Array() => minDist
    case points => this.findClosestBruteForce(points.tail, this.calculateMinDistantByPoint(points.head, points.tail, minDist))
  }

  @tailrec
  private def calculateMinDistantByPoint(point: Point, tail: Array[Point], minDist: Double): Double = tail match {
    case Array()  => minDist
    case points   =>
      val distant = this.calculateDistant(point, points.head)
      val minDistAux: Double = if (distant <= minDist) distant else minDist
      this.calculateMinDistantByPoint(point, points.tail, minDistAux)
  }

  private def checkCenterPoints(points: Array[Point]): Double = {

    if (points.length == 1)
      return Double.MaxValue

    if (points.length < 8)
      this.findClosestBruteForce(points)
    else
      this.findClosestInCenter(points)
  }

  private def calculateDistant(p1: Point, p2: Point): Double = {

    val xSq: Double = Math.pow(p1.x - p2.x, 2)
    val ySq: Double = Math.pow(p1.y - p2.y, 2)

    Math.sqrt(xSq + ySq)
  }

  @tailrec
  private def findClosestInCenter(points: Array[Point], minDist: Double = Double.MaxValue): Double = points match {
    case Array() => minDist
    case points => this.findClosestInCenter(points.tail, this.calculateMinDistantByPoint(points.head, points.tail.slice(0, 7), minDist))
  }
}
