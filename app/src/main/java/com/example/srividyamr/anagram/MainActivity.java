package com.example.srividyamr.anagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Object;
import java.util.Arrays;
import java.util.Random;

class anagram {
    public static String retstr() {
        String s[] = {"astronomer", "cinema", "the classroom", "peek", "eat",
                "acres", "airmen", "alter", "sale", "deal",
                "allergy", "name", "angel", "pat", "rats",
                "coats", "asleep", "ear", "auction", "break",
                "bats", "begin", "below", "bores", "caller",
                "paces", "crate", "clasp", "dare", "danger",
                "rated", "designs", "diets", "demo", "dilate",
                "paired", "does", "drawer", "dues", "earnest",
                "earth", "emit", "ones", "steer", "evil",
                "wolf", "snug", "hops", "inks", "male"};
        Random r = new Random();
        int n = r.nextInt(50);
        String s1 = s[n];
        return s1;
    }

    public static int ana(String s1,String c) {
        s1 = s1.replaceAll("\\s", "");
        String c1 = c;
        c1 = c1.replaceAll("\\s", "");
        boolean status = true;
        if (s1.length() != c1.length())
            status = false;
        else {
            char[] ss1 = s1.toLowerCase().toCharArray();
            char[] cc1 = c1.toLowerCase().toCharArray();
            Arrays.sort(ss1);
            Arrays.sort(cc1);
            status = Arrays.equals(ss1, cc1);
        }
        if(status)
            return 1;
        else
            return 0;
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.but1);
        TextView t1 = (TextView) findViewById(R.id.tv1);
        final EditText e1 = (EditText) findViewById(R.id.et);
        final anagram a=new anagram();

        final String str=a.retstr();
        t1.setText(str);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredData = e1.getText().toString();
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                int b=a.ana(str,enteredData);
                if(b==1)
                {
                    i.putExtra("custom-tag","CORRECT");
                    startActivity(i);
                }
                else
                {
                    i.putExtra("custom-tag","WRONG");
                    startActivity(i);
                }
            }
        });
    }

}
