package com.github.jinghea.commonslang.utils


import java.lang.{String => JString, Integer => JInteger, Long => JLong}
import java.util.{List => JList}

import java.util.{Collection => JCollection, HashMap => JHashMap, List => JList, Map => JMap, Set => JSet}

import scala.collection.Map
import scala.collection.mutable.{HashMap => MHashMap, Map => MMap}

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

  def map2JMap[A, B](items: Map[A, B]): JMap[A, B] = {

    items.foldLeft(new JHashMap[A, B]())((last, e) => {

      last.put(e._1, e._2)
      last

    })
  }
}



