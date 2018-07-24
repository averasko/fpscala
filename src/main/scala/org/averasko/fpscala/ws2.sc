import scala.annotation.tailrec

def isSorted[A](as: Array[A], sorted: (A,A) => Boolean) = {
  @tailrec
  def sortedFrom(i: Int): Boolean = if (i < as.length - 1) {
    sorted(as(i), as(i+1)) && sortedFrom(i+1)
  } else true

  sortedFrom(0)
}

def curry[A,B,C](f: (A,B) => C): A => B => C = (a: A) => (b: B) => f(a, b)

def uncurry[A,B,C](f: A => B => C): (A,B) => C = (a: A, b: B) => f(a)(b)

def compose[A,B,C](f: B => C, g: A => B): A => C = (a: A) => f(g(a))


val as = Array(3,6,8,10)

isSorted(as, (i1: Int, i2: Int) => i1 < i2)
