package com.github.jinghea.commonslang.utils

/**
  * Created by jing on 15/11/16.
  */
object ObjectUtils {


  /**
    * The target class need to have a apply method. Mostly use for case class.
    */
  def applyForFields[T](obj: T, applyForField: Object => Object): T = {

    val fields = obj.getClass.getDeclaredFields

    val values = fields.map(f => {

      f.setAccessible(true)
      applyForField(f.get(obj))
    })

    val applyMethod = obj.getClass.getDeclaredMethods.find(m => m.getName == "apply")

    val result = applyMethod match {
      case Some(applyMethod) => {
        applyMethod.invoke(null, values: _*)
      }
      case None => throw new NoSuchMethodException("The target class doesn't have a apply method")
    }

    result.asInstanceOf[T]
  }

}
