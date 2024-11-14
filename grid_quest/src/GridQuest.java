import ids.izaltinodsouza.GridQuest.MapGrid;
import ids.izaltinodsouza.GridQuest.MapLoader;
import ids.izaltinodsouza.GridQuest.Player;

import java.util.Random;

public class GridQuest
{
    public static void main(String[] args)
    {
      MapLoader map_loader = new MapLoader();
      MapGrid map = map_loader.load_from_disk("forest");
      
      Random random = new Random();
      Player player = new Player(random.nextInt(map.x_size()), random.nextInt(map.y_size()));
      
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
}
