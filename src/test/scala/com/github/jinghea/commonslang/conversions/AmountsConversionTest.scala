package com.github.jinghea.commonslang.conversions


import java.math.{BigDecimal => JBigDecimal, RoundingMode}
import java.lang.{Integer => JInteger}

import com.github.jinghea.commonslang.test.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
  * Created by Jing on 11/08/15.
  */


@RunWith(classOf[JUnitRunner])
class AmountsConversionTest extends UnitSpec{


  "safeJBigDecimal2BigDecimal" should "return scala bigdecimal" in{


    val amount = new JBigDecimal("10")

    import com.github.jinghea.commonslang.conversions.AmountsConversion.safeJBigDecimal2BigDecimal
    val sAmount:BigDecimal = amount

    assertResult(BigDecimal(10), "the scala bigdecimal"){
      sAmount
    }
  }

  "safeJBigDecimal2BigDecimal with null" should "return scala bigdecimal with 0" in{


    val amount:JBigDecimal = null

    import com.github.jinghea.commonslang.conversions.AmountsConversion.safeJBigDecimal2BigDecimal
    val sAmount:BigDecimal = amount

    assertResult(BigDecimal(0), "the scala bigdecimal"){
      sAmount
    }
  }

  "bigDecimal2JBigDecimal" should "return java bigdecimal" in{

    val amount:BigDecimal = BigDecimal(10)

    import com.github.jinghea.commonslang.conversions.AmountsConversion.bigDecimal2JBigDecimal
    val jBigDecimal:JBigDecimal = amount

    assertResult(new JBigDecimal("10"), "the java bigdecimal"){
      jBigDecimal
    }
  }

  "int2JBigDecimal" should "return java bigdecimal" in{

    val amount:Int = 10

    import com.github.jinghea.commonslang.conversions.AmountsConversion.int2JBigDecimal
    val jBigDecimal:JBigDecimal = amount

    assertResult(new JBigDecimal("10"), "the java bigdecimal"){
      jBigDecimal
    }
  }


  "double2JBigDecimal" should "return java bigdecimal" in{

    val amount:Double = 10.98d

    import com.github.jinghea.commonslang.conversions.AmountsConversion.double2JBigDecimal
    val jBigDecimal:JBigDecimal = amount

    assertResult(new JBigDecimal("10.98"), "the java bigdecimal"){
      jBigDecimal.setScale(2, RoundingMode.HALF_UP)
    }
  }

  "safeJIntegerToIntOption" should "return option Int" in{

    val amount: JInteger = 10

    import com.github.jinghea.commonslang.conversions.AmountsConversion.safeJIntegerToIntOption
    val optAmount: Option[Int] = amount

    assertResult(Some(amount), "the optional amount"){
      optAmount
    }
  }

  "safeJIntegerToIntOption when null" should "return option None" in{

    val amount: JInteger = null

    import com.github.jinghea.commonslang.conversions.AmountsConversion.safeJIntegerToIntOption
    val optAmount: Option[Int] = amount

    assertResult(None, "the None"){
      optAmount
    }
  }
}
