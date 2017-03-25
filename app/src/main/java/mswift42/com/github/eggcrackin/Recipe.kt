package mswift42.com.github.eggcrackin

import android.os.Parcel
import android.os.Parcelable

data class Recipe(val publisher: String, val title: String,
                  val source_url: String,
                  val image_url: Int, val publisher_url: String,
                  val recipe_id: String,
                  val ingredients: List<String>) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Recipe> = object : Parcelable.Creator<Recipe> {
            override fun createFromParcel(source: Parcel): Recipe = Recipe(source)
            override fun newArray(size: Int): Array<Recipe?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString(), source.readString(), source.readString(), source.readInt(), source.readString(), source.readString(), source.createStringArrayList())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(publisher)
        dest?.writeString(title)
        dest?.writeString(source_url)
        dest?.writeInt(image_url)
        dest?.writeString(publisher_url)
        dest?.writeString(recipe_id)
        dest?.writeStringList(ingredients)
    }
}
