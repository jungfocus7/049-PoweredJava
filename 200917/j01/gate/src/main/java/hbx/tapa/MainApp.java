package hbx.tapa;

import java.awt.BorderLayout;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public final class MainApp {
    private static final void println(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        println("Hello world!");

        try {
            char[] tca = { 'a', 'b', 'c' };
            char tc = tca[5];
            println(">>> " + tc);
        } catch (Exception ex) {
            println("Error");
            throw ex;
            // return;
        } finally {
            println("무조건 실행");
        }

        Ellipse2D.Double circle = new Ellipse2D.Double(50, 50, 100, 100);

        // initComponents();
    }

    private static void initComponents() {
        // Create the main frame
        JFrame frame = new JFrame("Simple JTable Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the frame

        // Define column names
        String[] columnNames = { "Name", "Age", "City" };

        // Define data for the table
        Object[][] data = {
                { "Alice", 30, "New York" },
                { "Bob", 24, "London" },
                { "Charlie", 35, "Paris" },
                { "Diana", 28, "Tokyo" },
        };
        List<Object[]> lst = new ArrayList<Object[]>();
        lst.add(new Object[] { "Diana", 28, "Tokyo" });
        lst.toArray();

        // Create a DefaultTableModel with data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create the JTable using the model
        JTable table = new JTable(model);

        // Wrap the table in a JScrollPane to enable scrolling if needed
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame's content pane
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}