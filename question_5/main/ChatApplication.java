package main;

import chatroom.User;
import adapter.ChatProtocol;
import adapter.HttpAdapter;
import adapter.WebSocketAdapter;

public class ChatApplication {
    public static void main(String[] args) {
        User alice = new User("Alice");
        User bob = new User("Bob");

        alice.joinChatRoom("Room123");
        bob.joinChatRoom("Room123");

        alice.sendMessage("Hello, everyone!");
        bob.sendMessage("Hi, Alice!");

        alice.leaveChatRoom();
        bob.sendMessage("Goodbye!");

        // Using adapter pattern for different communication protocols
        ChatProtocol webSocket = new WebSocketAdapter();
        ChatProtocol http = new HttpAdapter();

        webSocket.send("WebSocket message");
        http.send("HTTP message");
    }
}
