package tutorial.multiframe;

import javax.sound.sampled.*;
import java.net.URL;

public class MusicPlayer {
    private static MusicPlayer instance = null;
    private Clip clip;
    private boolean isPlaying = false;

    // Private constructor ensures this is a singleton.
    private MusicPlayer() {
        try {
            // Use an absolute path starting from the classpath root.
            URL url = MusicPlayer.class.getResource("/tutorial/multiframe/let-the-mystery-unfold-122118.wav");
            if (url == null) {
                throw new IllegalArgumentException("let-the-mystery-unfold-122118.wav not found in /tutorial/multiframe");
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static MusicPlayer getInstance() {
        if (instance == null) {
            instance = new MusicPlayer();
        }
        return instance;
    }

    public void play() {
        if (clip != null && !isPlaying) {
            clip.start();
            isPlaying = true;
        }
    }

    public void pause() {
        if (clip != null && isPlaying) {
            clip.stop();
            isPlaying = false;
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
            isPlaying = false;
        }
    }
}
