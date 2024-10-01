package com.carefreelife.carefreehealth.domains.physical.application.port.out.set

import com.carefreelife.carefreehealth.domains.physical.domain.`object`.PhysicalTrainExercise


interface CreatePhysicalTrainOutPort {
    fun createPhysicalTrainDetail(physicalTrainExercise: PhysicalTrainExercise): Long
}