import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class GPanel extends JPanel implements ActionListener{
	///properties
	Timer timer = new Timer(1000/60, this);
	JButton Return = new JButton("Main Menu");
	JButton changeChamp = new JButton("Change Champion");
	JLabel championStats = new JLabel("Champion Stats");
	
	BufferedImage champion1;
	BufferedImage champion2;
	BufferedImage champion3;
	BufferedImage champion4;
	
	int intX = 0;
	int intY = 0;
	int intSizeX = 40;
	int intSizeY = 40;
	int intSkillTime = 0;

	int intHP = 0;
	
	String[][] mapData = new String[484][5];
	
	//buffered images
	BufferedImage s;
	BufferedImage gr;
	BufferedImage w;
	BufferedImage bu;
	BufferedImage br;
	BufferedImage p;
	BufferedImage d;
	BufferedImage t;
	BufferedImage v;
	BufferedImage l;
	BufferedImage r;
	BufferedImage gp;
	BufferedImage bo;
	
	BufferedImage flamel;
	BufferedImage bishop;
	BufferedImage magnus;
	BufferedImage shadow;
		
	ArrayList<GameModel.Projectile1> projectiles = new ArrayList<GameModel.Projectile1>();
	ArrayList<GameModel.Terrain1> map = new ArrayList<GameModel.Terrain1>();
	ArrayList<GameModel.Character1> characters = new ArrayList<GameModel.Character1>();

	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == timer){
			this.repaint();
		}
	}
	
	public void paintComponent(Graphics g){
	
		for(int intCount = 0; intCount < 484; intCount++){
			if(mapData[intCount][2] == (null)){
				break; // change to try catch later
			}
			if(mapData[intCount][2].equals("water")){	
				g.drawImage(w, Integer.parseInt(mapData[intCount][0]), Integer.parseInt(mapData[intCount][1]), Integer.parseInt(mapData[intCount][3]), Integer.parseInt(mapData[intCount][4]), this);
			}else if(mapData[intCount][2].equals("dummy")){
				g.drawImage(d, Integer.parseInt(mapData[intCount][0]), Integer.parseInt(mapData[intCount][1]), Integer.parseInt(mapData[intCount][3]), Integer.parseInt(mapData[intCount][4]), this);
			}else if(mapData[intCount][2].equals("tree")){
				g.drawImage(t, Integer.parseInt(mapData[intCount][0]), Integer.parseInt(mapData[intCount][1]), Integer.parseInt(mapData[intCount][3]), Integer.parseInt(mapData[intCount][4]), this);
			}else if(mapData[intCount][2].equals("statue")){
				g.drawImage(s, Integer.parseInt(mapData[intCount][0]), Integer.parseInt(mapData[intCount][1]), null);
			}else if(mapData[intCount][2].equals("building")){
				g.drawImage(bu, Integer.parseInt(mapData[intCount][0]), Integer.parseInt(mapData[intCount][1]), Integer.parseInt(mapData[intCount][3]), Integer.parseInt(mapData[intCount][4]), this);
			}else if(mapData[intCount][2].equals("grass")){
				g.drawImage(gr, Integer.parseInt(mapData[intCount][0]), Integer.parseInt(mapData[intCount][1]), Integer.parseInt(mapData[intCount][3]), Integer.parseInt(mapData[intCount][4]), this);
			}else if(mapData[intCount][2].equals("path")){
				g.drawImage(p, Integer.parseInt(mapData[intCount][0]), Integer.parseInt(mapData[intCount][1]), Integer.parseInt(mapData[intCount][3]), Integer.parseInt(mapData[intCount][4]), this);
			}else if(mapData[intCount][2].equals("bridge")){
				g.drawImage(br, Integer.parseInt(mapData[intCount][0]), Integer.parseInt(mapData[intCount][1]), Integer.parseInt(mapData[intCount][3]), Integer.parseInt(mapData[intCount][4]), this);
			}else if(mapData[intCount][2].equals("statuex")){
				//terrain (look at loadMap method)
			}else if(mapData[intCount][2].equals("volcano")){
				g.drawImage(v, Integer.parseInt(mapData[intCount][0]), Integer.parseInt(mapData[intCount][1]), null);
			}else if(mapData[intCount][2].equals("volcanox")){
				//terrain
			}else if(mapData[intCount][2].equals("lava")){
				g.drawImage(l, Integer.parseInt(mapData[intCount][0]), Integer.parseInt(mapData[intCount][1]), Integer.parseInt(mapData[intCount][3]), Integer.parseInt(mapData[intCount][4]), this);
			}else if(mapData[intCount][2].equals("bones")){
				g.drawImage(bo, Integer.parseInt(mapData[intCount][0]), Integer.parseInt(mapData[intCount][1]), Integer.parseInt(mapData[intCount][3]), Integer.parseInt(mapData[intCount][4]), this);
			}else if(mapData[intCount][2].equals("rock")){
				g.drawImage(r, Integer.parseInt(mapData[intCount][0]), Integer.parseInt(mapData[intCount][1]), Integer.parseInt(mapData[intCount][3]), Integer.parseInt(mapData[intCount][4]), this);
			}else if(mapData[intCount][2].equals("grasspath")){
				g.drawImage(gp, Integer.parseInt(mapData[intCount][0]), Integer.parseInt(mapData[intCount][1]), Integer.parseInt(mapData[intCount][3]), Integer.parseInt(mapData[intCount][4]), this);
			}
		}
		
		g.setColor(Color.RED);
		for(int intCount = projectiles.size() -1; intCount >= 0; intCount--){
			if(projectiles.get(intCount).intID == 5){
				g.setColor(Color.RED);
			}else if(projectiles.get(intCount).intID == 6){
				g.setColor(Color.BLUE);
			}else if(projectiles.get(intCount).intID == 7){
				g.setColor(Color.GREEN);
			}else if(projectiles.get(intCount).intID == 8){
				g.setColor(Color.YELLOW);
			}else if(projectiles.get(intCount).intID == 9){
				g.setColor(Color.PINK);
			}
			g.fillRect(projectiles.get(intCount).intX, projectiles.get(intCount).intY, projectiles.get(intCount).intSize, projectiles.get(intCount).intSize); 			
		}
		
		for(int intCount = characters.size() -1; intCount >= 0; intCount--){
			if(characters.get(intCount).intID == 5){
				g.setColor(Color.RED);
			}else if(characters.get(intCount).intID == 6){
				g.setColor(Color.BLUE);
			}else if(characters.get(intCount).intID == 7){
				g.setColor(Color.GREEN);
			}else if(characters.get(intCount).intID == 8){
				g.setColor(Color.YELLOW);
			}else if(characters.get(intCount).intID == 9){
				g.setColor(Color.PINK);
			}
			g.fillRect(characters.get(intCount).intX, characters.get(intCount).intY+15, characters.get(intCount).intSizeX, characters.get(intCount).intSizeY-15); 			
			if(characters.get(intCount).intCharType == 1){
				g.drawImage(flamel, characters.get(intCount).intX, characters.get(intCount).intY, null);
			}else if(characters.get(intCount).intCharType == 2){
				g.drawImage(bishop, characters.get(intCount).intX, characters.get(intCount).intY, null);
			}else if(characters.get(intCount).intCharType == 3){
				g.drawImage(magnus, characters.get(intCount).intX, characters.get(intCount).intY, null);
			}else if(characters.get(intCount).intCharType == 4){
				g.drawImage(shadow, characters.get(intCount).intX, characters.get(intCount).intY, null);
			}
			 
		}
				
		g.setColor(Color.WHITE);
		g.fillRect(660, 0, 620, 720);
		g.fillRect(0, 660, 660, 60);
		
		g.setColor(Color.RED);
		g.drawString("HP: "+intHP, 750, 300);
		g.setColor(Color.BLUE);
		g.drawString("Skill: "+intSkillTime, 750, 350);
		
		g.setColor(Color.RED);
		for(int intCount = characters.size() -1; intCount >= 0; intCount--){
			int intXDraw = 730 + (intCount*50);
			g.drawString(characters.get(intCount).intID+": ", intXDraw, 50);
			g.drawString("HP: "+characters.get(intCount).intHP, intXDraw, 100);	
			g.drawString("Skill: "+characters.get(intCount).intSkillTime, intXDraw, 150);
			g.drawString("LIVES: "+characters.get(intCount).intLives, intXDraw, 200);		 
		}
	}
	
	//constructor
	public GPanel(){		
		super();
		this.setLayout(null);
		timer.start();
		
		//loading images of map 1 
		try{
			s = ImageIO.read(new File("statue.png"));
			gr = ImageIO.read(new File("grass.png"));
			w = ImageIO.read(new File("water.png"));
			bu = ImageIO.read(new File("building.png"));
			br = ImageIO.read(new File("bridge.png"));
			p = ImageIO.read(new File("path.png"));
			d = ImageIO.read(new File("dummy.png"));
			t = ImageIO.read(new File("tree.png"));
			l = ImageIO.read(new File("lava.png"));
			bo = ImageIO.read(new File("bones.png"));
			v = ImageIO.read(new File("volcano.png"));
			r = ImageIO.read(new File("rock.png"));
			gp = ImageIO.read(new File("grasspath.png"));
			
			flamel = ImageIO.read(new File("ingame_flamel.png"));
			bishop = ImageIO.read(new File("ingame_bishop.png"));
			magnus = ImageIO.read(new File("ingame_magnus.png"));
			shadow = ImageIO.read(new File("ingame_shadow.png"));
			
			//tutorialChar = ImageIO.read(new File("tc.png"));
			
			//accesses ttf file, creates it into a ttf font with java swing, and derives the font size using float
			Font customFont1 = Font.createFont(Font.TRUETYPE_FONT, new File("font1.ttf")).deriveFont(30f);
			Font customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("font2.ttf")).deriveFont(40f);
			Font customFont3 = Font.createFont(Font.TRUETYPE_FONT, new File("font3.TTF")).deriveFont(55f);
			Font customFont4 = Font.createFont(Font.TRUETYPE_FONT, new File("font4.TTF")).deriveFont(60f);
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(FontFormatException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}
		
}
		
