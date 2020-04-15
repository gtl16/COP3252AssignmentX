package com.larkins.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Card {
	public static final int WIDTH = 75;
	public static final int HEIGHT = 100;
	public static final int SLIDE_SPEED = 20;
	public static final int ARC_WIDTH = 15;
	public static final int ARC_HEIGHT = 15;
	
	private String value;
	private BufferedImage cardImage;
	private Color background;
	private Color text;
	private Font font;
	private int x;
	private int y;
	
	public Card(String value, int x, int y)
	{
		this.value = value;
		this.x = x;
		this.y = y;
		cardImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		drawImage();
	}
	
	private void drawImage()
	{
		Graphics2D g = (Graphics2D)cardImage.getGraphics();
		if(value.equals("0r") || value.equals("1r") || value.equals("2r") || value.equals("3r") || value.equals("4r")
				|| value.equals("5r") || value.equals("6r") || value.equals("7r") || value.equals("8r") 
				|| value.equals("9r") || value.equals("skipr") || value.equals("revr") || value.equals("p2r")
				|| value.equals("1r2") || value.equals("2r2") || value.equals("3r2") 
				|| value.equals("4r2") || value.equals("5r2") || value.equals("6r2") || value.equals("7r2") || value.equals("8r2") 
				|| value.equals("9r2") || value.equals("skipr2") || value.equals("revr2") || value.equals("p2r2"))
		{
			background = new Color(255, 51, 51);
			text = new Color(255,255, 255);
		}
		else if(value.equals("0o") || value.equals("1o") || value.equals("2o") || value.equals("3o") || value.equals("4o")
				|| value.equals("5o") || value.equals("6o") || value.equals("7o") || value.equals("8o") 
				|| value.equals("9o") || value.equals("skipo") || value.equals("revo") || value.equals("p2o")
				|| value.equals("1o2") || value.equals("2o2") || value.equals("3o2") || value.equals("4o2")
				|| value.equals("5o2") || value.equals("6o2") || value.equals("7o2") || value.equals("8o2") 
				|| value.equals("9o2") || value.equals("skipo2") || value.equals("revo2") || value.equals("p2o2"))
		{
			background = new Color(255, 153, 0);
			text = new Color(255,255, 255);
		}
		else if(value.equals("0g") || value.equals("1g") || value.equals("2g") || value.equals("3g") || value.equals("4g")
				|| value.equals("5g") || value.equals("6g") || value.equals("7g") || value.equals("8g") 
				|| value.equals("9g") || value.equals("skipg") || value.equals("revg") || value.equals("p2g")
				|| value.equals("1g2") || value.equals("2g2") || value.equals("3g2") || value.equals("4g2")
				|| value.equals("5g2") || value.equals("6g2") || value.equals("7g2") || value.equals("8g2") 
				|| value.equals("9g2") || value.equals("skipg2") || value.equals("revg2") || value.equals("p2g2"))
		{
			background = new Color(0, 204, 0);
			text = new Color(255,255, 255);
		}
		else if(value.equals("0b") || value.equals("1b") || value.equals("2b") || value.equals("3b") || value.equals("4b")
				|| value.equals("5b") || value.equals("6b") || value.equals("7b") || value.equals("8b") 
				|| value.equals("9b") || value.equals("skipb") || value.equals("revb") || value.equals("p2b")
				|| value.equals("1b2") || value.equals("2b2") || value.equals("3b2") || value.equals("4b2")
				|| value.equals("5b2") || value.equals("6b2") || value.equals("7b2") || value.equals("8b2") 
				|| value.equals("9b2") || value.equals("skipb2") || value.equals("revb2") || value.equals("p2b2"))
		{
			background = new Color(51, 153, 255);
			text = new Color(255,255, 255);
		}
		else if(value.equals("wild1") || value.equals("wild2") || value.equals("wild3") || value.equals("wild4")
				|| value.equals("p41") || value.equals("p42") || value.equals("p43") || value.equals("p44"))
		{
			background = new Color(0, 0, 0);
			text = new Color(255,255, 255);
		}
		
		g.setColor(new Color(0,0,0,0));
		g.fillRect(0, 0, WIDTH,HEIGHT);
		g.setColor(background);
		g.fillRoundRect(0, 0, WIDTH, HEIGHT, ARC_WIDTH, ARC_HEIGHT);
		
		g.setColor(text);
	//	if(!value.equals("skipb") && !value.equals("skipr") && !value.equals("skipo") && !value.equals("skipg"))
	//	{
			font = Game.cards.deriveFont(18f);
	//	}
	//	else
	//	{
	//		font = Game.main;
	//	}
		g.setFont(font);
		
		//this centers the card number/type on the card
		
		int drawX = WIDTH / 2 - DrawUtils.getMessageWidth(value, font, g)/2;
		int drawY = HEIGHT / 2 + DrawUtils.getMessageHeight(value, font, g) / 2;
		
		String v = null;
		if(value.equals("0r") || value.equals("0b") || value.equals("0g") || value.equals("0o"))
			v = "0";
		if(value.equals("1r") || value.equals("1b") || value.equals("1g") || value.equals("1o")
				|| value.equals("1r2") || value.equals("1b2") || value.equals("1g2") || value.equals("1o2"))
			v = "1";
		if(value.equals("2r") || value.equals("2b") || value.equals("2g") || value.equals("2o")
				|| value.equals("2r2") || value.equals("2b2") || value.equals("2g2") || value.equals("2o2"))
			v = "2";
		if(value.equals("3r") || value.equals("3b") || value.equals("3g") || value.equals("3o")
				|| value.equals("3r2") || value.equals("3b2") || value.equals("3g2") || value.equals("3o2"))
			v = "3";
		if(value.equals("4r") || value.equals("4b") || value.equals("4g") || value.equals("4o")
				|| value.equals("4r2") || value.equals("4b2") || value.equals("4g2") || value.equals("4o2"))
			v = "4";
		if(value.equals("5r") || value.equals("5b") || value.equals("5g") || value.equals("5o")
				|| value.equals("5r2") || value.equals("5b2") || value.equals("5g2") || value.equals("5o2"))
			v = "5";
		if(value.equals("6r") || value.equals("6b") || value.equals("6g") || value.equals("6o")
				|| value.equals("6r2") || value.equals("6b2") || value.equals("6g2") || value.equals("6o2"))
			v = "6";
		if(value.equals("7r") || value.equals("7b") || value.equals("7g") || value.equals("7o")
				|| value.equals("7r2") || value.equals("7b2") || value.equals("7g2") || value.equals("7o2"))
			v = "7";
		if(value.equals("8r") || value.equals("8b") || value.equals("8g") || value.equals("8o")
				|| value.equals("8r2") || value.equals("8b2") || value.equals("8g2") || value.equals("8o2"))
			v = "8";
		if(value.equals("9r") || value.equals("9b") || value.equals("9g") || value.equals("9o")
				|| value.equals("9r2") || value.equals("9b2") || value.equals("9g2") || value.equals("9o2"))
			v = "9";
		if(value.equals("wild1") || value.equals("wild2") || value.equals("wild3") || value.equals("wild4"))
			v = "wild";
		if(value.equals("p41") || value.equals("p42") || value.equals("p43") || value.equals("p44"))
			v = "+4";
		if(value.equals("skipr") || value.equals("skipr2") || value.equals("skipb") || value.equals("skipb2")
				|| value.equals("skipg") || value.equals("skipg2") || value.equals("skipo") || value.equals("skipo2")) 
			v = "skip";
		if(value.equals("revr") || value.equals("revr2") || value.equals("revb") || value.equals("revb2")
				|| value.equals("revg") || value.equals("revg2") || value.equals("revo") || value.equals("revo2")) 
			v = "rev";
		if(value.equals("p2b2") || value.equals("p2b") || value.equals("p2r2") || value.equals("p2r") || value.equals("p2g2")
				|| value.equals("p2g") || value.equals("p2o2") || value.equals("p2o"))
			v = "+2";

		g.drawString(v, drawX, drawY);
		g.dispose();
		
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics2D g)
	{
		g.drawImage(cardImage, x, y, null);
	}
	
	public String getValue()
	{
		return value;
	}
	
}
