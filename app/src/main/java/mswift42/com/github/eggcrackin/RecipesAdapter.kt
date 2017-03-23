package mswift42.com.github.eggcrackin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recipe_card.view.*
import mswift42.com.github.eggcrackin.Recipe
import mswift42.com.github.eggcrackin.MockRecipeData

class RecipesAdapter(val Recipes : MutableList<Recipe>) :
        RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder,  position: Int) {
        val isFavourite = FavouritesProvider.isFavourite(Recipes[position])
        holder.bindRecipe(Recipes[position], isFavourite)

    }

    override fun getItemCount() = Recipes.size

    class ViewHolder(view: View ) : RecyclerView.ViewHolder(view) {

        fun bindRecipe(recipe: Recipe, isFavourite: Boolean) {
            with(recipe) {
                itemView.ec_recipe_title.text = title
                itemView.ec_recipe_image.setImageResource(image_url)
                itemView.ec_recipe_publisher.text = publisher
                if (isFavourite) {
                    itemView.ec_favorite_icon_not_favourite.setImageResource(R.drawable.ic_favorite_black_24dp)
                }
                itemView.ec_favorite_icon_not_favourite.setOnClickListener { v ->
                    toggleFavourite(recipe)
                }
            }
        }

        private fun toggleFavourite(recipe: Recipe) {
            if (FavouritesProvider.isFavourite(recipe)) {
                itemView.ec_favorite_icon_not_favourite.setImageResource(R.drawable.ic_favorite_border_black_24dp)
                FavouritesProvider.deleteFavourite(recipe)
            } else {
                itemView.ec_favorite_icon_not_favourite.setImageResource(
                        R.drawable.ic_favorite_black_24dp)
                FavouritesProvider.addFavourites(recipe)
            }

        }
    }
}
