package com.example.smile.mydemotwo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.smile.mydemotwo.R;
import com.example.smile.mydemotwo.andfix.AndFixPatchManager;
import com.example.smile.mydemotwo.andfix.AndFixService;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_END = ".apatch";
    private String patchDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*//创建文件路径
        patchDir = getExternalCacheDir().getAbsolutePath() + "/apatch/";
        //创建文件夹
        File file = new File(patchDir);
        //判断文件夹是否存在
        if (file == null || !file.exists()) {
            //不存在就创建
            file.mkdir();
        }*/

        startAndFixService();
    }

    private void startAndFixService() {
        startService(new Intent(this, AndFixService.class));
    }

    public void createBug(View view) {
        //打印log信息为null，应用闪退
        //Utils.printLog();
        Toast.makeText(this, "bug已解决", Toast.LENGTH_SHORT).show();
    }

    public void fixBug(View view) {
        AndFixPatchManager.getInstance().addPatch(getPathName());
    }

    //构建Patch文件名
    private String getPathName() {
        return patchDir.concat("smile").concat(FILE_END);
    }
}
