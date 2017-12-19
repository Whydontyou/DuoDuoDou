package com.feidu.duoduodou.bottomnavigat

/**
 * Created by wangjian on 2017/12/15.
 */

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.feidu.duoduodou.R

/**
 * Class description

 * @author ashokvarma
 * *
 * @version 1.0
 * *
 * @see
 * @since 10 Jul 2017
 */
internal const val KEY_MESSAGE = "message"

fun newTextFragmentInstance(message: String): TextFragment {
    val textFragment = TextFragment()


    return textFragment
}

class TextFragment : Fragment() {

    internal var msg = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_text, container, false)

        return view
    }
}