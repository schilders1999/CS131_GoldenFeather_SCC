 
/**
 * This is the application class required to start the game.
 * 
 * @author Spencer Childers
 * @version 1.0
 * @since 18 April 2021
 */
public class RunGame
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
