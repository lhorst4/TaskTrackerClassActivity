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

    LinkedList<Task> tasks;
    ListView listView;
    EditText task_input;
    EditText owner_input;

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String tastText = task_input.getText().toString();
            String owner = owner_input.getText().toString();
            tastText = tastText.trim();
            if(tastText.length()>0) {
                Task newTask = new Task(tastText, owner);
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
        task_input = findViewById(R.id.input_et);
        owner_input = findViewById(R.id.owner_et);
    }

    public void addToList(Task t){
        if(tasks == null){
            tasks =  new LinkedList<>();
        }
        tasks.add(t);
        ArrayAdapter<Task> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listView.setAdapter(adapter);
    }

}