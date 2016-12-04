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

  "implicit replace as" should "replace items" in{

    import ElementsCompare._

    /** This method takes a List[A] returns an A which represent the combined value of applying the monoid operation successively across the whole list. Making the parameter m implicit here means we only have to provide the xs parameter at the call site, since if we have a List[A] we know what type A actually is and therefore what type Monoid[A] is needed. We can then implicitly find whichever val or object in the current scope also has that type and use that without needing to specify it explicitly. */

    assertResult("A,B"){
      CollectionUtils.replaceAs(Vector("A","B"), "B").mkString(",")
    }

    assertResult("1,2"){
      CollectionUtils.replaceAs(Vector(1,2), 3).mkString(",")
    }

    case class ThisVO(a:Int, b:String)

    implicit object ThisVOCompare extends AbsElementsCompare[ThisVO] {
      override def test(x: ThisVO, y:ThisVO): Boolean = x.a == y.a
    }

    assertResult("ThisVO(1,Hello),ThisVO(2,2)"){
      CollectionUtils.replaceAs(Vector(ThisVO(1, "1"),ThisVO(2,"2")), ThisVO(1,"Hello")).mkString(",")
    }
  }

}




