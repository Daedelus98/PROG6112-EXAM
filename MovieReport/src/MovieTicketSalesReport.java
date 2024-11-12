public class MovieTicketSalesReport {

    public static void main(String[] args) {
        //Initialise
        String[] movieNames = {"Napoleon", "Oppenheimer"};
        int[][] ticketSales = {
                {3000, 1500, 1700},
                {3500, 1200, 1600}
        };

        MovieTickets movieTickets = new MovieTickets();

        // Calculate total sales for each movie
        int[] totalSales = new int[movieNames.length];
        for (int i = 0; i < movieNames.length; i++) {
            totalSales[i] = movieTickets.totalMovieSales(ticketSales[i]);
        }
        int overallTotal = movieTickets.totalOverallSales(ticketSales);

        // Find the top-performing movie
        String topMovie = movieTickets.topMovie(movieNames, totalSales);

        // Print the report header
        System.out.println("MOVIE TICKET SALES REPORT - 2024");
        System.out.println("");
        System.out.println("\t\t\t\tJAN\t\tFEB\t\tMAR");
        System.out.println("----------------------------------------------------");

        // Display sales data
        for (int i = 0; i < movieNames.length; i++) {
            System.out.print(movieNames[i] + "\t\t");
            for (int j = 0; j < ticketSales[i].length; j++) {
                System.out.print(ticketSales[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("");

        // Display total sales for each movie
        for (int i = 0; i < movieNames.length; i++) {
            System.out.println("Total movie ticket sales for " + movieNames[i] + ": " + totalSales[i]);
        }
        System.out.println("");

        //Display overall total of sales
        System.out.println("Total overall ticket sales: " + overallTotal);
        System.out.println("");

        // Display top-performing movie
        System.out.println("Top performing movie: " + topMovie);
    }
}