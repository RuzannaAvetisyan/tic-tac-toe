package ruzanna.game.tic_toc

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class GameRes: AppCompatActivity()  {
    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val extras = intent.extras
        if (extras != null){
            val gamer1: User = extras.get("g1") as User
            val gamer2: User = extras.get("g2") as User
            val g1Name = gamer1.name
            val g2Name = gamer2.name
            val g1 = findViewById<TextView>(R.id.G1)
            val g2 = findViewById<TextView>(R.id.G2)
            val g1Res = findViewById<TextView>(R.id.G1Res)
            val g2Res = findViewById<TextView>(R.id.G2Res)
            g1.text = g1Name
            g2.text = g2Name
            val g1Arr = gamer1.result
            val g2Arr = gamer2.result

            val sList = findViewById<ListView>(R.id.second_list)
            val g2arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
                this,
                R.layout.list_view,
                R.id.textView,
                g2Arr
            )
            sList.adapter = g2arrayAdapter

            val fList = findViewById<ListView>(R.id.first_list)
            val g1arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
                this,
                R.layout.list_view,
                R.id.textView,
                g1Arr
            )
            fList.adapter = g1arrayAdapter
            g1Res.text = "Result ${g1Arr.sum()}"
            g2Res.text = "Result ${g2Arr.sum()}"
        }




    }
}

private fun Array<String>.sum():Int {
    var s = 0
    for(i in this){
        s += i.toInt()
    }
    return s
}
