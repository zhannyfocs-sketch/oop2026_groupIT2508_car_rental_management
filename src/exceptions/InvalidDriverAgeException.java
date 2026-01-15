package exceptions;

public class InvalidDriverAgeException extends Exception {
    private final int providedAge;

    public InvalidDriverAgeException(int age) {
        super("Driver age " + age + " is invalid. Customer must be at least 18 years old to rent a vehicle.");
        this.providedAge = age;
    }

    public int getProvidedAge() {
        return providedAge;
    }
}
