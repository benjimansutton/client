package com.benjiman.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Try block that connects to the server from this client into the local host 6000

        try(Socket socket = new Socket("localhost", 6000)) {  //127.0.0.100
            BufferedReader echoes = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            // Scanner to capture the input data from the user

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            // Do while loop to is to capture and send it to the server

            do {
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine();

                stringToEcho.println(echoString);
                if(!echoString.equals("exit")) {
                    response = echoes.readLine();
                    System.out.println(response);
                }
            } while(!echoString.equals("exit"));


            // Catch block for the Errors if there are any
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }


    }
}
