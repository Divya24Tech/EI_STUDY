package Media_Player_System.media.adapter;

import Media_Player_System.utilities.Logging;

public class VLCPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
        Logging.info("Playing VLC file: " + fileName);
    }

    @Override
    public void playMP4(String fileName) {
        // Do nothing
    }
}
