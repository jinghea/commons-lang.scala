package com.github.jinghea.commonslang.convert


import java.math.{BigDecimal => JBigDecimal}
import java.lang.{Integer => JInteger}
import java.lang.{Boolean => JBoolean}

import com.github.jinghea.commonslang.convert.Decorators._

/**
  * Created by jing on 11/11/16.
  */
trait DecorateAsScala {

  implicit def asScalaBigDecimalConverter(amount: JBigDecimal): AsScala[BigDecimal] =
    new AsScala(if (amount == null) BigDecimal(0) else amount)

  implicit def asScalaBooleanConverter(bool: JBoolean): AsScala[Boolean] =
    new AsScala(if (bool == null) false else bool.booleanValue())
}