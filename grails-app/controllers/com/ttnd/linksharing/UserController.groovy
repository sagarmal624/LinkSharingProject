package com.ttnd.linksharing

import com.ttnd.LinkSharing.Resource_Rating
import com.ttnd.LinkSharing.User
class UserController {
    def index() {

        render "${session.user} Dashboard"
    }
    def topPost()
    {
       if(session.user==null){
       }

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
    def show()
    {
        params.max= 1
        params.offset = params.offset?:0
        List<User> users = User.list(params)
        render ([view:"show", model:[userCount:User.count() , users:users]])
    }
    def toppost(){

        List<Resource_Rating>resources=Resource_Rating.createCriteria().list(max:5){
            projections{
                groupProperty('resource')
                avg('score','avgScore')
            }
            'resource'{
                property('id')
            }
            order('avgScore','desc')
        }

  render resources;
        }



}
