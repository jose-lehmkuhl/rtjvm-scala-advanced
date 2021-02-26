package lectures.part1as

import scala.util.Try

object DarkSugars extends App {

  def singleArgMethod(arg: Int): String = s"$arg little ducks..."

  val description = singleArgMethod {
    //complex code
    42
  }

  val aTryInstance = Try {
    throw new RuntimeException
  }

  List(1, 2, 3).map { x =>
    x + 1
  }


  //single abstract method
  trait Action {
    def act(x: Int): Int
  }

  val aInstance: Action = new Action {
    override def act(x: Int): Int = x + 1
  }

  val aFuncInstance: Action = (x: Int) => x + 1

  //example: Runnables
  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("hello scala")
  })
  val aSweeterThread = new Thread(() => println("hello scala"))

  abstract class AnAbstractType {
    def implemented: Int = 23
    def f(a: Int): Unit
  }
  val anAbstractInstance: AnAbstractType = (a: Int) => println("sweet")

  // :: #:: methods


}
