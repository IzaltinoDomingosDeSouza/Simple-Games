package ids.izaltinodsouza.GridQuest;

import ids.izaltinodsouza.GridQuest.Vec2;

public class Player
{
    private static int max_life = 3;
    
    private int life;
    private Vec2 pos = new Vec2(0,0);
    
    public Player(int x, int y)
    {
      pos.x = x;
      pos.y = y;
      life = max_life;
    }
    public void set_pos(int x, int y)
    {
      pos.x = x;
      pos.y = y;
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
      return pos.x;
    }
    public int get_posy()
    {
      return pos.y;
    }
    public int get_life()
    {
      return life;
    }
    public Vec2 preview_pos_left()
    {
      return new Vec2(pos.x - 1, pos.y);
    }
    public Vec2 preview_pos_right()
    {
      return new Vec2(pos.x + 1, pos.y);
    }
    public Vec2 preview_pos_up()
    {
      return new Vec2(pos.x, pos.y - 1);
    }
    public Vec2 preview_pos_down()
    {
      return new Vec2(pos.x, pos.y + 1);
    }
    public void move_left()
    {
      pos = preview_pos_left();
    }
    public void move_right()
    {
      pos = preview_pos_right();
    }
    public void move_up()
    {
      pos = preview_pos_up();
    }
    public void move_down()
    {
      pos = preview_pos_down();
    }
};
