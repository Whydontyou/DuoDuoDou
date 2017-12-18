package com.feidu.duoduodou

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.feidu.duoduodou.bottomnavigat.TextFragment
import com.feidu.duoduodou.bottomnavigat.newTextFragmentInstance
import com.feidu.duoduodou.shouye.ShouYeFragment
import com.feidu.duoduodou.shouye.showYeFragment

class MainActivity : AppCompatActivity(), BottomNavigationBar.OnTabSelectedListener {
    override fun onTabSelected(position: Int) {
//        lastSelectedPosition = position
        setMessageText(position.toString() + " Tab Selected")
        /*numberBadgeItem.setText(Integer.toString(position))*/
        replaceFragments(position)
    }

    lateinit internal var bottomNavigationBar: BottomNavigationBar
    lateinit internal var message: TextView

    lateinit internal var fragment1: ShouYeFragment
    lateinit internal var fragment2: TextFragment
    lateinit internal var fragment3: TextFragment
    lateinit internal var fragment4: TextFragment

    override fun onTabUnselected(position: Int) {}

    override fun onTabReselected(position: Int) {
        setMessageText(position.toString() + " Tab Reselected")
    }

    private fun setMessageText(messageText: String) {
        message.text = messageText
    }

    private fun replaceFragments(position: Int) {
        supportFragmentManager.beginTransaction().apply {
            when (position) {
                0 -> replace(R.id.home_activity_frag_container, fragment1)
                1 -> replace(R.id.home_activity_frag_container, fragment2)
                2 -> replace(R.id.home_activity_frag_container, fragment3)
                3 -> replace(R.id.home_activity_frag_container, fragment4)

            }
        }.commitAllowingStateLoss()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initview()
    }

    fun initview() {
        bottomNavigationBar = findViewById<BottomNavigationBar>(R.id.bottom_navigation_bar)
        message = findViewById<TextView>(R.id.message)
        fragment1 = showYeFragment()
        fragment2 = newTextFragmentInstance(getString(R.string.para2))
        fragment3 = newTextFragmentInstance(getString(R.string.para3))
        fragment4 = newTextFragmentInstance(getString(R.string.para4))

        bottomNavigationBar.setTabSelectedListener(this)
        bottomNavigationBar.selectTab(0, true)
        bottomNavigationBar.setBackgroundStyle(1)
        bottomNavigationBar.setMode(1)
        bottomNavigationBar.setBarBackgroundColor(R.color.nav_bg)
        bottomNavigationBar
                .addItem(BottomNavigationItem(R.drawable.nav_home, "首页").setActiveColorResource(R.color.orange))
                .addItem(BottomNavigationItem(R.drawable.nav_duihuan, "兑换").setActiveColorResource(R.color.teal)    )
                .addItem(BottomNavigationItem(R.drawable.nav_yaoqing, "邀请").setActiveColorResource(R.color.blue))
                .addItem(BottomNavigationItem(R.drawable.nav_my, "我的").setActiveColorResource(R.color.brown))
                .initialise()
    }
}
