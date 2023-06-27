package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity  {
TextView ans, inputText;
MaterialButton btn_7,btn_8,btn_9, btn_4, btn_5, btn_6, btn_1,btn_2, btn_3,btn_0, btn_00,
        btn_point,btn_c, btn_modulas, btn_AC,btn_divide,btn_multi,btn_substract, btn_add,btn_equal;
String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getIntent();
        ans=findViewById(R.id.ans);
        inputText=findViewById(R.id.inputText);
        btn_7=findViewById(R.id.btn_7);
        btn_8=findViewById(R.id.btn_8);
        btn_9=findViewById(R.id.btn_9);
        btn_4=findViewById(R.id.btn_4);
        btn_5=findViewById(R.id.btn_5);
        btn_6=findViewById(R.id.btn_6);
        btn_1=findViewById(R.id.btn_1);
        btn_2=findViewById(R.id.btn_2);
        btn_3=findViewById(R.id.btn_3);
        btn_0=findViewById(R.id.btn_0);
        btn_point=findViewById(R.id.btn_point);
        btn_c=findViewById(R.id.btn_c);
        btn_modulas=findViewById(R.id.btn_modulas);
        btn_AC=findViewById(R.id.btn_ac);
        btn_divide=findViewById(R.id.btn_divide);
        btn_multi=findViewById(R.id.btn_multiply);
        btn_substract=findViewById(R.id.btn_minus);
        btn_add=findViewById(R.id.btn_add);
        btn_equal=findViewById(R.id.btn_equal);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+"0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+"1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+"2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+"3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+"4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+"5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+"6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+"7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+"8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+"9");
            }
        });

        btn_AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(" ");
                ans.setText(" ");
            }
        });

        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+".");
            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                String res= data.substring(0,data.length()-1);
                inputText.setText(res);
            }
        });

        btn_modulas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+"%");
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+"÷");
            }
        });

        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+"×");
            }
        });

        btn_substract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+"-");
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputText.getText().toString();
                inputText.setText(data+"+");
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data =inputText.getText().toString();

              data=data.replaceAll("×","*");
                data=data.replaceAll("÷","/");
                data=data.replaceAll("%","/100");

                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);
                String final_result="";
                Scriptable scriptable=rhino.initSafeStandardObjects();
                final_result=rhino.evaluateString(scriptable,data,"Javascript",1,null).toString();
                ans.setText(final_result);
            }
        });
    }

}