package ruzanna.game.tic_toc

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var name: String,
    var result: Array<String>,
    var queue: Boolean,
    var walk: String
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (name != other.name) return false
        if (!result.contentEquals(other.result)) return false

        return true
    }

    override fun hashCode(): Int {
        var result1 = name.hashCode()
        result1 = 31 * result1 + result.contentHashCode()
        return result1
    }
}