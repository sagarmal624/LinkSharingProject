package com.ttnd.linksharing

import com.ttnd.LinkSharing.User
class UserController {
    def index() {

        render "${session.user} Dashboard"
    }
    def register(String firstname,String lastname,String email,String username,String password,String confirmPassword){
        User registerUser = new User(firstname:firstname,lastname:lastname,email:email,username:username,password:password,confirmPassword:confirmPassword )
        if(registerUser.validate())
        {
         registerUser.save(flush:true)
         render "success"
        }else {
             flash.message=registerUser.errors.allErrors.collect{g.message([error:it])}
            render "error"
        }
    }

}
