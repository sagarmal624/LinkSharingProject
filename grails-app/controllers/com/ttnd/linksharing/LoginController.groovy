package com.ttnd.linksharing

class LoginController {

    def index() {

        if (session.user) {
            forward(action: "index", controller: "user")

        } else {

            render "Failure!" + flash.error
        }
    }

    def loginHandler() {
        String username = params.username
        String password = params.password
        if (username == "sagar" && password == "sagar") {
            String active = params.active;
            println active

            if (active == "true") {
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
