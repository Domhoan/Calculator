package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class ShowFragment : Fragment() {

    var ctString : String? = null
    var oldString : String? = null


    private var tvShowCT: TextView?=null
    private var tvShowKQ: TextView?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_show, container, false)
        tvShowCT = view.findViewById(R.id.tvShowCT)
        tvShowKQ = view.findViewById(R.id.tvShowKQ)
        return view
    }

    fun getText(newString: String){
        oldString = tvShowCT?.text.toString()
        when(newString){
            "CLEAR" -> {
                ctString = null
                tvShowCT!!.text = ctString
                tvShowKQ!!.text = ctString
            }

            "DEL" -> {
                if (oldString!= "") {
                    var str: String = oldString!!.substring(0, oldString!!.length - 1);
                    tvShowCT!!.text = str
                } else {
                    tvShowCT!!.text = null
                }
            }

            "EQUAL" -> {
                var mgr = ScriptEngineManager()
                var engine  = mgr.getEngineByName("javascript")
                try {
                    var result : String = engine.eval(oldString).toString()
                    tvShowKQ!!.text = result
                } catch (se: ScriptException){
                   // No problem
                }
            }

            else -> {
                ctString = oldString + newString
                tvShowCT!!.text = ctString
            }
        }
    }

    companion object {
        @JvmStatic
        var instance: ShowFragment? = null
            get() {
                if (field == null) {
                    field = ShowFragment()
                }
                return field
            }
            private set
    }
}