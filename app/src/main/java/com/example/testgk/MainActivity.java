package com.example.testgk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.testgk.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view =binding.getRoot();
        setContentView(view);

        arrayList=new ArrayList<String>();
        arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        binding.listItem.setAdapter(arrayAdapter);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String a= binding.editText1.getText().toString();
                String b= binding.editText2.getText().toString();
                if(!a.equals("") && !b.equals("")){
                    if(isNumber(a) && isNumber(b)){

                        Float x=Float.parseFloat(a);
                        Float y=Float.parseFloat(b);
                        if(y==0){
                            Toast toast=Toast.makeText(MainActivity.this,"so chia phai khac 0", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,20,30);
                            toast.show();
                        }
                        else {
                            binding.text.setText(x + " / " + y + "=" + (float) x / y);
                            arrayList.add(binding.text.getText().toString());
                            arrayAdapter.notifyDataSetChanged();
                        }

                    }
                    else {
                        Toast toast=Toast.makeText(MainActivity.this,"du lieu khong phai la so", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,20,30);
                        toast.show();
                    }
                }
                else {
                    Toast toast = Toast.makeText(MainActivity.this, "ban chua nhap so", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 20, 30);
                    toast.show();
                }
            }
        });
    }
    public boolean isNumber(String string){
        return string.matches("-?\\d+(\\.\\d+)?");
    }

}