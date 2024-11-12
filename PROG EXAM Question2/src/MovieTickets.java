public class MovieTickets {

    // Validate movie ticket data
    public boolean validateMovieTicketData(String selectedMovie, int numTickets, double ticketPrice) {
        // Check for valid movie selection, ticket count, and price
        if (selectedMovie == null || selectedMovie.isEmpty()) {
            return false;
        }
        if (numTickets <= 0 || ticketPrice <= 0) {
            return false;
        }
        return true;
    }
}

