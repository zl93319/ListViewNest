package com.bupa.listviewnest.util;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.TypedValue;


import java.io.File;

/**
 * 作者: l on 2016/11/1 18:05
 * 邮箱: xjs250@163.com
 * 描述: 用来提供和资源，上下文相关工具
 */
public class UIUtils {

    /**
     * 全局的上下文
     */
    private static Context mBaseContext;
    private static Handler mHandler;

    /**
     * 初始化工具
     * @param application
     */
    public static void init(Application application) {
        mBaseContext = application;

        //在主线程中new
        mHandler = new Handler();
    }
    // 发起一个post的请求
    public static void post(Runnable task) {
        mHandler.post(task);
    }
    // 延迟加载一个任务
    public static void postDelayed(Runnable task, long delayed) {
        mHandler.postDelayed(task, delayed);
    }
    // 移除所有的回调函数
    public static void removeCallbacks(Runnable task) {
        mHandler.removeCallbacks(task);
    }
    // 获取资源文件夹
    public static Resources getResources() {
        return mBaseContext.getResources();
    }
    // 获取资源文件夹的字符串数组
    public static String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }
    // 全局的上下文对象
    public static Context getContext() {
        return mBaseContext;
    }
    // 获取包名
    public static String getPackageName() {
        return getContext().getPackageName();
    }
    // 获取缓存文件夹
    public static File getCacheDir() {
        return getContext().getCacheDir();
    }

    /**
     * dp --> px
     * @param dp
     * @return
     */
    public static float dp2px(float dp) {
        float dimension = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,
                dp,
                getResources().getDisplayMetrics());
        return dimension;
    }
    // 将px转换为dp
    public static float px2dp(float px) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                px,
                getResources().getDisplayMetrics());
    }
    // 获取资源文件夹的字符串
    public static String getString(int id, Object... formatArgs) {
        return getResources().getString(id, formatArgs);
    }

}
