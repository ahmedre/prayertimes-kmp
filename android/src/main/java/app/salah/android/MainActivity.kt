package app.salah.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.salah.Greeting
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Text(text = greet())
            }
        }
    }
}
