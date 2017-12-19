package com.feidu.duoduodou


import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.widget.TextView
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.feidu.duoduodou.bottomnavigat.TextFragment
import com.feidu.duoduodou.bottomnavigat.newTextFragmentInstance
import com.feidu.duoduodou.duihuan.DuiHuanFragment
import com.feidu.duoduodou.duihuan.newDuiHuan
import com.feidu.duoduodou.shouye.ShouYeFragment
import com.feidu.duoduodou.shouye.showYeFragment

class MainActivity : AppCompatActivity(), BottomNavigationBar.OnTabSelectedListener {
    override fun onTabSelected(position: Int) {
//        lastSelectedPosition = position

        /*numberBadgeItem.setText(Integer.toString(position))*/
        replaceFragments(position)
    }

    lateinit internal var bottomNavigationBar: BottomNavigationBar
    lateinit internal var message: TextView

    lateinit internal var fragment1: ShouYeFragment
    lateinit internal var fragment2: DuiHuanFragment
    lateinit internal var fragment3: TextFragment
    lateinit internal var fragment4: TextFragment
    var first: Boolean = true
    override fun onTabUnselected(position: Int) {}

    override fun onTabReselected(position: Int) {

    }



    private fun replaceFragments(position: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        if (first) {
            transaction.add(R.id.home_activity_frag_container, fragment1)
            transaction.add(R.id.home_activity_frag_container, fragment2)
            transaction.add(R.id.home_activity_frag_container, fragment3)
            transaction.add(R.id.home_activity_frag_container, fragment4)
            first = false
        }

        transaction.apply {
            hideFragment(transaction)
            when (position) {
                0 -> show(fragment1)
                1 -> show(fragment2)
                2 -> show(fragment3)
                3 -> show(fragment4)
            }
        }
        transaction.commit()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initview()
    }

    fun initview() {
        bottomNavigationBar = findViewById<BottomNavigationBar>(R.id.bottom_navigation_bar)
        fragment1 = showYeFragment()
        fragment2 = newDuiHuan()
        fragment3 = newTextFragmentInstance(getString(R.string.para3))
        fragment4 = newTextFragmentInstance(getString(R.string.para4))
        bottomNavigationBar.setTabSelectedListener(this)
        bottomNavigationBar.selectTab(0, true)
        bottomNavigationBar.setBackgroundStyle(1)
        bottomNavigationBar.setMode(1)
        bottomNavigationBar.setBarBackgroundColor(R.color.nav_bg)
        bottomNavigationBar
                .addItem(BottomNavigationItem(R.drawable.nav_home, "首页").setActiveColorResource(R.color.orange))
                .addItem(BottomNavigationItem(R.drawable.nav_duihuan, "兑换").setActiveColorResource(R.color.teal))
                .addItem(BottomNavigationItem(R.drawable.nav_yaoqing, "邀请").setActiveColorResource(R.color.blue))
                .addItem(BottomNavigationItem(R.drawable.nav_my, "我的").setActiveColorResource(R.color.brown))
                .initialise()
    }

    //隐藏所有的fragment
    private fun hideFragment(transaction: FragmentTransaction?) {
        if (fragment1 != null) {
            transaction!!.hide(fragment1)
        }
        if (fragment2 != null) {
            transaction!!.hide(fragment2)
        }
        if (fragment3 != null) {
            transaction!!.hide(fragment3)
        }
        if (fragment4 != null) {
            transaction!!.hide(fragment4)
        }
    }

}
