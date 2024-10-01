package adapter;

import utils.Logger;

public class WebSocketAdapter implements ChatProtocol {
    @Override
    public void send(String message) {
        Logger.log("Sending message via WebSocket: " + message);
    }
}
