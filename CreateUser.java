import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateUser extends JFrame implements ActionListener {

    private JTextField nameField;
    private JButton createButton;
    private JButton chooseColorButton; // Button to open the color picker

    private Color selectedColor; // Store the selected theme color

    public CreateUser() {
        setTitle("Create New User");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel nameLabel = new JLabel("Enter Name:");
        nameField = new JTextField(15);
        createButton = new JButton("Create User");
        chooseColorButton = new JButton("Choose Theme Color");

        getRootPane().setDefaultButton(createButton);

        createButton.addActionListener(this);
        chooseColorButton.addActionListener(this);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(chooseColorButton);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(createButton);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            String username = nameField.getText().trim();
            if (!username.isEmpty()) {
                // Create a new client2 object with the entered username and selected color
                SwingUtilities.invokeLater(() -> {
                    Client client = new Client("127.0.0.1", 6001, username, selectedColor);
                    client.connectToServer();
                });
               // Clear the textField after creating the user
               nameField.setText("");
            }
        } else if (e.getSource() == chooseColorButton) {
            // Open the color picker dialog
            selectedColor = JColorChooser.showDialog(this, "Choose Theme Color", selectedColor);
            if (selectedColor != null) {
                // Set the background color of the frame to the selected color
                getContentPane().setBackground(selectedColor);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CreateUser createUser = new CreateUser();
            createUser.setVisible(true);
        });
    }
}
