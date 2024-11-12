
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovieTicketSalesApp extends JFrame {

    // Constants
    private static final String[] MOVIES = {"Napoleon", "Oppenheimer", "Damsel"};
    private static final double VAT_RATE = 0.15; // 15% VAT

    // GUI Components
    private JComboBox<String> movieComboBox;
    private JTextField numTicketsTextField;
    private JTextField ticketPriceTextField;
    private JTextArea reportTextArea;

    // Constructor
    public MovieTicketSalesApp() {
        super("Movie Ticket Sales");

        initializeGUI();
        addMenu();
        addEventListeners();

        // Set window properties
        setSize(400, 400);
        setVisible(true);
        setLayout(new BorderLayout());
    }

    // Initialize GUI components
    private void initializeGUI() {
        // Create GUI components
        movieComboBox = new JComboBox<>(MOVIES);
        numTicketsTextField = new JTextField();
        ticketPriceTextField = new JTextField();
        reportTextArea = new JTextArea();
        reportTextArea.setEditable(false);

        // Create layout
        JPanel inputPanel = new JPanel(new GridLayout(4,2));


        // Add components to input panel
        inputPanel.add(new JLabel("Movie:"));
        inputPanel.add(movieComboBox);
        inputPanel.add(new JLabel("Number of Tickets:"));
        inputPanel.add(numTicketsTextField);
        inputPanel.add(new JLabel("Ticket Price:"));
        inputPanel.add(ticketPriceTextField);
        inputPanel.add(new JLabel("Ticket Report:"));
        inputPanel.add(new JScrollPane(reportTextArea), BorderLayout.CENTER);

        // Add input panel to frame
        add(inputPanel, BorderLayout.CENTER);
    }

    // Add menu items (File and Tools)
    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        // Add menu items
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitMenuItem);

        JMenuItem processMenuItem = new JMenuItem("Process");
        processMenuItem.addActionListener(e -> processTicketSale());
        toolsMenu.add(processMenuItem);

        JMenuItem clearMenuItem = new JMenuItem("Clear");
        clearMenuItem.addActionListener(e -> clearFields());
        toolsMenu.add(clearMenuItem);

        // Add menu bar to frame
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    // Add event listeners for menu and text fields
    private void addEventListeners() {
        // ComboBox item selection event
        movieComboBox.addItemListener(e -> processTicketSale());

        // Number of tickets field
        numTicketsTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                processTicketSale();
            }
        });

        // Ticket price field
        ticketPriceTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                processTicketSale();
            }
        });
    }

    // Process ticket sale
    private void processTicketSale() {
        String selectedMovie = (String) movieComboBox.getSelectedItem();
        int numTickets = 0;
        double ticketPrice = 0;

        try {
            numTickets = Integer.parseInt(numTicketsTextField.getText());
            ticketPrice = Double.parseDouble(ticketPriceTextField.getText());
        } catch (NumberFormatException e) {
            reportTextArea.setText("Invalid input for number of tickets or ticket price.");
            return;
        }

        // Validate data
        if (selectedMovie.isEmpty() || numTickets <= 0 || ticketPrice <= 0) {
            reportTextArea.setText("Please enter valid values for all fields.");
            return;
        }

        double totalTicketPrice = calculateTotalPrice(numTickets, ticketPrice);
        double totalPriceWithVAT = totalTicketPrice * (1 + VAT_RATE);

        String report = generateSalesReport(selectedMovie, numTickets, ticketPrice, totalTicketPrice, totalPriceWithVAT);
        reportTextArea.setText(report);
    }

    // Calculate total ticket price
    public double calculateTotalPrice(int numTickets, double ticketPrice) {
        return numTickets * ticketPrice;
    }

    // Generate sales report
    private String generateSalesReport(String selectedMovie, int numTickets, double ticketPrice, double totalTicketPrice, double totalPriceWithVAT) {
        return String.format(
                "Movie: %s\n" +
                        "Number of Tickets: %d\n" +
                        "Ticket Price: %.2f\n" +
                        "Total Price: %.2f\n" +
                        "Total Price with VAT: %.2f\n",
                selectedMovie, numTickets, ticketPrice, totalTicketPrice, totalPriceWithVAT
        );
    }

    // Clear all fields
    private void clearFields() {
        numTicketsTextField.setText("");
        ticketPriceTextField.setText("");
        reportTextArea.setText("");
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MovieTicketSalesApp());
    }
}
