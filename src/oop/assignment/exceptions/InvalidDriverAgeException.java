package oop.assignment.exceptions;

public class InvalidDriverAgeException extends Exception {
    private final int providedAge;
    private final int customerId;

    public InvalidDriverAgeException(int customerId, int age) {
        super("Customer ID " + customerId + " (age " + age +
                ") is too young. Must be at least 18 years old.");
        this.providedAge = age;
        this.customerId = customerId;
    }

    public int getProvidedAge() { return providedAge; }
    public int getCustomerId() { return customerId; }
}