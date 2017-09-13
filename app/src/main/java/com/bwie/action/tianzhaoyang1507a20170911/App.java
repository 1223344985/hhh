package com.bwie.action.tianzhaoyang1507a20170911;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * Created by ASUS on 2017/9/11.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
