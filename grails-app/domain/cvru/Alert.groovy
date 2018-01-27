package cvru

class Alert {
    String title
    String content
    Document doc
    Date date
    static constraints = {
        content (nullable: true, type: "text")
        doc (nullable: true)
    }
}
