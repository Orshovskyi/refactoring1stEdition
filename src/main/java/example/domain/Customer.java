package example.domain;

import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals;

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        double totalAmount = 0;
        int frequentRenterPoints = 0;

        for (Rental rental : rentals) {
            double thisAmount = rental.calculateAmount();
            int points = rental.calculateFrequentRenterPoints();

            frequentRenterPoints += points;
            totalAmount += thisAmount;

            result.append("\t")
                    .append(rental.getMovie().getTitle())
                    .append("\t")
                    .append(thisAmount)
                    .append("\n");
        }

        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");

        return result.toString();
    }
}
