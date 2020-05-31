package carher.algorithm.stack

import scala.annotation.tailrec
import scala.collection.mutable

object ParenthesisBalance {

  @tailrec
  def check(value: String, stack: mutable.Stack[Char]): Boolean =
    if (!value.isEmpty)
      check(value.tail, addElementStack(value.head, stack))
    else
      stack.isEmpty

  def addElementStack(c: Char, stack: mutable.Stack[Char]): mutable.Stack[Char]  =
    (this.isParenthesisOrBracket(c), this.isInStack(c, stack)) match {
      case (true, false)  => stack.push(c)
      case (true, true)   => removeLastElement(stack)
      case _              => stack
    }

  private def isInStack(c: Char, stack: mutable.Stack[Char]): Boolean = {
    val opposite = oppositeCloseElement(c)
    opposite.isDefined && getLastValueStack(stack) == opposite
  }

  private def getLastValueStack(stack: mutable.Stack[Char]): Option[Char] = stack match {
    case mutable.Stack() => None
    case _               =>
      val lastElement = stack.pop()
      stack.push(lastElement)
      Some(lastElement)
  }

  private def removeLastElement(stack: mutable.Stack[Char]): mutable.Stack[Char] = {
    stack.pop()
    stack
  }

  private def isParenthesisOrBracket(c: Char): Boolean = c match {
    case '(' => true
    case ')' => true
    case '{' => true
    case '}' => true
    case _   => false
  }

  private def oppositeCloseElement(c: Char): Option[Char] = c match {
    case ')' => Some('(')
    case '}' => Some('{')
    case _   => None
  }

}
