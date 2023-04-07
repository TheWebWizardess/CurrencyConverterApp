import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyConverter {
    private JFrame frame;
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JTextField amountTextField;
    private JButton convertButton;
    private JLabel resultLabel;

    public CurrencyConverter() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(4, 2));

        container.add(new JLabel("  Amount:"));
        amountTextField = new JTextField();
        container.add(amountTextField);

        container.add(new JLabel("  From:"));
        fromCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "JPY", "GBP", "AUD", "CAD", "CHF", "CNY", "HKD", "NZD", "KRW", "MXN", "SGD", "INR", "RUB", "ZAR", "BRL", "DKK", "NOK", "SEK", "TRY", "AED", "ILS", "SAR", "THB", "IDR"});
        container.add(fromCurrencyComboBox);

        container.add(new JLabel("  To:"));
        toCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "JPY", "GBP", "AUD", "CAD", "CHF", "CNY", "HKD", "NZD", "KRW", "MXN", "SGD", "INR", "RUB", "ZAR", "BRL", "DKK", "NOK", "SEK", "TRY", "AED", "ILS", "SAR", "THB", "IDR"});
        container.add(toCurrencyComboBox);



        convertButton = new JButton("Convert");
        container.add(convertButton);
        convertButton.addActionListener((ActionEvent e) -> convertAmount());

        resultLabel = new JLabel("  Result:");
        container.add(resultLabel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CurrencyConverter());
    }

    private void convertAmount() {
        String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
        String toCurrency = (String) toCurrencyComboBox.getSelectedItem();
        double amount;
        try {
            amount = Double.parseDouble(amountTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a number.");
            return;
        }

        double rate = getConversionRate(fromCurrency, toCurrency);
        if (rate > 0) {
            double convertedAmount = amount * rate;
            resultLabel.setText("Result: " + convertedAmount);
        } else {
            JOptionPane.showMessageDialog(frame, "Conversion rate not found.");
        }
    }

    private double getConversionRate(String fromCurrency, String toCurrency) {
        double rate = -1;
        try {
            Connection connection;
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT rate FROM dbo.CurrencyRates WHERE fromCurrency = ? AND toCurrency = ?";
            PreparedStatement statement;
            statement = connection.prepareStatement(sql);
            statement.setString(1, fromCurrency);
            statement.setString(2, toCurrency);
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                rate = resultSet.getDouble("rate");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("SQL Exception:");
        }

        return rate;
    }
}
