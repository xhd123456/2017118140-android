package cn.edu.hstc.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class hello2 extends AppCompatActivity {
    public static final String TAG="hello2";
    Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d(TAG, "onCreate execute");
        bt1=(Button) findViewById(R.id.btTohello1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*Intent intent=new Intent();
            intent.setClass(hello1.this,hello2.class);*/
                Intent intent=new Intent(hello2.this, hello1.class);
                startActivity(intent);
            }
        });
        bt2=(Button) findViewById(R.id.btTohello2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*Intent intent=new Intent();
            intent.setClass(hello1.this,hello2.class);*/
                Intent intent=new Intent(hello2.this, hello2.class);
                startActivity(intent);
            }
        });
        setTitle("欢迎来到hello2");
    }

}
