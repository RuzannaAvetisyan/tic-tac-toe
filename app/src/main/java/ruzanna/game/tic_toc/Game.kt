package ruzanna.game.tic_toc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.io.Serializable


class Game : AppCompatActivity()  {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.game)
        val extras = intent.extras
        if (extras != null) {
            val queue = findViewById<TextView>(R.id.queue)
            val gamer1: User = extras.get("g1") as User
            val gamer2: User = extras.get("g2") as User
            val g1Name = gamer1.name
            val g2Name = gamer2.name
            var g1Queue = gamer1.queue
            val g1Walk = gamer1.walk
            val g2Walk = gamer2.walk
            val imageView = findViewById<ImageView>(R.id.imageView)
            queue.text = if(g1Queue) g1Name else g2Name
            imageView.setImageResource(R.drawable.x)
            val r1c1 = findViewById<TextView>(R.id.r1c1)
            val r1c2 = findViewById<TextView>(R.id.r1c2)
            val r1c3 = findViewById<TextView>(R.id.r1c3)
            val r2c1 = findViewById<TextView>(R.id.r2c1)
            val r2c2 = findViewById<TextView>(R.id.r2c2)
            val r2c3 = findViewById<TextView>(R.id.r2c3)
            val r3c1 = findViewById<TextView>(R.id.r3c1)
            val r3c2 = findViewById<TextView>(R.id.r3c2)
            val r3c3 = findViewById<TextView>(R.id.r3c3)
            val result = findViewById<Button>(R.id.result)
            fun clear(){
                r1c1.text = ""
                r1c2.text = ""
                r1c3.text = ""
                r2c1.text = ""
                r2c2.text = ""
                r2c3.text = ""
                r3c1.text = ""
                r3c2.text = ""
                r3c3.text = ""
            }
            fun checker(): Pair<Boolean, String>{
                var endGame = false
                var winner = ""
                when{
                    r1c1.text == r1c2.text && r1c3.text == r1c2.text && r1c1.text != ""-> {
                        endGame = true
                        winner = r1c1.text.toString()
                    }
                    r2c1.text == r2c2.text && r2c3.text == r2c2.text && r2c1.text != "" -> {
                        endGame = true
                        winner = r2c1.text.toString()
                    }
                    r3c1.text == r3c2.text && r3c3.text == r3c2.text && r3c1.text != "" ->  {
                        endGame = true
                        winner = r3c1.text.toString()
                    }
                    r1c1.text == r2c1.text && r3c1.text == r2c1.text && r1c1.text != "" ->  {
                        endGame = true
                        winner = r1c1.text.toString()
                    }
                    r1c2.text == r2c2.text && r3c2.text == r2c2.text && r2c2.text != "" ->  {
                        endGame = true
                        winner = r1c2.text.toString()
                    }
                    r1c3.text == r2c3.text && r3c3.text == r2c3.text && r2c3.text != "" ->  {
                        endGame = true
                        winner = r1c3.text.toString()
                    }
                    r1c1.text == r2c2.text && r3c3.text == r2c2.text && r2c2.text != "" ->  {
                        endGame = true
                        winner = r2c2.text.toString()
                    }
                    r1c3.text == r2c2.text && r3c1.text == r2c2.text && r2c2.text != "" ->  {
                        endGame = true
                        winner = r2c2.text.toString()
                    }
                    r1c1.text != "" && r1c2.text != "" && r1c3.text != "" &&
                            r2c1.text != "" && r2c2.text != "" && r2c3.text != "" &&
                            r3c1.text != "" && r3c2.text != "" && r3c3.text != "" -> {
                        endGame = true
                    }
                }
                return Pair(endGame, winner)
            }

            r1c1.setOnClickListener{
                g1Queue = setText(r1c1, g1Queue, g1Walk, g2Walk,queue, g1Name, g2Name)
                if(g1Queue) imageView.setImageResource(R.drawable.x) else imageView.setImageResource(R.drawable.o)
                val res = checker()
                if(res.endGame){
                    g1Queue = showResult(res.winner, g1Name, g2Name, g1Queue, gamer1, gamer2)
                    clear()
                }
            }
            r1c2.setOnClickListener {
                g1Queue = setText(r1c2, g1Queue, g1Walk, g2Walk, queue, g1Name, g2Name)
                if(g1Queue) imageView.setImageResource(R.drawable.x) else imageView.setImageResource(R.drawable.o)
                val res = checker()
                if(res.endGame){
                    g1Queue = showResult(res.winner, g1Name, g2Name, g1Queue, gamer1, gamer2)
                    clear()
                }
            }
            r1c3.setOnClickListener {
                g1Queue = setText(r1c3, g1Queue, g1Walk, g2Walk, queue, g1Name, g2Name)
                if(g1Queue) imageView.setImageResource(R.drawable.x) else imageView.setImageResource(R.drawable.o)
                val res = checker()
                if(res.endGame){
                    g1Queue = showResult(res.winner, g1Name, g2Name, g1Queue, gamer1, gamer2)
                    clear()
                }
            }
            r2c1.setOnClickListener {
                g1Queue = setText(r2c1, g1Queue, g1Walk, g2Walk, queue, g1Name, g2Name)
                if(g1Queue) imageView.setImageResource(R.drawable.x) else imageView.setImageResource(R.drawable.o)
                val res = checker()
                if(res.endGame){
                    g1Queue = showResult(res.winner, g1Name, g2Name, g1Queue, gamer1, gamer2)
                    clear()
                }
            }
            r2c2.setOnClickListener {
                g1Queue = setText(r2c2, g1Queue, g1Walk, g2Walk, queue, g1Name, g2Name)
                if(g1Queue) imageView.setImageResource(R.drawable.x) else imageView.setImageResource(R.drawable.o)
                val res = checker()
                if(res.endGame){
                    g1Queue = showResult(res.winner, g1Name, g2Name, g1Queue, gamer1, gamer2)
                    clear()
                }
            }
            r2c3.setOnClickListener {
                g1Queue = setText(r2c3, g1Queue, g1Walk, g2Walk, queue, g1Name, g2Name)
                if(g1Queue) imageView.setImageResource(R.drawable.x) else imageView.setImageResource(R.drawable.o)
                val res = checker()
                if(res.endGame){
                    g1Queue = showResult(res.winner, g1Name, g2Name, g1Queue, gamer1, gamer2)
                    clear()
                }
            }
            r3c1.setOnClickListener {
                g1Queue = setText(r3c1, g1Queue, g1Walk, g2Walk, queue, g1Name, g2Name)
                if(g1Queue) imageView.setImageResource(R.drawable.x) else imageView.setImageResource(R.drawable.o)
                val res = checker()
                if(res.endGame){
                    g1Queue = showResult(res.winner, g1Name, g2Name, g1Queue, gamer1, gamer2)
                    clear()
                }
            }
            r3c2.setOnClickListener {
                g1Queue = setText(r3c2, g1Queue, g1Walk, g2Walk, queue, g1Name, g2Name)
                if(g1Queue) imageView.setImageResource(R.drawable.x) else imageView.setImageResource(R.drawable.o)
                val res = checker()
                if(res.endGame){
                    g1Queue = showResult(res.winner, g1Name, g2Name, g1Queue, gamer1, gamer2)
                    clear()
                }
            }
            r3c3.setOnClickListener {
                g1Queue = setText(r3c3, g1Queue, g1Walk, g2Walk, queue, g1Name, g2Name)
                if(g1Queue) imageView.setImageResource(R.drawable.x) else imageView.setImageResource(R.drawable.o)
                val res = checker()
                if(res.endGame){
                    g1Queue = showResult(res.winner, g1Name, g2Name, g1Queue, gamer1, gamer2)
                    clear()
                }
            }
            result.setOnClickListener{
                val intent = Intent(this, GameRes::class.java)
                intent.putExtra("g1", gamer1)
                intent.putExtra("g2", gamer2)
                startActivityForResult(intent, 1000)
            }

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun showResult(winner: String, g1Name: String, g2Name: String, g1Queue: Boolean, gamer1: User, gamer2: User): Boolean {
        val imageView = findViewById<ImageView>(R.id.imageView)
        val queue = findViewById<TextView>(R.id.queue)
        return when(winner){
            "X" -> {
                Toast.makeText(applicationContext, "$g1Name win !!!",
                    Toast.LENGTH_LONG).show()
                gamer1.result = gamer1.result.append("1")
                gamer2.result = gamer2.result.append("0")
                queue.text = gamer1.name
                imageView.setImageResource(R.drawable.x)
                true
            }
            "O" -> {
                Toast.makeText(applicationContext, "$g2Name win !!!",
                    Toast.LENGTH_LONG).show()
                gamer1.result = gamer1.result.append("0")
                gamer2.result = gamer2.result.append("1")
                queue.text = gamer2.name
                imageView.setImageResource(R.drawable.o)
                false
            }
            else ->{
                Toast.makeText(applicationContext, "Draw",
                    Toast.LENGTH_LONG).show()
                gamer1.result = gamer1.result.append("0")
                gamer2.result = gamer2.result.append("0")
                if(g1Queue) imageView.setImageResource(R.drawable.x) else imageView.setImageResource(R.drawable.o)
                if(g1Queue) queue.text = gamer1.name else queue.text = gamer2.name
                g1Queue
            }
        }
    }

    fun Array<String>.append(element: String): Array<String> {
        val list: MutableList<String> = this.toMutableList()
        list.add(element)
        return list.toTypedArray()
    }

    private fun setText(text: TextView, g1Queue: Boolean, g1Walk: String, g2Walk: String,
                        queue: TextView, g1Name: String, g2Name: String
    ): Boolean {
        if(text.text == ""){
            text.text = if(g1Queue) g1Walk else g2Walk
            setTextCollor(text)
            if(text.text == "X") queue.text =  g2Name else queue.text =  g1Name
            return !g1Queue
        }
        return g1Queue
    }
    private fun setTextCollor(text: TextView) {
        if(text.text == "X"){
            text.setTextColor(ContextCompat.getColor(this, R.color.black))
        } else text.setTextColor(ContextCompat.getColor(this, R.color.red))
    }
}

data class Pair<Boolean, String>(val endGame: Boolean, val winner: String): Serializable