package Main;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Sound {
    private Clip clip;
    private final URL[] soundURL = new URL[30];
    protected Map<String, Clip> activeClips;
    FloatControl fc;
    int volumeScale = 3;
    float volume;
    public Sound() {
        activeClips = new HashMap<>();

        soundURL[0] = getClass().getResource("/sound/river.wav");
        soundURL[1] = getClass().getResource("/sound/foot_grass.wav");
        soundURL[2] = getClass().getResource("/sound/background.wav");
        soundURL[3] = getClass().getResource("/sound/oldMan.wav");
        soundURL[4] = getClass().getResource("/sound/doorOpen.wav");
        soundURL[5] = getClass().getResource("/sound/doorClose.wav");
        soundURL[6] = getClass().getResource("/sound/select_sound.wav");
        soundURL[7] = getClass().getResource("/sound/click_sound.wav");
        soundURL[8] = getClass().getResource("/sound/cow_umbo.wav");
        soundURL[9] = getClass().getResource("/sound/start_FishTank.wav");
        soundURL[10] = getClass().getResource("/sound/Menu.wav");
        soundURL[11] = getClass().getResource("/sound/Menu_Button.wav");
        soundURL[12] = getClass().getResource("/sound/Menu_setting.wav");
        soundURL[13] = getClass().getResource("/sound/selectItem.wav");
        soundURL[14] = getClass().getResource("/sound/clickItem.wav");
        soundURL[15] = getClass().getResource("/sound/openAndCloseCollection.wav");
        soundURL[16] = getClass().getResource("/sound/openAndCloseCollection1.wav");
    }

    public void setField(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            checkVolume();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isPlaying(String soundName) {
        return activeClips.containsKey(soundName);
    }

    public void play(String soundName) {
        clip.start();
        activeClips.put(soundName, clip);
    }

    public void playSE(String soundName) {
        clip.start();
    }

    public void loop(String soundName) {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        activeClips.put(soundName, clip);
//        for (Map.Entry<String, Clip> entry : activeClips.entrySet()) {
//            String key = entry.getKey();
//            System.out.println("Key: " + key);
//        }
    }

    public void stop(String soundName) {
        Clip clip = activeClips.get(soundName);
        if (clip != null) {
            clip.stop();
            activeClips.remove(soundName);
        }
    }

    public void checkVolume(){
        switch (volumeScale){
            case 0:
                volume = -80f;
                break;
            case 1:
                volume = -18f;
                break;
            case 2:
                volume = -12f;
                break;
            case 3:
                volume = -5f;
                break;
            case 4:
                volume = 1f;
                break;
            case 5:
                volume = 6f;
                break;
        }
        fc.setValue(volume);
    }
}