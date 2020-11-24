package rauan.ferreira.provap2;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Firebase {
    private static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    public static List<Person> people = new ArrayList<Person>();
    public static ArrayAdapter list = null;

    public static void addPerson(Person person) {
        mDatabase.child("people").child(person.name).setValue(person);
    }


    public static void getPeople() {
        mDatabase.child("people").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                people = new ArrayList<>();

                for(DataSnapshot child : dataSnapshot.getChildren()) {
                    Person person = child.getValue(Person.class);
                    people.add(person);
                }

                list.clear();
                list.addAll(people);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("Error", "loadPost:onCancelled", databaseError.toException());
            }
        });
    }
}
