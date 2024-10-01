package chatroom;

import utils.Logger;

public class User {
    private String username;
    private ChatRoom currentRoom;

    public User(String username) {
        this.username = username;
        Logger.log("User created: " + username);
    }

    public String getUsername() {
        return username;
    }

    public void joinChatRoom(String roomId) {
        ChatRoomManager manager = ChatRoomManager.getInstance();
        ChatRoom room = manager.getChatRoom(roomId);
        room.joinRoom(this);
        currentRoom = room;
        
        Logger.log(username + " joined chat room: " + roomId);

        for (String msg : room.getMessageHistory()) {
            System.out.println(msg);
        }
    }

    public void leaveChatRoom() {
        if (currentRoom != null) {
            currentRoom.leaveRoom(this);
            currentRoom = null;
        } else {
            Logger.log(username + " is not in any chat room");
        }
    }

    public void sendMessage(String message) {
        if (currentRoom != null) {
            currentRoom.sendMessage(username + ": " + message, this);
        } else {
            Logger.log("User " + username + " is not in a chat room to send a message.");
        }
    }

    public void update(String message) {
        System.out.println("[" + username + "] New message: " + message);
    }
}
