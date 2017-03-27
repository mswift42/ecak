package mswift42.com.github.eggcrackin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager = GridLayoutManager(this, SpanUtility.calculateNoOfColumns(this))
        ec_recyclerview.layoutManager = layoutManager
        val adapter = RecipesAdapter(MockRecipeData.mockRecipeData)
        ec_recyclerview.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putParcelable("favourites", FavouritesProvider)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        val fav = savedInstanceState?.getParcelable<FavouritesProvider>("favourites")
        if (fav != null) {
            FavouritesProvider.setFavourites(fav?.getFavourites())
        }
    }

}
