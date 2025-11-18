package example.service;

import example.domain.Customer;
import example.domain.Rental;
import example.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

import static example.domain.Movie.MovieType.*;

@Service
public class CustomerService {

    // simple in-memory demo data
    public Customer getCustomerByName(String name) {
        List<Rental> rentals = List.of(
                new Rental(new Movie("Rembo", REGULAR), 1),
                new Rental(new Movie("Lord of the Rings", NEW_RELEASE), 4),
                new Rental(new Movie("Harry Potter", CHILDRENS), 5)
        );
        return new Customer(name, rentals);
    }

    public String getStatement(String name) {
        Customer customer = getCustomerByName(name);
        return customer.statement();
    }
}
