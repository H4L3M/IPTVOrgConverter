package model

import com.google.gson.annotations.SerializedName

data class GitChannel(
    @SerializedName("broadcast_area")
    val broadcastArea: List<String?>?,
    val categories: List<String?>?,
    val city: String?,
    val closed: String?,
    val country: String?,
    val id: String?,
    @SerializedName("is_nsfw")
    val isNsfw: Boolean?,
    val languages: List<String?>?,
    val launched: String?,
    val logo: String?,
    val name: String?,
    @SerializedName("native_name")
    val nativeName: String?,
    val network: String?,
    @SerializedName("replaced_by")
    val replacedBy: String?,
    val subdivision: String?,
    val website: String?
)