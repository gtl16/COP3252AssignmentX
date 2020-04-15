package com.larkins.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.larkins.game.DrawUtils;
import com.larkins.game.Game;

public class MainMenuPanel extends GuiPanel{

	private Font titleFont = Game.main.deriveFont(100f);
	private Font creatorFont = Game.cards.deriveFont(40f);
	private String title = "UNO";
	private int buttonWidth = 220;
	private int spacing = 90;
	
	public MainMenuPanel()
	{
		super();
		GuiButton playButton = new GuiButton(Game.WIDTH/2 - buttonWidth/2, 220, buttonWidth, 60);
		GuiButton instrucButton = new GuiButton(Game.WIDTH/2 - buttonWidth/2, playButton.getY() + spacing, buttonWidth, 60);
		GuiButton quitButton = new GuiButton(Game.WIDTH/2 - buttonWidth/2, instrucButton.getY()+spacing, buttonWidth, 60);

		playButton.setText("Play");
		instrucButton.setText("Rules");
		quitButton.setText("Quit");
		
		playButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GuiScreen.getInstance().setCurrentPanel("Play");
				
			}
			
		});
		
		instrucButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GuiScreen.getInstance().setCurrentPanel("Rules");
				
			}
			
		});
		
		quitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		
		add(playButton);
		add(instrucButton);
		add(quitButton);
	}
	
	@Override
	public void render(Graphics2D g)
	{
		super.render(g);
		g.setFont(titleFont);
		g.setColor(Color.black);
		g.drawString(title, Game.WIDTH/2 - DrawUtils.getMessageWidth(title, titleFont, g)/2, 150);
		
		//g.setFont(creator );
	}
	
}
