/*
   CODE BY: Tyler Greer
   
   *** CORRECTION MADE: cost instance variable is now declared.
   
   DON'T CHANGE THIS FILE. I WILL BE USING THIS VERSION OF IT TO GRADE YOUR PROGRAM.
*/

/**
   Represents a item that can be purchased with gold coins.
*/
public class Item
{
   private String name;          // name of item
   private int atkDie;           // number of attack dice
   private int defDie;           // number of defense dice
   private int potions;          // number of potions
   private String incompatible;  // item that can't be used concurrently with this item
   private int cost;             // amount of gold need to buy an item

   /**
      Initializes instance variables.
   */
   public Item()
   {
   }
   
   /**
      Initializes instance variables.
   */
   public Item(String name, int atkDie, int defDie, int potions, String incompatible, int cost)
   {
      this.name = name;
      this.atkDie = atkDie;
      this.defDie = defDie;
      this.potions = potions;
      this.incompatible = incompatible;
      this.cost = cost;
   }
   
   /**
      Updates name of item.
      @param name name of item
   */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
      Updates number of attack dice
      @param atkDie number of attack dice   
   */
   public void setAtkDie(int atkDie)
   {
      this.atkDie = atkDie;
   }

   /**
      Updates number of defense dice
      @param defDie number of defense dice   
   */
   public void setDefDie(int defDie)
   {
      this.defDie = defDie;
   }
   
   /**
      Updates number of potions
      @param potions number of potions  
   */
   public void setPotions(int potions)
   {
      this.potions = potions;
   }
   
   /**
      Updates name of incompatible item
      @param incompatible name of incompatible item
   */
   public void setIncompatible(String incompatible)
   {
      this.incompatible = incompatible;
   }

   /**
      Updates cost of item
      @param cost cost of item
   */
   public void setCost(int cost)
   {
      this.cost = cost;
   }


   /**
      Gets name of item
      @return name of item
   */
   public String getName()
   {
      return name;
   }
   
   /**
      Gets number of attack dice
      @return number of attack dice
   */
   public int getAtkDie()
   {
      return atkDie;
   }
   
   /**
      Gets number of defense dice
      @return number of defense dice
   */
   public int getDefDie()
   {
      return defDie;
   }

   /**
      Gets number of potions
      @return number of potions
   */
   public int getPotions()
   {
      return potions;
   }

   /**
      Gets name of incompatible item
      @return name of incompatible item
   */
   public String getIncompatible()
   {
      return incompatible;
   }

   /**
      Gets cost of item
      @return cost of item
   */
   public int getCost()
   {
      return cost;
   }

   /**
      Return information on the item
   */
   public String toString()
   {
      return this.name + ", " + this.atkDie + ", " + this.defDie + ", " + this.potions + ", " + this.incompatible + ", " + this.cost;
   }

}
