package com.github.jinghea.commonslang.conversions

import java.lang.{Long => JLong, Object => JObject, String => JString}
import java.math.{BigDecimal => JBigDecimal}
import java.util.{Collection => JCollection, HashMap => JHashMap, List => JList, Map => JMap, Set => JSet}

import scala.collection.mutable.{HashMap => MHashMap, Map => MMap}

import scala.collection.JavaConversions._


object MapConversion {

  implicit def map2JMap(fromMap: Map[String, Map[String, String]]) = {

    ((new JHashMap[JString, JMap[JString, JString]]) /: fromMap) {
      (map, e) => {

        val jNestedMap: JMap[JString, JString] = new JHashMap[JString, JString]
        e._2.foreach(ee => {
          jNestedMap.put(ee._1, ee._2)
        })

        map.put(e._1, jNestedMap)

        map
      }
    }
  }


  implicit def jMap2Map[A, B](jMap: JMap[A, B]) = {

    var map: Map[A, B] = Map.empty

    val keys = jMap.keySet()

    keys.foreach(k => {

      val v = jMap.get(k)

      map += (k -> v)
    })

    map
  }

  implicit def keyLong[A](map: Map[JLong, A]) = {

    map.map(e=>{
      val newKey:Long = e._1
      (newKey -> e._2)
    })

  }
}


