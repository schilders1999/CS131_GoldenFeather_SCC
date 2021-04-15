import java.util.Scanner;
import java.awt.*;  
import javax.swing.*;  
/**
 * This is the application class required to start the game. In addition, there is code required to display images of the game's maps.
 * 
 * @author Spencer Childers
 * @version 1.0
 * @since 4/15/2021
 */
public class RunGame
{	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		
		JFrame basement = new JFrame("Basement Map");
		JFrame house = new JFrame("House Map");
		
		ImageIcon houseMap = new ImageIcon (new ImageIcon("Map of House.jpg").getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT));
		ImageIcon basementMap = new ImageIcon (new ImageIcon("Map of Basement.jpg").getImage().getScaledInstance(1100, 660, Image.SCALE_DEFAULT));
		
		JLabel houseLabel , basementLabel;
		
		JPanel subPanel1 = new JPanel();
		subPanel1.setPreferredSize(new Dimension(400,400));
		subPanel1.setBackground(Color.WHITE);
		
		JPanel subPanel2 = new JPanel();
		subPanel2.setPreferredSize(new Dimension(400,400));
		subPanel2.setBackground(Color.WHITE);
		
		houseLabel = new JLabel (null , houseMap , SwingConstants.CENTER);
		basementLabel = new JLabel (null , basementMap , SwingConstants.CENTER);
		
		subPanel1.add(houseLabel);
		subPanel2.add(basementLabel);
		
		house.setSize(1000,700);
		house.setVisible(true);
		house.add(subPanel1);
		basement.setSize (1000,700);
		basement.setVisible(true);
		basement.add(subPanel2);
		
		//Instantiating a game object so the game starts.
        House yoyo = new House();
			
		

	}
}
