package mswift42.com.github.eggcrackin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recipe_card.view.*


class RecipesAdapter : RecyclerView.Adapter<RecipesAdapter.viewHolder>() {
    private val mRecipes: MutableList<Recipe>
    private val mOnClickListener: View.OnClickListener

    init {
            mRecipes = MockRecipeData.mockRecipeData
        mOnClickListener = View.OnClickListener { v ->

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val context = parent.context
        val layoutIdForListItem = R.layout.recipe_card
        var shouldAttachToParentImmediately = false
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately)
        val viewHolder = RecipesAdapter.viewHolder(view)
        return viewHolder(inflater.inflate(R.layout.recipe_card, parent, false))
    }

    override fun getItemCount(): Int {
        return mRecipes.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val recipe = mRecipes[position]
        val title = recipe.title
        val publisher = recipe.publisher
        val image_url = recipe.image_url
        holder.
    }

    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recipe_title = view.ec_recipe_title
        val recipe_image = view.ec_recipe_image
        val recipe_publisher = view.ec_recipe_publisher
        val recipe_ingredients = view.ec_recipe_ingredients
    }

}