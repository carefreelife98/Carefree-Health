package com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.repository

import com.carefreelife.carefreehealth.domains.physical.adaptor.out.persistence.entity.PhysicalTrainEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhysicalTrainRepository: JpaRepository<PhysicalTrainEntity, Long> {

}