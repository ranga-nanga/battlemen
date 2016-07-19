package dungeon;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;

import battlemen.Battle;

public class Main {

	final static String path = System.getenv("TILE_PATH");	
	
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
	
	public Main() {
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
		
		//Setup Action Buttons
		fight.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Battle.encounter();
			}
    	});
		actionPanel.add(steal);
		actionPanel.add(disarm);
		actionPanel.add(hide);
		actionPanel.add(fight);
		
		//TODO: Add arrow button listeners
		//TODO: include an nxn array to store filenames of already visited rooms in case of loopbacks
		//TODO: Add action button listeners
		
		main.pack();
		main.setLocationRelativeTo(null);
		main.setVisible(true);
	}
	
	public void execute(){
		//Start tile is displayed
		String fileName = "start.png";
		displayTile(fileName);
		//TODO: determine valid directions(by filename? udlr#.png)
		//TODO: enable - disable arrow buttons based on valid directions
		//TODO: determine valid actions and therefore buttons to be shown
		//TODO: setvisible to true-false for action buttons
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
	
	public static void main(String[] args){
		Main m = new Main();
		//m.execute();
	}
}
