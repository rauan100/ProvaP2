package rauan.ferreira.provap2;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Firebase {
    private static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    public static List<Person> people = new ArrayList<Person>();

    public static void addPerson(Person person) {
        mDatabase.child("people").child(person.name).setValue(person);
    }
}
