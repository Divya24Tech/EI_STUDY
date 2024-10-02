package Media_Player_System.media.adapter;

import Media_Player_System.utilities.Logging;

public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VLCPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new MP4Player();
        }
    }

    @Override
    public void play(String fileName) {
        if (advancedMediaPlayer instanceof VLCPlayer) {
            advancedMediaPlayer.playVLC(fileName);
        } else if (advancedMediaPlayer instanceof MP4Player) {
            advancedMediaPlayer.playMP4(fileName);
        } else {
            Logging.error("Invalid media type.");
        }
    }
}
