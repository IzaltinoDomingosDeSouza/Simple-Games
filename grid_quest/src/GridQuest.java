import ids.izaltinodsouza.GridQuest.MapGrid;
import ids.izaltinodsouza.GridQuest.MapLoader;
import ids.izaltinodsouza.GridQuest.Player;
import ids.izaltinodsouza.GridQuest.UserInputOption;
import ids.izaltinodsouza.GridQuest.GameState;

import java.util.Random;

public class GridQuest
{
    private static Random random = new Random();
    private static MapGrid map = new MapGrid(8,8);
    private static Player player = new Player(0,0);
    private static UserInputOption input = new UserInputOption();
    private static GameState gstate = GameState.NewGame;
    
    public static void main(String[] args)
    {
      boolean is_running = true;
      while(is_running)
      {
        switch(gstate)
        {
          case NewGame:
            new_game();
          break;
          case GameOver:
            is_running = false;
          break;
          case TryAgain:
            try_again();
          break;
          case PlayerTurn:
            player_turn();
          break;
        }
      }
    }
    public static void new_game()
    {
      map = MapLoader.load_from_disk("forest");
      player.set_pos(random.nextInt(map.x_size()), random.nextInt(map.y_size()));
      
      System.out.println("You are lost in a forest and need to find your way out!");
      
      gstate = GameState.PlayerTurn;
    }
    public static void try_again()
    {
      System.out.printf("Don't you want to try again?\n");
      System.out.printf("[Y]es or [N]o : ");
      
      var yes_or_no = input.get_confirmation();
      
      switch(yes_or_no)
      {
        case Yes:
          gstate = GameState.NewGame;
        break;
        case No:
          gstate = GameState.GameOver;
        break;
      }
    }
    public static void player_turn()
    {
      System.out.printf("You are at location (%d, %d)!\n", player.get_posx(), player.get_posy());
      
      gstate = GameState.GameOver;
    }
}

