package com.ttnd.linksharing

class DemoTagLib {
    static defaultEncodeAs = [taglib:'html']
  static namespace = "sagar"


    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
 def showMe={body->
      out<<body()

 }

}
