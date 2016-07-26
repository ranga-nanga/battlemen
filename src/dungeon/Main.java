package dungeon;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;

import battlemen.Battle;
import battlemen.Fighter;

public class Main {
	public static Fighter[] guiPlayers;

	//Class variables
	final static String path = System.getenv("TILE_PATH");	
	public static File dir = new File(path);
	public static File[] directoryListing = dir.listFiles();
	public static String currImage = "";
	public static boolean roomTrap = false;
	public static String[][] minimap;
	
	//GUI components
	public static JFrame main = new JFrame("Dungeon");
	public static JPanel dungeonTilePanel = new JPanel();
	public static JPanel messagePanel = new JPanel();
	public static JPanel controlPanel = new JPanel();
	public static JPanel directionalPanel = new JPanel();
	public static JPanel actionPanel = new JPanel();
	
	public static JButton up = new BasicArrowButton(BasicArrowButton.NORTH);
	public static JButton down = new BasicArrowButton(BasicArrowButton.SOUTH);
	public static JButton left = new BasicArrowButton(BasicArrowButton.WEST);
	public static JButton right = new BasicArrowButton(BasicArrowButton.EAST);
	
	public static JButton steal = new JButton("Steal");
	public static JButton disarm = new JButton("Disarm Trap");
	public static JButton fight = new JButton("Fight");
	public static JButton hide = new JButton("Hide");
	
	public static JLabel[][] picArray;
	
	public Main(Fighter[] players) {
		guiPlayers = players;
		//Setup Frame
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setLayout(new BorderLayout());
        
		//Add Panels
		main.add(dungeonTilePanel, BorderLayout.WEST);
		main.add(messagePanel, BorderLayout.NORTH);
		main.add(controlPanel, BorderLayout.EAST);
		
		//Setup Controls
		controlPanel.setLayout(new BorderLayout());
		controlPanel.add(directionalPanel, BorderLayout.NORTH);
		controlPanel.add(actionPanel, BorderLayout.SOUTH);
		
		//Setup Arrow Buttons
		directionalPanel.setLayout(new BorderLayout());
		directionalPanel.add(right, BorderLayout.EAST);
		directionalPanel.add(up, BorderLayout.NORTH);
		directionalPanel.add(down, BorderLayout.SOUTH);
		directionalPanel.add(left, BorderLayout.WEST);
		
		//Setup and add arrow button listeners
		ActionListener move = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (directoryListing != null) {
					//if the room is trapped and was never disarmed each player takes damage when leaving the room
					if(roomTrap == true){
						for(Fighter f : guiPlayers){
							f.setFighterHP(f.getFighterHP()-1);
						}
					}
					Random r = new Random();
					currImage = directoryListing[r.nextInt(directoryListing.length-1)].getName();
				    displayTile(currImage);
				    
				    //default all buttons to disabled
				    resetButtons(directionalPanel);
				    resetButtons(controlPanel);
				    roomTrap = false;
				    if(currImage.contains("u")){
				    	up.setEnabled(true);
				    }
				    if(currImage.contains("l")){
				    	left.setEnabled(true);
				    } 
				    if(currImage.contains("r")){
				    	right.setEnabled(true);
				    }
				    if(currImage.contains("d")){
				    	down.setEnabled(true);
				    }
				    if(currImage.contains("c")){				    	
				    	hide.setEnabled(true);
				    	hide.setVisible(true);
				    	if(guiPlayers[1].hidden == true){
				    		steal.setEnabled(true);
					    	steal.setVisible(true);
				    	}
				    }
				    if(currImage.contains("t")){
				    	disarm.setEnabled(true);
				    	disarm.setVisible(true);
				    	roomTrap = true;
				    }
				    if(currImage.contains("m")){
				    	fight.setEnabled(true);
				    	fight.setVisible(true);
				    }
				} else {
					System.out.println("No Dungeon Tiles in filepath: " + path);
				}
			}
		};
		right.addActionListener(move);
		left.addActionListener(move);
		up.addActionListener(move);
		down.addActionListener(move);
		
		//Setup Action Buttons
		fight.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Battle.encounter();
			}
    	});
		
		disarm.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				roomTrap = false;
			}
		});
		
		hide.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				guiPlayers[1].setHidden(true);
				steal.setEnabled(true);
		    	steal.setVisible(true);
			}
		});
		
		steal.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO: generate random item
				//TODO: popup with character selection(only characters w/ hp > 0)
				//TODO: put item in player's inventory
			}
		});
		
		actionPanel.add(steal);
		actionPanel.add(disarm);
		actionPanel.add(hide);
		actionPanel.add(fight);
		
		//TODO: include an nxn array to store filenames of already visited rooms in case of loopbacks
		
		main.pack();
		main.setLocationRelativeTo(null);
		main.setVisible(true);
	}
	
	public void resetButtons(JPanel panel){
		Component[] components = panel.getComponents();
		for(Component c : components){
			c.setEnabled(false);
		}
	}
	
	public void execute(){
		//Start tile is displayed
		String fileName = "start.png";
		displayTile(fileName);
		minimap[0][0] = fileName;
	}
	
	public void displayTile(String fileName){
		BufferedImage image = null;
    	try {
			image = ImageIO.read(new File(path + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	JLabel picLabel = new JLabel(new ImageIcon(scale(image, BufferedImage.TYPE_INT_RGB, 182, 300, 0.061, 0.072)));
    	dungeonTilePanel.add(picLabel);
    	dungeonTilePanel.revalidate();
    	dungeonTilePanel.repaint();
	}
	
	public static BufferedImage scale(BufferedImage sbi, int imageType, int dWidth, int dHeight, double fWidth, double fHeight) {
        BufferedImage dbi = null;
        if(sbi != null) {
            dbi = new BufferedImage(dWidth, dHeight, imageType);
            Graphics2D g = dbi.createGraphics();
            AffineTransform at = AffineTransform.getScaleInstance(fWidth, fHeight);
            g.drawRenderedImage(sbi, at);
        }
        return dbi;
    }

}
