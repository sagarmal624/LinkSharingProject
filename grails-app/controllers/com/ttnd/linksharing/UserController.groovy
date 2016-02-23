package com.ttnd.linksharing

import com.ttnd.LinkSharing.User

class UserController {

    def index() {

        render "${session.user} Dashboard"
    }
    def register(){
//        User.validate()
      //  User user=User.save(params)
        User registerUser = new User(firstname:params.firstname,lastname:params.lastname,email:params.email,username:params.username,password:params.password,confirmPassword:params.confirmPassword )
        if(registerUser.validate())
        {
         registerUser.save(flush:true)
         render "success"
        }else {
             flash.message=registerUser.errors.allErrors.collect{[code:it]}
            render flash.message
        }
    }
}
