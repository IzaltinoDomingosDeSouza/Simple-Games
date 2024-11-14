package ids.izaltinodsouza.GridQuest;

import ids.izaltinodsouza.GridQuest.MapGrid;
import ids.izaltinodsouza.GridQuest.GridElement;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class MapLoader
{
  private static String maps_location = "bin/data/maps";
  public static MapGrid load_from_disk(String name)
  {
    String map_location_filename = maps_location + "/" + name + ".grid";
    
    MapGrid map = new MapGrid(8,8);
    
    try(BufferedReader reader = new BufferedReader(new FileReader(map_location_filename)))
    {
        String line;
        int y = 0;
        while((line = reader.readLine()) != null)
        {
          for(int x = 0;x < 8;++x)
          {
            switch(line.charAt(x))
            {
              case '#':
                map.set_element(x,y,GridElement.Empty);
              break;
              case '!':
                map.set_element(x,y,GridElement.Exit);
              break;
              case '@':
                map.set_element(x,y,GridElement.Fruits);
              break;
              case '$':
                map.set_element(x,y,GridElement.Coins);
              break;
              case '*':
                map.set_element(x,y,GridElement.Poisonous);
              break;
            }
          }
          ++y;
        }
    }catch(IOException e)
    {
      throw new RuntimeException("The map "+ name + " on location \"" + map_location_filename + "\"  could not be opened", e);
    }
    
    return map;
  }
}
