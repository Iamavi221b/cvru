package cvru

class Document {
    String filename
    String fullPath
    int fileType = 0
    Date uploadDate = new Date()
    static constraints = {
        filename(blank:false,nullable:false)
        fullPath(blank:false,nullable:false)
    }
}
