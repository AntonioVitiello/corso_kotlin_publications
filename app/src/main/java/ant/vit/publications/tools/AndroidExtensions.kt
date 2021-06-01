package ant.vit.publications.tools

import android.util.Log
import android.widget.ImageView
import ant.vit.publications.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Vitiello Antonio
 */
fun Date.format(dateFormat: SimpleDateFormat): String {
    return dateFormat.format(this)
}

fun String.parseDateOrNull(dateFormat: SimpleDateFormat): Date? {
    return try {
        dateFormat.parse(this)
    } catch (exc: ParseException) {
        Log.e("AndroidExtensions", "Error while parsing date:$this.")
        null
    }
}

fun ImageView.loadImage(imageUrl: String?) {
    Picasso.get()
        .load(imageUrl)
        .fit()
        .placeholder(R.drawable.ic_placeholder)
        .error(R.drawable.ic_broken_image)
        .into(this, object : Callback {
            override fun onSuccess() {
                Log.d("AndroidExtensions", "Image loaded: $imageUrl")
            }

            override fun onError(exc: Exception) {
                Log.e("AndroidExtensions", "Error while loading image: $imageUrl", exc)
            }
        })
}

fun Int.isPair(): Boolean {
    return this % 2 == 0
}

