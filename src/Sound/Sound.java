package Sound;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.EOFException;
import javax.sound.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.net.URL;

public class Sound {
//	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
//	Scanner scanner = new Scanner(System.in);
//	File file = new File("sound/soundGame.wav");
//	AudioInputStream audioStream= AudioSystem.getAudioInputStream(file);
//	Clip clip = AudioSystem.getClip();
//	clip.open(audioStream);
//	clip.start();
//	String response = scanner.next();
//	}
	 public static Clip getSound(){
	        try {
	        	File file = new File("sound/soundGame.wav");

	            AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(file);
	            Clip clip= AudioSystem.getClip();
	            clip.open(audioInputStream);
	            return  clip;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

}
