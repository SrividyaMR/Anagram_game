package com.example.srividyamr.anagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.String;
import android.content.Intent;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button b2=(Button) findViewById(R.id.but2);
        TextView t2=(TextView) findViewById(R.id.tv2);
        Bundle bundle=getIntent().getExtras();
        String data=bundle.getString("custom-tag");
        if(data!=null)
            t2.setText(data);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(in);
            }
        });

    }
}
