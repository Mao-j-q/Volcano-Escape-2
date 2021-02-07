package tutorial;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	public Handler handler;
	boolean uP;
	boolean dP;
	boolean lP;
	boolean rP;
	private HUD hud;
	Game game;

	public KeyInput(Handler handler, Game game, HUD hud) {
		this.handler = handler;
		this.game = game;
		this.hud = hud;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.list.size(); i++) {
			gameObject temp = handler.list.get(i);
			if (temp.getID() == ID.player) {
				if (key == KeyEvent.VK_W) {
					temp.setVelY(-4 - (hud.getSpeedBoost() - 1));
					uP = true;
				}
				if (key == KeyEvent.VK_S) {
					temp.setVelY(4 + (hud.getSpeedBoost() - 1));
					dP = true;
				}
				if (key == KeyEvent.VK_A) {
					temp.setVelX(-4 - (hud.getSpeedBoost() - 1));
					lP = true;
				}
				if (key == KeyEvent.VK_D) {
					temp.setVelX(4 + (hud.getSpeedBoost() - 1));
					rP = true;
				}
			}
		}
		if (game.gameState == STATE.Game || game.gameState == STATE.Boss) {
			if (key == KeyEvent.VK_ESCAPE) {
				AudioPlayer.getSound("cancel sound").play();
				game.gameState = STATE.Pause;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.list.size(); i++) {
			gameObject temp = handler.list.get(i);
			if (temp.getID() == ID.player) {
				if (key == KeyEvent.VK_W) {
					uP = false;
					if (dP) {
						temp.setVelY(4 + (hud.getSpeedBoost() - 1));
					} else {
						temp.setVelY(0);
					}
				}
				if (key == KeyEvent.VK_S) {
					dP = false;
					if (uP) {
						temp.setVelY(-4 - (hud.getSpeedBoost() - 1));
					} else {
						temp.setVelY(0);
					}
				}
				if (key == KeyEvent.VK_A) {
					lP = false;
					if (rP) {
						temp.setVelX(4 + (hud.getSpeedBoost() - 1));
					} else {
						temp.setVelX(0);
					}
				}
				if (key == KeyEvent.VK_D) {
					rP = false;
					if (lP) {
						temp.setVelX(-4 - (hud.getSpeedBoost() - 1));
					} else {
						temp.setVelX(0);
					}
				}
			}
		}
	}

}
