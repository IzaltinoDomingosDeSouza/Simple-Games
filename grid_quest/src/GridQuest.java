import ids.izaltinodsouza.GridQuest.MapGrid;
import ids.izaltinodsouza.GridQuest.MapLoader;
import ids.izaltinodsouza.GridQuest.Player;
import ids.izaltinodsouza.GridQuest.UserInputOption;
import ids.izaltinodsouza.GridQuest.GameState;
import ids.izaltinodsouza.GridQuest.GridElement;

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
        update();
        System.out.printf("Life %d!\n",player.get_life());
      }
    }
    public static void update()
    {
      var element = map.get_element(player.get_posx(),player.get_posy());
      switch(element)
      {
        case Exit:
          System.out.printf("Congratulations, you've found your way out of the forest!\n");
          gstate = GameState.TryAgain;
        break;
        case Fruits:
          System.out.printf("At your location, you find a fruit that grants you an extra life!\n");
          player.take_fruit();
        break;
        /*case Coins: NOT IMPLEMENTED YET
          System.out.printf("At your location, you find a fruit that grants you a coin!\n");
        break;*/
        case Poisonous:
          System.out.printf("At your location, you come across a poisonous plant and lose a life!\n");
          player.take_poisonous();
          if(!player.is_alive())
          {
            System.out.printf("Sorry, you have no more lives left! Game Over.\n");
            gstate = GameState.GameOver;
          }
        break;
      }
     map.set_element(player.get_posx(),player.get_posy(),GridElement.Empty);
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
      
      System.out.printf("Here are the available directions you can move to : \n");
      var directions = player_available_directions();
      for(var dir : directions)
      {
        switch(dir)
        {
          case Left:
            System.out.printf("\t[L]eft  (%d,%d)\n", player.preview_pos_left().x, player.preview_pos_left().y);
          break;
          case Right:
            System.out.printf("\t[R]ight (%d,%d)\n", player.preview_pos_right().x, player.preview_pos_right().y);
          break;
          case Up:
            System.out.printf("\t[U]p    (%d,%d)\n", player.preview_pos_up().x, player.preview_pos_up().y);
          break;
          case Down:
            System.out.printf("\t[D]own  (%d,%d)\n", player.preview_pos_down().x, player.preview_pos_down().y);
          break;
        }
      }
      
      System.out.printf("Which direction would you like to go? : ");
      switch(input.get_direction())
      {
        case Left:
          if(directions.contains(UserInputOption.Direction.Left))
          {
            player.move_left();
          }else
          {
            gstate = GameState.PlayerTurn;
          }
        break;
        case Right:
          if(directions.contains(UserInputOption.Direction.Right))
          {
            player.move_right();
          }else
          {
            gstate = GameState.PlayerTurn;
          }
        break;
        case Up:
          if(directions.contains(UserInputOption.Direction.Up))
          {
            player.move_up();
          }else
          {
            gstate = GameState.PlayerTurn;
          }
        break;
        case Down:
          if(directions.contains(UserInputOption.Direction.Down))
          {
            player.move_down();
          }else
          {
            gstate = GameState.PlayerTurn;
          }
        break;
      }
    }
    public static List<UserInputOption.Direction> player_available_directions()
    {
      var left = player.preview_pos_left();
      var right = player.preview_pos_right();
      var up = player.preview_pos_up();
      var down = player.preview_pos_down();
      
      List<UserInputOption.Direction> directions = new ArrayList<>();
      if((left.x > 0 && left.y > 0) && (left.x < 8 && left.y < 8))
      {
        directions.add(UserInputOption.Direction.Left);
      }
      if((right.x > 0 && right.y > 0) && (right.x < 8 && right.y < 8))
      {
        directions.add(UserInputOption.Direction.Right);
      }
      if((up.x > 0 && up.y > 0) && (up.x < 8 && up.y < 8))
      {
        directions.add(UserInputOption.Direction.Up);
      }
      if((down.x > 0 && down.y > 0) && (down.x < 8 && down.y < 8))
      {
        directions.add(UserInputOption.Direction.Down);
      }
      
      return directions;
    }
}

