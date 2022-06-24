/*
Name: Olivia Howard           Date Assigned: 11/11/2021

Course: CSCI 2003-42733       Date Due: 11/11/2021

Instructor: Ms. Greer

File name: Dungeon.java

Program Description: This class represents a dungeon in the game Solo Dungeon Bash. This class includes
methods to hanndle movement in four directions: up, down, left, right. These movement methods also return
if the move was successful or if somthing hindered the move in a string. There are also methods to get
the current row and collum that the character piece is located.
*/

/**
This class represents a dungeon.
*/
public class Dungeon
{
   private int currCol = 5; //current collum
   private int currRow = 0; // current row
   private String xWall = "" + (char) 177 + (char) 177 + (char) 177 + (char) 177 + (char) 177; // varible for horizontal wall graphic 
   private String yWall = "" + (char) 177; //variable for vertial wall graphic
   private String[][] dungeon = {{yWall,   xWall,   xWall,   xWall,   xWall, "  X  ",   xWall,   xWall,   xWall,   xWall, yWall}, // this array represents the dungeon
                                 {yWall, "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", yWall},
                                 {yWall, "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", yWall},
                                 {yWall, "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", yWall},
                                 {yWall, "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", yWall},
                                 {yWall, "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", yWall},
                                 {yWall, "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", yWall},
                                 {yWall, "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", yWall},
                                 {yWall, "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", yWall},
                                 {yWall, "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", yWall},
                                 {yWall, "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", "     ", yWall},
                                 {yWall,   xWall,   xWall,   xWall,   xWall, "     ",   xWall,   xWall,   xWall,   xWall, yWall}};
   
   /**
   A method to handle movement to the right
   @return if the move was successful or a reason why it was unsuccessful
   */
   public String moveR()
   {
      // check if there is a wall obsuring the path or if the character is attempting to enter a room they have already been in
      if (!dungeon[currRow][currCol + 1].equals(xWall) && !dungeon[currRow][currCol + 1].equals(yWall) && !dungeon[currRow][currCol + 1].equals("  >  ") && !dungeon[currRow][currCol + 1].equals("  <  ") && !dungeon[currRow][currCol + 1].equals("  v  ") && !dungeon[currRow][currCol + 1].equals("  ^  "))
      {
         dungeon[currRow][currCol] = "  >  "; // update the dungeon array and current possition 
         dungeon[currRow][currCol + 1] = "  X  ";
         currCol++;
         return "Move Successful."; // feedback that the move was successful
      }
      
      // somthing obscured the path of the player. What was it?  
      else
      {  
         // in this case the player tried to run into a wall
         if(dungeon[currRow][currCol + 1].equals(xWall) || dungeon[currRow][currCol + 1].equals(yWall))
         {
            return "A wall obscures the path.";
         }
         
         // assume if the player didn't hit a wall then they are trying to enter a room they have already been in   
         else
         {
            return "The door to this room is locked. It also appears to be a room that you have already searched.";
         } 
      }
   }
   
   /**
   A method to handle movement to the left
   @return if the move was successful or a reason why it was unsuccessful
   */
   public String moveL()
   {
      // check if there is a wall obsuring the path or if the character is attempting to enter a room they have already been in
      if (!dungeon[currRow][currCol - 1].equals(xWall) && !dungeon[currRow][currCol - 1].equals(yWall) && !dungeon[currRow][currCol - 1].equals("  >  ") && !dungeon[currRow][currCol - 1].equals("  <  ") && !dungeon[currRow][currCol - 1].equals("  v  ") && !dungeon[currRow][currCol - 1].equals("  ^  "))
      {
         dungeon[currRow][currCol] = "  <  "; // update the dungeon array and current possition 
         dungeon[currRow][currCol - 1] = "  X  ";
         currCol--;
         return "Move Successful.";
      }
      
      // somthing obscured the path of the player. What was it?    
      else
      {
         // in this case the player tried to run into a wall
         if(dungeon[currRow][currCol - 1].equals(xWall) || dungeon[currRow][currCol - 1].equals(yWall))
         {
            return "A wall obscures the path.";
         }
         
         // assume if the player didn't hit a wall then they are trying to enter a room they have already been in   
         else
         {
            return "The door to this room is locked. It also appears to be a room that you have already searched.";
         } 
      }
   }
   
   /**
   A method to handle movement down
   @return if the move was successful or a reason why it was unsuccessful
   */
   public String moveD()
   {
      // check if there is a wall obsuring the path or if the character is attempting to enter a room they have already been in
      if (!dungeon[currRow + 1][currCol].equals(xWall) && !dungeon[currRow + 1][currCol].equals(yWall) && !dungeon[currRow + 1][currCol].equals("  >  ") && !dungeon[currRow + 1][currCol].equals("  <  ") && !dungeon[currRow + 1][currCol].equals("  v  ") && !dungeon[currRow + 1][currCol].equals("  ^  "))
      {
         dungeon[currRow][currCol] = "  v  "; // update the dungeon array and current possition
         dungeon[currRow + 1][currCol] = "  X  ";
         currRow++;
         return "Move Successful.";
      }
      
      // somthing obscured the path of the player. What was it?    
      else
      {
         // in this case the player tried to run into a wall
         if(dungeon[currRow + 1][currCol].equals(xWall) || dungeon[currRow + 1][currCol].equals(yWall))
         {
            return "A wall obscures the path.";
         }
          
         // assume if the player didn't hit a wall then they are trying to enter a room they have already been in   
         else
         {
            return "The door to this room is locked. It also appears to be a room that you have already searched.";
         } 
      }
   }
    /**
   A method to handle movement up
   @return if the move was successful or a reason why it was unsuccessful
   */
   public String moveU()
   {
      try
      {
         // check if there is a wall obsuring the path or if the character is attempting to enter a room they have already been in
         if (!dungeon[currRow - 1][currCol].equals(xWall) && !dungeon[currRow - 1][currCol].equals(yWall) && !dungeon[currRow - 1][currCol].equals("  >  ") && !dungeon[currRow - 1][currCol].equals("  <  ") && !dungeon[currRow - 1][currCol].equals("  v  ") && !dungeon[currRow - 1][currCol].equals("  ^  "))
         {
            dungeon[currRow][currCol] = "  ^  "; // update the dungeon array and current possition
            dungeon[currRow - 1][currCol] = "  X  ";
            currRow--;
            return "Move Successful.";
         }
         
         // somthing obscured the path of the player. What was it?
         else
         {
            // in this case the player tried to run into a wall
            if(dungeon[currRow - 1][currCol].equals(xWall) || dungeon[currRow - 1][currCol].equals(yWall))
            {
               return "A wall obscures the path.";
            }
            
            // assume if the player didn't hit a wall then they are trying to enter a room they have already been in
            else
            {
               return "The door to this room is locked. It also appears to be a room that you have already searched.";
            } 
         }
      }
      
      // the only place the player can reach the outer bounds of the dundeon is at the doorways to the dungeon. Tell them that the door is locked and dont update thier possition
      catch (ArrayIndexOutOfBoundsException obj)
      {
         return "You attempt to leave the dungeon, but the door is locked!!";
      }
   }
   
   /**
   to String method to return the dungeon state in the form of a String
   @return the current dungeon layout
   */
   public String toString()
   {
      String currState = "";
      
      for(int row = 0; row < dungeon.length; row++)// go through each row
      {
         for(int col = 0; col < dungeon[row].length; col++) // go through each collum
         {
            if(col < 9 && col > 0)
            {
               currState += dungeon[row][col] + "|"; //if its an inner collum add a grid divider
            }
            
            else
            {
               currState += dungeon[row][col]; // dont put a divider for outer collums
            }
         }
         
         if (row != 11) // add a horisontal divider after each row except the last row
         {
            currState += "\n" + yWall + "-----+-----+-----+-----+-----+-----+-----+-----+-----" + yWall + "\n";
         }
      }
      
      return currState; // return the current state of the dungeon in string form
   }
   
   /**
   method to get the row possition of the player in the dungeon
   @return currRow
   */
   public int getRow()
   {
      return currRow;
   }
   
   /**
   method to get the collum possition of the player in the dungeon
   @return currCol
   */
   public int getCol()
   {
      return currCol;
   }
}