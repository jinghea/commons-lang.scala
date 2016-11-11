package com.github.jinghea.commonslang.convert


/**
  * Created by jing on 11/11/16.
  */
private[convert] trait Decorators {

  class AsJava[A](op: => A) {
    def asJava: A = op
  }


  class AsScala[A](op: => A) {
    def asScala: A = op
  }

}

private[convert] object Decorators extends Decorators
