package site.algosipeosseong.domain.file.application

import org.springframework.web.multipart.MultipartFile

interface UploadFileService {
    fun upload(file: MultipartFile, path: String): String
}