import java.util.ArrayList;
import java.util.Comparator;
class School {
    ArrayList<Person> members;

    public School() {
        members = new ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
    }
    public String toString() {
        members.sort(Comparator.comparing(Person::getSurname, Comparator.nullsFirst(Comparator.naturalOrder())));

        StringBuilder result = new StringBuilder();
        for (Person member : members) {
            result.append(member.toString()).append("\n");
        }
        return result.toString();
    }
}