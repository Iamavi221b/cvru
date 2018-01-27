package cvru

import org.springframework.web.multipart.MultipartFile

class Notice {
    String title
    String content
    Document doc
    Date date
    static constraints = {
        content (nullable: true, type: "text")
        doc (nullable: true)
    }
}
