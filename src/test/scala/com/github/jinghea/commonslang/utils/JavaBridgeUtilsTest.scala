package com.github.jinghea.commonslang.utils

import java.text.SimpleDateFormat

import com.github.jinghea.commonslang.test.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
  * Created by jing on 29/06/16.
  */


@RunWith(classOf[JUnitRunner])
class JavaBridgeUtilsTest extends UnitSpec {

  "get or else a None option" should "return the else object even it's null" in {

    val empty: Option[String] = Option(null)

    assertResult(null) {
      empty.getOrElse(null)
    }
  }

  "get or else a None option with function" should "return the function result" in {

    val empty: Option[String] = Option(null)

    assertResult(null) {
      empty.getOrElse(null)
    }
  }

}
