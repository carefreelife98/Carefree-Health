package com.carefreelife.carefreehealth.core.property

import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length

data class Description(

    @NotBlank
    @Length(max = 255)
    var description: String
)
