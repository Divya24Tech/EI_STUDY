package adapter;

import utils.Logger;

public class HttpAdapter implements ChatProtocol {
    @Override
    public void send(String message) {
        Logger.log("Sending message via HTTP: " + message);
    }
}
