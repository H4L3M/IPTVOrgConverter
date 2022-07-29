package model

import com.google.gson.annotations.SerializedName

/**
 * Example
 * MAR - ALG - EGY - UAE - KSA
 * KID - DOC - SPO - MOV - ISL - CUL - ED
 * MBC - BEIN - ROTANA - SNRT
 * */

data class EliteChannel(
    val id: Int = 0,
    val name: Name? = Name(),
    val logo: String? = null,
    val code: Code = Code(),
    @SerializedName("user_agent") val userAgent: String? = null,
    val stream: String? = null,
    val status: String? = null,
    val new: Boolean = false,
    val visible: Boolean = true,
)

data class Name(
    val ar: String? = null,
    val en: String? = null
)

data class Code(
    val country: String? = null,
    val category: String? = null,
    val `package`: String? = null
)

