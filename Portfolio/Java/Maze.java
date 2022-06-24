import java.util.Scanner;

public class Maze
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      
      String[] maze = {"########", // The maze you would like to solve. rows are strings, colums are the indeces of that string
                       "#....#.#", // walls = '#'
                       "####.#.#", // paths = '.'
                       "#...o..#", // start = 'o'
                       "####.#.#", // end = '*'
                       "##...#*#",
                       "########"};
                       
      int[] currLocation = new int[2]; // position of the search curser
      int[] prevLocation = new int[2]; // the possition of the search cruser directly before current location
      int[] destination = new int[2]; // this is the desired location
      int[][] prevBranch = new int[20][2]; // this 2d array keeps track of the location of all route branches.
      int currBranch = 0; // this keeps track of which branch should be tried after a dead end
      int numBranch = 0; // this is how many branches have been found
      int numTerminalLocation = 0; // the number of times we stand is the same spot
      int numPath = 0; // this is how many paths exist from the search crusers current location.
      boolean isUpPath = false; // booleans to store possible directions from current location
      boolean isDownPath = false;
      boolean isLeftPath = false;
      boolean isRightPath = false;
      
      
      
      
      for(int row = 0; row < maze.length; row++) // gather start and destination locations and set current location to the start
      {
         for(int col = 0; col < maze[row].length(); col++)
         {
            if(maze[row].charAt(col) == 'o')
            {
               currLocation[0] = row;
               currLocation[1] = col;
            }
            
            if(maze[row].charAt(col) == '*')
            {
               destination[0] = row;
               destination[1] = col;
            }
         }
      }
      
      while((currLocation[0] != destination[0] || currLocation[1] != destination[1]) && numTerminalLocation <= 1) // loop to traverse the maze
      {
         prevLocation[0] = currLocation[0];// keep track of where we immediatly were
         prevLocation[1] = currLocation[1];
         
         if(maze[currLocation[0] - 1].charAt(currLocation[1]) == '.' || maze[currLocation[0] - 1].charAt(currLocation[1]) == '*') //look around and find possible paths
         {
            numPath += 1;
            isUpPath = true;
         }
         
         if(maze[currLocation[0] + 1].charAt(currLocation[1]) == '.' || maze[currLocation[0] + 1].charAt(currLocation[1]) == '*')
         {
            numPath += 1;
            isDownPath = true;
         }
         
         if(maze[currLocation[0]].charAt(currLocation[1] - 1) == '.' || maze[currLocation[0]].charAt(currLocation[1] - 1) == '*')
         {
            numPath += 1;
            isLeftPath = true;
         }
         
         if(maze[currLocation[0]].charAt(currLocation[1] + 1) == '.' || maze[currLocation[0]].charAt(currLocation[1] + 1) == '*')
         {
            numPath += 1;
            isRightPath = true;
         }
         
         if(numPath > 1) // if there is more than one path then it is a branch
         {
            prevBranch[numBranch][0] = currLocation[0];
            prevBranch[numBranch][1] = currLocation[1];
            numBranch++;
         }
         
         if(isUpPath) // take one of the available paths and update maze graphic
         {
            currLocation[0] -= 1;
            maze[currLocation[0]] += " ";
            maze[currLocation[0]] = (maze[currLocation[0]].substring(0, currLocation[1]) + "^" + maze[currLocation[0]].substring(currLocation[1] + 1, maze[currLocation[0]].length() - 1));
         }
         
         else if(isDownPath)
         {
            currLocation[0] += 1;
            maze[currLocation[0]] += " ";
            maze[currLocation[0]] = (maze[currLocation[0]].substring(0, currLocation[1]) + "v" + maze[currLocation[0]].substring(currLocation[1] + 1, maze[currLocation[0]].length() - 1));   
         }
         
         else if(isLeftPath)
         {
            currLocation[1] -= 1;
            maze[currLocation[0]] += " ";
            maze[currLocation[0]] = (maze[currLocation[0]].substring(0, currLocation[1]) + "<" + maze[currLocation[0]].substring(currLocation[1] + 1, maze[currLocation[0]].length() - 1));   
         }
         
         else if(isRightPath)
         {
            currLocation[1] += 1;
            maze[currLocation[0]] += " ";
            maze[currLocation[0]] = (maze[currLocation[0]].substring(0, currLocation[1]) + ">" + maze[currLocation[0]].substring(currLocation[1] + 1, maze[currLocation[0]].length() - 1));
  
         }
         
         else // if you end up cornered go back to one of the branches you havent tried all of the paths to
         {
            if(prevBranch[currBranch][0] != 0) // so long as that branch isn't the zero vector
            {
               currLocation[0] = prevBranch[currBranch][0];
               currLocation[1] = prevBranch[currBranch][1];
               currBranch++;
            }
         }        
   
         isUpPath = false; // reset path variables
         isDownPath = false;
         isLeftPath = false;
         isRightPath = false;
         numPath = 0;
         
         for(int row = 0; row < maze.length; row++) // show the maze with current location
         {
            System.out.println(maze[row]);
         }
         
         if(prevLocation[0] == currLocation[0] && prevLocation[1] == currLocation[1])
         {
            numTerminalLocation++;
         }
         
         in.nextLine();
         
      }
      
      if (numTerminalLocation >= 1)
      {
         System.out.println("There is a not solution to this maze.");
      }
      
      else
      {
         System.out.println("There is a soluton to this maze.");
      }
   }
}