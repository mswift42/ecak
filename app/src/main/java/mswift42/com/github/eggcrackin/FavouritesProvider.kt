package mswift42.com.github.eggcrackin

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable


@SuppressLint("ParcelCreator")
object FavouritesProvider : Parcelable {
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeList(getFavourites().toList())
    }

    override fun describeContents() = 0

    var favourites = HashSet<Recipe>()

    fun getFavourites(): List<Recipe> {
        return favourites.toList()
    }

    fun setFavourites(favs: List<Recipe>) {
        favourites = favs.toHashSet()
    }

    fun addFavourites(recipe: Recipe) {
        favourites.add(recipe)
    }

    fun deleteFavourite(recipe: Recipe) {
        favourites.remove(recipe)
    }

    fun isFavourite(recipe: Recipe) : Boolean {
        return favourites.contains(recipe)
    }
}