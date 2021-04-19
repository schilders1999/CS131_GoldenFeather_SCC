 
/**
 * This is the application class required to start the game. In addition, there is code required to display images of the game's maps.
 * 
 * @author Spencer Childers
 * @version 1.0
 * @since 18 April 2021
 */
public class RunGame extends House
{	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		//Instantiating a gameFunctions object so that the startGame method can be called to instantiate a Golden Feather game object.
		gameFunctions game = new gameFunctions();
		game.displayMaps();
		game.startGame();
       
        
       

	}
}
