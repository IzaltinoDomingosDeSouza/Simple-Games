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
    public static void main(String[] args)
    {
      new_game();
      
      System.out.println(player.get_posx() + " " + player.get_posy());
      System.out.println(map.get_element(player.get_posx(),player.get_posy()).name() + "\n");
      
      // Debug
      for (int y = 0; y < map.y_size(); y++)
      {
        for (int x = 0; x < map.x_size(); x++)
        {
          System.out.print(map.get_element(x,y).name() + " ");
        }
         System.out.println();
      }
    }
    public static void new_game()
    {
      map = MapLoader.load_from_disk("forest");
      player.set_pos(random.nextInt(map.x_size()), random.nextInt(map.y_size()));
    }
}
