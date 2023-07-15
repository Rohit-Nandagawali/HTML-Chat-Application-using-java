import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client implements ActionListener, Runnable {

    // public String username = "Bharat";

    private final String serverAddress;
    private final int serverPort;
    public final String username;
    public final Color themeColor;

    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    private JFrame frame;
    private JPanel topPanel;
    private JTextField msgField;
    private JButton sendButton;
    private JPanel textArea;
    private Box vertical;
    static String mymsg;

    

    private final static Color purple = new Color(138, 37, 196);
    private final static Color  pinkish = new Color(245,48,94);
    private final static Color  yellowColor = new Color(246,181,0);
   

    // public final static Color themeColor = yellowColor;

    public final Color blackForBg = new Color(26, 32, 47);
    public final Color blackForMsg = new Color(57, 71, 101);

    public Client(String serverAddress, int serverPort, String username,Color themeColor) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.username = username;

        this.themeColor = themeColor; // Set the theme color

        initializeGUI(username);
    }

    private void initializeGUI(String username) {
        frame = new JFrame(username);
        topPanel = new JPanel();
        msgField = new JTextField();
        sendButton = new JButton("Send");
        textArea = new JPanel();
        vertical = Box.createVerticalBox();

        frame.getContentPane().setBackground(blackForBg);
        frame.setLayout(null);
        frame.setSize(450, 700);
        frame.setLocation(10, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        topPanel.setLayout(null);
        topPanel.setBackground(themeColor);
        topPanel.setBounds(0, 0, 450, 70);

        ImageIcon backIcon = new ImageIcon("icons/3.png");
        Image backIconSized = backIcon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        JLabel label1 = new JLabel(new ImageIcon(backIconSized));
        label1.setBounds(5, 17, 30, 30);

        ImageIcon dpIcon = new ImageIcon("icons/grp_icon.png");
        Image dpIconSized = dpIcon.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        JLabel label2 = new JLabel(new ImageIcon(dpIconSized));
        label2.setBounds(40, 5, 60, 60);

        JLabel name = new JLabel("Chat Group");
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        name.setForeground(Color.WHITE);
        name.setBounds(110, 15, 100, 18);

        JLabel activeStatus = new JLabel("You, other members");
        activeStatus.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
        activeStatus.setForeground(Color.WHITE);
        activeStatus.setBounds(110, 35, 110, 20);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(0, 70, 431, 545);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        msgField.setBorder(BorderFactory.createEmptyBorder());
        msgField.setBackground(blackForMsg);
        msgField.setForeground(Color.WHITE);
        msgField.setBounds(0, 615, 310, 40);
        msgField.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));

        sendButton.setBounds(310, 615, 123, 40);
        sendButton.setForeground(Color.WHITE);
        sendButton.setBackground(themeColor);
        // setting 'sendButton' as default button so msg will be send On pressing Enter
        frame.getRootPane().setDefaultButton(sendButton);
        sendButton.addActionListener(this);

        topPanel.add(label1);
        topPanel.add(label2);
        topPanel.add(name);
        topPanel.add(activeStatus);

        frame.add(topPanel);
        frame.add(scrollPane);
        frame.add(msgField);
        frame.add(sendButton);

        frame.setVisible(true);

        textArea.setBackground(blackForBg); // main background, grayish black
    }

    public void connectToServer() {
        try {
            socket = new Socket(serverAddress, serverPort);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            Thread thread = new Thread(this);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // **** formatLabel() for sended message
    public static JPanel formatLabel(String out,Color themeColor) {
        // creating local panel3
        JPanel panel3 = new JPanel();
        // creating label and putting sended message in it
        JLabel l1 = new JLabel("<html><p style=\"width:150px;\">" + out + "</p></html>");

        // setting background this is Color code for purple
        l1.setBackground(themeColor);

        l1.setForeground(Color.WHITE);
        // setting this label as Opaque to set background color
        l1.setOpaque(true);

        // setting border for l1->this is like margin in HTML
        l1.setBorder(new EmptyBorder(15, 15, 15, 50));

        // saving 'out' to 'mymsg' for following code
        mymsg = out;

        // adding l1 to panel3 and returning panel
        panel3.add(l1);
        return panel3;
    }

    // for received message ,same as above
    public static JPanel formatLabelReceived(String out) {
        JPanel panel3 = new JPanel();
        JLabel l1 = new JLabel("<html><p style=\"width:150px;\">" + out + "</p></html>");
        l1.setBackground(new Color(57, 71, 101));// old color->37,211,102
        l1.setForeground(Color.WHITE);
        l1.setOpaque(true);
        l1.setBorder(new EmptyBorder(15, 15, 15, 50));
        mymsg = out;
        panel3.add(l1);
        return panel3;
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            // String message = msgField.getText();
            // if (!message.isEmpty()) {
            // dataOutputStream.writeUTF(message);
            // msgField.setText("");
            // }
            // setting layout for mainPanel
            textArea.setLayout(new BorderLayout());

            // setting layout for right panel->right single message panel,this will take
            // complete area
            JPanel right = new JPanel(new BorderLayout());

            String out = "<b style=\"color:white;\"><u>" + username + ":</u></b><br>" + msgField.getText();

            // declaring new frame ,which will be added to' right' panel
            JPanel p4 = new JPanel();
            // sending out message to 'formatLabel' function
            p4 = formatLabel(out,themeColor);

            // setting color to panels
            p4.setBackground(blackForBg);// purple
            right.setBackground(blackForBg);// grayinsh black

            // adding p4 in right and setting position of p4
            right.add(p4, BorderLayout.LINE_END);

            // adding right panel to vertical
            vertical.add(right);

            // adding verticle to mainPanel
            textArea.add(vertical, BorderLayout.PAGE_START);
            // refreshing frame after adding above message
            frame.validate();

            // clearing 'msgField' for after sending message
            msgField.setText("");

            // ***** sending message to server *****
            dataOutputStream.writeUTF(out);

            System.out.println("message send Successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {
                String receivedMessage = dataInputStream.readUTF();
                System.out.println("received message - " + receivedMessage);
                displayReceivedMessage(receivedMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayReceivedMessage(String message) {
        /**
         * this if else for : as we know our sended message go to server and server send
         * that message to all client ,so server wil send our own sended message to us
         * ,so I have to write the following code
         */

        // Extract the username from the message (assuming the username format is "<b
        // style=\"color:white;\"><u>USERNAME:</u></b><br>")

        int startIndex = message.indexOf("<u>") + 3;
        int endIndex = message.indexOf(":", startIndex); // Find the index of ":" after the username
        String senderUsername = message.substring(startIndex, endIndex);
        System.out.println("Received message from: " + senderUsername);

        System.out.println("sender - "+senderUsername+", username - "+username);

        // If the sender is the same as the client's username, remove the message (sent
        // message)
        if (senderUsername.equals(username)) {
            frame.validate();
            JPanel p2 = formatLabel(message, themeColor);
            JPanel left = new JPanel(new BorderLayout());
            left.add(p2, BorderLayout.LINE_START);
            System.out.println("I removed the sent message");
            vertical.remove(left);
            frame.validate();
        } else {
            // Else it's a received message, display it
            frame.validate();
            JPanel p2 = formatLabelReceived(message);
            JPanel left = new JPanel(new BorderLayout());
            p2.setBackground(blackForBg); // black
            left.setBackground(blackForBg); // grayish black
            left.add(p2, BorderLayout.LINE_START);
            vertical.add(left);
            frame.validate();
            System.out.println(username + " : " + message);
        }

        frame.repaint();

        // frame.validate();
        // frame.repaint();
    }

   
}
