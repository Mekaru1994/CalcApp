package jp.techacademy.takaaki.mekaru.calcapp;

import android.content.Intent;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import static java.lang.Double.doubleToLongBits;
import static java.lang.Double.parseDouble;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){

        EditText editText1 = (EditText)findViewById(R.id.editText1);
        EditText editText2 = (EditText)findViewById(R.id.editText2);

        String str1 = editText1.getText().toString();
        String str2 = editText2.getText().toString();
        String result;

        if (str1.equals("") || str2.equals("")) {
            Snackbar.make(view, "数値を入力してください。", Snackbar.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(str1);
        double b = Double.parseDouble(str2);
        double c = 0;

        if(view.getId() == R.id.button1){
            c = a+b;
        }else if(view.getId() == R.id.button2){
            c = a-b;
        }else if(view.getId() == R.id.button3){
            c = a*b;
        }else if(view.getId() == R.id.button4){
            c = a/b;
        }

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", c);
        startActivity(intent);


    }
}
