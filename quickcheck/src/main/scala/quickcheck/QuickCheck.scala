package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  property("min1") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("min2") = forAll{ (a:Int, b:Int)=>
     val h = insert(b, insert(a,empty))
     val m = if (a > b) a else b
     findMin(h) == m
  }

  property("del1") = forAll { (a: Int, b: Int) =>

  }

  lazy val genHeap: Gen[H] = for {
    k <- arbitrary[Int]
    m <- oneOf(empty, genHeap)
  } yield insert(k, m)


  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

}
