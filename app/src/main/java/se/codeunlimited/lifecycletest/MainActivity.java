package se.codeunlimited.lifecycletest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import se.codeunlimited.lifecycletest.test1.Test1Activity;
import se.codeunlimited.lifecycletest.test2.Test2Activity;
import se.codeunlimited.lifecycletest.test3.Test3Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTest1(View view) {
        startActivity(new Intent(this, Test1Activity.class));
    }

    public void startTest2(View view) {
        startActivity(new Intent(this, Test2Activity.class));
    }

    public void startTest3(View view) {
        startActivity(new Intent(this, Test3Activity.class));
    }
}
