package jp.yuki.senda.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import jp.yuki.senda.calcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btPlus.setOnClickListener(this)
        binding.btMinus.setOnClickListener(this)
        binding.btMultiplication.setOnClickListener(this)
        binding.btDivision.setOnClickListener(this)
    }

    //クリックした時の処理
    override fun onClick(v: View) {
        //インテントのインスタンスを取得
        val intent = Intent(this, ResultActivity::class.java)

        //未入力の時
        if(binding.edit1.text.isEmpty() || binding.edit2.text.isEmpty()){
            Toast.makeText(this, "数値を入力してください。", Toast.LENGTH_SHORT).show()
        }else{
        //編集型（editText）→ String型 → Double型へ変換
        val value1 = binding.edit1.text.toString().toDouble()
        val value2 = binding.edit2.text.toString().toDouble()

            //四則演算結果の変数を用意
            val resultPlus = value1 + value2
            val resultMinus = value1 - value2
            val resultMultiplication = value1 * value2
            val resultDivision = value1 / value2

            //各ボタンで条件分岐
            when (v.id) {
                R.id.btPlus -> intent.putExtra("VALUE", resultPlus)
                R.id.btMinus -> intent.putExtra("VALUE", resultMinus)
                R.id.btMultiplication -> intent.putExtra("VALUE", resultMultiplication)
                R.id.btDivision -> intent.putExtra("VALUE", resultDivision)
            }
            startActivity(intent)
        }
    }
}