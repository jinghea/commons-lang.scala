package com.github.jinghea.commonslang.utils

;

import java.lang.{Long => JLong, String => JString, Object => JObject}
import java.util.{Collection => JCollection, HashMap => JHashMap, List => JList, Set => JSet, Map => JMap}

/**
  * Created by Jing on 17/09/15.
  */
package object AmountUtils {

  def round(amount: BigDecimal): BigDecimal = {

    round(amount, 2)

  }


  def round(amount: BigDecimal, scale: Int): BigDecimal = {

    amount.setScale(scale, BigDecimal.RoundingMode.HALF_UP)

  }

  def calcPercent(amount: BigDecimal, total: BigDecimal): BigDecimal = {

    total match {

      case t if t > 0 => {

        val result = round(amount * 100 / t)

        result match {
          case l if l < 0 => 0
          case _ => result
        }
      }
      case _ => 0
    }
  }

}
