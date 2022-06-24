/*
Name: Olivia Howard           Date Assigned: 11/11/2021

Course: CSCI 2003-42733       Date Due: 11/11/2021

Instructor: Ms. Greer

File name: SoloDungeonBash.java

Program Description: This is a game that uses Item, Character, and Dungeon objects. The player 
is brief about their situation at the begining of the game and given the rules of the game. 
From there, the player traverses the dungeon, finds treasure or potions, and manage stats and 
equipment. The player will also fight enemies generated using the character class. The encounters
are random for each room and the battles are deturmined randomly action-by-action.
*/

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SoloDungeonBash
{
   public static void main(String[] args)
   {  
      boolean playerAlive = true; // boolean to determine if the player won or lost the game
     
      boolean dracularDefeated = false;// boolean to determine if the player won or lost the game
      
      boolean error = false; // boolean to deturmine if there was an error with user input
      
      boolean shopping = true; // boolean to deturmine if the player is still shopping
      
      
      
      int choice = 5; // used to let the player choose what they want to do
      
      int event;
      
      
      String direction; // used to store user input and method feedback for choosing a direction in the dungeon
     
      
      Scanner in = new Scanner(System.in); // used to gather user input
     
      
      Random die = new Random(); // used for random dice rolls 
   
   
      Item[] shop = {new Item("1 Potion", 0, 0, 1, "", 1), //all of the items in the game
                     new Item("3 Potions", 0, 0, 3, "", 2), 
                     new Item("6 Potions", 0, 0, 6, "", 3), 
                     new Item("Buckler", 0, 1, 0, "Shield", 1), 
                     new Item("Shield", 0, 2, 0, "Buckler", 2), 
                     new Item("Big Sword", 1, 0, 0, "Big Axe", 3), 
                     new Item("Big Axe", 2, 0, 0, "Big Sword", 4), 
                     new Item("Spiky Armour", 2, 1, 0, "", 5), 
                     new Item("Magical Armour", 0, 5, 0, "", 6),
                     new Item("Gold", 0, 0, 0, "", 1)};
       
                     
      Character[] horde = {new Character("Orc", 1, 0), //all of the possible enemies
                           new Character("Wolf", 2, 0), 
                           new Character("Skeleton", 3, 0), 
                           new Character("Evil Warrior", 4, 0), 
                           new Character("Devil Bat", 5, 0), 
                           new Character("Cyclops", 6, 0), 
                           new Character("Dark Elf", 7, 0), 
                           new Character("Skeleton Lord", 8, 0), 
                           new Character("Wizard", 9, 0), 
                           new Character("Demon", 10, 0), 
                           new Character("Dracular", 9, 9)};
       
                          
      Dungeon dungeon = new Dungeon();// create the dungeon that the player will explore
      
      
      Character shopkeeper = new Character("Shopkeeper"); // the idea was to make the shopkeeper manage the shop
      shopkeeper.setEquipment(shop);                      // he wound up just printing banners
      shopkeeper.setCurrSize(10);                         // but at least I got to use the shopkeeper in the shop in shome way         
                                 
      
      
      
      Character player;// create a character to store player information
      
      Character enemy = new Character(); // placeholder character to copy enemies from horde array
      
   
      
      
      String[] title = {" --------------- ---------------   ---------------  ", // title graphic encoded in a string array
                        "-F=============T-+=============L---+============T--",
                        "-| F===========J-| +==========  L|-| F=========T L|-",
                        "-| |-------------| |---------L|  |-| |---------F  |-",
                        "-| L===========T-| |----------|  |-| L========   F+-",
                        "-L===========T |-| |----------|  |-+=============+- ",
                        " ------------| |-| |----------|  |-| F========L  L+-",
                        "   ----------| |-| |----------|  |-| |---------L| |-",
                        " ------------| |-| |---------F|  |-| |---------F| |-",
                        "-F===========J |-| +==========  F|-| L========F  F|-",
                        "-+=============+-+=============F---+============J-- ",
                        " --------------- ---------------   ---------------  "};
      
      for(int string = 0; string < title.length; string++) // go through each string
      {
         for(int i = 0; i < title[string].length(); i++)// check all indexes of each string
         {
            if (title[string].charAt(i) == '-') // if the character at index i is a dash
            {
               System.out.print("" + (char) 177); // print a brick block in its place
            }
            
            else
            {
               System.out.print(" "); // else print a space
            }
         }
         
         System.out.println(); // this adds a newline character
      }
   
      System.out.println();
      
      shopkeeper.printBanner("Welcome to Solo Dungeon Bash!"); // print banner with divider
      
      System.out.println("I'm your friendly neigborhood shopkeeper and it" + //shopkeeper rablings
                         "\nappears that you and I have gotten trapped in this" + 
                         "\ndungeon. Now don't get me wrong here; even though" +
                         "\nwe are stuck in this dungeon, YOU are the only one" +
                         "\nwho can get us unstuck. In other words you're bashing" +
                         "\nthis dungeon solo! You like what I did there?" + 
                         "\n\nAnyway, if we want to get out of this dungeon we need" + 
                         "\nto get to the other side. Piece of cake right?! " +
                         "\nWell thats not all... there are some pretty nasty" +
                         "\ncreatures down here and they wont let us just waltz on" +
                         "\non by. Here take some potions. If you want more you" +
                         "\nwill have to buy them from my shop or maybe you'll" +
                         "\nget lucky and find some in the dungeon." +
                         "\n\nYou should also be able to find some gold down" + 
                         "\nhere too. What? You think I should give you equipment" +
                         "\nfor free?! Getting out of here alive doesn't do me any" +
                         "\ngood if I go out of business. Here lets recap the basics" +
                         "\nof dungeon survival. You look like you are a bit confused.\n\n");
      
      shopkeeper.printActionBanner("Press enter to progress"); // pause and wait for user to progress text
      in.nextLine();
      System.out.println("\n");
      
      shopkeeper.printBanner("Turn sequence"); // print banner  with divider
      
      System.out.println("1. Pick a square in the dungeon and move to it" + // the turn sequence listed
                         "\n   this square cannot be a square you have already" +
                         "\n   been in" +
                         "\n2. Roll a six sided die to see what you find in the room." +
                         "\n3. If you find gold add it to your gold count." +
                         "\n4. If you find  potion, add it to your potions." +
                         "\n5. If you find a monster, get ready for battle!" +
                         "\n6. Manage your equipment, check your stats, shop for" +
                         "\n   items, and/or use a potion.\n\n");
      
      shopkeeper.printActionBanner("Got it? Press enter"); // pause and wait for user to progress text
      in.nextLine();
      System.out.println("\n");
      
      shopkeeper.printBanner("What is your name?"); // print banner with divider
      
      System.out.print("Enter your character's name: "); // prompt user to enter their character name
      
      player = new Character(in.nextLine()); // set the name of the player character to what the user entered
      
      System.out.print("\n" + player + "\n"); // print the players stats
      
      System.out.print("\n" + player.equipmentList() + "\n\n");
      
      shopkeeper.printActionBanner("Press enter to start");
      in.nextLine();
   
      
      while (playerAlive && !dracularDefeated) // the game begins
      {
         switch(choice) // takes player choice for action menu
         {
            case 1: // displays players stats
            
               System.out.println("\n" + player + "\n"); 
               shopkeeper.printActionBanner("Press enter to continue");
               in.nextLine();
               System.out.println();
               
               break;
               
            case 2: //displays character equipment
            
               System.out.println("\n" + player.equipmentList() + "\n");
               shopkeeper.printActionBanner("Press enter to continue");
               in.nextLine();
               System.out.println();
               
               break;
               
            case 3: // this is the shop
               
               while(shopping) // while the player is shopping repeat
               {
                  System.out.println();
                  shopkeeper.printUnderline("                                         ");
                  shopkeeper.printUnderline("|    |     Items     | Cost | Atk | Def |");
                  shopkeeper.printUnderline("|  1 | 1 Potion      | 1 GP |     |     |");
                  shopkeeper.printUnderline("|  2 | 3 Potions     | 2 GP |     |     |");
                  shopkeeper.printUnderline("|  3 | 6 Potions     | 3 GP |     |     |");
                  shopkeeper.printUnderline("|  4 | Buckler       | 1 GP |     |  +1 |");
                  shopkeeper.printUnderline("|  5 | Shield        | 2 GP |     |  +2 |");
                  shopkeeper.printUnderline("|  6 | Big Sword     | 3 GP |  +1 |     |");
                  shopkeeper.printUnderline("|  7 | Big Axe       | 4 GP |  +2 |     |");
                  shopkeeper.printUnderline("|  8 | Spiky Armor   | 5 GP |  +2 |  +1 |");
                  shopkeeper.printUnderline("|  9 | Magical Armor | 6 GP |     |  +5 |");
                  shopkeeper.printUnderline("| 10 |       Return to Action menu      |");
                  System.out.println();
               
                  System.out.print("Enter number of item you would like to buy: ");
                  
                  try
                  {
                     switch (in.nextInt()) //take players choice for item
                     {
                     
                        case 1: // buy 1 potion
                        
                           in.nextLine(); // get rid of new line character after int entry
                        
                           if (player.buyItem(shop[0])) // if the player successfully buys the item
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[0].getName() + " purchased");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else if (player.getGold() < shop[0].getCost()) // if gold is the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(player.getName() + " doesn't have enough gold");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else // else its item incompatability causing the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[0].getName() + " is incompatable with " + shop[0].getIncompatible());
                              in.nextLine();
                              System.out.println();
                           }
                        
                           break;
                     
                        case 2: // buy 3 potions
                        
                           in.nextLine(); // get rid of new line character after int entry
                        
                           if (player.buyItem(shop[1])) // if the player successfully buys the item
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[1].getName() + " purchased");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else if (player.getGold() < shop[1].getCost()) // if gold is the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(player.getName() + " doesn't have enough gold");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else // else its item incompatability causing the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[1].getName() + " is incompatable with " + shop[1].getIncompatible());
                              in.nextLine();
                              System.out.println();
                           }
                        
                           break;
                        
                        case 3: // buy 6 potions
                        
                           in.nextLine(); // get rid of new line character after int entry
                        
                           if (player.buyItem(shop[2])) // if the player successfully buys the item
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[2].getName() + " purchased");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else if (player.getGold() < shop[2].getCost()) // if gold is the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(player.getName() + " doesn't have enough gold");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else // else its item incompatability causing the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[2].getName() + " is incompatable with " + shop[2].getIncompatible());
                              in.nextLine();
                              System.out.println();
                           }
                        
                           break;
                        
                        case 4: // buy buckler
                        
                           in.nextLine(); // get rid of new line character after int entry
                        
                           if (player.buyItem(shop[3]))// if the player successfully buys the item
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[3].getName() + " purchased");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else if (player.getGold() < shop[3].getCost()) // if gold is the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(player.getName() + " doesn't have enough gold");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else // else its item incompatability causing the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[3].getName() + " is incompatable with " + shop[3].getIncompatible());
                              in.nextLine();
                              System.out.println();
                           }
                        
                           break;
                        
                        case 5: //buy shield
                        
                           in.nextLine(); // get rid of new line character after int entry
                        
                           if (player.buyItem(shop[4])) // if the player successfully buys the item
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[4].getName() + " purchased");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else if (player.getGold() < shop[4].getCost()) // if gold is the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(player.getName() + " doesn't have enough gold");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else // else its item incompatability causing the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[4].getName() + " is incompatable with " + shop[4].getIncompatible());
                              in.nextLine();
                              System.out.println();
                           }
                        
                           break;
                        
                        case 6: // buy big sword
                        
                           in.nextLine(); // get rid of new line character after int entry
                        
                           if (player.buyItem(shop[5]))// if the player successfully buys the item
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[5].getName() + " purchased");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else if (player.getGold() < shop[5].getCost()) // if gold is the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(player.getName() + " doesn't have enough gold");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else // else its item incompatability causing the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[5].getName() + " is incompatable with " + shop[5].getIncompatible());
                              in.nextLine();
                              System.out.println();
                           }
                        
                           break;
                        
                        case 7: // buy big axe
                        
                           in.nextLine(); // get rid of new line character after int entry
                        
                           if (player.buyItem(shop[6]))// if the player successfully buys the item
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[6].getName() + " purchased");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else if (player.getGold() < shop[6].getCost()) // if gold is the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(player.getName() + " doesn't have enough gold");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else // else its item incompatability causing the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[6].getName() + " is incompatable with " + shop[6].getIncompatible());
                              in.nextLine();
                              System.out.println();
                           }
                        
                           break;
                        
                        case 8: // buy spiky armor
                        
                           in.nextLine(); // get rid of new line character after int entry
                        
                           if (player.buyItem(shop[7]))// if the player successfully buys the item
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[7].getName() + " purchased");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else if (player.getGold() < shop[7].getCost()) // if gold is the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(player.getName() + " doesn't have enough gold");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else // else its item incompatability causing the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[7].getName() + " is incompatable with " + shop[7].getIncompatible());
                              in.nextLine();
                              System.out.println();
                           }
                        
                           break;
                        
                        case 9: // buy magical armor
                        
                           in.nextLine(); // get rid of new line character after int entry
                        
                           if (player.buyItem(shop[8]))// if the player successfully buys the item
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[8].getName() + " purchased");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else if (player.getGold() < shop[8].getCost()) // if gold is the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(player.getName() + " doesn't have enough gold");
                              in.nextLine();
                              System.out.println();
                           }
                           
                           else // else its item incompatability causing the issue
                           {
                              System.out.println();
                              shopkeeper.printActionBanner(shop[8].getName() + " is incompatable with " + shop[8].getIncompatible());
                              in.nextLine();
                              System.out.println();
                           }
                        
                           break;
                        
                        case 10: // exit shop
                        
                           shopping = false;
                        
                           break;
                     
                        default: // if something other than a number range 1-10
                           
                           in.nextLine(); // clear next line
                           System.out.println(); 
                           shopkeeper.printActionBanner("Enter a number 1-10. Press enter to continue");
                           in.nextLine(); // wait for player to press enter
                           
                     
                     }   
                  }
                  
                  catch(InputMismatchException obj) // if a input other than an integer is entered
                  {
                     in.nextLine(); // clear next line
                     System.out.println();
                     shopkeeper.printActionBanner("Invalid entry. Enter a number (1-10). Press enter to continue");
                     in.nextLine(); //wait for player to press enter
                  }
                  
               }
               
               shopping = true; // reset shopping boolean
               
               break;
            
            case 4: //use potion option in action menu
            
               if (player.usePotion()) // if player successfully dinks the potion
               {
                  System.out.println();
                  shopkeeper.printActionBanner( player.getName() + " drank a potion HP: " + player.getHealth());
                  in.nextLine();
                  System.out.println();
               }
               
               else if (player.getPotions() == 0) // the player doesn't have any potons here
               {
                  System.out.println();
                  shopkeeper.printActionBanner( player.getName() + " has no potions to drink");
                  in.nextLine();
                  System.out.println();
               }
               
               else // otherwise the player has max health
               {
                  System.out.println();
                  shopkeeper.printActionBanner( player.getName() + "'s health is max. No potion was consumed");
                  in.nextLine();
                  System.out.println();
               }
               
               
               
               break;
               
            case 5: // move phase, also continue quest in action menu
               
               System.out.println("\n");
               shopkeeper.printBanner("Move phase"); // print a banner with a line to section off phase
            
               System.out.println(dungeon);
               System.out.print("\nMove (U)p, (D)own, (L)eft, (R)ight: ");
               direction = in.nextLine(); // decide the direction 
               
               switch(direction) 
               {
                  case "U": // move up
                  
                     direction = dungeon.moveU(); // move up and store the returned string to direction
                     System.out.println(); // print a line of space
                     shopkeeper.printActionBanner(direction); // print the result of the move
                     error = !direction.equals("Move Successful."); // if the move wasn't sucessful an error occured
                     break;
                     
                  case "D": // move down
                  
                     direction = dungeon.moveD(); // move down and store the returned string to direction
                     System.out.println(); // print a line of space 
                     shopkeeper.printActionBanner(direction); // print the result of the move
                     error = !direction.equals("Move Successful."); // if the move wasn't sucessful an error occured
                     break;
                     
                  case "L": // move left
                  
                     direction = dungeon.moveL(); // move left and store the returned string to direction
                     System.out.println(); // print a line of space
                     shopkeeper.printActionBanner(direction); // print the result of the move
                     error = !direction.equals("Move Successful."); // if the move wasn't sucessful an error occured
                     break;
                     
                  case "R": // move right
                  
                     direction = dungeon.moveR(); // move Right and store the returned string to direction
                     System.out.println(); // print a line of space
                     shopkeeper.printActionBanner(direction); // print the result of the move
                     error = !direction.equals("Move Successful."); // if the move wasn't sucessful an error occured
                     break;
                     
                  default: // the user didn't put the above choices
                  
                     System.out.println(); 
                     shopkeeper.printActionBanner("Invalid input. Type U, D, L, or R for choice. Hit enter to continue.");
                     in.nextLine();
                     error = true;  
               }
               
               if (!error) // if an error didn't occur in the move phase
               {
                  event = die.nextInt(6) + 1; // roll a d6 to deturmine the event
                  System.out.println();
                  
                  switch(dungeon.getRow()) // use the location of the player to deturmine the event outcome
                  {     
                     case 1: // player is on the first row of the dungeon
                     
                        if (event == 1) // dice roll logic
                        {
                           player.foundPotion();
                        }
                        
                        else if (event <= 4) // dice roll was 2-4
                        {  
                           enemy.copyOf(horde[0]); // copy orc from horde
                           playerAlive = player.fight(enemy); // player fights orc
                        }
                        
                        else if (event == 5)
                        {
                           player.emptyRoom(); //player finds an empty room
                        }
                        
                        else
                        {
                           player.foundGold(); // player found gold
                        }
                        
                        break;
                        
                     case 2: // the player is on the 2nd row of the dungeon
                     
                        if (event == 1) // dice roll logic
                        {
                           enemy.copyOf(horde[0]); // fight an orc
                           playerAlive = player.fight(enemy);
                        }
                        
                        else if (event == 2)
                        {  
                           enemy.copyOf(horde[1]); // fight a wolf
                           playerAlive = player.fight(enemy);
                        }
                        
                        else if (event <= 5) // player rolled 3-5
                        {
                           player.emptyRoom(); //player finds an empty room
                        }
                        
                        else
                        {
                           player.foundGold(); // player found gold
                        }
                        
                        break;
                        
                     case 3: // 3rd row of dungeon
                     
                        switch(event) // take the dice roll and deturmine the outcome
                        {
                           case 1:
                              
                              enemy.copyOf(horde[0]); // fight an orc
                              playerAlive = player.fight(enemy);
                              
                              break;
                           
                           case 2:
                              
                              enemy.copyOf(horde[1]); // fight a wolf
                              playerAlive = player.fight(enemy);
                              
                              break;
                           
                           case 3:
                           
                              enemy.copyOf(horde[2]); // fight a skeleton
                              playerAlive = player.fight(enemy);
                              
                              break;
                           
                           case 4:
                           
                              player.foundGold(); // player found gold
                           
                              break;
                           
                           case 5:
                           
                              player.foundPotion(); // player found potion
                           
                              break;
                           
                           case 6:
                           
                              player.emptyRoom(); //player finds an empty room
                           
                              break;
                        
                        }
                        
                        break;
                        
                     case 4: // 4th row of dungeon
                     
                        switch(event) // take the dice roll and deturmine the outcome
                        {
                           case 1:
                           
                              enemy.copyOf(horde[0]); // fight an orc
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 2:
                              
                              enemy.copyOf(horde[1]); // fight a wolf
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 3:
                              
                              enemy.copyOf(horde[2]); // fight a skeleton
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 4:
                           
                              enemy.copyOf(horde[3]); // fight an Evil Warrior
                              playerAlive = player.fight(enemy);
                              
                              break;
                           
                           case 5:
                              
                              player.foundGold(); // player found gold
                           
                              break;
                           
                           case 6:
                           
                              player.emptyRoom(); //player finds an empty room
                           
                              break;
                        
                        }
                        
                        break;
                        
                     case 5: // 5th row of dungeon
                     
                        switch(event) // take the dice roll and deturmine the outcome
                        {
                           case 1:
                           
                              enemy.copyOf(horde[1]); // fight a wolf
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 2:
                           
                              enemy.copyOf(horde[2]); // fight a skeleton
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 3:
                           
                              enemy.copyOf(horde[3]); // fight an Evil Warrior
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 4:
                           
                              enemy.copyOf(horde[4]); // fight a Devil Bat
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 5:
                              
                              player.foundGold(); // player found gold
                           
                              break;
                           
                           case 6:
                           
                              player.emptyRoom(); //player finds an empty room
                           
                              break;
                        
                        }
                        
                        break;
                        
                     case 6: // 6th row of dungeon
                     
                        switch(event) // take the dice roll and deturmine the outcome
                        {
                           case 1:
                           
                              enemy.copyOf(horde[2]); // fight a skeletion
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 2:
                           
                              enemy.copyOf(horde[3]); // fight a Evil Warrior
                              playerAlive = player.fight(enemy);
                              
                              break;
                           
                           case 3:
                           
                              enemy.copyOf(horde[4]); // fight a devil bat
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 4:
                              
                              enemy.copyOf(horde[5]); // fight a Cyclops
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 5:
                           
                              player.foundGold(); // player found gold
                           
                              break;
                           
                           case 6:
                           
                              player.emptyRoom(); //player finds an empty room
                           
                              break;
                        
                        }
                        
                        break;
                        
                     case 7: // 7th row of dungeon
                     
                        switch(event) // take the dice roll and deturmine the outcome
                        {
                           case 1:
                           
                              enemy.copyOf(horde[3]); // fight a Evil Warrior
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 2:
                           
                              enemy.copyOf(horde[4]); // fight a devil bat
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 3:
                           
                              enemy.copyOf(horde[5]); // fight a cyclops
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 4:
                           
                              enemy.copyOf(horde[6]); // fight a Dark Elf
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 5:
                           
                              player.foundGold(); // player found gold
                           
                              break;
                           
                           case 6:
                           
                              player.emptyRoom(); //player finds an empty room
                           
                              break;
                        
                        }
                        
                        break;
                        
                     case 8: // 8th row of dungeon
                     
                        switch(event) // take the dice roll and deturmine the outcome
                        {
                           case 1:
                           
                              enemy.copyOf(horde[4]); // fight a devil bat
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 2:
                           
                              enemy.copyOf(horde[5]); // fight a cyclops
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 3:
                           
                              enemy.copyOf(horde[6]); // fight a dark elf
                              playerAlive = player.fight(enemy);
                              
                              break;
                           
                           case 4:
                           
                              enemy.copyOf(horde[7]); // fight a skeleton lord
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 5:
                           
                              player.foundGold(); // player found gold
                           
                              break;
                           
                           case 6:
                           
                              player.emptyRoom(); //player finds an empty room
                           
                              break;
                        
                        }
                        
                        break;
                        
                     case 9: // 9th row of dungeon
                     
                        switch(event) // take the dice roll and deturmine the outcome
                        {
                           case 1:
                              
                              enemy.copyOf(horde[5]); // fight a cyclops
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 2:
                           
                              enemy.copyOf(horde[6]); // fight a dark elf
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 3:
                           
                              enemy.copyOf(horde[7]); // fight a skeleton lord
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 4:
                           
                              enemy.copyOf(horde[8]); // fight a Wizard
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 5:
                              
                              player.foundGold(); // player found gold
                              
                              break;
                           
                           case 6:
                           
                              player.foundPotion(); //player finds a potion
                           
                              break;
                        
                        }
                        
                        break;
                        
                     case 10: // 10th row of dungeon
                     
                        switch(event) // take the dice roll and deturmine the outcome
                        {
                           case 1:
                           
                              enemy.copyOf(horde[6]); // fight a dark elf
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 2:
                           
                              enemy.copyOf(horde[7]); // fight a skeleton lord
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 3:
                           
                              enemy.copyOf(horde[8]); // fight a Wizard
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 4:
                           
                              enemy.copyOf(horde[9]); // fight a Demon
                              playerAlive = player.fight(enemy);
                           
                              break;
                           
                           case 5:
                           
                              player.foundGold(); // player found gold
                           
                              break;
                           
                           case 6:
                           
                              player.emptyRoom(); //player finds an empty room
                           
                              break;
                        
                        }
                        
                        break;
                        
                     case 11: //player reached the other side of dungeon
                     
                        playerAlive = player.fight(horde[10]);// no need to make a copy of dracular. he is a unique enemy
                        dracularDefeated = playerAlive; // if the player is alive at this point then they defeated dracular
                        
                        break;
                        
                  }
               }
               
               break; // end of move option
               
            
            
            /*
            
            
            no need for default here because that is handled by input validation in the actual action menu
            
            
            */
            
            
         }
         
         if(!error && playerAlive && !dracularDefeated) // if there wan't an error the move phase give actions
         {                                              // also if the player defeats or is defeated by dracular dont show this menu
            
            do
            {
               System.out.println();
               shopkeeper.printBanner("Action phase"); // print divider with title "Action Phase
               
            
               shopkeeper.printUnderline("Actions"); // list actions
               System.out.println("1. View Stats\n2. View Inventory\n3. Shop For Items\n4. Use Potion\n5. Continue Quest\n");
            
               System.out.print("Choose an action: "); // ask for what the player would like to do
               
               try
               {
                  choice = in.nextInt();  // try taking in the next integer the user enters
               }
               
               catch (InputMismatchException obj)
               {
                  choice = -1; // if the user didn't enter an integer then set choice to -1 to show error message
               }
               
               in.nextLine(); // move past next line character
            
               if( choice > 5 || choice < 1) // if the choice isn't in a valid range of options
               {
                  System.out.println();
                  shopkeeper.printActionBanner("Invalid input. Enter a number 1-5. Press enter to continue.");//let the player know they entered somthing out of the range of options
                  in.nextLine();
                  System.out.println();
                  
               }
            
            }
            while( choice > 5 || choice < 1); // repeat the action menu as long as the player puts in invalid entries
            
           
         }
         
         else // there was an error or the player lost or won the game
         {
            error = false; // reset error
         }
         
      }
      
      if(playerAlive && dracularDefeated) // if the player is alive and dracular is defeated
      {
         System.out.println("\n");
         shopkeeper.printActionBanner(" *** You Win!!! *** ");//the player wins
      }
      
      else // the player was defeated and dracular lives
      {
         System.out.println("\n");
         shopkeeper.printActionBanner("): you lose :(");//the player lost
      }
        
   }
   
}