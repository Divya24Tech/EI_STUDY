package Media_Player_System.media.decorator;

import Media_Player_System.media.adapter.MediaPlayer;

public abstract class MediaPlayerDecorator implements MediaPlayer {
    protected MediaPlayer decoratedMediaPlayer;

    public MediaPlayerDecorator(MediaPlayer decoratedMediaPlayer) {
        this.decoratedMediaPlayer = decoratedMediaPlayer;
    }

    @Override
    public void play(String fileName) {
        decoratedMediaPlayer.play(fileName);
    }
}
