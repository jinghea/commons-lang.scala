package com.github.jinghea.commonslang.utils

import java.io.IOException
import javax.servlet.ServletOutputStream
import javax.servlet.http.HttpServletResponse

import org.apache.commons.io.IOUtils
import org.slf4j.{LoggerFactory, Logger}

/**
  * Created by jing on 26/05/16.
  */
trait ServletUtils{

  val logger : Logger = LoggerFactory.getLogger(getClass)

  def responseForDownload(response: HttpServletResponse, exportByte: Array[Byte]) {

    response.setContentType("application/octet-stream")
    response.setContentLength(exportByte.length)

    try {
      val servletOutputStream: ServletOutputStream = response.getOutputStream()
      IOUtils.write(exportByte, servletOutputStream);
    } catch {
      case e: IOException => logger.error("", e)
    }

  }

}

object ServletUtils extends ServletUtils
