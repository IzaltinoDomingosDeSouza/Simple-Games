package ids.izaltinodsouza.GridQuest;

import ids.izaltinodsouza.GridQuest.GridElement;

public class MapGrid
{
  private GridElement[][] grid;
  private int x_size;
  private int y_size;
  
  public MapGrid(int x, int y)
  {
    x_size = x;
    y_size = y;
    grid = new GridElement[y][x];
    clear();
  }
  public int x_size()
  {
    return x_size;
  }
  public int y_size()
  {
    return y_size;
  }
  public void clear()
  {
    for (int y = 0; y < y_size; y++)
    {
      for (int x = 0; x < x_size; x++)
      {
        grid[y][x] = GridElement.Empty;
      }
    }
  }
  public void bounds_check(int x, int y)
  {
    if((x < 0 || x >= x_size) || (y < 0 || y >= y_size))
    {
        throw new IndexOutOfBoundsException("coordinates are out of bounds : (" + x + ", " + y + ")");
    }
  }
  public void set_element(int x, int y, GridElement element)
  {
    bounds_check(x,y);
    grid[y][x] = element;
  }
  public GridElement get_element(int x, int y)
  {
    bounds_check(x,y);
    return grid[y][x];
  }
}
