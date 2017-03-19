package mswift42.com.github.eggcrackin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recipe_card.view.*
import mswift42.com.github.eggcrackin.Recipe
import mswift42.com.github.eggcrackin.MockRecipeData

class RecipesAdapter(val Recipes : MutableList<Recipe>, val itemClick: (Recipe) -> Unit) :
        RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_card, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder,  position: Int) {
        holder.bindRecipe(Recipes[position])

    }

    override fun getItemCount() = Recipes.size

    class ViewHolder(view: View, val itemClick: (Recipe) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindRecipe(recipe: Recipe) {
            with(recipe) {
                itemView.ec_recipe_title.text = title
                itemView.ec_recipe_image.setImageResource(image_url)
                itemView.ec_recipe_publisher.text = publisher


            }
        }
    }
}
