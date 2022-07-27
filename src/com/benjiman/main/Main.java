package com.benjiman.main;

import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        // Try block that connects to the server from this client into the local host 5000

        try(Socket socket = new Socket("localhost", 5000)) {  //127.0.0.100

            // Catch block for the Errors if there are any
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }


    }
}
