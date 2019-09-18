package com.example.charcha;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment
{
    databasehelper mydb;
    EditText n,mb,em;
    Button r;



    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View frag = inflater.inflate(R.layout.fragment_register, container, false);
        mydb=new databasehelper(getActivity());
        r=(Button)frag.findViewById(R.id.r);
        n=(EditText)frag.findViewById(R.id.n);
        mb=(EditText)frag.findViewById(R.id.mb);
        em=(EditText)frag.findViewById(R.id.em);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hua(n.getText().toString(),mb.getText().toString(),em.getText().toString());

            }
        });

        return frag;
    }


   private void hua(String us,String mob,String id)
    {
        int counter = 0,last =0;
        char c = us.charAt(0);
        int k = (int)c;
        if (k>=48 && k<=57){
            Toast.makeText(getActivity(),"Invalid name",Toast.LENGTH_SHORT).show();
            last++;}
        if (mob.length()!=10){
            Toast.makeText(getContext(),"Invalid Mobile No.",Toast.LENGTH_SHORT).show();
            last++;}
        int l = id.length();
        for (int i=0;i<l;i++)
        {
            char ch=id.charAt(i);
            if(ch=='@')
            {
                counter++;
                break;
            }

        }
        if (counter != 1){
            Toast.makeText(getActivity(),"Invalid Email Id",Toast.LENGTH_SHORT).show();
            last++;}
        if (last==0)
        {
            boolean x =  mydb.insertdata(n.getText().toString(),mb.getText().toString());
            if (x==true){
                Toast.makeText(getActivity(),"Data Inserted",Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(getActivity(),"Data not Inserted",Toast.LENGTH_SHORT).show();

            Intent j = new Intent(getActivity(), Main2Activity.class);
            startActivity(j);
        }

    }

}
