package com.ksantd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public final static int PORT = 8080;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            while (true) {
                String name = in.readLine();
                System.out.println(String.format("Client %s, his port is %d", name, clientSocket.getPort()));
                out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}