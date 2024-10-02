package Media_Player_System.media.adapter;

import Media_Player_System.utilities.Logging;

public class MP4Player implements AdvancedMediaPlayer {
    @Override
    public void playMP4(String fileName) {
        Logging.info("Playing MP4 file: " + fileName);
    }

    @Override
    public void playVLC(String fileName) {
        // Do nothing
    }
}
