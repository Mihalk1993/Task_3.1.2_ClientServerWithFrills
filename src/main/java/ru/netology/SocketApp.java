package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketApp {
    public static void main(String[] args) {

        int port = 8080;
        String message = null;

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

//          Приветствие при подключении к серверу:
            String name = in.readLine();
            out.println(String.format("Hi %s, local port: %s, your port: %s",
                    name,
                    clientSocket.getLocalPort(),
                    clientSocket.getPort()));

//          Запрос на ввод имени:
            out.println("Write your name");
            String clientName = in.readLine();
            out.println(clientName);


//          Запрос а не ребенок ли пользователь:
            out.println("Are you a child (yes/no)?");
            String isChildAnswer = in.readLine();
            out.println(isChildAnswer);

//          Запрос хороший ли пользователь человек:
            out.println("Are you good person (yes/no)?");
            String isGoodAnswer = in.readLine();
            out.println(isGoodAnswer);

//          Выбор приветственного сообщения:
            if (isChildAnswer.equals("yes") && isGoodAnswer.equals("yes")) {
                message = String.format("Welcome to the kids area, %s! Let's play!", clientName);
            } else if (isChildAnswer.equals("no") && isGoodAnswer.equals("yes")) {
                message = String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", clientName);
            }

            out.println(message);
            System.out.println(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
