package cvru

class Album {
    String albumName
    List<Image> imageInstances = []
    static constraints = {
        albumName(blank:false,nullable:false)
    }
}
