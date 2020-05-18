package carher.algorithm.sort

import scala.reflect.ClassTag

object MergeSort {

  def sort[A: ClassTag](values: Array[A])
                            (implicit goe:(A, A) => Boolean): Array[A] = sortByPosition(values, 0, values.length - 1)


  private def sortByPosition[A: ClassTag](values: Array[A], start: Int, end: Int)
                               (implicit goe:(A, A) => Boolean): Array[A] = {
    if (start < (end - 1))
      divideArrayMiddle(values, start, end)
    else
      merge(values.slice(start, end), values.slice(end, end + 1))
  }


  private def divideArrayMiddle[A: ClassTag](values: Array[A], start: Int, end: Int)
                                            (implicit goe:(A, A) => Boolean): Array[A] = {
    val middle: Int = Math.floor((start + end) / 2).toInt
    val left: Array[A] = sortByPosition(values, start, middle)
    val right: Array[A] = sortByPosition(values, middle + 1, end)
    merge(left, right)
  }

  private def merge[A: ClassTag](leftValues: Array[A], rightValues: Array[A])
                                      (implicit goe:(A, A) => Boolean): Array[A] =
    (leftValues, rightValues) match {
      case (Array(), Array())                                     => Array[A]()
      case (lValues, Array())                                     => lValues.head +: merge(lValues.tail, Array[A]())
      case (Array(), rValues)                                     => rValues.head +: merge(Array[A](), rValues.tail)
      case (lValues, rValues) if goe(rValues.head, lValues.head)  => lValues.head +: merge(lValues.tail, rValues)
      case (lValues, rValues) if goe(lValues.head, rValues.head)  => rValues.head +: merge(lValues, rValues.tail)
      case _                                                      => Array[A]()
  }

}
