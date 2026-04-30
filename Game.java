
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener{

	
	private BufferedImage back; 
	private int key;
	private ImageIcon background;
	private Background bg;
	private Image Icon loseBG;
	private Character img;
	private int score = 0;
	private char screen;
	

	
	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		key =-1;
		screen = 'S';
		initializeBackground();
		img = new Character();
	
	}

	public void screen(Graphics g2d){		
		switch(screen){

			case 'S':
			g2d.clearRect(0,0,getWidth(),getHeight());
			g2d.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
			g2d.setFont(new Font("Georgia", Font.BOLD, 65));
			Color GreenColor= new Color(74, 158, 122);
			g2d.setColor(GreenColor);
			g2d.drawString("Press S to Start", getWidth()/2 - 250, getHeight()/2 - 60);
			g2d.drawString("and P to Pause", getWidth()/2 - 250, getHeight()/2 + 30);
			break;

			case 'G':
			break;

			case 'P':
			g2d.clearRect(0,0,getSize().width,getSize().height);
			g2d.drawImage(background.getImage(), bg.getX(), 0, getWidth(), getHeight(), this);
			g2d.drawImage(background.getImage(), bg.getX() + getWidth(), 0, getWidth(), getHeight(), this);
			g2d.setFont(new Font("Georgia", Font.BOLD, 75));
			Color stemGreenColor= new Color(74, 158, 122);
			g2d.setColor(stemGreenColor);
			int x = getWidth()/2 - 150;
			int y = getHeight()/2; 
			g2d.drawString("Paused", x, y);



			break;

			case 'L':
			
			g2d.clearRect(0, 0, getWidth(), getHeight());
			g2d.drawImage(loseBG.getImage(), 0, 0, getWidth(), getHeight(), this);
			g2d.setFont(new Font("Georgia", Font.BOLD, 65)); 
			g2d.setColor(Color.blue); 
			g2d.drawString("You Lost!", getWidth()/2 - 160, getHeight()/2 - 60); 
			g2d.drawString("Score: " + score, getWidth()/2 - 130, getHeight()/2 + 10);
			g2d.drawString("Press R to Restart", getWidth()/2 - 310, getHeight()/2 + 80);
			}
			
			return;		
		}
		}

	public void initializeBackground(){
		bg = new Background(getWidth());
		background = new ImageIcon("skybg.jpg");
		loseBG = new ImageIcon ("losebg.jpg");
	}
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
				if(screen != 'P'){
	   		Thread.currentThread().sleep(10);
	    repaint();
	         }
			else{
				Thread.currentThread().sleep(10);
			}
	      }
		}
	   		catch(Exception e)
	      {
	      }
	  	}
	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		if (background == null){
			initializeBackground();
		}
		
		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		
		g2d.setFont( new Font("Georgia", Font.BOLD, 50));
		g2d.drawImage(background.getImage(), bg.getX(), 0, getWidth(), getHeight(), this);
		g2d.drawImage(background.getImage(), bg.getX() + getWidth(), 0, getWidth(), getHeight(), this);

		if (screen == 'G'){
			bg.move();
			img.move();
		}

		g2d.drawImage(img.getPic().getImage(), img.getX(), img.getY(), img.getWidth(), img.getHeight(), this);
		drawObstacles(g2d);

		if (screen == 'G'){
			g2d.setFont(new Font("Georgia", Font.BOLD, 50));
			Color blueish= new Color(141, 115, 217);
			g2d.setColor(blueish);
			g2d.drawString("Score: " + score, 30, 60); }

		screen(g2d);

		twoDgraph.drawImage(back, null, 0, 0);

	}

	



	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		
		
		
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
		
	}
	
	
	

	
}
