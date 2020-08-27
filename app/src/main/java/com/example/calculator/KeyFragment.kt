package com.example.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class KeyFragment : Fragment() {

    private var sendTextListener: SendTextListener? = null

    fun setSendTextListener(sendTextListener: SendTextListener?) {
        this.sendTextListener = sendTextListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_key, container, false)
        val btnOne: Button = view.findViewById(R.id.btnOne)
        val btnTwo: Button = view.findViewById(R.id.btnTwo)
        val btnThree: Button = view.findViewById(R.id.btnThree)
        val btnFour: Button = view.findViewById(R.id.btnFour)
        val btnFive: Button = view.findViewById(R.id.btnFive)
        val btnSix: Button = view.findViewById(R.id.btnSix)
        val btnSeven: Button = view.findViewById(R.id.btnSeven)
        val btnEight: Button = view.findViewById(R.id.btnEight)
        val btnNine: Button = view.findViewById(R.id.btnNine)
        val btnZero: Button = view.findViewById(R.id.btnZero)
        val btnDot: Button = view.findViewById(R.id.btnDot)
        val btnMul: Button = view.findViewById(R.id.btnMul)
        val btnDivide: Button = view.findViewById(R.id.btnDivide)
        val btnMinus: Button = view.findViewById(R.id.btnMinus)
        val btnPlus: Button = view.findViewById(R.id.btnPlus)
        val btnOpen: Button = view.findViewById(R.id.btnOpen)
        val btnClose: Button = view.findViewById(R.id.btnClose)
        val btnClear: Button = view.findViewById(R.id.btnClear)
        val btnDel : Button = view.findViewById(R.id.btnDel)
        val btnEquals: Button = view.findViewById(R.id.btnEquals)

        btnClear.setOnClickListener { sendTextListener!!.sendText("CLEAR") }
        btnDel.setOnClickListener { sendTextListener!!.sendText("DEL") }
        btnEquals.setOnClickListener { sendTextListener!!.sendText("EQUAL") }
        initView(btnOne)
        initView(btnTwo)
        initView(btnThree)
        initView(btnFour)
        initView(btnFive)
        initView(btnSix)
        initView(btnSeven)
        initView(btnEight)
        initView(btnNine)
        initView(btnZero)
        initView(btnDot)
        initView(btnMul)
        initView(btnDivide)
        initView(btnMinus)
        initView(btnPlus)
        initView(btnOpen)
        initView(btnClose)

        return view
    }

    private fun initView(button: Button) {
        button.setOnClickListener { sendTextListener!!.sendText(button.text.toString()) }
    }

    companion object {
        @JvmStatic
        var instance: KeyFragment? = null
            get() {
                if (field == null) {
                    field = KeyFragment()
                }
                return field
            }
            private set
    }
}