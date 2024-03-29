package com.wlp.crique;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    private void init() {
        CirqueProgressControlView ccv = (CirqueProgressControlView) findViewById(R.id.ccv);
        ccv.setProgressRange(0, 100);//可以在xml中指定，也可以在代码中设置
        //        ccv.setIsAnim(false);//这个方法必须在setProgress之前执行
        ccv.setProgress(50);  //添加默认数据--注:不能超出范围
        ccv.setOnTextFinishListener(new CirqueProgressControlView.OnCirqueProgressChangeListener() {
            @Override
            public void onChange(int minProgress, int maxProgress, int progress) {
            }
            @Override
            public void onChangeEnd(int minProgress, int maxProgress, int progress) {
                showToast(MainActivity.this, "control finish. last progress is " + progress );
            }
        });


    }
    @SuppressLint("ShowToast")
    private void showToast(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context,
                    content,
                    Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }

}
