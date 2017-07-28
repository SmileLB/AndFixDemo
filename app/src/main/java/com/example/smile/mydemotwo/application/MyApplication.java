package com.example.smile.mydemotwo.application;

import android.app.Application;

import com.example.smile.mydemotwo.andfix.AndFixPatchManager;

/**
 * Description:
 * Created by LiBing
 * Data:2017/7/28 10:30
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //完成andFix模块的初始化
        initAndFix();
    }

    private void initAndFix() {
        AndFixPatchManager.getInstance().initPatch(this);
    }
}
