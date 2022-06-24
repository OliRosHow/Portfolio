/*
Name: Olivia Howard           Date Assigned: 11/11/2021

Course: CSCI 2003-42733       Date Due: 11/11/2021

Instructor: Ms. Greer

File name: Character.java

Program Description: This is a class that is used to generate character objects for the game
Solo Dungeon Bash. This class includes 3 construcors, setters and getters, character actions
pertaining to stats, and equipment management via array manipulation. This method also includes
a copyOf() mehtod to copy values from another character to the character with the method extension.
*/



import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

/**
This is a class that represents a character in the game Solo Dungeon Bash
*/
public class Character
{
   Scanner input = new Scanner(System.in);
   Random die = new Random();
   
   private String name;
   private int health;
   private int attack;
   private int defence;
   private int potions;
   private int gold;
   private Item[] equipment; 
   private int currSize;
   
   /**
   This is a no-argument constructor that defaults to create an Orc character
   */
   public Character()
   {
      name = "Orc";
      health = 1;
      attack = 1;
      defence = 0;
      potions = 0;
      gold = 0;
      equipment = null;
      currSize = 0;
   }
   
   /**
   This is a argument constructor that works well for player character creation
   @param name the name you would like to assign to the character
   */
   public Character(String name)
   {
      this.name = name;
      health = 30;
      attack = 1;
      defence = 1;
      potions = 2;
      gold = 4;
      equipment = new Item[99];
      currSize = 0;
   }
   
   /**
   This is a argument constructor that works well for enemy character creation
   @param name the name you would like to assign to the character
   @param attack the number of attack die the character will have
   @param defence the number of defence die the character will have
   */
   public Character(String name, int attack, int defence)
   {
      this.name = name;
      health = 1;
      this.attack = attack;
      this.defence = defence;
      potions = 0;
      gold = 0;
      equipment = null;
      currSize = 0;
   }
   
   /**
   Setter for character name
   @param n the desired name for the character
   */
   public void setName(String n)
   {
      name = n;
   }
   
   /**
   Setter for character health
   @param hp the desired number of health points
   */
   public void setHealth(int hp)
   {
      health = hp;
   }
   
   /**
   Setter for character attack
   @param atk the desired number of attack die
   */
   public void setAttack(int atk)
   {
      attack = atk;
   }
   
   /**
   Setter for character defence
   @param def the desired number of defence die
   */
   public void setDefence(int def)
   {
      defence = def;
   }
   
   /**
   Setter for character potion count
   @param p the desired number of potions for the character 
   */
   public void setPotions(int p)
   {
      potions = p;
   }
   
   /**
   Setter for character gold
   @param g the amount of gold you want the character to have
   */
   public void setGold(int g)
   {
      gold = g;
   }
   
   /**
   Setter for the character equipment array. I would recommend using the setCurrSize() method directly after using this method.
   @param items the array of item objects you would like the character to have. 
   */
   public void setEquipment(Item[] items)
   {
      try
      {
         equipment = Arrays.copyOf(items, 99);
      }
      
      catch(NullPointerException obj)
      {
         equipment = null;
      }
   }
   
   /**
   Setter for the currSize counter associated to the character equipment array. I recommend calling this after using the setEquipment() method.
   @param cs the size count of the non-null objects in the equipment array
   */
   public void setCurrSize(int cs)
   {
      currSize = cs;
   }
   
   /**
   Getter for character name
   @return the name associated to the character
   */
   public String getName()
   {
      return name;
   }
   
   /**
   Getter for character health
   @return the health point value associated to the character
   */
   public int getHealth()
   {
      return health;
   }
   
   /**
   Getter for character attack
   @return the number of attack die the character has
   */
   public int getAttack()
   {
      return attack;
   }
   
   /**
   Getter for character defence
   @return the number of defence die the character has
   */
   public int getDefence()
   {
      return defence;
   }
   
   /**
   Getter for character potions
   @return the number of potions the character has
   */
   public int getPotions()
   {
      return potions;
   }
   
   /**
   Getter for character gold
   @return the amount of gold that the character has
   */
   public int getGold()
   {
      return gold;
   }
   
   /**
   Getter for character equipment
   @return the equipment array associated to the character
   */
   public Item[] getEquipment()
   {
      return equipment;
   }
   
   /**
   Getter for the characters currSize counter to represent non-null objects
   @return the number of non-null objects in the equipment array
   */
   public int getCurrSize()
   {
      return currSize;
   }
   
   /**
   This method updates player health by subtracting the amout of damage they take
   @param damage the amount of damage the player takes in the form of a possitive integer(negative would heal the player)
   */
   public void takeDamage(int damage)
   {
      health -= damage;
   }
   
   /**
   This method subracts a potion from the characters potion count and adds it to health
   @return if the character successfully drank the potion in the form of a boolean
   */
   public boolean usePotion()
   {
      if (potions > 0 && health != 30)
      {
         health += 1;
         potions -= 1;;
         return true;
      }
      
      else
      {
         return false;
      }   
   }
   
   /**
   This method checks the characters equipment and updates the variable attack accordingly
   */
   public void updateAttack()
   {
      attack = 1;
      for (int item = 0; item < currSize; item++)
      {
         this.attack += equipment[item].getAtkDie();
      }
   }
   
   /**
   This method checks the characters equipment and updates the varable defence accordingly
   */
   public void updateDefence()
   {  
      defence = 1;
      for(int item = 0; item < currSize; item++)
      {
         defence += equipment[item].getDefDie();
      }
   }
   
   /**
   This method removes Gold items from character equipment and adds them to the variable gold
   */
   public void updateGold()
   {
      for(int item = 0; item < currSize; item++)
      {
         if (equipment[item].getName().equals("Gold"))
         {
            gold += 1;
            
            for( int pouch = item; pouch < currSize; pouch++) // shift everthing to the left. overwrite gold item
            {
               equipment[pouch] = equipment[pouch + 1];
            }
            
            item--;// move search index to the left too
            currSize--; // reduce the current size
            equipment[currSize] = null; // go to the end of the array and get rid of the copy item from the shift left  
         }
      }
   }
   
   /**
   This method removes potion items from the character equipment and adds them to the variable potions
   */
   public void updatePotions()
   {
      for(int item = 0; item < currSize; item++)
      {
         if (equipment[item].getName().equals("1 Potion") || equipment[item].getName().equals("3 Potions") || equipment[item].getName().equals("6 Potions"))
         {
            potions += equipment[item].getPotions();
            
            for( int pouch = item; pouch < currSize; pouch++) // shift everthing to the left. overwrite potion item
            {
               equipment[pouch] = equipment[pouch + 1];
            }
            
            item--;// move search index to the left too
            currSize--; // reduce the current size
            equipment[currSize] = null; // go to the end of the array and get rid of the copy item from the shift left  
         }
      }
   }
   
  /**
  This method calls all update methods at once.
  */ 
   public void update()
   {
      updateAttack();
      updateDefence();
      updateGold();
      updatePotions();
   }
   
   /**
   This method adds an Item object to the end of the charcters equipment array but before the first null object
   @param item the item you wish to add to the character equipment
   */
   public void addItem(Item item)
   {
      equipment[currSize] = item;
      currSize++;
      update();
   }
   
   /**
   This method is for buying an item
   @param item the item you would like to buy for the character
   @return if the transaction was sucessful
   */
   public boolean buyItem(Item item)
   {
      boolean compatable = true;
      
      for (int i = 0; i < currSize; i++)
      {
         if (equipment[i].getIncompatible().equals(item.getName()) || equipment[i].getName().equals(item.getName())) // if the item is incompatable or the player already has the item
         {
            compatable = false; // return that the transaction was unsucessful
         } 
      }
      
      if(compatable && gold - item.getCost() >= 0) // if the item is compatable and the character has the gold
      {
         addItem(item); // give the character the item and update the currSize variable
         gold -= item.getCost(); // subtract the cost from character gold
         update(); // update all character information
         return true; // return that the transaction was sucessful
      }
      
      else
      {
         return false; // reutrn that the transaction was unsucessful
      }
   }
   
   /**
   This is a method to sell an item in the character inventory
   @param item the item object you wish to sell from the players equipment array
   */
   public void sellItem(Item item)
   {
      for (int i = 0; i < currSize; i++)
      {
         if (equipment[i].getName().equals(item.getName()))// find the item in character inventory
         {  
            gold += equipment[i].getCost()/2; // sell the item for half it's original value
            
            for( int pouch = i; pouch < currSize; pouch++) // shift everything after the item to the left and overwrite the item
            {
               equipment[pouch] = equipment[pouch + 1];
            }
            currSize--; // reduce current size
            equipment[currSize] = null; // get rid of duplicate item at the end of array from shift left
         }
      }
      update(); // update all character information
   }
   
   /**
   This method takes a string prints that string with an outline and divider.
   @param title the string you would like to print with banner outline.
   */
   public void printBanner(String title)
   {
      System.out.print("" + (char) 201);
      
      for (int i = 0; i < title.length() + 2; i++)
      {
         System.out.print("" + (char) 205);
      }
      
      System.out.println("" + (char) 187);
      System.out.print( "" + (char) 206 + " " + title + " " + (char) 206);
      
      for(int i = 0; i < 58 - title.length(); i++)
      {
         System.out.print("" + (char) 205);
      }
      
      System.out.print("\n" + (char) 200);
      
      for (int i = 0; i < title.length() + 2; i++)
      {
         System.out.print("" + (char) 205);
      }
      
      System.out.println("" + (char) 188 + "\n\n");  
   }
   
   /**
   This method prints a basic 58 character long divider
   */
   public void printDivider()
   {
      for (int i = 0; i < 58; i++)
      {
         System.out.print("" + (char) 205);
      }
      
      System.out.println();
   }
   
   /**
   This method prints an underline
   @param toUnderline the string you would like to underline
   */
   public void printUnderline(String toUnderline)
   {
      System.out.println(toUnderline);
      
      for(int i = 0; i < toUnderline.length(); i++)
      {
         System.out.print("" + (char) 205);
         
      }
      
      System.out.println();
   }
   
   /**
   This method prints a string inside a banner which is usually used to denotate that the play needs to make some sort of action
   @param action the string you would like to print inside the banner
   */
   public void printActionBanner(String action)
   {
      for (int i = 0; i < action.length(); i++)
      {
         System.out.print("" + (char) 205);
      }
      
      System.out.println("\n" + action);
      
      for (int i = 0; i < action.length(); i++)
      {
         System.out.print("" + (char) 205);
      }      
   }
   
   /**
   This method prints the string with corners around it which is usually used to give the player the message they were defeated or an enemy was defeated
   @param defeated the message you would like to print in the banner
   */
   public void printDefeatBanner(String defeated)
   {  
      System.out.print("" + (char) 188);
      
      for(int i = 0; i < defeated.length() + 2; i++)
      {
         System.out.print("" + (char) 205);
      }
      
      System.out.println("" + (char) 200);
      System.out.println( "" + (char) 206 + " " + defeated + " " + (char) 206 );
      
      System.out.print("" + (char) 187 );
      
      for(int i = 0; i < defeated.length() + 2; i++)
      {
         System.out.print("" + (char) 205);
      }
      
      System.out.println("" + (char) 201);
      
   }
   
   
   /**
   This method copyies all of the variables from the parameter character to this character
   @param character the character whose variables you would like to copy
   */
   public void copyOf(Character character)
   {  
      this.name = character.name;
      this.health = character.health;
      this.attack = character.attack;
      this.defence = character.defence;
      this.potions = character.potions;
      this.gold = character.gold;
      this.setEquipment(character.getEquipment());
      this.currSize = character.currSize;
   }
   /**
   This method handles the fighting action for the character
   @param enemy the character object that character will fight
   @return if the character won the battle or not in the form of a boolean
   */
   
   public boolean fight(Character enemy)
   {
      
      int numEvenAtk;
      int numEvenDef;
      int damage;
      
      System.out.println("\n\n" + enemy.name + " appears!\n\n"); // let the play know who they are facing
      
      while ( this.health > 0 && enemy.health > 0)// as long as both the orc and the player have health the battle continues
      {  
         numEvenAtk = 0;// reset variables
         numEvenDef = 0;
         damage = 0;
         
         printBanner("ENEMY ATTACKS"); // let the player know the enemy is attacking
                  
         for (int roll = 0; roll < enemy.attack; roll++) // roll the dice for each enemy attck die
         {  
            if (die.nextInt(6) % 2 == 0) //check if the number is even
            {
               numEvenAtk += 1; //if it is then add one to the attack counter
            }  
         }
         
         if (numEvenAtk > 0) // if the enemy hit at least once then do this
         { 
            System.out.println(enemy.name + " rolls " + numEvenAtk + " even number(s)!\n\n"); // let the player know how many even rolls the enemy got
         
            printActionBanner("Press enter to roll defense dice"); // prompt the player to roll
            input.nextLine();
         
            for(int roll = 0; roll < this.defence; roll++) // roll the dice for each player defence die
            {
               if(die.nextInt(6) % 2 == 0)//check if that number is even
               {
                  numEvenDef++; // if it is add to defence counter
               }
            }
         
            System.out.println("\n\n" + this.name + " rolls " + numEvenDef + " even number(s)!\n\n"); // show the player how many even rolls they got
         
            damage = numEvenAtk - numEvenDef; // subract player defence from enemy attack to get damage
         
            if (damage > 0) // if damage is greater than 0
            {
               this.takeDamage(damage); // the player takes the resulting damage
               System.out.println(this.name + " takes " + damage + " damage!! HP: " + this.health + "\n\n"); // tell the player how much damage they recieved
            }
            
            else if (numEvenAtk > 0) // if the enemy actually rolled at least a single even number
            {
              System.out.println(enemy.name + "'s attack blocked!\n\n");// tell the player they blocke the attack
            }
            
            else // the enemy rolled 0 even attack die
            {
               System.out.println(enemy.name + " misses!!\n\n");// if the damage was 0 or negative tell the player that the enemy missed
            }
         }
         
         else //when the enemy rolls 0 even attack die
         {
            System.out.println(enemy.name + " rolls " + numEvenAtk + " even number(s)!\n\n"); // tell the player that
            System.out.println(enemy.name + " misses!!\n\n");// let the player know this results in a miss 
         }
         
         numEvenAtk = 0;//reset attack and defence
         numEvenDef = 0;
         
         if( this.health > 0 ) // if the player has health they get a turn
         {
            printBanner("PLAYER ATTACKS"); // let the player know that they are attacking now
         
            printActionBanner("Press enter to roll attack dice"); // prompt the player to roll
            input.nextLine();
         
            for (int roll = 0; roll < this.attack; roll++) // roll the dice for each player attack die
            {  
               if (die.nextInt(6) % 2 == 0) // check if it is even
               {
                  numEvenAtk++; // if it is then add to attack counter
               }  
            }
            
            if (numEvenAtk > 0) // if the player hit at least once
            { 
               System.out.println("\n\n" + this.name + " rolls " + numEvenAtk + " even number(s)!\n\n"); //let the player know how many time they hit
            
               for(int roll = 0; roll < enemy.defence; roll++) //roll the dice for each enemy defence die
               {
                  if(die.nextInt(6) % 2 == 0)// check for evens
                  {
                     numEvenDef++;// add to the defence counter if even
                  }
               }
            
               System.out.println( enemy.name + " rolls " + numEvenDef + " even number(s)!\n\n"); // let the player know how many time the enemy blocked
            
               damage = numEvenAtk - numEvenDef; // calculate damage
            
               if (damage > 0) //if damage is at least one
               {
                  enemy.takeDamage(damage); // the enemy takes teh damage
                  System.out.println(enemy.name + " takes " + damage + " damage!!\n\n");//let the player know that the enemy took damage
               }
               
               else if(numEvenAtk > 0)// if the player rolled at lest one even attack die but damage was zero
               {
                  System.out.print(this.name + "'s attack was blocked!\n\n"); // tell them that thier attack was blocked
               }
               
               else // the player rolled 0 even attack die
               {
                  System.out.println(this.name + " misses!!\n\n"); // if damage was less than 1 then let the player know they missed
               }
            }
            
            else // 0 even attack rolls
            {
               System.out.println("\n\n" + this.name + " rolls " + numEvenAtk + " even number(s)!\n\n"); // let the player know they rolled 0 attacks
               System.out.println(this.name + " misses!!\n\n"); // tell them that they missed
            }
         }
      }
      
      // we left the loop someone has 0 or less health
      if (this.health <= 0) // if the player has 0 or less health
      {
         printDefeatBanner("You have been defeated");//let them know they were defeated
         return false; // return false to denotate defeat of the player
      }
      
      else // the enemy has 0 or less health otherwise
      {
         printDefeatBanner(enemy.name + " has been defeated!!!");//let the player know they were victorious
         return true;// return true to denotate victory for the player
      }
      
      
   }
   
   /**
   Generates the equipment list of the character
   @return a list of equipment that the character has with items on thier own line
   */
   public String equipmentList()
   {
      String list = "Equipment List\n" + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205;
      for(int item = 0; item < currSize; item++)
      {
         list += "\n" + (item + 1) + ". " + equipment[item].getName();
      }
      return list; 
   }
   
   /**
   A toString method that lists the characters stats
   @return Character name, health, attack, defence, potions, and gold
   */
   public String toString()
   {
      return "Character Info\n" + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + (char) 205 + "\nName:    " + name + "\nHP:      " + health + "\nATK:     " + attack + "\nDEF:     " + defence + "\nPotions: " + potions + "\nGold:    " + gold;
   }
   
   /**
   This method handles when the player finds a potion
   */
   public void foundPotion()
   {
      System.out.println();
      printActionBanner( this.name + " found a Potion!");
      input.nextLine();
      potions++;
      
   }
   
   /**
   This method handles when the player finds gold
   */
   public  void foundGold()
   {
      System.out.println();
      printActionBanner(this.name + " found Gold!");
      input.nextLine();
      gold++;
   }
   
   /**
   This method tells the player that they entered an empty room
   */
   public void emptyRoom()
   {
      System.out.println();
      printActionBanner("This room is empty.");
      input.nextLine();
   }
   
   
}