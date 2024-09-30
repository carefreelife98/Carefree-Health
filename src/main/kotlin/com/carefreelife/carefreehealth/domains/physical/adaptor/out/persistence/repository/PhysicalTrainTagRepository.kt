package com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.repository

import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity.PhysicalTrainTagEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhysicalTrainTagRepository: JpaRepository<PhysicalTrainTagEntity, Long> {

}