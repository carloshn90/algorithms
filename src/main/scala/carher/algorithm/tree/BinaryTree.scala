package carher.algorithm.tree

sealed trait Tree[+A]
case class Node[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]
case class Empty[A]() extends Tree[A]
