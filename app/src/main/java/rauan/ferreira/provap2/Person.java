package rauan.ferreira.provap2;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Person {
    public String name;
    public Integer age;

    public Person() {

    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("age", age);

        return result;
    }

    public String toString() {

        return this.name;
    }
}
