package example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void testStatementWithVariousMovies() {
        Movie regular = new Movie("Rembo", Movie.MovieType.REGULAR);
        Movie newRelease = new Movie("Lord of the Rings", Movie.MovieType.NEW_RELEASE);
        Movie childrens = new Movie("Harry Potter", Movie.MovieType.CHILDRENS);

        List<Rental> rentals = List.of(
                new Rental(regular, 1),
                new Rental(newRelease, 4),
                new Rental(childrens, 5)
        );

        Customer customer = new Customer("John Doe", rentals);
        String statement = customer.statement();

        String expected =
                "Rental Record for John Doe\n" +
                        "\tRembo\t2.0\n" +
                        "\tLord of the Rings\t12.0\n" +
                        "\tHarry Potter\t4.5\n" +
                        "Amount owed is 18.5\n" +
                        "You earned 4 frequent renter points";

        assertEquals(expected, statement);
    }

    @Test
    public void testRegularMoviePriceForMoreThan2Days() {
        Movie movie = new Movie("Test", Movie.MovieType.REGULAR);
        Rental rental = new Rental(movie, 5);

        Customer c = new Customer("Bob", List.of(rental));
        String statement = c.statement();

        assertTrue(statement.contains("\tTest\t6.5"));
        assertTrue(statement.contains("Amount owed is 6.5"));
    }

    @Test
    public void testNewReleaseFrequentRenterBonusPoint() {
        Movie movie = new Movie("New Release", Movie.MovieType.NEW_RELEASE);
        Rental rental = new Rental(movie, 3);

        Customer c = new Customer("Alice", List.of(rental));
        String s = c.statement();

        assertTrue(s.contains("You earned 2 frequent renter points"));
    }

    @Test
    public void testChildrensPriceCalculation() {
        Movie movie = new Movie("Kids Movie", Movie.MovieType.CHILDRENS);
        Rental rental = new Rental(movie, 2);

        Customer c = new Customer("Kid", List.of(rental));
        String s = c.statement();

        assertTrue(s.contains("\tKids Movie\t1.5"));
    }

    @Test
    public void testChildrensPriceAbove3Days() {
        Movie movie = new Movie("Kids Movie", Movie.MovieType.CHILDRENS);
        Rental rental = new Rental(movie, 6);

        Customer c = new Customer("Kid", List.of(rental));
        String s = c.statement();

        assertTrue(s.contains("\tKids Movie\t6.0"));
    }
}
