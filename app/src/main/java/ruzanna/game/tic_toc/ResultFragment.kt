package ruzanna.game.tic_toc

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ResultFragment : Fragment() {
    var gamer1: User? = null
    var gamer2: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("tets", "onCreate")
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("tets", "onCreateView")
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultG1 = view.findViewById<TextView>(R.id.resultG1)
        val resultG2 = view.findViewById<TextView>(R.id.resultG2)
        if(savedInstanceState == null){
            resultG1.text = "${gamer1?.name} ${gamer1?.result?.sum()}"
            resultG2.text = "${gamer2?.name} ${gamer1?.result?.sum()}"
        }else{
            val g1 = savedInstanceState.getParcelable<User>("g1")
            if(g1 != null){
                resultG1.text = "${g1.name} ${g1.result.sum()}"
            }
            val g2 = savedInstanceState.getParcelable<User>("g2")
            if(g2 != null){
                resultG2.text = "${g2.name} ${g2.result.sum()}"
            }
        }

    }

    fun test(savedInstanceState: Bundle?){
        view?.let { this.onViewCreated(it,  savedInstanceState) }
    }
}

