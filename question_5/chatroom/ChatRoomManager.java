package chatroom;

import java.util.HashMap;
import java.util.Map;
import utils.Logger;

public class ChatRoomManager {
    private static ChatRoomManager instance;
    private Map<String, ChatRoom> chatRooms = new HashMap<>();

    private ChatRoomManager() {}

    public static synchronized ChatRoomManager getInstance() {
        if (instance == null) {
            instance = new ChatRoomManager();
            Logger.log("ChatRoomManager initialized");
        }
        return instance;
    }

    public ChatRoom getChatRoom(String roomId) {
        return chatRooms.computeIfAbsent(roomId, ChatRoom::new);
    }
}
