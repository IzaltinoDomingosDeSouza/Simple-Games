package ids.izaltinodsouza.GridQuest;

public class Player
{
    private static int max_life = 3;
    
    private int life;
    private int pos_x;
    private int pos_y;
    
    public Player(int x, int y)
    {
      pos_x = x;
      pos_y = y;
      life = max_life;
    }
    public void set_pos(int x, int y)
    {
      pos_x = x;
      pos_y = y;
    }
    public void take_fruit()
    {
      life += 1;
      if(life > max_life)
      {
        life = max_life;
      }
    }
    public void take_poisonous()
    {
      life -= 1;
      if(life < 0)
      {
        life = 0;
      }
    }
    public boolean is_alive()
    {
      return life > 0;
    }
    public int get_posx()
    {
      return pos_x;
    }
    public int get_posy()
    {
      return pos_y;
    }
    public int get_life()
    {
      return life;
    }
};
