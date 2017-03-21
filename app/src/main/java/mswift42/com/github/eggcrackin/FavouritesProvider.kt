package mswift42.com.github.eggcrackin

object FavouritesProvider {
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