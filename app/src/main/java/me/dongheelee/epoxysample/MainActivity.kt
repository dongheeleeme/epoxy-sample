package me.dongheelee.epoxysample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.*
import me.dongheelee.epoxysample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val users = listOf(
        "Mario Speedwagon",
        "Petey Cruiser",
        "Anna Sthesia",
        "Paul Molive",
        "Anna Mull",
        "Gail Forcewind",
        "Paige Turner",
        "Bob Frapples",
        "Walter Melon",
        "Nick R. Bocker",
        "Barb Ackue",
        "Buck Kinnear",
        "Greta Life",
        "Ira Membrit",
        "Shonda Leer",
        "Brock Lee",
        "Maya Didas",
        "Rick O'Shea",
        "Pete Sariya",
        "Monty Carlo"
    ).mapIndexed { id, name ->
        val thumbnail = (id % 16).let {
            when {
                it == 0 -> "img_avatar_16"
                it < 10 -> "img_avatar_0${it}"
                else -> "img_avatar_${it}"
            }
        }
        User(id.toLong(), name, thumbnail, (0..100).random())
    }

    private val controller = FollowerController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        container.setController(controller)
        controller.setData(users)
    }
}
