package com.carefreelife.carefreehealth.domains.physical.adaptor.`in`.rest

import com.carefreelife.carefreehealth.core.dto.response.BaseCarefreeApiResponse
import com.carefreelife.carefreehealth.core.dto.response.ResponseCode
import com.carefreelife.carefreehealth.core.property.ExerciseId
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponse.PhysicalTrainResponseDto
import com.carefreelife.carefreehealth.domains.physical.application.usecases.GetPhysicalTrainUseCase
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "헬스 트레이닝 관련 조회 API")
@RequestMapping(path = ["/api/v1/exercise/physical"])
@RestController
@RequiredArgsConstructor
class PhysicalTrainGetApiAdaptor (
    private var getPhysicalTrainUseCase: GetPhysicalTrainUseCase
) {

    @GetMapping(path = ["/{exerciseId}"], produces = ["application/json"])
    fun getPhysicalTrainDetail(
        @Valid @PathVariable("exerciseId") exerciseId: Long
    ): BaseCarefreeApiResponse<PhysicalTrainResponseDto> {

        val response = getPhysicalTrainUseCase.getPhysicalTrainDetailById(ExerciseId(exerciseId))
        return BaseCarefreeApiResponse(ResponseCode.SUCCESS, response)
    }
}