package joshuahe.com.github.commonslang.utils

import java.text.SimpleDateFormat

import joshuahe.com.github.commonslang.test.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
  * Created by jing on 6/05/16.
  */

@RunWith(classOf[JUnitRunner])
class DateUtilsTest extends UnitSpec with DateUtils{

  "parse simple date" should "parse the simple date string into java date" in{

    val date = parseSimpleDate("2016-07-01")

    assertResult("2016-07-01 00:00:00"){

      val sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
      sf.format(date.get)
    }
  }

  "format a simple date" should "return a formated string date" in{

    val sf = new SimpleDateFormat("dd/MM/yyyy")
    val date = sf.parse("30/06/2017")

    assertResult("2017-06-30"){

      formatSimpleDate(date)

    }
  }

  "format a null date" should "return empty string" in{

    assertResult(""){
      formatSimpleDate(null)

    }
  }
}
