package com.ttnd.linksharing

class LoginController {

    def index() {

        if (session.user) {
            forward(action: "index", controller: "user")

        } else {

            render "Failure!" + flash.error
        }
    }

    def loginHandler(String username,String password,Boolean active) {
        if (username == "sagar" && password == "sagar") {
//            println active
            if (active) {
                session.user = username
                println session.user
                forward(action: "index")
            } else {
                flash.error = "Your Account is not active"
                render flash.error
       }
        } else {
            flash.error = "User is not found"
            forward(action: "index")
        }

    }

    def logout() {
        session.invalidate()
        forward(action: "index")
    }

}
