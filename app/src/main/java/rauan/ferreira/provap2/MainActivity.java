package rauan.ferreira.provap2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.openForm);

        Intent formView = new Intent(this, Form.class);

        btn.setOnClickListener(view -> {
            startActivity(formView);
        });

        ListView peopleList = findViewById(R.id.people);

        ArrayAdapter<Person> data = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, Firebase.people);

        Firebase.list = data;

        Firebase.getPeople();


        peopleList.setAdapter(data);
    }
}