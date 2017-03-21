package mswift42.com.github.eggcrackin


import android.content.Context
import android.util.DisplayMetrics

object SpanUtility {
    fun calculateNoOfColumns(context: Context): Int {
        val displayMetrics = context.resources.displayMetrics
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density
        val columns = (dpWidth / 300).toInt()
        return columns
    }
}
