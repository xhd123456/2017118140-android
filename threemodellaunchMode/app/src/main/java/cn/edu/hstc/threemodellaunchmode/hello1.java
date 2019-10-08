package cn.edu.hstc.threemodellaunchmode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class hello1 extends AppCompatActivity {

    Button bt1,bt2,bt3;
    public static final String TAG="hello1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate execute");
        setContentView(R.layout.activity_main);
        bt1=(Button) findViewById(R.id.btTohello1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*Intent intent=new Intent();
            intent.setClass(hello1.this,hello2.class);*/
                Intent intent=new Intent(hello1.this, hello1.class);
                startActivity(intent);
            }
        });
        bt2=(Button) findViewById(R.id.btTohello2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*Intent intent=new Intent();
            intent.setClass(hello1.this,hello2.class);*/
                Intent intent=new Intent(hello1.this, hello2.class);
                startActivity(intent);
            }
        });
        setTitle("欢迎来到hello1");
        bt3=(Button) findViewById(R.id.btTohello3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hello1.this,hello3.class);
                startActivity(intent);

            }
        });

    }
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart execute");
    }

    @Override
    protected void onResume() { //恢复
        super.onResume();
        Log.d(TAG, "onResume execute");
    }

    @Override
    protected void onPause() { //暂停
        super.onPause();
        Log.d(TAG, "onPause execute");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop execute");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy execute");
    }
}
