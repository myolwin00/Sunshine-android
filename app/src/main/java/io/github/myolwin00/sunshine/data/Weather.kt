package io.github.myolwin00.sunshine.data

import com.google.gson.annotations.SerializedName

class Weather {
    @SerializedName("description")
    var mDescription: String? = null
    @SerializedName("icon")
    var mIcon: String? = null
    @SerializedName("id")
    var mId: Long? = null
    @SerializedName("main")
    var mMain: String? = null
}
