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
}
