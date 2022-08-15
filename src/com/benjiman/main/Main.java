package com.benjiman.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Try block that connects to the server from this client into the local host 6000

        try(Socket socket = new Socket("localhost", 6001)) {  //127.0.0.100

            // Timeout for the if the server doesn't respond
            socket.setSoTimeout(25000);
            BufferedReader echoes = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            // Scanner to capture the input data from the user

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            // Do while loop to is to capture and send it to the server

            do {
                printMenu();

                echoString = scanner.nextLine();

                stringToEcho.println(echoString);
                if (!echoString.equals("exit")) {
                    response = echoes.readLine();
                    System.out.println(response);
                }
            } while (!echoString.equals("start"));

            // This catch block connects with the server in the event of a time out
        } catch(SocketTimeoutException e) {
            System.out.println("The socket timed out");


            // Catch block for the Errors if there are any
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }


    }
    // This method prints out the menu and waits for the user to select the option
    private static void printMenu() {
        System.out.println("Actions available:\npress");
        System.out.println(
                "0 - to quit\n" +
                "1 - Ready the troops\n" +
                "2 - Show number with Ammo\n" +
                "3 - Show number with Food\n" +
                "4 - Show number with Water\n" +
                "5 - Show number with Location\n" +
                "6 - Move 100 meters\n" +
                "7 - Replenish Food, Water & Ammo");
    }

}
