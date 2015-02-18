import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MonadTest {

    @Test
    public void flatMap() throws Exception {
        String expectedStreet = "Street";
        Optional<Person> person = new Optional<>(new Person(new Address(expectedStreet)));

        String carName = person.flatMap(new Function<Person, Optional<Address>>() {
            @Override
            public Optional<Address> apply(Person person) {
                return person.getAddress();
            }
        }).map(new Function<Address, String>() {
            @Override
            public String apply(Address car) {
                return car.getStreet();
            }
        }).orElse("Nowhere");

        assertEquals(carName, expectedStreet);
    }

    @Test
    public void orElse_default() throws Exception {
        String expectedString = "expected";

        Optional<String> string = new Optional<>(null);

        assertEquals(string.orElse(expectedString), expectedString);
    }
}
