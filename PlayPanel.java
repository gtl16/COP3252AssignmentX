package com.larkins.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.larkins.game.DrawUtils;
import com.larkins.game.Game;
import com.larkins.game.GameBoard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayPanel extends GuiPanel{

	private GameBoard board;
	private BufferedImage info;
	
	//private ScoreManager scores;
	//private Font scoreFont;
	
	//Game Over
	private GuiButton newGame;
	private GuiButton mainMenu;
	private int smallButtonWidth = 250; 
	private int spacing = 20;
	private int buttonHeight = 50;
	private boolean added;
	private int alpha;// for fading out
	private Font gameOverFont;
	
	public PlayPanel()
	{
		gameOverFont = Game.main.deriveFont(80f);
		board = new GameBoard(Game.WIDTH/2 - GameBoard.BOARD_WIDTH/2, Game.HEIGHT - GameBoard.BOARD_HEIGHT -20);
		//scores = board.getScores();
		info = new BufferedImage(Game.WIDTH, 200, BufferedImage.TYPE_INT_RGB);
		
		mainMenu = new GuiButton(Game.WIDTH/2 + spacing, 150 ,smallButtonWidth, buttonHeight);
		newGame = new GuiButton(Game.WIDTH/2 - smallButtonWidth , 150 ,smallButtonWidth, buttonHeight);
		
		//g.setColor(Color.black);
		newGame.setText("Play Again");
		mainMenu.setText("Main Menu");
		
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//board.getScores().reset();
				//	board.reset();
				alpha = 0;
				
				remove(newGame);
				remove(mainMenu);
			
				added = false;
			
			}
			
		});
		
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				GuiScreen.getInstance().setCurrentPanel("Menu");
			}
			
		});
		

	}
	
	private void drawGui(Graphics2D g)
	{
		Graphics2D g2d = (Graphics2D)info.getGraphics();
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, info.getWidth(), info.getHeight());
//		g2d.setFont(scoreFont);
//		g2d.drawString("" + scores.getCurrentScore(), 30, 40);
//		g2d.setColor(Color.red);
//		g2d.drawString(", x, y);
		
	}
	
	private void drawGameOver(Graphics2D g)
	{
		g.setColor(new Color(222,222,222,alpha));
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.setColor(Color.red);
		g.setFont(gameOverFont);
		g.drawString("Game Over!", Game.WIDTH/2 - DrawUtils.getMessageWidth("Game Over", gameOverFont, g)/2, 100);
	}
	
	@Override
	public void update()
	{
		board.update();
	//	if(board.isDead())
	//	{
	//		alpha++;
	//		if(alpha > 170)
	//			alpha = 170;
	//	}
	}
	
	@Override
	public void render(Graphics2D g)
	{
		drawGui(g);
		board.render(g);
		
	//	if(board.isDead())
	//	{
			if(!added)
			{
				added = true;
				add(mainMenu);
				add(newGame);
			}
			drawGameOver(g);
		//}
		super.render(g);
		
	}
	
}
