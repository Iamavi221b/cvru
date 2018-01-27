package cvru

class AdminpanelController {

    void check(){
        if(!session.user) {
            redirect(controller: "dashboard", action: "index")
        }
    }

    def index() {
        check()
        [notice: Notice.list(), alert: Alert.list(), album: Album.list()]
    }

    def addnotice() {
        check()
    }

    def updatenotice(long id) {
        check()
        Notice noticeInstance = Notice.get(id)
        def documentInstance
        if (noticeInstance.doc) {
            documentInstance = Document.get(noticeInstance.doc.id)
        }
        [notice: noticeInstance, doc: documentInstance]
    }

    def updateNotice(long id) {
        check()
        def noticeInstance = Notice.get(id)
        if (noticeInstance) {
            noticeInstance.title = params.title
            noticeInstance.content = params.content
            if (noticeInstance.doc) {
                def document = noticeInstance.doc
                def file = request.getFile('file')

                if(file.empty) {
                    flash.message = "File cannot be empty"
                } else {
                    def documentInstance = new Document()
                    documentInstance.filename = file.originalFilename
                    documentInstance.fullPath = grailsApplication.config.uploadFolder + documentInstance.filename
                    file.transferTo(new File(documentInstance.fullPath))
                    if ((file.contentType == "image/jpeg") || (file.contentType == "image/jpg") || (file.contentType == "image/png")) {
                        documentInstance.fileType = 1
                    }
                    else if ((file.contentType == "application/pdf")) {
                        documentInstance.fileType = 2
                    }
                    documentInstance.save(flush:true)
                    noticeInstance.doc = documentInstance
                }
                    document.delete(flush:true)


            }
            noticeInstance.save(flush:true)
        }
        redirect(action: 'index')
    }

    def deletenotice(long id) {
        check()
        Notice noticeInstance = Notice.get(id)
        def documentInstance
        if (noticeInstance.doc) {
            documentInstance = Document.get(noticeInstance.doc.id)
        }
        if(noticeInstance.doc){
            new File(grailsApplication.config.uploadFolder + "/" + noticeInstance.doc.filename).delete()
        }
        noticeInstance.delete(flush:true)
        if (documentInstance) {
            documentInstance.delete(flush:true)
        }
        redirect(controller: 'adminpanel',action:'index')
    }

    def save() {
        check()
        Map notice = [:]
        notice.title = params.title
        if (params.content) {
            notice.content = params.content
        }
        notice.date = new Date()
            def file = request.getFile('file')

            if(file.empty) {
                flash.message = "File cannot be empty"
            } else {
                def documentInstance = new Document()
                documentInstance.filename = file.originalFilename
                documentInstance.fullPath = grailsApplication.config.uploadFolder + "/" + documentInstance.filename
                file.transferTo(new File(documentInstance.fullPath))
                if ((file.contentType == "image/jpeg") || (file.contentType == "image/jpg") || (file.contentType == "image/png")) {
                    documentInstance.fileType = 1
                }
                else if ((file.contentType == "application/pdf")) {
                    documentInstance.fileType = 2
                }
                documentInstance.save(flush:true)
                notice.doc = documentInstance
            }
        
        Notice noticeInstance = new Notice(notice)
        noticeInstance.save(flush:true)
        redirect (controller: 'adminpanel',action:'index')
    }

    def createAlbum(){
        check()
    }

    def saveAlbum(){
        check()
        new File(grailsApplication.config.uploadFolder + "/" + params.album).mkdir()
        def albumInstance = new Album()
        albumInstance.albumName = params.album
        List fileList = request.getFiles('files')
        fileList.each { file ->
            if(file.empty) {
                flash.message = "File cannot be empty"
            } else {
                def imageInstance = new Image()
                imageInstance.filename = file.originalFilename
                imageInstance.fullPath = grailsApplication.config.uploadFolder + "/" + albumInstance.albumName + "/" + imageInstance.filename
                file.transferTo(new File(imageInstance.fullPath))
                albumInstance.imageInstances << imageInstance
                imageInstance.save(flush:true)
            }

        }
        albumInstance.save(flush:true)
        redirect (controller: 'adminpanel',action:'index')
    }

    def addImage(long id) {
        check()
        def albumInstance = Album.get(id)
        [albumInstance: albumInstance]
    }

    def deleteAlbum(long id) {
        check()
        def albumInstance = Album.get(id)
        if(albumInstance) {
            new File(grailsApplication.config.uploadFolder + "/" + albumInstance.albumName).deleteDir()
        }
        albumInstance.delete(flush: true)
        redirect (controller: 'adminpanel',action:'index')
    }

    def saveImage(long id) {
        check()
        def albumInstance = Album.get(id)
        List fileList = request.getFiles('files')
        fileList.each { file ->
            if(file.empty) {
                flash.message = "File cannot be empty"
            } else {
                def imageInstance = new Image()
                imageInstance.filename = file.originalFilename
                imageInstance.fullPath = grailsApplication.config.uploadFolder + "/" + albumInstance.albumName + "/" + imageInstance.filename
                file.transferTo(new File(imageInstance.fullPath))
                albumInstance.imageInstances << imageInstance
                imageInstance.save(flush:true)
            }

        }
        albumInstance.save(flush:true)
        redirect (controller: 'adminpanel',action:'index')
    }

    def deleteImage(long id) {
        check()
        def temp
        def imageInstance = Image.get(id)
            Album.list().each {
                it.imageInstances.each{
                    if(it == imageInstance) {
                        temp = it
                        new File(it.fullPath).delete()
                        it.delete()
                    }
                }
                it.imageInstances = it.imageInstances.minus(temp)
                it.save(flush:true)
            }
        redirect(controller: 'adminpanel',action:'index')
    }

    def addAlert() {
        check()
    }

    def saveAlert() {
        check()
        Map alert = [:]
        alert.title = params.title
        if (params.content) {
            alert.content = params.content
        }
        alert.date = new Date()
        def file = request.getFile('file')
        if(file) {
            if(file.empty) {
                flash.message = "File cannot be empty"
            } else {
                def documentInstance = new Document()
                documentInstance.filename = file.originalFilename
                documentInstance.fullPath = grailsApplication.config.uploadFolder + "/" + documentInstance.filename
                file.transferTo(new File(documentInstance.fullPath))
                if ((file.contentType == "image/jpeg") || (file.contentType == "image/jpg") || (file.contentType == "image/png")) {
                    documentInstance.fileType = 1
                }
                else if ((file.contentType == "application/pdf")) {
                    documentInstance.fileType = 2
                }
                documentInstance.save(flush:true)
                alert.doc = documentInstance
            }
        }
        Alert alertInstance = new Alert(alert)
        alertInstance.save(flush:true)
        redirect (controller: 'adminpanel',action:'index')
    }

    def deleteAlert(long id) {
        check()
        Alert alertInstance = Alert.get(id)
        def documentInstance
        if (alertInstance.doc) {
            documentInstance = Document.get(alertInstance.doc.id)
        }
        if(alertInstance.doc){
            new File(grailsApplication.config.uploadFolder + "/" + alertInstance.doc.filename).delete()
        }
        alertInstance.delete(flush:true)
        if (documentInstance) {
            documentInstance.delete(flush:true)
        }
        redirect(controller: 'adminpanel', action:'index')
    }

    def updateAlert(long id) {
        check()
        Alert alertInstance = Alert.get(id)
        def documentInstance = null
        if (alertInstance.doc) {
            documentInstance = Document.get(alertInstance.doc.id)
        }
        [alert: alertInstance, doc: documentInstance]
    }

    def updatealert(long id) {
        check()
        def alertInstance = Alert.get(id)
        if (alertInstance) {
            alertInstance.title = params.title
            alertInstance.content = params.content
            def file = request.getFile('file')
            if(file){
                if (alertInstance.doc) {
                    def document = alertInstance.doc
                    if(file.empty) {
                        flash.message = "File cannot be empty"
                    } else {
                        def documentInstance = new Document()
                        documentInstance.filename = file.originalFilename
                        documentInstance.fullPath = grailsApplication.config.uploadFolder + documentInstance.filename
                        file.transferTo(new File(documentInstance.fullPath))
                        if ((file.contentType == "image/jpeg") || (file.contentType == "image/jpg") || (file.contentType == "image/png") || (file.contentType == "image/gif")) {
                            documentInstance.fileType = 1
                        }
                        else if ((file.contentType == "application/pdf")) {
                            documentInstance.fileType = 2
                        }
                        documentInstance.save(flush:true)
                        alertInstance.doc = documentInstance
                    }
                    document.delete(flush:true)
                }
                else {
                    if(file.empty) {
                        flash.message = "File cannot be empty"
                    } else {
                        def documentInstance = new Document()
                        documentInstance.filename = file.originalFilename
                        documentInstance.fullPath = grailsApplication.config.uploadFolder + documentInstance.filename
                        file.transferTo(new File(documentInstance.fullPath))
                        if ((file.contentType == "image/jpeg") || (file.contentType == "image/jpg") || (file.contentType == "image/png") || (file.contentType == "image/gif")) {
                            documentInstance.fileType = 1
                        }
                        else if ((file.contentType == "application/pdf")) {
                            documentInstance.fileType = 2
                        }
                        documentInstance.save(flush:true)
                        alertInstance.doc = documentInstance
                    }
                }
            }

            alertInstance.save(flush:true)
        }
        redirect(action: 'index')
    }

    def viewAlert() {
        check()
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

    def viewAlbum(long id) {
        check()
        def albumInstance = Album.get(id)
        [album: albumInstance]
    }

    def viewNotice() {
        check()
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

    def download(int id) {
        check()
        def fileInstance = Document.findById(id)

        response.setContentType("APPLICATION/OCTET-STREAM")
        response.setHeader("Content-Disposition", "Attachment;Filename=\"${fileInstance.filename}\"")
        def file1 = new File(fileInstance.fullPath)
        def fileInputStream = new FileInputStream(file1)
        def outputStream = response.getOutputStream()
        byte[] buffer = new byte[4096]
        int len
        while ((len = fileInputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len)
        }
        outputStream.flush()
        outputStream.close()
        fileInputStream.close()

    }

    def about() {
        check()
    }

    def facultyofarts() {
        check()
    }

    def facultyofcommerce() {
        check()
    }

    def facultyofit() {
        check()
    }

    def facultyofmanagement() {
        check()
    }

    def facultyofscience() {
        check()
    }

}
