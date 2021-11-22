package tb.soft;

import java.util.Comparator;
import java.util.Objects;

class BettaPerson extends Person implements Comparable{
    public BettaPerson(String first_name, String last_name) throws PersonException {
        super(first_name, last_name);
    }
    String firstName = getFirstName();
    String lastName = getLastName();
    int birthYear = getBirthYear();

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthYear);
    }

    @Override
    public boolean equals(Object o) {
        birthYear = getBirthYear();
        System.out.println("Sprawdzam czy to te same osoby");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BettaPerson person = (BettaPerson) o;
        System.out.println(birthYear + " "+ person.getBirthYear());
        return birthYear == person.getBirthYear()
                && Objects.equals(firstName, person.firstName)
                && lastName.equals(person.lastName);
    }

    @Override
    public int compareTo(Object o) {

        return getLastName().compareTo(((Person) o).getLastName());
    }

}

class NFComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }

    @Override
    public boolean equals(Object obj){
        return false;
    }
}

