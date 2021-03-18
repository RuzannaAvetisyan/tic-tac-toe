package ruzanna.game.tic_toc

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val start = findViewById<Button>(R.id.start)
        val fName = findViewById<EditText>(R.id.First)
        val sName = findViewById<EditText>(R.id.Second)

        start.setOnClickListener {
            val arr:Array<String> = arrayOf()
            val firstGamer = User(fName.text.toString().capitalize(), arr, true, "X")
            val secondGamer = User(sName.text.toString().capitalize(),arr, false, "O")

            if(fName.text.toString() != "" && sName.text.toString() != ""){
                val intent = Intent(this, Game::class.java)
                intent.putExtra("g1", firstGamer)
                intent.putExtra("g2", secondGamer)
                startActivity(intent)
                finish()
            }
        }
    }
}
