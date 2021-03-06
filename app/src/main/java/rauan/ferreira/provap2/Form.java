package rauan.ferreira.provap2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Button btn = findViewById(R.id.register);

        TextView name = findViewById(R.id.name);
        TextView age = findViewById(R.id.age);

        btn.setOnClickListener(view -> {
            this.registerUser(name.getText().toString(), Integer.parseInt(age.getText().toString()));
        });
    }

    private void registerUser(String name, Integer age) {
        Person person = new Person(name, age);
        Firebase.addPerson(person);

        Toast.makeText(getApplicationContext(), "Usuário inserido com sucesso", Toast.LENGTH_LONG).show();
    }
}