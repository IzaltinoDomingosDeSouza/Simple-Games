import ids.izaltinodsouza.GridQuest.MapGrid;
import ids.izaltinodsouza.GridQuest.MapLoader;
import ids.izaltinodsouza.GridQuest.Player;
import ids.izaltinodsouza.GridQuest.UserInputOption;
import ids.izaltinodsouza.GridQuest.GameState;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
  
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
      int left_posx = player.get_posx() - 1;
      int left_posy = player.get_posy();
      
      int right_posx = player.get_posx() + 1;
      int right_posy = player.get_posy();
      
      int up_posx = player.get_posx();
      int up_posy = player.get_posy() - 1;
      
      int down_posx = player.get_posx();
      int down_posy = player.get_posy() + 1;
      
      System.out.printf("You are at location (%d, %d)!\n", player.get_posx(), player.get_posy());
      
      System.out.printf("Here are the available directions you can move to : \n");
      var directions = player_available_directions();
      for(var dir : directions)
      {
        switch(dir)
        {
          case Left:
            System.out.printf("\t[L]eft  (%d,%d)\n", left_posx, left_posy);
          break;
          case Right:
            System.out.printf("\t[R]ight (%d,%d)\n", right_posx, right_posy);
          break;
          case Up:
            System.out.printf("\t[U]p    (%d,%d)\n", up_posx, up_posy);
          break;
          case Down:
            System.out.printf("\t[D]own  (%d,%d)\n", down_posx, down_posy);
          break;
        }
      }
      
      System.out.printf("Which direction would you like to go? : ");
      switch(input.get_direction())
      {
        case Left:
          if(directions.contains(UserInputOption.Direction.Left))
          {
            player.set_pos(left_posx,left_posy);
          }
        break;
        case Right:
          if(directions.contains(UserInputOption.Direction.Left))
          {
            player.set_pos(right_posx,right_posy);
          }
        break;
        case Up:
          if(directions.contains(UserInputOption.Direction.Left))
          {
            player.set_pos(up_posx,up_posy);
          }
        break;
        case Down:
          if(directions.contains(UserInputOption.Direction.Left))
          {
            player.set_pos(down_posx,down_posy);
          }
        break;
      }
      
      gstate = GameState.GameOver;
    }
    public static List<UserInputOption.Direction> player_available_directions()
    {
      int left_posx = player.get_posx() - 1;
      int left_posy = player.get_posy();
      
      int right_posx = player.get_posx() + 1;
      int right_posy = player.get_posy();
      
      int up_posx = player.get_posx();
      int up_posy = player.get_posy() - 1;
      
      int down_posx = player.get_posx();
      int down_posy = player.get_posy() + 1;
      
      List<UserInputOption.Direction> directions = new ArrayList<>();
      if((left_posx > 0 && left_posy > 0) && (left_posx < 8 && left_posy < 8))
      {
        directions.add(UserInputOption.Direction.Left);
      }
      if((right_posx > 0 && right_posy > 0) && (right_posx < 8 && right_posy < 8))
      {
        directions.add(UserInputOption.Direction.Right);
      }
      if((up_posx > 0 && up_posy > 0) && (up_posx < 8 && up_posy < 8))
      {
        directions.add(UserInputOption.Direction.Up);
      }
      if((down_posx > 0 && down_posy > 0) && (down_posx < 8 && down_posy < 8))
      {
        directions.add(UserInputOption.Direction.Down);
      }
      
      return directions;
    }
}

