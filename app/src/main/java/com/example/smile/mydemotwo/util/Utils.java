package com.example.smile.mydemotwo.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

/**
 * Description:
 * Created by LiBing
 * Data:2017/7/28 10:26
 */

public class Utils {

    /**
     * 获取应用程序versionname
     */
    public static String getVersionName(Context context) {
        String versionName = "1.0.0";
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }

    public static void printLog() {
        String error = null;
        Log.e("libing", error);
    }
}
