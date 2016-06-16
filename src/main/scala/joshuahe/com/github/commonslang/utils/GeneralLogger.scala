package joshuahe.com.github.commonslang.utils

/**
 * Created by Jing on 18/09/15.
 */

import org.slf4j.{Logger, LoggerFactory}

trait GeneralLogger{

  val logger : Logger = LoggerFactory.getLogger(getClass)

}
