package com.example.smile.mydemotwo.andfix;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;

import java.io.File;

/**
 * Description:1、检查patch文件 2、下载patch文件 3、加载patch文件
 * Created by LiBing
 * Data:2017/7/28 14:35
 */

public class AndFixService extends Service {

    private static final int UPDATE_PATCH = 0x02;
    private static final int DOWNLOAD_PATCH = 0x01;
    private static final String FILE_END = ".apatch";
    //存放Patch文件的目录
    private String mPatchFileDir;
    //存放Patch文件
    private String mPatchFile;
    //消息转发
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_PATCH:
                    checkPatchUpdate();
                    break;
                case DOWNLOAD_PATCH:
                    downloadPatch();
                    break;
            }
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        init();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mHandler.sendEmptyMessage(UPDATE_PATCH);
        //这个返回值如果被系统回收之后不会被系统重启
        return START_NOT_STICKY;
    }

    //完成文件目录的构造
    private void init() {
        mPatchFileDir = getExternalCacheDir().getAbsolutePath() + "/apatch/";
        File file = new File(mPatchFileDir);
        try {
            if (file == null || !file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
            stopSelf();
        }
    }

    //检查是否有新的patch文件
    private void checkPatchUpdate() {
        //网络请求,失败停止服务
    }

    private void downloadPatch() {
        //网络请求,失败停止服务
        mPatchFile = mPatchFileDir.concat(System.currentTimeMillis() + "").concat(FILE_END);
    }

}
