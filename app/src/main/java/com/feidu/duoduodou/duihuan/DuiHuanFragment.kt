package com.feidu.duoduodou.duihuan

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.feidu.duoduodou.App
import com.feidu.duoduodou.R
import com.feidu.duoduodou.bean.BannerBean
import com.feidu.duoduodou.bean.DuihuanLeiBie
import com.feidu.duoduodou.bean.TabNewEntity
import com.flyco.tablayout.CommonTabLayout
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.google.gson.Gson
import com.google.gson.JsonObject
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.ArrayList


/**
 * Created by wangjian on 2017/12/18.
 */

internal const val KEY_MESSAGE = "message"
internal var tablay: CommonTabLayout? = null
private val mTabEntities = ArrayList<CustomTabEntity>()
private val list = ArrayList<DuihuanLeiBie.DataBean>()
fun newDuiHuan(): DuiHuanFragment {
    val duihuanFragment = DuiHuanFragment()

    return duihuanFragment
}

class DuiHuanFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_duihuan, container, false)

        initView(view)
        tabLay()
        return view
    }

    fun initView(view: View) {
        tablay= view.findViewById<CommonTabLayout>(R.id.commtab)
    }

    //横向列表数据
    fun tabLay() {
        App.getRetrofitUtil().getRetrofit().getDuihuanLiebia().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(object : Subscriber<JsonObject>() {
            override fun onCompleted() {
            }

            override fun onError(e: Throwable) {
            }

            override fun onNext(jsonObject: JsonObject) {
                mTabEntities.clear()
                val leibie = Gson().fromJson<DuihuanLeiBie>(jsonObject, DuihuanLeiBie::class.java!!)
                list.add(DuihuanLeiBie.DataBean("0", "全部"))
                for (i in 0 until leibie.getData().size) {
                    list.add(DuihuanLeiBie.DataBean(leibie.getData().get(i).getID(), leibie.getData().get(i).getName()))
                }

                mTabEntities.add(TabNewEntity("全部"))
                for (i in 0 until leibie.getData().size) {
                    mTabEntities.add(TabNewEntity(leibie.getData().get(i).getName().toString()))
                }
                tablay?.setTabData(mTabEntities)
                tab()

            }
        })
    }

    private fun tab() {
        tablay?.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {

            }

            override fun onTabReselect(position: Int) {

            }
        })
    }
}