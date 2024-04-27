package site.algosipeosseong.domain.file.infrastructure

import com.amazonaws.regions.ServiceAbbreviations.Directory
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import site.algosipeosseong.domain.file.application.UploadFileService
import site.algosipeosseong.global.config.property.AwsProperties
import java.util.*


@Service
class S3Service(
    private val amazonS3: AmazonS3,
    private val awsProperties: AwsProperties
) : UploadFileService {
    private val bucket = awsProperties.s3.bucket
    override fun upload(file: MultipartFile, path: String): String {
        if (file.isEmpty) throw RuntimeException()

        val fileName: String = createFileName(path, file.originalFilename!!)
        try {
            val request = PutObjectRequest(
                bucket,
                fileName,
                file.inputStream,
                getObjectMetadata(file)
            )
            amazonS3.putObject(request.withCannedAcl(CannedAccessControlList.Private))
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException()
        }

        return amazonS3.getUrl(bucket, fileName).toString()
    }

    private fun createFileName(path: String, originalName: String): String {
        return (path + "/" + UUID.randomUUID())+ "-" + originalName
    }

    private fun getObjectMetadata(file: MultipartFile): ObjectMetadata {
        val objectMetadata = ObjectMetadata()
        objectMetadata.contentLength = file.size
        objectMetadata.contentType = file.contentType
        return objectMetadata
    }
}