package com.github.jinghea.commonslang.utils


import java.lang.{String => JString, Integer => JInteger, Long => JLong, Boolean => JBoolean}
import java.util.{List => JList}

import java.util.{Collection => JCollection, HashMap => JHashMap, List => JList, Map => JMap, Set => JSet}

import scala.collection.mutable.{HashMap => MHashMap, Map => MMap}

import scala.collection.JavaConversions._

/**
  * Created by jing on 21/06/16.
  */

object JavaBridgeUtils {

  import scala.collection.JavaConversions._

  def jList2Seq[A](items: JList[A]): Seq[A] = {
    items
  }

  def seq2JList[A](items: Seq[A]): JList[A] = {
    items
  }

  def jCollection2Iterable[A](coll: JCollection[A]): Iterable[A] = {
    coll
  }

  def map2JMap[A, B](items: Map[A, B]): JMap[A, B] = {

    items.foldLeft(new JHashMap[A, B]())((last, e) => {

      last.put(e._1, e._2)
      last

    })
  }

  def addToJCollection[A](coll: JCollection[A], toAdd: Iterable[A]): JCollection[A] = {

    toAdd.foreach(e => coll.add(e))
    coll
  }

  def safeJBooleanToBoolean(b: JBoolean): Boolean = {
    if (b == null) false else Boolean.box(b)
  }
}



