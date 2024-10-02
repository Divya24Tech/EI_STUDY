package Media_Player_System.media.decorator;

import Media_Player_System.media.adapter.MediaPlayer;
import Media_Player_System.utilities.Logging;

public class LoggingMediaPlayer extends MediaPlayerDecorator {

    public LoggingMediaPlayer(MediaPlayer decoratedMediaPlayer) {
        super(decoratedMediaPlayer);
    }

    @Override
    public void play(String fileName) {
        Logging.info("Logging: Starting playback of file " + fileName);
        super.play(fileName);
    }
}
