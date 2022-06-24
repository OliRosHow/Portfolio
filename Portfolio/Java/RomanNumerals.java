/*
Name: Olivia Howard           Date Assigned: 9/22/2021 

Course: CSCI 2003-42733       Date Due: 9/30/2021 

Instructor: Ms. Greer

File name: RomanNumerals.java

Program Description: This program generates the corisponding roman numeral from a users decimal input.
Then, the user is asked what the roman numeral of thier decimal input is. If the user answers correctly
or incorrectly they are informed so and the correct anwer is diplayed at the end.
*/
import java.util.Scanner;

public class RomanNumerals
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int deciOnes; // used to store the ones place of decimal input
      int deciTens; // used to store the tens place of decimal input
      int deciHundreths; //used to store the hundres place of decimal input
      int deciNum; // used to store the decimal input
      
      String romOnes;// used in the conversion of the decimal ones place to roman numeral ones place
      String romTens;// used in the conversion of the decimal tens place to roman numeral tens place
      String romHundreths;// used in the conversion of the decimal hundreths place to roman numberal hundreths place
      String romNum; // the roman numeral representation of deciNum
      
      //start of game
      System.out.println("Do You Know the Roman Numerals?\n" +
                         "===============================\n\n" +
                         "+-----------------------------+\n" +
                         "|        Roman Numerals       |\n" +
                         "+-----------------------------+\n" +
                         "| 1    5    10  50   100  500 |\n" +
                         "+-----------------------------+\n" +
                         "| I    V    X   L    C    D   |\n" +
                         "+-----------------------------+\n");
                         
      System.out.print("Enter a number (100-899): ");
      
      deciNum = in.nextInt();
      in.nextLine();
      
      //simple input validation for our requested range
      if (deciNum >= 100 && deciNum <= 899)
      {
         deciOnes = deciNum%10;
         deciTens = (deciNum%100 - deciOnes)/10;
         deciHundreths = (deciNum - deciTens)/100;
         
         // start of decicion structure to deturmine what romHundreths will equal
         if (deciHundreths == 1)
         {
            romHundreths = "C";
         }
         else if (deciHundreths == 2)
         {
            romHundreths = "CC";
         }
         else if (deciHundreths == 3)
         {
            romHundreths = "CCC";
         }
         else if (deciHundreths == 4)
         {
            romHundreths = "CD";
         }
         else if (deciHundreths == 5)
         {
            romHundreths = "D";
         }
         else if (deciHundreths == 6)
         {
            romHundreths = "DC";
         }
         else if (deciHundreths == 7)
         {
            romHundreths = "DCC";
         }
         else 
         {
            romHundreths = "DCCC";
         }
         
         //start of the decision structure to deturming what romTens will equal
         if (deciTens == 0)
         {
            romTens = "";
         }
         else if (deciTens == 1)
         {
            romTens = "X";
         }
         else if (deciTens == 2)
         {
            romTens = "XX";
         }
         else if (deciTens == 3)
         {
            romTens = "XXX";
         }
         else if (deciTens == 4)
         {
            romTens = "XL";
         }
         else if (deciTens == 5)
         {
            romTens = "L";
         }
         else if (deciTens == 6)
         {
            romTens = "LX";
         }
         else if (deciTens == 7)
         {
            romTens = "LXX";
         }
         else if (deciTens == 8)
         {
            romTens = "LXXX";
         }
         else
         {
            romTens = "XC";
         }
         
         //start of decicion structure to deturmine what romOnes will equal
         if (deciOnes == 0)
         {
            romOnes = "";
         }
         else if (deciOnes == 1)
         {
            romOnes = "I";
         }
         else if (deciOnes == 2)
         {
            romOnes = "II";
         }
         else if (deciOnes == 3)
         {
            romOnes = "III";
         }
         else if (deciOnes == 4)
         {
            romOnes = "IV";
         }
         else if (deciOnes == 5)
         {
            romOnes = "V";
         }
         else if (deciOnes == 6)
         {
            romOnes = "VI";
         }
         else if (deciOnes == 7)
         {
            romOnes = "VII";
         }
         else if (deciOnes == 8)
         {
            romOnes = "VIII";
         }
         else
         {
            romOnes = "IX";
         }
         
         romNum = romHundreths + romTens + romOnes;// combine all roman numeral components to make a roman numeral
         
         
         System.out.print("\nEnter the Roman Numeral of " + deciNum +": "); // ask user to enter what they think the roman numeral equals
         
         if (in.nextLine().equals(romNum)) // check to see if input equal the correct roman numeral value
         {
            System.out.println("\n* * * Correct * * *"); // let the user know they are correct
         }
         else
         {
            System.out.println("\n* * * Incorrect * * *"); // let the user know they are incorrect
         }
         System.out.println("\n" + deciNum + " is Roman numeral " + romNum);// display the answer
      }
      else
      {
         System.out.println("Error: number entered is out of range."); // display if the user enters a number out of the given range
      }
   }
}   