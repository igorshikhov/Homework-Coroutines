package otus.homework.coroutines

import com.google.gson.annotations.SerializedName

data class Fact(
    @field:SerializedName("fact") val fact: String,
    @field:SerializedName("length") val length: Int
)

data class ImageLink(
    @field:SerializedName("url") val url: String
)
