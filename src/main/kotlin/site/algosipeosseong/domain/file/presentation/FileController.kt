package site.algosipeosseong.domain.file.presentation

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import site.algosipeosseong.domain.file.application.UploadFileService
import site.algosipeosseong.domain.file.application.dto.FileResponse

@RestController
@RequestMapping("/file")
class FileController(
    private val uploadFileService: UploadFileService
) {
    @PostMapping("/upload")
    fun uploadFile(
        @RequestPart(required = true) file: MultipartFile,
        @RequestParam path: String
    ): FileResponse {
        return FileResponse(uploadFileService.upload(file, path))
    }

}