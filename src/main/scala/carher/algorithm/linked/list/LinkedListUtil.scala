package carher.algorithm.linked.list

import scala.annotation.tailrec

sealed trait LinkedList[+A] {
  def value: A
  def next: LinkedList[A]

  def ::[B >: A](elem: B): LinkedList[B]
  def :+[B >: A](elem: B): LinkedList[B]
}

case class Node[+A](value: A, next: LinkedList[A] = Nil) extends LinkedList[A] {

  override def ::[B >: A](elem: B): LinkedList[B] = Node[B](elem, this)
  override def :+[B >: A](elem: B): LinkedList[B] = Node[B](elem, this)

  override def toString: String = s"head: $value, next: $next"
}

object Nil extends LinkedList[Nothing] {
  override def value: Nothing = throw new NoSuchElementException("head of empty list")
  override def next: LinkedList[Nothing] = throw new UnsupportedOperationException("tail of empty list")

  override def ::[B >: Nothing](elem: B): LinkedList[B] = Node[B](elem, this)
  override def :+[B >: Nothing](elem: B): LinkedList[B] = Node[B](elem, this)

  override def toString: String = s"Nil"
}

object LinkedListUtil {

  @tailrec
  def reverse[A](list: LinkedList[A], reverseList: LinkedList[A] = Nil): LinkedList[A] = list match {
    case Nil                => Nil
    case Node(value, Nil)   => reverseList :+ value
    case Node(value, next)  => reverse(next, reverseList :+ value)
  }
}
