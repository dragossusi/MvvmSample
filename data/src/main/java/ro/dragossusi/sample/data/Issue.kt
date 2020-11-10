package ro.dragossusi.sample.data

import com.google.gson.annotations.SerializedName


/**
 *
 * @since 9/23/20
 * @author dragos
 */
class Issue(
    @SerializedName("title")
    val title: String,
    @SerializedName("subtitle")
    val subtitle: String
)