package ch11.id_map;

import java.util.HashMap;
import java.util.Map;

public class IdMap {
    private Map people = new HashMap();

    public static void addPerson(Person arg) {
        soleInstance.people.put(arg.getId(), arg);
    }

    public static Person getPerson(Long key) {
        return (Person) soleInstance.people.get(key);
    }

    public static Person getPerson(long key) {
        return getPerson(Long.valueOf(key));
    }
}
