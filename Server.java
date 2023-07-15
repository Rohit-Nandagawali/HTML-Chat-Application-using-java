import java.net.*;
import java.util.Vector;
import java.io.*;

public class Server  implements Runnable{


    // creating socket reference variable
    Socket socket;

    // storing all clients using vectors
    public static Vector clients = new Vector();


    public Server(Socket s){
        try {
            //storing s value to socket for run method's socket object because message is in ' socket '
            socket =s;
        } catch (Exception e) {
            
            System.out.println(e);
        }
    }

    public void run(){
        try {
            // creating object of dataInputStream and dataOutputStream 
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // adding dataOutputStream object to all clients
            clients.add(dataOutputStream);

            // reading or Inputing messages from clients, so there will be multiple msgs form multiple users t
            while (true) {
               String msgInput = dataInputStream.readUTF();
               System.out.println("received "+msgInput);

                System.out.println(clients.size());
            //    sending msg to all client
            for (int i = 0; i < clients.size(); i++) {
                try {
                    DataOutputStream dos = (DataOutputStream)clients.get(i);
                    System.out.println(dos);
                    dos.writeUTF(msgInput);
                    System.out.println("hey i  am in try");
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            }

            }


        } catch (Exception e) {
            
            System.out.println(e);
        }
    }
    public static void main(String[] args) throws Exception {
        // creating Server socket and setting port
        ServerSocket serverSocket = new ServerSocket(6001);

        // we are using here infinite loop because we dont know number of client so any number of clients can connect
        while (true) {
            // accepting request for connections
            Socket socket = serverSocket.accept();
            // just creating object of class that we have just created and sending socket object
            Server server = new Server(socket);
            // creating threads because there are multiple client objects
            Thread thread = new Thread(server);
            // starting thread for each client 
            thread.start();
        }
    }
    
}
