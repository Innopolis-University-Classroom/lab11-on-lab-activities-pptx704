interface MediaPlayer {
    void playMp4();
}

interface AudioPlayer {
    void playMp3();
}

class Media implements MediaPlayer {
    String content;
    public Media(String content){
        this.content = content;
    }
    public void playMp4(){
        System.out.println("Playing " + content);
    }
}

class Audio implements AudioPlayer {
    String content;
    public Audio(String content){
        this.content = content;
    }
    public void playMp3(){
        System.out.println("Playing " + content);
    }
}

class PlayerDevice{
    public void playMp4(MediaPlayer m){
        m.playMp4();
    }
}

class MediaAdapter implements MediaPlayer{
    Audio audio;
    
    public MediaAdapter(Audio audio){
        this.audio = audio;
    }

    public void playMp4(){
        this.audio.playMp3();
    }
}

public class problem3 {
    public static void main(String[] args) {
        Audio audio = new Audio("Song 1");
        Media media = new Media("Video 1");
        MediaAdapter adapter = new MediaAdapter(audio);
        PlayerDevice device = new PlayerDevice();
        device.playMp4(media);
        device.playMp4(adapter);
    }
}