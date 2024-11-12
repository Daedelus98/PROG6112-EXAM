import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieTicketSalesReportTest {

    @Test
    void calculateTotalSales_ReturnsExpectedTotalSales() {
        MovieTickets movieTickets = new MovieTickets();
        int[] ticketSales = {3000, 1500, 1700};
        int expectedTotalSales = 6200;

        int actualTotalSales = movieTickets.totalMovieSales(ticketSales);

        assertEquals(expectedTotalSales, actualTotalSales);
    }

    @Test
    void topMovieSales_ReturnsTopMovie() {
        MovieTickets movieTickets = new MovieTickets();
        String[] movieNames = {"Napoleon", "Oppenheimer"};
        int[] totalSales = {6200, 6300};
        String expectedTopMovie = "Oppenheimer";

        String actualTopMovie = movieTickets.topMovie(movieNames, totalSales);

        assertEquals(expectedTopMovie, actualTopMovie);
    }
}