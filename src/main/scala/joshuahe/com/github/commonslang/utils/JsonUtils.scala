package joshuahe.com.github.commonslang.utils

;

import java.lang.{Long => JLong, Object => JObject, String => JString}
import java.util.{Collection => JCollection, HashMap => JHashMap, List => JList, Map => JMap, Set => JSet}

import com.fasterxml.jackson.databind.ObjectMapper

import scala.reflect.ClassTag

/**
  *
  * This class only support Java dto or general class. Doesn't support case class.
  * Created by Jing on 17/09/15.
  */
trait JsonUtils {

  def fromJson[A: ClassTag](json: String, valueType: Class[A]): A = {
    val objectMapper: ObjectMapper = new ObjectMapper()
    return objectMapper.readValue(json, valueType)

  }

  def toJson(obj: Object): String = {
    val objectMapper: ObjectMapper = new ObjectMapper()
    return objectMapper.writeValueAsString(obj)

  }
}
