package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.WorkSource;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity {

    TextView workspace;
    String s="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workspace = (TextView) findViewById(R.id.workspace);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

    }



    //numbers and symbols clicking event
    public void onButClick(View v){
        if(s.length()<14){
            workspace.setTextSize(TypedValue.COMPLEX_UNIT_DIP,50);
        }
        else{
            workspace.setTextSize(TypedValue.COMPLEX_UNIT_DIP,30);

        }
            switch (v.getId()) {
                case R.id.one:
                    s = s + "1";



                    break;
                case R.id.two:
                    s = s + "2";
                    break;
                case R.id.three:
                    s = s + "3";
                    break;
                case R.id.four:
                    s = s + "4";
                    break;
                case R.id.five:
                    s = s + "5";
                    break;
                case R.id.six:
                    s = s + "6";
                    break;
                case R.id.seven:
                    s = s + "7";
                    break;
                case R.id.eight:
                    s = s + "8";
                    break;
                case R.id.nine:
                    s = s + "9";
                    break;
                case R.id.point:
                    s = s + ".";
                    break;
                case R.id.zer:
                    s = s + "0";
                    break;
                case R.id.twozeroes:
                    s = s + "00";
                    break;
                case R.id.plus:
                    s = s + "+";
                    break;
                case R.id.sub:
                    s = s + "-";
                    break;
                case R.id.mul:
                    s = s + "*";
                    break;
                case R.id.div:
                    s = s + "/";
                    break;
                case R.id.lpar:
                    s = s + "(";
                    break;
                case R.id.rpar:
                    s = s + ")";
                    break;
                case R.id.clear:
                    s = "";
                    break;
                case R.id.delone:
                    if (s.length() > 0) {
                        s = s.substring(0, s.length() - 1);
                    }
                    break;

            }
            workspace.setText(s);
    }

    //EqualButton Click Event
    public void evalute(View v){
           String res="";

               try {
                   Expression exp = new ExpressionBuilder(s).build();
                   double result = exp.evaluate();
                   res = Double.toString(result);

               } catch (Exception x) {
                   Toast.makeText(this, "Invalid Expression", Toast.LENGTH_SHORT).show();
                   s = "";
               }
               s = res;
               workspace.setText(res);



    }
}
