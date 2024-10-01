package chatroom;

import java.util.*;
import utils.Logger;

public class ChatRoom {
    private String roomId;
    private List<User> users = new ArrayList<>();
    private List<String> messageHistory = new ArrayList<>();

    public ChatRoom(String roomId) {
        this.roomId = roomId;
        Logger.log("Created chat room with ID: " + roomId);
    }

    public String getRoomId() {
        return roomId;
    }

    public void joinRoom(User user) {
        if (!users.contains(user)) {
            users.add(user);
            Logger.log("User " + user.getUsername() + " joined room: " + roomId);
            user.update("Welcome to the room " + roomId);
        } else {
            Logger.log("User " + user.getUsername() + " is already in room: " + roomId);
        }
    }

    public void leaveRoom(User user) {
        users.remove(user);
        Logger.log("User " + user.getUsername() + " left room: " + roomId);
    }

    public void sendMessage(String message, User sender) {
        messageHistory.add(message);
        Logger.log("Message from " + sender.getUsername() + ": " + message);
        notifyUsers(message, sender);
    }

    private void notifyUsers(String message, User sender) {
        for (User user : users) {
            if (!user.equals(sender)) {
                user.update(message);
            }
        }
    }

    public List<String> getMessageHistory() {
        return messageHistory;
    }
}
