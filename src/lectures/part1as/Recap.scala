package lectures.part1as

import scala.annotation.tailrec

object Recap extends App {

  val aCondition: Boolean = false
  val aConditionedVal = if (aCondition) 42 else 65

  val aCodeBlock = {
    if (aCondition) 54
    56
  }

  val theUnit = println("hello, Scala")

  def aFunction(x: Int): Int = x + 1

  @tailrec def factorial(n: Int, accumulator: Int): Int =
    if (n <= 1) accumulator
    else factorial(n - 1, accumulator * n)

  class Animal
  class Dog extends Animal
  val aDog: Animal = new Dog //subtyping polymorphism

  trait Carnivore {
    def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = println("Crunch")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog

  val aCarnivore = new Carnivore {
    override def eat(a: Animal): Unit = println("Roar")
  }

  //generics
  abstract class MyList[+A]

  //singletons and companions
  object MyList

  case class Person(name: String, age: Int)

  val throwsException = throw new RuntimeException
  val aPotentialFailure = try {
    throw new RuntimeException
  } catch {
    case e: Exception => "I caught an exception"
  } finally {
    println("some logs")
  }

  val incrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }

  incrementer(1)
  val anonymousIncrementer = (x: Int) => x + 1
  List(1, 2, 3).map(anonymousIncrementer)

  //for-comprehension
  val pairs = for {
    num <- List(1,2,3)//if guard ->  if num % 2 == 0
    char <- List("a", "b", "c")
  } yield num + "-" + char

  val aMap = Map(
    "Daniel" -> 789,
    "Jess" -> 555
  )

  val anOption = Some(2)

  //pattern matching
  val x = 2
  val order = x match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => x + "th"
  }

  val bob = Person("Bob", 22)
  val greeting = bob match {
    case Person(n, _) => s"Hi, my name is $n"
  }

}
