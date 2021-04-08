package com.tecjaunt.ramzanapp

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application.getProcessName
import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.util.Log
import android.webkit.WebView
import android.widget.FrameLayout
import android.widget.RelativeLayout
import com.google.android.gms.ads.*
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd.load
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import okhttp3.internal.Util
import java.util.*

@SuppressLint("StaticFieldLeak")
object AdManger {

    private lateinit var adCallBackInterstisial: FullScreenContentCallback
    var mIntersital: InterstitialAd?=null
    var mRewardedAd: RewardedAd? = null
    var mRewardItem = false
    private lateinit var mContext: Context
    var adCallBackRewardedAd: CallBackRewardedAd? = null



    var context: Context?=null
    var loadRewarStatus = false
    var adLayout: RelativeLayout? = null
    var adView: AdView? = null

//    private const val interstitialAdsSimple = "ca-app-pub-3005749278400559~3051755351"
    private const val interstitialAds = "ca-app-pub-6505777977604901/1441290559"
//    private const val interstitialAds2 = "ca-app-pub-3005749278400559/3150514625"
//
//
//    private const val rewarded_video_add_id ="ca-app-pub-3005749278400559/5869258872"
//    private const val rewarded_video_add_id_2 ="ca-app-pub-3005749278400559/8564588138"



    @JvmStatic
    fun init(context: Context) {
//        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val process = getProcessName()
                if (context.packageName != process) WebView.setDataDirectorySuffix(process)
            }

            MobileAds.initialize(context)
//            AudienceNetworkAds.initialize(this)

//        } catch (e: Error) {
//            e.printStackTrace()
//        } catch (e: Exception) {
//           e.printStackTrace()
//        }
//        MobileAds.initialize(context)
//        mIntersital = InterstitialAd(context)
//        mIntersital.adUnitId = interstitialAds
        this.context = context
    }

    @JvmStatic
    fun loadBannerAds(layout: RelativeLayout, activity: Activity) {
        //Log.e("myAds", "lyaout found")
        adLayout = layout
        bannerAd(activity)
    }

    /**************************************Banner Ads *****************************/
    fun bannerAd(activity: Activity) {
        (setUpAds(activity))
    }

    private const val BANNER_ID_1 = "ca-app-pub-6505777977604901/2343676249"
    private const val BANER_ID_2 = "ca-app-pub-6505777977604901/9462822208"

    private fun setUpAds(activity: Activity) {
        try {
            adView = AdView(activity)

            if (laodBannerId()){
                adView!!.adUnitId = BANER_ID_2
            }else{
                adView!!.adUnitId = BANER_ID_2
            }

            val adSize = adSize(activity)
            adView!!.adSize = adSize
            adLayout!!.addView(adView)
            val request = AdRequest.Builder().build()
            adView!!.loadAd(request)
        } catch (e: Exception) {
            e.printStackTrace()
        }catch (e:Error){
            e.printStackTrace()
        }

    }

    private fun loadBanner(activity: Activity) {
        adView = AdView(context)
        adView!!.adUnitId = activity.getString(R.string.banner_ads)
        val adSize = adSize(activity)
        adView!!.adSize = AdSize.SMART_BANNER
        adLayout!!.addView(adView)
        val adRequest = AdRequest.Builder().build()
        // Start loading the ad in the background.
        try {
            adView!!.loadAd(adRequest)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    // Determine the screen width (less decorations) to use for the ad width.
    fun adSize(activity: Activity): AdSize {
        try {
            // Determine the screen width (less decorations) to use for the ad width.
            val display = activity.windowManager.defaultDisplay
            val outMetrics = DisplayMetrics()
            display.getMetrics(outMetrics)
            val density = outMetrics.density
            var adWidthPixels = adLayout!!.width.toFloat()
            // If the ad hasn't been laid out, default to the full screen width.
            if (adWidthPixels == 0f) {
                adWidthPixels = outMetrics.widthPixels.toFloat()
            }
            val adWidth = (adWidthPixels / density).toInt()
            return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, adWidth)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            return AdSize.BANNER
        }
    }
    @JvmStatic
    fun loadInterstial(context: Context,adCallback: FullScreenContentCallback) {
//
//        adCallbackInterstisial = adCallback
//        if (!mIntersital.isLoaded) {
//
//            try {
//                if (laodIntersititalId()){
//                    mIntersital!!.adUnitId = interstitialAds
//                }else{
//                    mIntersital!!.adUnitId = interstitialAds2
//                }
//                if (Util.isNetworkAvailable(context!!)) {
//                    mIntersital.loadAd(AdRequest.Builder().build())
//                    Log.e("myAds", "loadAds")
//                }
//
//            } catch (ex: Exception) {
//                ex.printStackTrace()
//            }
//
//        }

        adCallBackInterstisial = adCallback
        /** ads rokh di hn loading  **/
        try {
            if (mIntersital == null) {
                if (laodIntersititalId()) {
                    val adRequest = AdRequest.Builder().build()
                    InterstitialAd.load(
                        context,
                        interstitialAds,
                        adRequest,
                        object : InterstitialAdLoadCallback() {
                            override fun onAdFailedToLoad(loadingError: LoadAdError) {
                                super.onAdFailedToLoad(loadingError)
                                Log.e("error", loadingError.message)
                                mIntersital = null
                            }

                            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                                super.onAdLoaded(interstitialAd)
                                mIntersital = interstitialAd
                            }
                        })
                } else {
                    val adRequest = AdRequest.Builder().build()
                    InterstitialAd.load(
                        context,
                        interstitialAds,
                        adRequest,
                        object : InterstitialAdLoadCallback() {
                            override fun onAdFailedToLoad(loadingError: LoadAdError) {
                                super.onAdFailedToLoad(loadingError)
                                Log.e("error", loadingError.message)
                                mIntersital = null
                            }

                            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                                super.onAdLoaded(interstitialAd)
                                mIntersital = interstitialAd
                            }
                        })
                }
            }


            adListner(adCallback)
        }catch (e:Exception){
            e.printStackTrace()
        }catch (e:Error){
            e.printStackTrace()
        }

//        try {
//            mIntersital.let {
//                if (!it.isLoaded) {
//                    if (laodIntersititalId()){
//
//                        it.adUnitId = interstitialAds
//                    }else{
//
//                        it.adUnitId = interstitialAds2
//                    }
//                    if (Util.isNetworkAvailable(context)) {
//                        it.loadAd(AdRequest.Builder().build())
//                        Log.e("myAds", "loadAds")
//                    }
//                    adListner(adCallback)
//                } else {
//                    Log.d("myAds", "Ads is already load")
//                }
//            }
//        } catch (e: UninitializedPropertyAccessException) {
//            e.printStackTrace()
//            init(context)
//        }

    }



    @JvmStatic
    fun loadRewardedAd(activity: Activity, adCallBack: CallBackRewardedAd) {

        adCallBackRewardedAd = adCallBack

        try {

            if (BuildConfig.DEBUG) {

                if (mRewardedAd == null) {
//                    mRewardedAd = RewardedAd(activity, activity.baseContext!!.resources.getString(R.string.rewarded_video_add_id_2))
//                    loadRewardAds()

                } else {

                    if (mRewardedAd!!.isLoaded) {
                        Log.e("TAG", "Ads is already load")
                    } else {
//                        loadRewardAds()
                    }
                }

            } else {

                if (mRewardedAd == null) {

                    if (loadRewarStatus) {
                        mRewardedAd = RewardedAd(activity, "rewarded_video_add_id")
                        Log.e("TAG", "Ads is laoding id 2 load")
                    } else {
                        mRewardedAd = RewardedAd(activity, "rewarded_video_add_id_2")
                        Log.e("TAG", "Ads is laoding id 2 load")
                    }

//                    loadRewardAds()

                    loadRewarStatus = !loadRewarStatus

                } else {

                    if (mRewardedAd!!.isLoaded) {
                        Log.e("TAG", "Ads is already load")
                    } else {

                        if (loadRewarStatus) {
                            mRewardedAd = RewardedAd(activity, "rewarded_video_add_id")
                            Log.e("TAG", "Ads is already load")
                        } else {
                            mRewardedAd = RewardedAd(activity, "rewarded_video_add_id_2")
                            Log.e("TAG", "Ads is laoding id 2 load")
                        }

//                        loadRewardAds()
                        loadRewarStatus = !loadRewarStatus
                    }


                }

            }

        } catch (e: UninitializedPropertyAccessException) {
            e.printStackTrace()
            init(activity)
        }


    }

//    private fun loadRewardAds() {
//        mRewardedAd?.loadAd(AdRequest.Builder().build(), object : RewardedAdLoadCallback() {
//            override fun onRewardedAdLoaded() {
//                super.onRewardedAdLoaded()
//                Log.e("TAG", "onRewardedAdFailedToLoad")
//            }
//
//            override fun onRewardedAdFailedToLoad(i: Int) {
//                @Suppress("DEPRECATION")
//                super.onRewardedAdFailedToLoad(i)
//                Log.e("TAG", "onRewardedAdFailedToLoad")
//            }
//        })
//    }

//    @JvmStatic
//    fun showRewardedVideo(activity: Activity, adCallBack: CallBackRewardedAd) {
//
//        adCallBackRewardedAd = adCallBack
//
//        if (mRewardedAd == null) {
//            loadRewardedAd(activity, adCallBack)
//        } else {
//
//            if (mRewardedAd!!.isLoaded) {
//                mRewardItem = false
//
//                mRewardedAd!!.show(activity, object : RewardedAdCallback() {
//                    override fun onUserEarnedReward(rewardItem: RewardItem) {
//                        adCallBackRewardedAd?.onUserEarnedReward(rewardItem)
//                        mRewardItem = true
//                    }
//                    override fun onRewardedAdClosed() {
//                        super.onRewardedAdClosed()
//                        adCallBackRewardedAd?.onRewardedAdClosed()
//                    }
//                })
//
//                loadRewardedAd(activity, adCallBack)
//
//            } else {
//                loadRewardedAd(activity, adCallBack)
//            }
//        }
//
//    }
//
//
////    @JvmStatic
//    fun showInterstial(adCallback: AdManagerListener?,change:String) {
//
//        adCallbackInterstisial = adCallback
//
//        if (mIntersital.isLoaded) {
//            mIntersital.show()
//            Log.e("myAds", "showAds")
//        }
//
//        mIntersital.adListener = object : AdListener() {
//
//            override fun onAdClosed() {
//
//                try {
//                    adCallbackInterstisial?.onAdClose(change)
//                } catch (ex: Exception) {
//                    ex.printStackTrace()
//                }
//            }
//        }
//
//    }

    @JvmStatic
    private fun adListner(adCallback: FullScreenContentCallback) {

        mIntersital?.fullScreenContentCallback=adCallback

//        mIntersital?.let {

//            it.adListener= adCallback
//            it.adListener = object : AdListener() {
//
//                override fun onAdLoaded() {
//                    Log.d("AdManager", "Ad Loaded sdfdsdfsdfsdf")
//                    adCallBackInterstisial?.onAdLoaded()
//                }
//
//                override fun onAdFailedToLoad(errorCode: Int) {
//                    if (errorCode == AdRequest.ERROR_CODE_NO_FILL) {
//                        Log.d("AdManager", "Ad Failed To Load = Ad request successful, but no ad returned due to lack of ad inventory.")
//                    }
//                    adCallBackInterstisial?.onAdFailedToLoad(errorCode)
//                }
//
//                override fun onAdOpened() {
//                    Log.d("AdManager", "Ad Opened")
//                    adCallBackInterstisial?.onAdOpened()
//                }
//
//                override fun onAdClicked() {
//                    Log.d("AdManager", "Ad Clicked")
//                    adCallBackInterstisial?.onAdClicked()
//                }
//
//                override fun onAdLeftApplication() {
//                    Log.d("AdManager", "User Left Application")
//                    adCallBackInterstisial?.onAdLeftApplication()
//                }
//
//                override fun onAdClosed() {
//                    Log.d("AdManager", "Ad Closed")
//                    loadInterstial(mContext, adCallBackInterstisial!!)
//                    adCallBackInterstisial?.onAdClose()
//                }
//
//            }
//        }
    }


    interface CallBackRewardedAd {
        fun onRewardedAdLoaded()
        fun onRewardedAdFailedToLoad(loadAdError: LoadAdError)

        fun onUserEarnedReward(rewardItem: RewardItem)
        fun onRewardedAdClosed()
        fun onRewardedAdFailedToShow(adError: AdError)
        fun onRewardedAdOpened()
    }

    @JvmStatic
    fun showInterstial(activity: Activity,context: Context, adCallBack: FullScreenContentCallback) {
        adCallBackInterstisial = adCallBack
        if (mIntersital!=null) {
            mIntersital!!.show(activity)
            loadInterstial(context, adCallBack)
        } else {
            loadInterstial(context, adCallBack)
        }

    }

    @JvmStatic
    fun isInterstialLoaded(): Boolean {
        return mIntersital!=null
    }

    @JvmStatic
    fun isRewardedAdLoaded(): Boolean {
        return if (mRewardedAd == null) {
            false
        } else {
            mRewardedAd!!.isLoaded
        }
    }

//
    interface AdManagerListener {
        fun onAdClose(catname: String, pos: Int)
        fun onAdClose(string: String)
        fun onAdCloseActivity()
    }

    private var bannerStatus: Boolean = false
    private var intersititalStatus: Boolean = false

    //This method call only when you'r using more then one banner id
    private fun laodBannerId(): Boolean {
        bannerStatus = !bannerStatus
        return bannerStatus
    }
    //This method call only when you'r using more then one banner id
    private fun laodIntersititalId(): Boolean {
        intersititalStatus = !intersititalStatus
        return intersititalStatus
    }
}