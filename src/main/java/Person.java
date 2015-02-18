public class Person {

    private final Optional<Address> address;

    public Person(Address address) {
        this.address = new Optional<>(address);
    }

    public Optional<Address> getAddress() {
        return address;
    }
}
