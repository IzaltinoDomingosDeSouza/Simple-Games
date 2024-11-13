# Grid Quest

## Overview
**Grid Quest** is a simple adventure game where the player is lost in an 8x8 grid, representing a forest.
The player needs to navigate through the grid to find the exit, while avoiding dangerous obstacles and collecting rewards along the way.

### Objective
- Navigate through the forest (8x8 grid) to find the exit.
- The player can move in four directions: Up, Down, Left, Right.
- The grid contains:
  - **Poisonous plants**: The player loses 1 life.
  - **Fruits**: The player gains 1 life (up to a maximum of 3).
  - **Collectible objects**: The player gains coins.

---

## Game Rules
1. **Life**: The player starts with 3 lives. Stepping on a poisonous plant causes the player to lose 1 life.
2. **Coins**: The player collects coins by landing on specific cells with collectible objects.
3. **Fruits**: The player can collect fruits to heal and restore life, but the player's life cannot exceed 3.
4. **Exit**: The player must navigate to the exit of the forest (grid). The exit is in a specific grid cell.
5. **Movement**: The player moves one step at a time in any of the 4 directions.
6. **Winning**: The player wins by reaching the exit with at least 1 life remaining.

---

## Game Flow
1. **Start**: The player begins at a random position on the grid.
2. **Player's Turn**: Each turn, the player moves one step in any direction (up, down, left, right).
3. **Event Handling**:
   - **Poisonous plant**: Lose 1 life.
   - **Fruit**: Heal by 1 life (up to a maximum of 3).
   - **Collectible object**: Gain coins.
4. **Winning Conditions**: The game ends when the player reaches the exit.
