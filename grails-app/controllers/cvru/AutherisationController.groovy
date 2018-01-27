package cvru

class AutherisationController {

    def index() {

    }
    def check() {
        String username = params.userName
        String password = params.password
        User userInstance = User.findByUserNameAndPassword(username,password)
        if(userInstance) {
            session.user = userInstance
            redirect(controller: "adminpanel", action: "index")
        }
        else {
            flash.wrong = "Invalid Credentials"
            redirect (action: "index")
        }
    }
    def logout() {
        session.invalidate()
        redirect(controller: "dashboard", action: "index")
    }
}
