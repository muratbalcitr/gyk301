package com.gyk.gyk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {

    private ListView listView;
    private StudentAdapter studentAdapter;
    private ArrayList<Student> students = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        students.add(new Student("a", "b", 0));

        students.add(new Student("Metin Şimşek", "cehennemmelegi", 24));
        students.add(new Student("Ayşe Sönmez", "ucamayankelebek", 27));
        students.add(new Student("Can Tunga", "kodunsairi", 57));
        students.add(new Student("Sarı Kanarya", "fenerbahce", 112));
        students.add(new Student("CİMBOM","cimbom",114));
        students.add(new Student("Kartal","bjkKARTAL",116));
        students.add(new Student("Rıdvan Dilmen", "seytan", 58));
        students.add(new Student("3426", "rakipsiz", 1));

        listView = findViewById(R.id.listView);

        studentAdapter = new StudentAdapter(CustomListViewActivity.this, students);
        listView.setAdapter(studentAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomListViewActivity.this, students.get(position).getFullname(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
