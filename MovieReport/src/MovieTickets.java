interface IMovieTickets {
    int totalMovieSales(int[] movieTicketSales);
    String topMovie(String[] movies, int[] totalSales);

    int totalOverallSales(int[][] allMovieTicketSales);
}

class MovieTickets implements IMovieTickets {
    @Override
    public int totalMovieSales(int[] movieTicketSales) {
        int totalSales = 0;
        for (int sales : movieTicketSales) {
            totalSales += sales;
        }
        return totalSales;
    }

    @Override
    public String topMovie(String[] movies, int[] totalSales) {
        int maxIndex = 0;
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > totalSales[maxIndex]) {
                maxIndex = i;
            }
        }
        return movies[maxIndex];
}
    @Override
    public int totalOverallSales(int[][] allMovieTicketSales) {
        int overallTotal = 0;
        for (int[] movieSales : allMovieTicketSales) {
            overallTotal += totalMovieSales(movieSales);
        }
        return overallTotal;
    }
}
