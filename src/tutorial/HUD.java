package tutorial;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HUD {
	private Game game;
	public static float HEALTH = 100;
	private int gVal = 255;
	private int score = 0;
	private int level = 1;
	private int count = 0;
	private int stage = 1;
	private int lives = 3;
	private int credits;
	private int defense = 1;
	private int finScore;
	private boolean won;
	private int speedBoost = 1;
	private boolean finStage = false;
	private int eSizeDec = 1;

	public HUD(Game game) {
		this.game = game;

	}

	public void tick() {
		HEALTH = Game.clamp(HEALTH, 100, -1);
		gVal = (int) Game.clamp((float) gVal, 255, 0);
		gVal = (int) (HEALTH * 2.5);
		if (game.gameState == STATE.Boss) {
			count++;
			if (count == 10) {
				score++;
				count = 0;
			}
		}
	}

	public void render(Graphics g) {

		if (game.gameState == STATE.Game) {
			Font font = new Font("arial", 1, 25);
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Level: " + level, 15, 60);
			g.drawString("Stage: " + stage, 15, 30);
			g.drawString("Lives: " + lives, 15, 90);
			g.setColor(new Color(0, 80, 0));
			g.fillRect((int) (Game.WIDTH - 25), (int) (Game.HEIGHT / 2 - 50),
					20, 40);
			g.setColor(new Color(0, 150, 0));
			g.drawRect((int) (Game.WIDTH - 25), (int) (Game.HEIGHT / 2 - 50),
					20, 40);

		} else if (game.gameState == STATE.Boss) {
			Font font = new Font("arial", 1, 18);
			Font font2 = new Font("arial", 1, 17);

			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Level: " + level, 200, 75);

			g.drawString("Stage: " + stage, 200, 55);

			g.setColor(Color.black);
			g.fillRect(15, 15, 250, 20);
			g.setColor(new Color(150, gVal, 0));
			g.fillRect(15, 15, (int) (HEALTH * 2.5), 20);
			g.setColor(Color.white);
			g.drawRect(15, 15, 250, 20);
			if (game.difficulty == MODE.Easy) {
				g.setColor(Color.red);
				g.setFont(font);
				if (getStage() == 1) {
					g.drawString("SURVIVAL ROUND: REACH 75 SCORE", 270, 32);
				} else if (getStage() == 2) {
					g.drawString("SURVIVAL ROUND: REACH 100 SCORE", 270, 32);
				} else if (getStage() == 3) {
					g.drawString("SURVIVAL ROUND: REACH 125 SCORE", 270, 32);
				}
			} else if (game.difficulty == MODE.Normal) {
				g.setColor(Color.red);
				g.setFont(font);
				if (getStage() == 1) {
					g.drawString("SURVIVAL ROUND: REACH 100 SCORE", 270, 32);
				} else if (getStage() == 2) {
					g.drawString("SURVIVAL ROUND: REACH 125 SCORE", 270, 32);
				} else if (getStage() == 3) {
					g.drawString("SURVIVAL ROUND: REACH 150 SCORE", 270, 32);
				}
			} else if (game.difficulty == MODE.Hard) {
				g.setColor(Color.red);
				g.setFont(font);
				if (getStage() == 1) {
					g.drawString("SURVIVAL ROUND: REACH 125 SCORE", 270, 32);
				} else if (getStage() == 2) {
					g.drawString("SURVIVAL ROUND: REACH 150 SCORE", 270, 32);
				} else if (getStage() == 3) {
					g.drawString("SURVIVAL ROUND: REACH 175 SCORE", 270, 32);
				}
			}
			g.setColor(Color.white);
			g.setFont(font);
			g.drawString((int) HEALTH + "%", 15, 55);
			g.drawString("Score: " + score, 15, 75);
		}
	}

	public Rectangle getGoalBounds() {
		return new Rectangle((int) (Game.WIDTH - 25),
				(int) (Game.HEIGHT / 2 - 50), 20, 40);
	}

	public int findCredits() {
		int healthcreds = 0;
		if (HEALTH >= 90) {
			healthcreds = 1100;
		} else if (HEALTH >= 75) {
			healthcreds = 900;
		} else if (HEALTH >= 50) {
			healthcreds = 700;
		} else {
			healthcreds = 500;
		}
		return (lives * 100) + (stage * 700) + healthcreds;
	}

	public int findPD() {
		if (game.difficulty == MODE.Easy) {
			return 1;
		} else if (game.difficulty == MODE.Normal) {
			return 2;
		} else if (game.difficulty == MODE.Hard) {
			return 3;
		} else
			return 1;
	}

	public int findFinScore() {
		int additional = 0;
		if (won) {
			additional = ((int) HEALTH * 75) + (credits);
		}

		return ((stage * 1000) - 1000 + (level * 100) + additional) * findPD();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getStage() {
		return stage;

	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int creds) {
		this.credits = creds;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getFinScore() {
		return finScore;
	}

	public void setFinScore(int finScore) {
		this.finScore = finScore;
	}

	public boolean getWon() {
		return won;
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	public int getSpeedBoost() {
		return speedBoost;
	}

	public void setSpeedBoost(int speedBoost) {
		this.speedBoost = speedBoost;
	}

	public boolean getFinStage() {
		return finStage;
	}

	public void setFinStage(boolean finStage) {
		this.finStage = finStage;
	}

	public int getESizeDec() {
		return eSizeDec;
	}

	public void setESizeDec(int eSizeDec) {
		this.eSizeDec = eSizeDec;
	}

}
