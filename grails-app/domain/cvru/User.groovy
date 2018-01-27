package cvru

class User {
    String userName
    String password
    static constraints = {
        userName unique: true, blank: false, nullable: false
        password blank: false, nullable: false
    }
}
