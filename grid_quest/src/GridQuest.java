import ids.izaltinodsouza.GridQuest.MapGrid;
import ids.izaltinodsouza.GridQuest.MapLoader;
import ids.izaltinodsouza.GridQuest.Player;
import ids.izaltinodsouza.GridQuest.UserInputOption;

import java.util.Random;

public class GridQuest
{
    private static Random random = new Random();
    private static MapGrid map = new MapGrid(8,8);
    private static Player player = new Player(0,0);
    private static UserInputOption input = new UserInputOption();
    
    public static void main(String[] args)
    {
      new_game();
      try_again();
    }
    public static void new_game()
    {
      map = MapLoader.load_from_disk("forest");
      player.set_pos(random.nextInt(map.x_size()), random.nextInt(map.y_size()));
    }
    public static void try_again()
    {
      System.out.printf("Don't you want to try again?\n");
      System.out.printf("[Y]es or [N]o : ");
      
      var yes_or_no = input.get_confirmation();
      
      switch(yes_or_no)
      {
        case Yes:
          
        break;
        case No:
          
        break;
      }
    }
}

