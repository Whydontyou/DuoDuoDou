package com.feidu.duoduodou.shouye

/**
 * Created by wangjian on 2017/12/16.
 */
/*
<cn.bingoogolapple.bgabanner.BGABanner
android:id="@+id/banner_main_fade"
style="@style/BannerDefaultStyle"
app:banner_transitionEffect="fade" />*/

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import cn.bingoogolapple.bgabanner.BGABanner
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.feidu.duoduodou.App
import com.feidu.duoduodou.BannerBean
import com.feidu.duoduodou.R
import com.feidu.duoduodou.bottomnavigat.KEY_MESSAGE
import com.feidu.duoduodou.bottomnavigat.TextFragment
import com.feidu.duoduodou.http.net.UrlPath.UrlIMG
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.fragment_shouye.*
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Class description

 * @author ashokvarma
 * *
 * @version 1.0
 * *
 * @see
 * @since 10 Jul 2017
 */
private var mZoomBanner: BGABanner? = null
var listImg=ArrayList<String>()
var listTip=ArrayList<String>()

fun showYeFragment(): ShouYeFragment {
    val shouYeFragment = ShouYeFragment()
    return shouYeFragment
}

class ShouYeFragment : Fragment(), BGABanner.Delegate<ImageView, String>, BGABanner.Adapter<ImageView, String> {
    override fun onBannerItemClick(banner: BGABanner?, itemView: ImageView?, model: String?, position: Int) {
        Toast.makeText(banner?.getContext(), "点击了第" + (position + 1) + "页", Toast.LENGTH_SHORT).show()
    }

    override fun fillBannerItem(banner: BGABanner?, itemView: ImageView?, model: String?, position: Int) {
        Glide.with(itemView?.getContext())
                .load(model)
                .apply(RequestOptions().placeholder(R.drawable.holder).error(R.drawable.holder).dontAnimate().centerCrop())
                .into(itemView)
    }

    internal var msg = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* msg = arguments.getString(KEY_MESSAGE, "")*/
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_shouye, container, false)
        mZoomBanner = view.findViewById(R.id.banner_main_zoom)
        // (view.findViewById<TextView>(R.id.tf_textview)).text = msg
        mZoomBanner?.setDelegate(showYeFragment())
        //轮播
        indata()
        return view
    }

    fun indata() {
        val num = App.getRetrofitUtil().getRetrofit().getLunBo("1")
        num.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(object : Subscriber<JsonObject>() {
            override fun onCompleted() {
            }
            override fun onError(e: Throwable) {
            }
            override fun onNext(jsonObject: JsonObject) {
                val gson = Gson()
                val bannerModel = gson.fromJson<BannerBean>(jsonObject, BannerBean::class.java!!)
                mZoomBanner?.setAutoPlayAble(bannerModel.data.size > 1)
                if (listImg.size>0){
                    listImg.clear()
                    listTip.clear()
                }
                for (img in bannerModel.data){
                    listImg.add(UrlIMG+img.imgUrl)
                }
                for (tip in bannerModel.data){
                    listTip.add("")
                }

                mZoomBanner?.setAdapter(showYeFragment())
                mZoomBanner?.setData(listImg, listTip)

            }
        })
    }
}