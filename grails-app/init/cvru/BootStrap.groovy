package cvru

class BootStrap {

    def init = { servletContext ->
        User admin = new User([userName: "Admin", password: "Lamborghini"])
        admin.save()

    Document arts = new Document([filename: "FACULTY OF ARTS.docx", fullPath: "/home/avinash/Documents/CVRUBHILAI-master/cvru/grails-app/assets/docs/FACULTY OF ARTS.docx"])
        arts.save()

        Document sci = new Document([filename: "FACULTY OF SCIENCE.docx", fullPath: "/home/avinash/Documents/CVRUBHILAI-master/cvru/grails-app/assets/docs/FACULTY OF SCIENCE.docx"])
        sci.save()

        Document commerce = new Document([filename: "FACULTY OF COMMERCE.docx", fullPath: "/home/avinash/Documents/CVRUBHILAI-master/cvru/grails-app/assets/docs/FACULTY OF COMMERCE.docx"])
        commerce.save()

        Document it = new Document([filename: "FACULTY OF INFORMATION TECHNOLOGY.docx", fullPath: "/home/avinash/Documents/CVRUBHILAI-master/cvru/grails-app/assets/docs/FACULTY OF INFORMATION TECHNOLOGY.docx"])
        it.save()

        Document manage = new Document([filename: "FACULTY OF MANAGEMENT.docx", fullPath: "/home/avinash/Documents/CVRUBHILAI-master/cvru/grails-app/assets/docs/FACULTY OF MANAGEMENT.docx"])
        manage.save()
    }
    def destroy = {
    }
}
