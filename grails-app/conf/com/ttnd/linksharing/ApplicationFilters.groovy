package com.ttnd.linksharing

class ApplicationFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                log.info("before........controller:${controllerName} and Action:${actionName}")

            }
            after = { Map model ->
                log.info("after........controller:${controllerName} and Action:${actionName}")

            }
            afterView = { Exception e ->

            }
        }
        sessionCheck(controller: "*", action: "*")
                {
                    before = {
                        if (session.user) {
                            log.info "...........log in user is:${session.user}"
                        } else
                            log.info "..........user is not log in"
                    }
                }
//        loginCheck(action: "*", controllerExclude: 'login')
//                {
//                    before = {
//                        if (session.user) {
//                            render session.user
//                        } else {
//                            flash.error = "Please Sign in........."
//                            redirect(action: "index", controller: "login")
//
//                        }
//                    }
//
//                }

    }
}
