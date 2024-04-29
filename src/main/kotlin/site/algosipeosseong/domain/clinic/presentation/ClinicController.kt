package site.algosipeosseong.domain.clinic.presentation

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import site.algosipeosseong.domain.clinic.application.QueryClinicListRadiusUseCase
import site.algosipeosseong.domain.clinic.application.RegisterClinicUseCase
import site.algosipeosseong.domain.clinic.application.dto.request.ClinicListRadiusRequest
import site.algosipeosseong.domain.clinic.application.dto.request.RegisterClinicRequest
import site.algosipeosseong.domain.clinic.application.dto.response.ClinicSimpleResponse

@RestController
@RequestMapping("/clinic")
class ClinicController(
    private val registerClinicUseCase: RegisterClinicUseCase,
    private val clinicListRadiusUseCase: QueryClinicListRadiusUseCase
) {
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun registerClinic(
        @RequestBody request: RegisterClinicRequest
    ) {
        registerClinicUseCase.execute(request)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getClinicsByRadius(
        @RequestParam(required = true) radius: Int,
        @RequestBody request :ClinicListRadiusRequest
    ): List<ClinicSimpleResponse> {
        return clinicListRadiusUseCase.execute(request, radius)
    }
}