package mswift42.com.github.eggcrackin

data class Recipe(val publisher: String, val title: String,
                  val source_url: String,
                  val image_url: Int, val publisher_url: String,
                  val recipe_id: String,
                  val ingredients: List<String>)
