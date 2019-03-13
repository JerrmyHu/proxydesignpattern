package proxy.jdk;

import proxy.Girl;
import proxy.Person;

public class JDKTest {

    public static void main(String[] args) {
        Person person = (Person) new Meipo().getInstance(new Girl());
        person.findLove();

    }
}
