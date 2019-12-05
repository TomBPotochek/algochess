package fiuba.algo3.algochess.controller;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Util {

	public static void reproducirSonido(String archivo) {

    	Media sound = new Media(new File("src/main/resources/" + archivo).toURI().toString());
    	MediaPlayer mediaPlayer = new MediaPlayer(sound);
    	mediaPlayer.play();

    }
}
