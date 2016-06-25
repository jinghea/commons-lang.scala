package joshuahe.com.github.commonslang.utils


import java.lang.{String => JString, Integer => JInteger, Long => JLong}
import java.util.{List => JList}

/**
  * Created by jing on 21/06/16.
  */
object JavaBridgeUtils {

  import scala.collection.JavaConversions._

  def jList2Seq[A](items: JList[A]): Seq[A] = {
    items
  }

  def seq2JList[A](items: Seq[A]): JList[A] = {
    items
  }

}



