package example;

import org.junit.Test;

import static org.junit.Assert.*;

public class RentalTest {

    @Test
    public void testRentalFields() {
        Movie movie = new Movie("Test", Movie.MovieType.REGULAR);
        Rental rental = new Rental(movie, 7);

        assertEquals(movie, rental.getMovie());
        assertEquals(7, rental.getDaysRented());
    }
}
