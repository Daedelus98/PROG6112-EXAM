import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieTicketSalesAppTest {

    @Test
    public void testCalculateTotalPrice() {
        MovieTicketSalesApp app = new MovieTicketSalesApp();
        double totalPrice = app.calculateTotalPrice(2, 10.0);
        assertEquals(20.0, totalPrice, 0.01);
    }

    @Test
    public void testValidateMovieTicketData() {
        MovieTickets tickets = new MovieTickets();
        boolean isValid = tickets.validateMovieTicketData("Napoleon", 2, 10.0);
        assertTrue(isValid);
    }
}