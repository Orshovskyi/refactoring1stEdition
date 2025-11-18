package test;

import example.domain.Customer;
import example.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerServiceTest {

    private static CustomerService customerService;

    @BeforeAll
    public static void setUp() {
        customerService = new CustomerService();
    }

    @Test
    public void testGetCustomerByName() {
        Customer customer = customerService.getCustomerByName("John Doe");
        assertTrue(customer.getName().equals("John Doe"));
        assertTrue(customer.statement().contains("Rental Record for John Doe"));
    }

    @Test
    public void testGetStatementContainsMovies() {
        String statement = customerService.getStatement("John Doe");

        assertTrue(statement.contains("Rembo"));
        assertTrue(statement.contains("Lord of the Rings"));
        assertTrue(statement.contains("Harry Potter"));
    }

    @Test
    public void testStatementAmountAndPoints() {
        String statement = customerService.getStatement("John Doe");

        // check amount
        assertTrue(statement.contains("Amount owed is 18.5"));
        // check frequent renter points
        assertTrue(statement.contains("You earned 4 frequent renter points"));
    }
}

