package com.github.jinghea.commonslang.utils

/**
  * Created by jing on 30/11/16.
  */
object CollectionUtils {


  def replace[A](it: Iterable[A], replaceTo: A)(test: (A, A) => Boolean): Iterable[A] = {

    it.map(i => if (test(i, replaceTo)) replaceTo else i)
  }


  def merge[A](it: Iterable[A], replaces: Iterable[A])(test: (A, A) => Boolean): Iterable[A] = {

    it.map(i => {

      val found = replaces.find(r => test(i, r))

      found match {
        case Some(found) => found
        case None => i
      }
    })
  }

  def replaceAs[A](it: Iterable[A], replaceTo: A)(implicit m: AbsElementsCompare[A]): Iterable[A] ={
    it.map(i => if (m.test(i, replaceTo)) replaceTo else i)
  }
}


abstract class AbsElementsCompare[A]{
  def test(a: A, b:A): Boolean
}

object ElementsCompare{

  implicit object StringCompare extends AbsElementsCompare[String] {
    override def test(a: String, b:String): Boolean = a == b
  }
  implicit object IntCompare extends AbsElementsCompare[Int] {
    override def test(a: Int, b:Int): Boolean = a == b
  }
}
