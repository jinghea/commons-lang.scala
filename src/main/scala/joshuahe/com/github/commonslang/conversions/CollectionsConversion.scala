package joshuahe.com.github.commonslang.conversions

import java.lang.{Long => JLong, Object => JObject, String => JString}
import java.math.{BigDecimal => JBigDecimal}
import java.util.{Collection => JCollection, HashMap => JHashMap, List => JList, Map => JMap, Set => JSet}

import scala.collection.Map
import scala.collection.mutable.{HashMap => MHashMap, Map => MMap}


object MapConversion {

  implicit def map2JMap(fromMap: Map[String, Map[String, String]]) = {

    val map: JMap[JString, JMap[JString, JString]] = new JHashMap[JString, JMap[JString, JString]]


    fromMap.map(e => {

      val jNestedMap: JMap[JString, JString] = new JHashMap[JString, JString]

      e._2.foreach(ee => {
        jNestedMap.put(ee._1, ee._2)
      })

      map.put(e._1, jNestedMap)
    })

    map
  }
}


