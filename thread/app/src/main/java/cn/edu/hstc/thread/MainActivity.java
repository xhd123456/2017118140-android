package cn.edu.hstc.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {

    public static final int UPDATE_TEXT = 1;
    private int counter;

    private TextView text;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    // 在这里可以进行UI操作
                    text.setText("Nice to meet you");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.bt);
        text = findViewById(R.id.text);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DemoThread thread = new DemoThread();
                Log.d("子线程号：", "" + thread.getId());
                try {
                    thread.start();
                } catch (Exception e) {

                }
                Log.d("子线程号：", "" + Thread.currentThread().getId());
                text.setText("我是：" + counter);
           }
        });
    }

    class DemoThread extends Thread {
        public void run() {
            try {
                Thread.sleep(200);
            } catch (Exception e) {

            }
            counter++;
        }

    }
}
