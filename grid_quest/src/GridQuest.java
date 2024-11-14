import ids.izaltinodsouza.GridQuest.MapGrid;
import ids.izaltinodsouza.GridQuest.MapLoader;

public class GridQuest
{
    public static void main(String[] args)
    {
      MapLoader map_loader = new MapLoader();
      MapGrid map = map_loader.load_from_disk("forest");
      
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
