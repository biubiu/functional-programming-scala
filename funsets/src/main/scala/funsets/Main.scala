package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  println(singletonSet(1))
  println(union(Set(1,2,3), Set(3,4,5)))
}
