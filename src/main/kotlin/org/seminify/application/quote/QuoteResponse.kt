package org.seminify.application.quote

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class QuoteResponse(val type: String, val value: Quote)
