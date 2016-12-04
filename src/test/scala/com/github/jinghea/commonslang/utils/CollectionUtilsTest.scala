package com.github.jinghea.commonslang.utils

import com.github.jinghea.commonslang.test.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
  * Created by jing on 1/12/16.
  */

@RunWith(classOf[JUnitRunner])
class CollectionUtilsTest extends UnitSpec with DateUtils {


  "replace an item" should "replace it" in {

    val col = Vector("A", "B", "QQ")

    val replaced = CollectionUtils.replace(col, "C")((a, b) => {
      if (a == "QQ") true else false
    })

    assertResult("A,B,C") {
      replaced.mkString(",")
    }

  }


  "merge items" should "replace items" in {

    val col = Vector("A", "B", "QQ")

    val toMerge = Vector("C", "D", "E")

    val replaced = CollectionUtils.merge(col, toMerge)((a, b) => {
      if (a == "QQ" && b == "E") true else false
    })

    assertResult("A,B,E") {
      replaced.mkString(",")
    }

  }

}




