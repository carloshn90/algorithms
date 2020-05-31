package carher.algorithm.stack

import carher.algorithm.UnitSpec
import carher.algorithm.stack.ParenthesisBalance.check

import scala.collection.mutable

class ParenthesisBalanceTest extends UnitSpec {

  "Check empty array" should "return true" in {
    val stack = mutable.Stack[Char]()

    val emptyString: String = ""

    val isCorrect: Boolean = check(emptyString, stack)
    isCorrect shouldBe true
  }

  "Check wrong complex operation" should "return false" in {
    val stack = mutable.Stack[Char]()

    val operation: String = "(2 + 3) + {(3 - 1 - (2 + 2)}"

    val isCorrect: Boolean = check(operation, stack)
    isCorrect shouldBe false
  }

  "Check wrong position" should "return false" in {
    val stack = mutable.Stack[Char]()

    val operation: String = "(){)()(}"

    val isCorrect: Boolean = check(operation, stack)
    isCorrect shouldBe false
  }

  "Check correct complex operation" should "return true" in {
    val stack = mutable.Stack[Char]()

    val operation: String = "(2 + 3) + {(3 - 1) - (2 + 2)}"

    val isCorrect: Boolean = check(operation, stack)
    isCorrect shouldBe true
  }

}
