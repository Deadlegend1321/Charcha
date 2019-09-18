package com.example.charcha;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button reg,lg,del;
    EditText name,ph;
    databasehelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new databasehelper(this);
        reg = (Button)findViewById(R.id.reg);
        lg = (Button)findViewById(R.id.lg);
        del = (Button)findViewById(R.id.del);
        name = (EditText)findViewById(R.id.name);
        ph = (EditText)findViewById(R.id.ph);
        deletedata();
        viewall();
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lg.setVisibility(View.INVISIBLE);
                del.setVisibility(View.INVISIBLE);
                reg.setVisibility(View.INVISIBLE);
                name.setVisibility(View.INVISIBLE);
                ph.setVisibility(View.INVISIBLE);
                getSupportFragmentManager().beginTransaction().replace(R.id.contu,new RegisterFragment()).commit();

            }
        });

    }

    public void viewall(){
        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = mydb.getAllData();
                if (res.getCount()==0){
                    showmsg("Error","Nothing found");
                    return;
                }
                StringBuffer bf = new StringBuffer();
                while (res.moveToNext())
                {
                    String s = bf.append(res.getString(1)).toString();
                    String st = bf.append(res.getString(2)).toString();
                   // Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    //startActivity(i);
                    if (s.compareTo(name.getText().toString())==0 && st.compareTo(ph.getText().toString())==0)
                    {
                        Intent j = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(j);
                    }

                }
            }
        });
    }
    public void showmsg(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void deletedata(){
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydb.deleteData();
            }
        });
    }

}
