package pattern;



/**
 * Created by nali on 2018/10/8.
 */
public class AdapterPatternDemo {
	public static void main(String[] args) {
		MediaPlayer mediaPlayer = new AudioPlayer();
		mediaPlayer.play("mp3", "randy1");
		mediaPlayer.play("mp4", "randy2");
		mediaPlayer.play("vcl", "randy3");
	}
}

interface MediaPlayer {
	void play(String audioType, String fileName);
}

interface AdvanceMediaPlayer {
	void playVcl(String fileName);

	void playMp4(String fileName);
}

class VclPlayer implements AdvanceMediaPlayer {

	@Override
	public void playVcl(String fileName) {
		System.out.println("VclPlayer play "+ fileName);
	}

	@Override
	public void playMp4(String fileName) {

	}
}

class Mp4Player implements AdvanceMediaPlayer {

	@Override
	public void playVcl(String fileName) {

	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("Mp4Player play " + fileName);
	}
}

class MediaAdapter implements MediaPlayer {
	private AdvanceMediaPlayer advanceMediaPlayer;

	public MediaAdapter(String audioType) {
		if ("vcl".equalsIgnoreCase(audioType)){
			advanceMediaPlayer = new VclPlayer();
		} else {
			advanceMediaPlayer = new Mp4Player();
		}
	}
	@Override
	public void play(String audioType, String fileName) {
		if ("vcl".equalsIgnoreCase(audioType)) {
			advanceMediaPlayer.playVcl(fileName);
		} else {
			advanceMediaPlayer.playMp4(fileName);
		}
	}
}

class AudioPlayer implements MediaPlayer {
	private MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		if ("mp3".equalsIgnoreCase(audioType)) {
			System.out.println("AudioPlayer play " + fileName);
		} else {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}
	}
}