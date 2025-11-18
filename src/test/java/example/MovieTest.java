package example;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void testMovieFields() {
        Movie movie = new Movie("Avatar", Movie.MovieType.NEW_RELEASE);

        assertEquals("Avatar", movie.getTitle());
        assertEquals(Movie.MovieType.NEW_RELEASE, movie.getPriceCode());
    }
}

