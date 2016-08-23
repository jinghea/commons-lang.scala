package com.github.jinghea.commonslang.conversions

import java.lang.{Long => JLong, Object => JObject, String => JString}
import java.util.{Collection => JCollection, HashMap => JHashMap, List => JList, Map => JMap, Set => JSet}

import com.github.jinghea.commonslang.test.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.collection.Map
import scala.collection.mutable.{HashMap => MHashMap, Map => MMap}

import com.github.jinghea.commonslang.conversions.MapConversion.map2JMap

/**
 * Created by Jing on 7/04/2016.
 */


@RunWith(classOf[JUnitRunner])
class MapConversionTest extends UnitSpec {


  "test map2JMap" should "return java map" in {

    val fromMap: Map[String, Map[String, String]] = Map("RP" -> Map("A" -> "1", "B" -> "2"), "RP01" -> Map("A01" -> "0101"))

    val map: JMap[JString, JMap[JString, JString]] = fromMap


    assertResult(2, "the converted map size") {
      map.size()
    }

    assertResult("1", "The A in RP") {
      map.get("RP").get("A")
    }

    assertResult("2", "The B in RP") {
      map.get("RP").get("B")
    }

    assertResult("0101", "The A in RP01") {
      map.get("RP01").get("A01")
    }

  }
}
