package Media_Player_System.media.decorator;

import Media_Player_System.media.adapter.MediaPlayer;
import Media_Player_System.utilities.Logging;

public class BufferedMediaPlayer extends MediaPlayerDecorator {

    public BufferedMediaPlayer(MediaPlayer decoratedMediaPlayer) {
        super(decoratedMediaPlayer);
    }

    @Override
    public void play(String fileName) {
        Logging.info("Buffering: Preparing to play file " + fileName);
        super.play(fileName);
        Logging.info("Buffering complete.");
    }
}
