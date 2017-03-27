package mswift42.com.github.eggcrackin

import android.content.Context
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.InputStreamReader


object FileUtility {
    private val savedFavourites = "favourites.json"

    fun writeToFile(context: Context, content: String) {
        val outputStream: FileOutputStream
        try {
            outputStream = context.applicationContext
                    .openFileOutput(savedFavourites, Context.MODE_PRIVATE)
            outputStream.write(content.toByteArray())
            outputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    @Throws(FileNotFoundException::class)
    fun restoreFromFile(context: Context): String {
        try {
            val fi = context.applicationContext
                    .openFileInput(savedFavourites)
            val isr = InputStreamReader(fi)
            val br = BufferedReader(isr)
            val sb = StringBuilder()
            var line = br.readLine()
            while (line != null) {
                sb.append(line)
            }
            return sb.toString()
        } catch (e: Exception) {
            throw FileNotFoundException()
        }

    }

}