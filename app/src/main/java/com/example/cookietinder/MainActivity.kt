package com.example.cookietinder

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var imgCookie: ImageView
    private lateinit var lblName: TextView
    private lateinit var lblStory: TextView

    private val cookies = generateCookies()
    private var index = 0

    @SuppressLint("SetTextI18n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgCookie = findViewById(R.id.imgCookie)
        lblName = findViewById(R.id.lblName)
        lblStory = findViewById(R.id.lblStory)
        val btnlike: Button = findViewById(R.id.btnlike)
        val btndislike: Button = findViewById(R.id.btndislike)



        showCookie(cookies[index])

        btnlike.setOnClickListener {
            Toast.makeText(this@MainActivity, cookies[0].likedMessage, Toast.LENGTH_SHORT).show()
            index++
            if (index == cookies.size) {
                index = 0
            }
            showCookie(cookies[index])
        }
        btndislike.setOnClickListener {
            Toast.makeText(this@MainActivity, cookies[0].dislikedMessage, Toast.LENGTH_SHORT).show()
            index++

            if (index == cookies.size) {
                index = 0
            }
            showCookie(cookies[index])

        }


    }

    private fun showCookie(cookie: Cookie) {
        imgCookie.setImageResource(cookie.image)
        lblName.text = cookie.name
        lblStory.text = cookie.story

    }

    private fun generateCookies(): List<Cookie> {
        return arrayListOf(
            Cookie(
                "Choc-Chip Cookie", R.drawable.choc_chip_cookie,
                "A cookie filled with chocolate chips.",
                "Liked", "Disliked"
            ),

            Cookie(
                "Oatmeal Cookie", R.drawable.oatmeal_cookie,
                "A Cookie containing rolled oats.",
                "Liked", "Disliked"),

            Cookie(
                "GingerBread Cookie", R.drawable.ginger_cookie,
                "Soft chewy centre,crunchy outside with a " +
                                 "flavour of Ginger.",
                "Liked", "Disliked"),

            Cookie(
                "Peanut Butter Cookie", R.drawable.peanut_butter_cookie,
                "Contains a filling of peanut butter originally " +
                                    "made in the USA.",
                "Liked", "Disliked"),

            Cookie(
                "No Bake Cookie", R.drawable.no_bake_cookie,
                "Cookies that do not need to be baked in the oven.",
                "Liked", "Disliked"),

            Cookie(
                "Sugar Cookie", R.drawable.sugar_cookie,
                "A sweet cookie with a soft, chewy inside and " +
                                 "a crunchy outside.",
                "Liked", "Disliked"),

            Cookie(
                "Maryland Cookie", R.drawable.maryland_cookie,
                "A small crunchy cookie filled with chocolate bits.",
                "Liked", "Disliked"),













            )
    }


    data class Cookie(
        val name: String, val image: Int, val story: String,
        val likedMessage: String,
        val dislikedMessage: String
    )
}

