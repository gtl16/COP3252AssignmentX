package com.larkins.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameBoard {
	public static final int ROWS = 3;
	public static final int COLS = 10;
	
	private final int startingCards = 7;
	private Card[][] board;
	private boolean pullCard; // keeps track of if you can play any cards or have to pull another
	private boolean won; 
	private String[] deck = {"0r","1r","2r","3r","4r","5r","6r","7r","8r","9r","skipr","revr","p2r",
			"1r2","2r2","3r2","4r2","5r2","6r2","7r2","8r2","9r2","skipr2","revr2","p2r2",
			"0g","1g","2g","3g","4g","5g","6g","7g","8g","9g","skipg","revg","p2g",
			"1g2","2g2","3g2","4g2","5g2","6g2","7g2","8g2","9g2","skipg2","revg2","p2g2",
			"0o","1o","2o","3o","4o","5o","6o","7o","8o","9o","skipo","revo","p2o",
			"1o2","2o2","3o2","4o2","5o2","6o2","7o2","8o2","9o2","skipo2","revo2","p2o2",
			"0b","1b","2b","3b","4b","5b","6b","7b","8b","9b","skipb","revb","p2b",
			"1b2","2b2","3b2","4b2","5b2","6b2","7b2","8b2","9b2","skipb2","revb2","p2b2",
			"wild1", "wild2", "wild3", "wild4", "p41", "p42", "p43", "p44"};
	private int deal = 0;
	private boolean[] beenDealt = new boolean[108];
	
	private BufferedImage gameBoard;
	private BufferedImage finalBoard;
	private int x;
	private int y;
	
	private static int SPACING = 5;
	public static int BOARD_WIDTH = (COLS + 1) * SPACING + COLS * Card.WIDTH;
	public static int BOARD_HEIGHT = (ROWS + 1) * SPACING + ROWS * Card.HEIGHT;
	
	private boolean hasStarted;
	
	public GameBoard(int x, int y)
	{
		this.x = x;
		this.y = y;
		board = new Card[ROWS][COLS];
		gameBoard = new BufferedImage(BOARD_WIDTH, BOARD_HEIGHT, BufferedImage.TYPE_INT_RGB);
		finalBoard = new BufferedImage(BOARD_WIDTH, BOARD_HEIGHT, BufferedImage.TYPE_INT_RGB);
		for(int s = 0; s< 108; s++)
			beenDealt[s] = false;
		createBoardImage();
		start();
		
	}
	
	private void createBoardImage()
	{
		Graphics2D g = (Graphics2D) gameBoard.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
		g.setColor(Color.lightGray);
		
		for(int row = 0; row< ROWS; row++)
		{
			for(int col = 0; col < COLS; col++)
			{
				int x = SPACING+ SPACING * col + Card.WIDTH * col;
				int y = SPACING + SPACING * row + Card.HEIGHT * row;
				g.fillRoundRect(x, y, Card.WIDTH, Card.HEIGHT, Card.ARC_WIDTH, Card.ARC_HEIGHT);
			}
		}
		
	}
	
	private void start()
	{
		
		//for(int i = 0; i < startingCards; i++)
		//{
			for(int m = 0; m < startingCards; m++)
			{
				int f = randCard();
				String val = deck[f];
				
				Card card = new Card(val, getCardX(m), getCardY(0));
				board[0][m] = card; // figure out what goes in the x,y spots
			}
		//}
	}
	
	private int randCard()
	{
	
		Random random = new Random();
		if(deal == 0)
		{
			int fcard = random.nextInt(108);
			beenDealt[fcard] = true;
			return fcard;
			
		}
		
		int car = random.nextInt(108);;
		if(deal != 0 && deal < 108)
		{
			while(beenDealt[car] == true)
				car = random.nextInt(108);
		}
		
		deal++;
	
		//if all cards have been dealt, take discardStack array and set all those values to false in the beenDealt array
		
		return car;
	}
	
	public int getCardX(int col)
	{
		return SPACING + col * Card.WIDTH + col * SPACING;
	}
	
	public int getCardY(int row)
	{
		return SPACING + row * Card.HEIGHT + row * SPACING;
	}
	
	public void render(Graphics2D g)
	{
		Graphics2D g2d = (Graphics2D)finalBoard.getGraphics();
		g2d.drawImage(gameBoard,0,0,null);
		
		for(int row = 0; row < ROWS; row++)
		{
			for(int col = 0; col < COLS; col++)
			{
				Card current = board[row][col];
				if(current == null) continue;
				current.render(g2d);
			}
		}
		
		g.drawImage(finalBoard, x, y, null);
		g2d.dispose();
			
	}
	
	public void update()
	{
		//for(int row = 0; row < ROWS; )
	}
	
	
}
