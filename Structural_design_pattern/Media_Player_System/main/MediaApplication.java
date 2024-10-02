package Media_Player_System.main;

import Media_Player_System.media.adapter.MediaAdapter;
import Media_Player_System.media.adapter.MediaPlayer;
import Media_Player_System.media.decorator.BufferedMediaPlayer;
import Media_Player_System.media.decorator.LoggingMediaPlayer;
import Media_Player_System.utilities.Logging;

import java.util.Scanner;

public class MediaApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter media type (mp4 or vlc):");
        String mediaType = scanner.nextLine();

        System.out.println("Enter file name:");
        String fileName = scanner.nextLine();

        try {
            MediaPlayer mediaPlayer = new MediaAdapter(mediaType);

            // Adding decorators
            mediaPlayer = new LoggingMediaPlayer(mediaPlayer);
            mediaPlayer = new BufferedMediaPlayer(mediaPlayer);

            mediaPlayer.play(fileName);

        } catch (IllegalArgumentException e) {
            Logging.error(e.getMessage());
        }

        scanner.close();
    }
}
