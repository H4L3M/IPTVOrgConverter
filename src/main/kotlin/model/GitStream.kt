package model

import com.google.gson.annotations.SerializedName

data class GitStream(
    @SerializedName("bitrate")
    val bitrate: Int?,
    @SerializedName("channel")
    val channel: String?,
    @SerializedName("frame_rate")
    val frameRate: Double?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("http_referrer")
    val httpReferrer: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("user_agent")
    val userAgent: String?,
    @SerializedName("width")
    val width: Int?
)