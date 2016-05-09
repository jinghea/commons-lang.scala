package joshuahe.com.github.commonslang.utils

import java.lang.{Long => JLong, Object => JObject, String => JString}
import java.util.{Collection => JCollection, HashMap => JHashMap, List => JList, Map => JMap, Set => JSet}

import com.fasterxml.jackson.databind.ObjectMapper
import joshuahe.com.github.commonslang.model.CaseSerializable

import scala.reflect.ClassTag

/**
  *
  * This class only support Java dto or general class. Doesn't support case class.
  * Created by Jing on 17/09/15.
  */
trait JsonUtils {

  def fromJson[A: ClassTag](json: String, valueType: Class[A]): A = {
    val objectMapper: ObjectMapper = new ObjectMapper()
    objectMapper.readValue(json, valueType)

  }

  def toJson(obj: Object): String = {

    val objectMapper: ObjectMapper = new ObjectMapper()

    isCaseSerializable(obj) match{
      case true => objectMapper.writeValueAsString(caseClass2JMap(obj))
      case false => objectMapper.writeValueAsString(obj)
    }
  }

  def isCaseSerializable(obj:Object): Boolean = {
     obj.isInstanceOf[CaseSerializable]
  }

  def caseClass2JMap(obj:AnyRef):JMap[String, Object] = {

   (new JHashMap[String, Object]() /: obj.getClass.getDeclaredFields) { (a, f) =>
      f.setAccessible(true)
     isCaseSerializable(f.get(obj)) match{
        case true => a.put(f.getName, caseClass2JMap(f.get(obj)))
        case false => a.put(f.getName, f.get(obj))
      }
      a
    }
  }

}
