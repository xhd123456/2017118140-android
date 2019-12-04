package cn.edu.hstc.server;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startService=findViewById(R.id.start_serive);
        Button stopService=findViewById(R.id.stop_srtive);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_serive:
                Intent startIntent=new Intent(this,MyService.class);
                startActivity(startIntent);
                break;
            case R.id.stop_srtive:
                Intent stopIntent=new Intent(this,MyService.class);
                startActivity(stopIntent);
                break;
        }
    }
}
