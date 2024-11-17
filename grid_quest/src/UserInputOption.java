package ids.izaltinodsouza.GridQuest;

import java.util.Scanner;

enum Direction
{
  Left,
  Right,
  Up,
  Down,
  Unknown
};

enum Confirmation
{
  Yes,
  No
};

public class UserInputOption
{
  private Scanner scanner;
  
  public UserInputOption()
  {
    scanner = new Scanner(System.in);
  }
  public Direction get_direction()
  {
    var tmp = scanner.nextLine().trim();
    var option = Direction.Unknown;
    switch(tmp)
    {
      case "L":
        option = Direction.Left;
      break;
      case "R":
        option = Direction.Right;
      break;
      case "U":
        option = Direction.Up;
      break;
      case "D":
        option = Direction.Down;
      break;
    }
    return option;
  }
  public Confirmation get_confirmation()
  {
      var tmp = scanner.nextLine().trim().toUpperCase();
      var option = Confirmation.No;
      switch (tmp)
      {
        case "Y":
        option = Confirmation.Yes;
        break;
        case "N":
        option = Confirmation.No;
        break;
      }
    return option;
  }
}
