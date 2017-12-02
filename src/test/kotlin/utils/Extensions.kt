package utils

import com.google.common.io.Resources
import java.nio.charset.Charset

fun getResourceAsString(resourceName: String, charset: Charset = Charsets.UTF_8) =
    Resources.toString(Resources.getResource(resourceName), charset)