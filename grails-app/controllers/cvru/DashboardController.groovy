package cvru

class DashboardController {

    def index() {
        [notice: Notice.list(), alert: Alert.list(), album: Album.list()]
    }

    def viewNotice() {
        def id = params.id
        Document documentInstance
        Notice noticeInstance = Notice.findById(id)
        if (noticeInstance.doc) {
            def doc = noticeInstance.doc
            documentInstance = Document.find(doc)
        }
        else {
            documentInstance = null
        }
        [notice: noticeInstance, document: documentInstance]
    }

    def viewAlert() {
        def id = params.id
        Document documentInstance
        Alert alertInstance = Alert.findById(id)
        if (alertInstance.doc) {
            def doc = alertInstance.doc
            documentInstance = Document.find(doc)
        }
        else {
            documentInstance = null
        }
        [alert: alertInstance, document: documentInstance]
    }

    def download(long id) {
        Document documentInstance = Document.get(id)
        if ( documentInstance == null) {
            flash.message = "Document not found."
            redirect (action:'list')
        } else {
            response.setContentType("APPLICATION/OCTET-STREAM")
            response.setHeader("Content-Disposition", "Attachment;Filename=\"${documentInstance.filename}\"")
            def file = new File(documentInstance.fullPath)
            def fileInputStream = new FileInputStream(file)
            def outputStream = response.getOutputStream()
            byte[] buffer = new byte[4096];
            int len;
            while ((len = fileInputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
            outputStream.flush()
            outputStream.close()
            fileInputStream.close()
        }
    }

    def viewAlbum(long id) {
        def albumInstance = Album.get(id)
        [album: albumInstance]
    }

    def about() {

    }

    def facultyofarts() {

    }

    def facultyofcommerce() {

    }

    def facultyofit() {

    }

    def facultyofmanagement() {

    }

    def facultyofscience() {

    }
}
