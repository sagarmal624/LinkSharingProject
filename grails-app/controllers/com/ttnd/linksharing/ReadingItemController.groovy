package com.ttnd.linksharing

import com.ttnd.LinkSharing.ReadingItem

class ReadingItemController {

    def index() { }
    def changeIsRead(Long id,Boolean isRead)
      {

      int result=ReadingItem.executeUpdate("update ReadingItem set isRead=${isRead} where id=${id}")//+"Row Updated"
       if(!result){
           render "Error"
       }else {
           render "Success"
       }


      }
}
