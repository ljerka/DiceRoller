package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.diceroller.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bRoll.text = "Let's roll"
        binding.bRoll.setOnClickListener {
            //Toast.makeText(this, "Let's roll!", Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }

    private fun rollDice() {
        val diceValue = Random().nextInt(6) + 1
        //binding.tvDiceValue.text = diceValue.toString()
        val image = when (diceValue) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.ivDice.setImageResource(image)
    }
}

/*
* Napomene:
* vektorske slike podržane su od levela 21 na novije, za starije se automatski konverta u png
* i te slike znaju biti ultra velike i crashati mobitel; workaround:
* - u gradle u defaultConfig{} dodati vectorDrawables.useSupportLibrary = true
* - u xml koji poziva vektor dodati namespace app (res-auto) i svaki android:src izmijeniti u app:srcCompat
*  (podržava do api levela 7)
* */