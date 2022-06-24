/*
Name: Olivia Howard           Date Assigned: 11/23/2021

Course: CSCI 2003-42733       Date Due: 11/30/2021

Instructor: Ms. Greer

File name: ArrayOps.java

Program Description: This is a class of static methods to handle integer array operations. The following
operations are as follows: a method to deturmine if an integer is contained in an integer array, a method
that counts the number of times and integer occurs in an integer array, a method that find the first instance
of an integer in an integer array reading left to right, a method to find the first instance of  an integer
in an integer array reading right to left, a method to deturmine if two integer arrays are equal, and 
a method to return all of the elements of an integer array in the form of a String.
*/

/**
This class contains static methods pertaining to integer arrays
*/
public class ArrayOps
{

   /**
   This method checks to see if there is a single instance of an integer in an integer array
   @param array the integer array you would like to check
   @param number the single integer you would like to check the array for
   @return if the number is in the array in the form of a boolean
   */
   public static boolean contains(int[] array, int number)
   {
      for (int index = 0; index < array.length; index++) // go through each index of the array
      {
         if(array[index] == number)// until you find the number in the array
         {
            return true;
         }
      }
      
      return false; // if you reach this point the number isn't in the array
   }
   
   /**
   This method counts the amount of times an integer is in an integer array
   @param array the integer array you would like to count
   @param number the integer you want to count the occurances of
   @return the count of how many times a number appears in an array   
   */
   public static int count(int[] array, int number)
   {
      int count = 0; // set count to 0
      
      for (int index = 0; index < array.length; index++)// go through each index in the array
      {
         if (array[index] == number)// if you find the number you are looking for
         {
            count++;// add 1 to count
         }
      }
      
      return count; // return the final count
   }
   
   /**
   This method retruns the index at which the first instance an integer appears in an integer array reading from left to right
   @param array the integer array you would like to search from left to right
   @param number the integer you would like to search the array for
   @return the first index that the integer is found
   */
   public static int find(int[] array, int number)
   {
      for (int index = 0; index < array.length; index++)// go through each index starting from 0 and increment the index for each pass
      {
         if (array[index] == number)// if you find the number you are looking for
         {
            return index; // return the index it is located at
         }
      } 
      
      return -1; // if you get here the number doesn't exist in the array so return a value that is sure to raise questions
   }
   
   /**
   This method retruns the index at which the first instance an integer appears in an integer array reading from right to left
   @param array the integer array you would like to search from right to left
   @param number the integer you would like to search the array for
   @return the first index that the integer is found
   */
   public static int rfind(int[] array, int number)
   {
      for (int index = array.length - 1 ; index > -1; index--)// go through each index starting from the end and decrement the index for each pass until you reach the beggining of the array
      {
         if (array[index] == number)// if you find the number you are looking for
         {
            return index; // return the index it is located at
         }
      } 
      
      return -1; // if you get here the number doesn't exist in the array so return a value that is sure to raise questions
   }
   
   /**
   This method tests if two integer arrays are equal
   @param array1 the first array you are comparing to
   @param array2 the second array that you would like to compare to the first array
   @return if the two arrays are equal in the form of a boolean
   */
   public static boolean equals(int[] array1, int[] array2)
   {
   
      try
      {
         for (int index = 0; index < array1.length; index++)// go through each index
         {
            if (array1[index] != array2[index]) // compare the same index of both arrays if they are not equal
            {
               return false; // return that they are not equal
            }
         }
      }
      
      catch (ArrayIndexOutOfBoundsException obj) // if array1 is longer than array2
      {
         return false; // retrun that they are not equal
      }
      
      return true; // if we reach this point then the arrays are equal
   }
   
   /**
   This method retruns all of the elements of an integer array in String form
   @param array the array that you would like the elements of
   @return a String of array elements contained in the int array
   */
   public static String elements(int[] array)
   {
      String elements = "{"; // create a string to store elements to
      
      for (int index = 0 ; index < array.length; index++) // go through each index of the integer array
      {
         if(index != array.length - 1)// if we are not on the last index
         {
            elements += (array[index] + ", "); // add the element at that index to the string elements with a comma and space
         }
         
         else
         {
            elements += (array[index] + "}"); // add the final element to the string elements and close with a bracket
         }
      }
      
      return elements; // return the constructed elements string
   }
}