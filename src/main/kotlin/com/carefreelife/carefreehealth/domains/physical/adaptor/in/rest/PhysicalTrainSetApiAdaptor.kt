package com.carefreelife.carefreehealth.domains.physical.adaptor.`in`.rest

import com.carefreelife.carefreehealth.core.common.ResponseCode
import com.carefreelife.carefreehealth.core.dto.response.BaseCarefreeApiResponse
import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.CreatePhysicalTrainPersistAdaptor
import com.carefreelife.carefreehealth.domains.physical.application.dto.request.PhysicalTrainRequestDto
import com.carefreelife.carefreehealth.domains.physical.application.dto.response.PhysicalTrainResponseDto
import com.carefreelife.carefreehealth.domains.physical.application.port.`in`.set.CreatePhysicalTrainInPort
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Physical Training API", description = "헬스 트레이닝 생성, 수정, 삭제 API 입니다.")
@RestController
@RequestMapping(path = ["/api/v1/exercise/physical"])
class PhysicalTrainSetApiAdaptor(
    private val physicalTrainInPort: CreatePhysicalTrainInPort,
) {

    @PostMapping(path = ["/create"], produces = ["application/json"])
    @Tag(name = "Physical Training API")
    @Operation(summary = "헬스 트레이닝 종목 생성", description = "헬스 종목 상세 정보를 생성해요.")
    fun createPhysicalTrainDetail(
        @Valid @RequestBody physicalTrainRequestDto: PhysicalTrainRequestDto
    ): BaseCarefreeApiResponse<Long> {
        return BaseCarefreeApiResponse(ResponseCode.SUCCESS, physicalTrainInPort.createPhysicalTrainDetail(physicalTrainRequestDto))
    }

}