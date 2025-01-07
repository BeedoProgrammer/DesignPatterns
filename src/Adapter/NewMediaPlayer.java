package Adapter;

public interface NewMediaPlayer {
    void playMP4(String MP4);
}

interface OriginalMediaPlayer {
    void playMP3(String MP3);
}

class MP3Player implements OriginalMediaPlayer {
    @Override
    public void playMP3(String MP3) {
        System.out.println("Playing file: " + MP3);
    }
}

class MP4Player implements NewMediaPlayer {
    @Override
    public void playMP4(String MP4) {
        System.out.println("Playing file: " + MP4);
    }
}

class MP4PlayerAdapter implements OriginalMediaPlayer {
    private MP4Player mP4Player;

    public MP4PlayerAdapter() {
        mP4Player = new MP4Player();
    }

    @Override
    public void playMP3(String MP3) {
        String MP4 = convertMP3ToMP4(MP3);
        mP4Player.playMP4(MP4);
    }
    
    private String convertMP3ToMP4(String MP3){
        String MP4 = "Coverted to MP4";
        return MP4;
    }
}

class Main {
    public static void main(String[] args) {
        OriginalMediaPlayer mp3Player = new MP3Player();
        MP4PlayerAdapter mP4PlayerAdapter = new MP4PlayerAdapter();
        mP4PlayerAdapter.playMP3("song.mp3");
    }
}
