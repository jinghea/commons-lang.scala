package com.github.jinghea.commonslang.utils

import com.github.jinghea.commonslang.test.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
  * Created by jing on 15/11/16.
  */

@RunWith(classOf[JUnitRunner])
class ObjectUtilsTest extends UnitSpec {

  "doForFields" should "doForFields" in {

    val o = O(BigDecimal(1.11), BigDecimal(5.55), BigDecimal(3), "This is O")

    val res = ObjectUtils.applyForFields(o, f => {
      f.isInstanceOf[BigDecimal] match {
        case true => f.asInstanceOf[BigDecimal].setScale(0, BigDecimal.RoundingMode.HALF_UP)
        case false => f
      }
    })

    assertResult(BigDecimal(6)) {
      res.b
    }

    val res1 = ObjectUtils.applyForFields(o, f => {
      f.isInstanceOf[String] match {
        case true => f.asInstanceOf[String] + "."
        case false => f
      }
    })

    assertResult("This is O.") {
      res1.d
    }

  }

}


case class O(a: BigDecimal, b: BigDecimal, c: BigDecimal, d: String)
