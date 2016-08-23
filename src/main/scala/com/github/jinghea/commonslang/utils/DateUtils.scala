package com.github.jinghea.commonslang.utils

import java.text.SimpleDateFormat
import java.util.Date

/**
  * Created by jing on 6/05/16.
  */
trait DateUtils {

  val SIMPLE_DATE_FORMAT = "yyyy-MM-dd"

  def parseSimpleDate(s:String):Option[Date]={
    try {
      val sf = new SimpleDateFormat(SIMPLE_DATE_FORMAT)
      Option(sf.parse(s))
    }catch{
      case e: Throwable => None
    }
  }


  def formatSimpleDate(date:Date):String = {

    Option(date) match{
      case Some(date) =>{
        val sf = new SimpleDateFormat(SIMPLE_DATE_FORMAT)
        sf.format(date)
      }
      case None => ""
    }
  }
}
