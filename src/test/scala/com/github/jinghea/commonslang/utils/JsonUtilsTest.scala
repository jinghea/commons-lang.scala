package com.github.jinghea.commonslang.utils

import com.github.jinghea.commonslang.model.CaseSerializable
import com.github.jinghea.commonslang.test.UnitSpec
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

  "toJson with case class" should "convert object into json" in{

    val c = Company("GoodCom", Employee("John", 19))

    val json = toJson(c)

    assertResult(true, "after convert") {
      json.indexOf(s"""name":"GoodCom""")>=0
    }

    assertResult(true, "after convert") {
      json.indexOf(s"""name":"John""")>=0
    }

    assertResult(true, "after convert") {
      json.indexOf(s"""age":19""")>=0
    }

    assertResult(true, "after convert") {
      json.indexOf(s"""employee":{""")>=0
    }
  }
}

class People(){
  @BeanProperty
  var name:String = null

}

case class Company(name:String, employee:Employee) extends CaseSerializable{

}

case class Employee(name:String, age: Int) extends CaseSerializable{

}

