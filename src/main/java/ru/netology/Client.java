package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        String host = "netology.homework";
        int port = 8080;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Client");
            System.out.println("\nNew connection accepted.");
            System.out.println(in.readLine());

//          Ответ на запрос на ввод имени:
            String clientNameQuestion = in.readLine();
            System.out.println("server: " + clientNameQuestion);
            out.println("Vasya");
//          Для контроля принимаю имя от сервера обратно:
            String clientNameReturn = in.readLine();
            System.out.println("client : " + clientNameReturn);

//          Ответ на запрос а не ребенок ли пользователь:
            String isChildQuestion= in.readLine();
            System.out.println("server: "+ isChildQuestion);
            out.println("no");
            String isChildReturn = in.readLine();
            System.out.println("client : " + isChildReturn);

//          Ответ на запрос хороший ли пользователь человек:
            String isGoodQuestion = in.readLine();
            System.out.println("server: "+ isGoodQuestion);
            out.println("yes");
            String isGoodReturn = in.readLine();
            System.out.println("client : " + isGoodReturn);

//          Приветственное сообщение от сервера:
            String welcomeMessage = in.readLine();
            System.out.println("server: " + welcomeMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
