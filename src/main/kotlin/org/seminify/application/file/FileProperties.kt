package org.seminify.application.file

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("file")
data class FileProperties(var path: String = "file")
