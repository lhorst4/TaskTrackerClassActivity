package com.example.tasktrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    LinkedList<String> tasks;
    ListView listView;
    EditText input;

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String newTask = input.getText().toString();
            newTask = newTask.trim();
            if(newTask.length()>0) {
                addToList(newTask);
            }else{
                Toast.makeText(getApplicationContext(),"Cannot ass an empty task", Toast.LENGTH_LONG).show();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.task_list);
        input = findViewById(R.id.input_et);
    }

    public void addToList(String t){
        if(tasks == null){
            tasks =  new LinkedList<>();
        }
        if(tasks.size()==7) {
            tasks.remove(0);
        }
        tasks.add(t);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listView.setAdapter(adapter);
    }

}