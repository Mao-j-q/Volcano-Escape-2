package tutorial;

import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import javax.sound.sampled.*;

import java.util.HashMap;

//AudioPlayer class to load all the needed sounds and music tracks. 

public class AudioPlayer {

	// Creates two static variable HashMaps for Sound and Music.

	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();

	/*
	 * Static load method to put all corresponding sound and music onto its
	 * pertaining HashMap. Give string name and new Sound/Music with file.
	 */

	public static void load() {
		try {
			soundMap.put("error sound",
					new Sound("res/142608__autistic-lucario__error.wav"));
			soundMap.put("game start sound",
					new Sound("res/243020__plasterbrain__game-start.ogg"));
			soundMap.put("menu select sound",
					new Sound("res/150222__pumodi__menu-select.wav"));
			soundMap.put("purchase sound",
					new Sound("res/126422__makofox__level-up.wav"));
			soundMap.put("cancel sound",
					new Sound("res/213148__complex-waveform__click.wav"));
			soundMap.put("win sound", new Sound(
					"res/242501__gabrielaraujo__powerup-success.wav"));
			soundMap.put("hit sound",
					new Sound("res/89769__cgeffex__fist-punch-3.wav"));
			soundMap.put("game over sound",
					new Sound("res/350983__cabled-mess__lose-c-07.wav"));
			soundMap.put("win game cheer",
					new Sound("res/397435__foolboymedia__crowd-cheer-ii.wav"));
			musicMap.put("game music", new Music(
					"res/251461__joshuaempyre__arcade-music-loop.wav"));
			musicMap.put("main music", new Music(
					"res/550316__podcapocalipsis__indie-game-intro-menu-musica-v.wav"));

		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Static method to return certain Music given its corresponding String.
	 * Does this by using HashMap get method and entering the string key given
	 * to the relating Music.
	 */
	public static Music getMusic(String key) {
		return musicMap.get(key);
	}

	/*
	 * Static method to return certain Sound given its corresponding String.
	 * Does this by using HashMap get method and entering the string key given
	 * to the relating Sound.
	 */
	public static Sound getSound(String key) {
		return soundMap.get(key);
	}

	/*
	 * Static method to pause the certain music given its corresponding String.
	 * Does this by using HashMap get method and entering the string key given
	 * to the relating Music then calling the .pause() method on the Music.
	 */
	public static void pause(String key) {
		musicMap.get(key).pause();
	}

}
