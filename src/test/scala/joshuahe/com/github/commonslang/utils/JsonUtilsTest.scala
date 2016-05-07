package joshuahe.com.github.commonslang.utils

import java.text.SimpleDateFormat

import joshuahe.com.github.commonslang.test.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.beans.BeanProperty

/**
  * Created by jing on 6/05/16.
  */


@RunWith(classOf[JUnitRunner])
class JsonUtilsTest extends UnitSpec with JsonUtils{




  "fromJson" should "conver json into the target class" in{

    val p:People = fromJson("""{"name":"Jack"}""", classOf[People])

    assertResult("Jack", "from json") {
      p.getName
    }
  }

  "toJson" should "convert object into json" in{

      val p = new People
      p.setName("People")

      assertResult("""{"name":"People"}""", "after convert") {
        toJson(p)
      }
  }
}

class People(){
  @BeanProperty
  var name:String = null

}

