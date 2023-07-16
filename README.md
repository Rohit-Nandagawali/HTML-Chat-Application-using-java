# HTML Chat Application using java

The HTML Chat Application is a real-time chat platform that supports basic HTML tags and allows users to communicate with their friends while experimenting and learning HTML. This application provides an interactive and educational chatting experience, making it ideal for beginners interested in HTML.

## Table of Contents
- [Introduction](#introduction)
- [Demo](#demo)
- [Technology Used](#technology-used)
- [Concepts Used](#concepts-used)
- [How to Run](#how-to-run)
- [Features](#features)
- [Modules](#modules)
- [Server](#server)
- [Client](#client)
- [CreateUser](#createuser)
- [Scope](#scope)
- [Contributing](#contributing)
- [License](#license)

## Introduction
The HTML Chat Application is a simple and user-friendly chat platform designed to facilitate real-time communication between users. Its unique feature is the support for basic HTML tags, enabling users to format their messages creatively and learn HTML while chatting with their friends.

## Demo

https://github.com/Rohit-Nandagawali/HTML-Chat-Application-using-java/assets/85486891/fc17a8e6-d98b-4bcd-a1e0-56a1d846e204




## Technology Used
- Java: The primary programming language used for building the chat client and server.
- Swing: Java GUI library utilized for creating the chat interface with various components.
- Socket Programming: Employed to enable real-time communication between clients and the server over the network.

## Concepts Used
The HTML Chat Application utilizes the following programming concepts:
- Object-Oriented Programming (OOP): The application is designed using OOP principles, with classes and objects representing various components.
- Java Swing Components: The graphical user interface is constructed using various Swing components like JFrame, JPanel, JTextField, JButton, and more.
- Multi-threading: The application implements multi-threading to handle both server-client connections and GUI updates simultaneously, ensuring smooth performance during real-time messaging.
- Client-Server Architecture: The application follows a client-server model to facilitate communication between multiple users.

## How to Run
1. Clone this repository to your local machine using `git clone`.
2. Open the project in your Java IDE (e.g., Eclipse, IntelliJ).
3. Compile and Run the `Server.java` file to start the chat server, which will listen for incoming connections.

   ```
   javac Server.java
   java Server
   ```
4. Only Compile the `Client.java` file, so will able to create Client instance in CreateUser.

   ```
   javac Client.java
   ```
7. Compile and Run the `CreateUser.java` file to create a new user (client).

   ```
   javac CreateUser.java
   java CreateUser
   ```
8. Enter your desired username and select a theme color.
9. Click the "Create User" button to launch the chat client.
10. The chat client window will open, allowing you to enter messages in the text field and click "Send" to communicate with other users.

## Features
1. Real-time Chat: Users can send and receive messages instantly, providing a seamless chatting experience.
2. HTML Support: The application supports basic HTML tags, enabling users to format their messages creatively.
3. Image Display: Users can include image tags in their messages, and the application will display the images.
4. Theming: Users can select their preferred theme color, making the chat interface customizable and visually appealing.
5. User-Friendly Interface: The application offers an intuitive and easy-to-use graphical interface, making it accessible for beginners.

## Modules
The project consists of the following main modules:
1. **Server**: Responsible for handling client connections, message broadcasting, and managing active users.
2. **Client**: Represents the chat client, which allows users to send and receive messages and interact with the chat interface.
3. **CreateUser**: Provides a user-friendly form for creating a new user with a chosen username and theme color.

## Server
The `Server.java` file contains the main logic for the chat server. It listens for incoming client connections, creates threads for each client, and manages message broadcasting to all connected clients.

## Client
The `Client.java` file represents the chat client. It establishes a connection to the server, sends and receives messages, and handles the chat interface. The client also supports HTML tags for message formatting.

## CreateUser
The `CreateUser.java` file provides a simple form for creating a new user. Users can enter their desired username and select a theme color before joining the chat.

## Scope
The HTML Chat Application aims to provide a user-friendly, interactive, and educational chat platform for individuals interested in learning HTML. Its scope includes supporting basic HTML tags, enabling image display, and facilitating real-time communication between users. The application can be expanded further to incorporate more advanced HTML features and additional functionalities to enhance the learning experience.

## User-Defined Functions

### Client.java

1. `initializeGUI(String username)`: Initializes the client's graphical user interface (GUI) and sets the theme color for the chat window.
2. `connectToServer()`: Establishes a connection to the chat server and initializes data input and output streams for communication.
3. `formatLabel(String out, Color themeColor)`: Formats a message with HTML tags and returns a JPanel with the formatted message.
4. `formatLabelReceived(String out)`: Similar to `formatLabel` but used for formatting received messages.
5. `actionPerformed(ActionEvent ae)`: Handles user actions (button clicks) in the chat client, sending messages to the server, and updating the chat interface.
6. `run()`: Implements `Runnable` to run the client as a separate thread, listening for incoming messages from the server.

### Server.java

1. `run()`: Implements `Runnable` to run the server as a separate thread. This function is executed for each client connection and broadcasts messages to all connected clients.

### CreateUser.java

1. `actionPerformed(ActionEvent e)`: Handles user actions in the create user interface. Creates a new client with the entered username and selected theme color.

## Sample Inputs
Try by sending these messages.
1.
```
<h1>hello</h1>
```
2. 

```
 <img src="https://static.javatpoint.com/htmlpages/images/good-morning.jpg"></img>
```
3. 
```
<header>
    <h1>Welcome to My Simple Website</h1>
</header>

<nav>
    <ul>
        <li><a href="#home">Home</a></li>
        <li><a href="#about">About</a></li>
        <li><a href="#contact">Contact</a></li>
    </ul>
</nav>

<main>
    <section id="home">
        <h2>Home Section</h2>
        <p>This is the home section of my simple website.</p>
    </section>

    <section id="about">
        <h2>About Section</h2>
        <p>This is the about section. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    </section>

    <section id="contact">
        <h2>Contact Section</h2>
        <p>Contact us at contact@example.com</p>
    </section>
</main>

```

## Conclusion

This chat application with HTML support is an excellent tool for beginners to learn HTML while communicating with friends. The ability to experiment with HTML tags and send messages with rich formatting makes it both fun and educational.

We encourage you to be a part of this project and contribute to its growth. Whether you have ideas for new features, find and fix bugs, or improve the documentation, your contributions are valuable to the community. Together, we can make the HTML Chat Application even better and help more people learn HTML in an interactive and engaging way!


## Contributing
Contributions to the HTML Chat Application are welcome! If you have any suggestions, bug fixes, or new features to propose, please feel free to open an issue or submit a pull request. We believe that collaborative efforts can make this project even better!

## License
The HTML Chat Application is licensed under the [MIT License](LICENSE). You are free to use, modify, and distribute this project as per the terms of the MIT License.

