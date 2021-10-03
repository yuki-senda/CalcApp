package jp.yuki.senda.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.yuki.senda.calcapp.databinding.ActivityMainBinding
import jp.yuki.senda.calcapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calcResult = intent.getDoubleExtra("VALUE", 0.0)

        binding.calcResult.text = calcResult.toString()
    }
}