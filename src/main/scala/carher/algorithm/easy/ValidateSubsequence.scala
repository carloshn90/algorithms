package carher.algorithm.easy

import scala.annotation.tailrec

object ValidateSubsequence {


  @tailrec
  def isValidSubsequence(array: Array[Int], sequence: Array[Int], seqPos: Int = 0): Boolean = array match {
    case Array()                                  => seqPos == sequence.length
    case hTail if hTail.head == sequence(seqPos)  => isValidSubsequence(hTail.tail, sequence, seqPos + 1)
    case hTail                                    => isValidSubsequence(hTail.tail, sequence, seqPos)
  }
}
