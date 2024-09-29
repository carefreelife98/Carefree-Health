package com.carefreelife.carefreehealth.domains.physical.adaptor.`in`.rest

import com.carefreelife.carefreehealth.core.dto.response.BaseCarefreeApiResponse
import com.carefreelife.carefreehealth.core.dto.response.ResponseCode
import com.carefreelife.carefreehealth.core.property.ExerciseId
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponse.PhysicalTrainResponseDto
import com.carefreelife.carefreehealth.domains.physical.application.usecases.GetPhysicalTrainUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Physical Training API", description = "헬스 트레이닝 관련 API 입니다.")
@RequestMapping(path = ["/api/v1/exercise/physical"])
@RestController
@RequiredArgsConstructor
class PhysicalTrainGetApiAdaptor (
    private var getPhysicalTrainUseCase: GetPhysicalTrainUseCase
) {

    @GetMapping(path = ["/{exerciseId}"], produces = ["application/json"])
    @Tag(name = "Physical Training API")
    @Operation(summary = "헬스 트레이닝 종목 상세 조회", description = "ID 별 헬스 종목 상세 정보를 조회해요.")
    fun getPhysicalTrainDetail(
        @Valid @PathVariable("exerciseId") exerciseId: Long
    ): BaseCarefreeApiResponse<PhysicalTrainResponseDto> {

        val response = getPhysicalTrainUseCase.getPhysicalTrainDetailById(ExerciseId(exerciseId))
        return BaseCarefreeApiResponse(ResponseCode.SUCCESS, response)
    }
}