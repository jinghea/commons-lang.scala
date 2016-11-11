package com.github.jinghea.commonslang.convert

import com.github.jinghea.commonslang.test.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import java.math.{BigDecimal => JBigDecimal}
import java.lang.{Integer => JInteger}
import java.lang.{Boolean => JBoolean}

import com.github.jinghea.commonslang.convert.JavaConverters._

/**
  * Created by jing on 11/11/16.
  */

@RunWith(classOf[JUnitRunner])
class JavaConvertersTest extends UnitSpec {

  "convert java bigdecimal to " should "return scala bigdecimal" in {

    val amount = new JBigDecimal("10")

    assertResult(BigDecimal(10), "the scala bigdecimal") {
      amount.asScala
    }
  }

  "convert null java bigdecimal to " should "return 0" in {

    val amount: JBigDecimal = null

    assertResult(0, "the scala bigdecimal") {
      amount.asScala
    }
  }
}
