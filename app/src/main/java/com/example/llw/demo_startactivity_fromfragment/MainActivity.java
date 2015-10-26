package com.example.llw.demo_startactivity_fromfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout linearLayout;
    private Button btnFragment1;
    private Button btnFragment2;
    private FrameLayout framLayout;
    private FragmentManager fragmentManager;
    private  Fragment_1 fragment_1;
    private  Fragment_2 fragment_2;

    private int  Requestcode_ID =1;
    private void assignViews() {
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        btnFragment1 = (Button) findViewById(R.id.btn_fragment1);
        btnFragment2 = (Button) findViewById(R.id.btn_fragment2);
        framLayout = (FrameLayout) findViewById(R.id.fram_layout);
        btnFragment2.setOnClickListener(this);
        btnFragment1.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        fragmentManager = getFragmentManager();
    }


    @Override
    public void onClick(View v) {
        setAllbutton();

        switch (v.getId()) {
            case R.id.btn_fragment1:
                fun(0);
                break;
            case R.id.btn_fragment2:
                fun(1);
                break;
        }
    }

    public void setAllbutton() {
        btnFragment1.setTextColor(Color.BLUE);
        btnFragment1.setBackgroundColor(Color.RED);
        btnFragment2.setTextColor(Color.BLUE);
        btnFragment2.setBackgroundColor(Color.RED);

    }

    public void fun(int index) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        cleanAllbackgroudcolor(fragmentTransaction);

        switch (index)
        {
            case 0:
                btnFragment1.setTextColor(Color.WHITE);
                btnFragment1.setBackgroundColor(Color.BLACK);

                if (fragment_1==null)
                {
                    fragment_1 = new Fragment_1();
                    fragmentTransaction.add(R.id.fram_layout,fragment_1);
                }else {
                    fragmentTransaction.show(fragment_1);
                }
                break;
            case 1:
                btnFragment2.setTextColor(Color.WHITE);
                btnFragment2.setBackgroundColor(Color.BLACK);

                if (fragment_2==null)
                {
                    fragment_2 = new Fragment_2();
                    fragmentTransaction.add(R.id.fram_layout,fragment_2);
                }else {
                    fragmentTransaction.show(fragment_2);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    public void cleanAllbackgroudcolor( FragmentTransaction fragmentTransaction) {
        if (fragment_1!=null)
        {
            fragmentTransaction.hide(fragment_1);
        }

        if (fragment_2!=null)
        {
            fragmentTransaction.hide(fragment_2);
        }
    }
    /*??????????????????????????????????????????????????????????????????????????????????????????????????????*/
    public  void  fun()
    {
        Intent intent = new Intent(MainActivity.this,Fragment_1.class);
        startActivityForResult(intent,Requestcode_ID);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1)
        {
            if (resultCode==0x11)
            {
                String str = data.getExtras().getString("H");
                Toast.makeText(MainActivity.this, "从第一个fragment中返回的结果是："+str, Toast.LENGTH_SHORT).show();
            }
        }

    }
}
