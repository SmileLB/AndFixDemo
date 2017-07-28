package com.example.smile.mydemotwo.andfix;

import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;
import com.example.smile.mydemotwo.util.Utils;

/**
 * Description:管理AndFix所有的API
 * Created by LiBing
 * Data:2017/7/28 10:17
 */

public class AndFixPatchManager {

    private static AndFixPatchManager mInstance = null;

    private static PatchManager mPatchManager = null;

    private AndFixPatchManager() {
    }

    public static AndFixPatchManager getInstance() {
        if (mInstance == null) {

            synchronized (AndFixPatchManager.class) {

                if (mInstance == null) {

                    mInstance = new AndFixPatchManager();

                }
            }
        }
        return mInstance;
    }

    //初始化AndFix方法
    public void initPatch(Context context) {
        mPatchManager = new PatchManager(context);
        mPatchManager.init(Utils.getVersionName(context));
        mPatchManager.loadPatch();
    }

    //加载我们的patch文件,参数patch文件的路径
    public void addPatch(String path) {
        try {
            if (mPatchManager != null) {
                mPatchManager.addPatch(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
