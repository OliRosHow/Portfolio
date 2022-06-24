/*
Name: Olivia Howard           Date Assigned: 11/23/2021

Course: CSCI 2003-42733       Date Due: 11/30/2021

Instructor: Ms. Greer

File name: ArrayOpsDriver.java

Program Description: This driver program tests all of the methods of the ArrayOps class. Each
operation is divided in to a category where each operation is tested twice with the exception
of the element operator with prints all of the arrays specified accordingly at least once a
piece. All alternate results are accounted for to fully test the operations.
*/

/**
This class is a driver program to test all methods of the ArrayOps class
*/
public class ArrayOpsDriver
{  
   /**
   This is the main method of the program. 
   @param args String array arguments
   */
   public static void main(String[] args)
   {
      // all of the arrays we will use
      int[] array1 = {1, 2, 3, 1};
      int[] array2 = {1, 2, 3, 1};
      int[] array3 = {2, 3, 4, 4};
      int[] array4 = {1, 2, 3, 3, 2, 3};
      
      // show the arrays that we are using
      System.out.println("Arrays\n======\n" + ArrayOps.elements(array1) + "\n" + ArrayOps.elements(array2) + "\n" + ArrayOps.elements(array3) + "\n" + ArrayOps.elements(array4) + "\n");
      
      //print category with divider
      System.out.println("Contains\n========");
      
      System.out.print(ArrayOps.elements(array1)); // show first array to test
      
      if (ArrayOps.contains(array1, 2)) // if it contains 2
      {
         System.out.println(" contains 2.");// say that it contains 2
      }
      
      else // if it does not contain 2
      {
         System.out.println(" does not contain 2.");// say that it does not contain 2
      }
      
      System.out.print(ArrayOps.elements(array3));// display the array we are working with
      
      if (ArrayOps.contains(array3, 5)) // if it contains 5
      {
         System.out.println(" contains 5.");// say that it contains 5
      }
      
      else // if it does not contain 5
      {
         System.out.println(" does not contain 5.\n");// say that it does not contain 5
      }
      
      //print category with divider
      System.out.println("Count\n=====");
      
      //print how many times 3 appears in array 3 and 4
      System.out.println("3 appears " + ArrayOps.count(array3, 3) + " time(s) in " + ArrayOps.elements(array3) + ".");
      System.out.println("3 appears " + ArrayOps.count(array4, 3) + " time(s) in " + ArrayOps.elements(array4) + ".\n");
      
      //print category with divider
      System.out.println("Find First Instance\n===================");
      
      if(ArrayOps.find(array3, 4) != -1) // if 4 is found in the array
      {
        System.out.println("4 is at index " + ArrayOps.find(array3, 4) + " in " + ArrayOps.elements(array3) + "."); // print were it was found  
      }
      
      else // if 4 couldn't be found 
      {
        System.out.println("4 is Not in " + ArrayOps.elements(array3) + "."); // print that it couldn't be found
      }
      
      if(ArrayOps.find(array4, 4) != -1) // if 4 is found in the array
      {
        System.out.println("4 is at index " + ArrayOps.find(array4, 4) + " in " + ArrayOps.elements(array4) + "."); // print were it was found  
      }
      
      else // if 4 couldn't be found 
      {
        System.out.println("4 is Not in " + ArrayOps.elements(array4) + "."); // print that it couldn't be found
      }
      
      //print category with divider
      System.out.println("\nFind Last Instance\n==================");
      
      if(ArrayOps.rfind(array3, 4) != -1) // if 4 is found in the array
      {
        System.out.println("4 is at index " + ArrayOps.rfind(array3, 4) + " in " + ArrayOps.elements(array3) + "."); // print were it was found  
      }
      
      else // if 4 couldn't be found 
      {
        System.out.println("4 is Not in " + ArrayOps.elements(array3) + "."); // print that it couldn't be found
      }
      
      if(ArrayOps.rfind(array4, 4) != -1) // if 4 is found in the array
      {
        System.out.println("4 is at index " + ArrayOps.rfind(array4, 4) + " in " + ArrayOps.elements(array4) + "."); // print were it was found  
      }
      
      else // if 4 couldn't be found 
      {
        System.out.println("4 is Not in " + ArrayOps.elements(array4) + "."); // print that it couldn't be found
      }
      
      //print category with divider
      System.out.println("\nEquals\n======");
      
      if(ArrayOps.equals(array1, array2)) // if the arrays are equal
      {
         System.out.println(ArrayOps.elements(array1) + " and " + ArrayOps.elements(array2) + " are equal."); // print they are equal
      }
      
      else // else they are not equal
      {
         System.out.println(ArrayOps.elements(array1) + " and " + ArrayOps.elements(array2) + " are Not equal.");// print they are not equal
      }
      
      if(ArrayOps.equals(array1, array3))// if the arrays are equal
      {
         System.out.println(ArrayOps.elements(array1) + " and " + ArrayOps.elements(array3) + " are equal."); // print they are equal
      }
      
      else// else they are not equal
      {
         System.out.println(ArrayOps.elements(array1) + " and " + ArrayOps.elements(array3) + " are NOT equal.");// print they are not equal
      }  
   }  
}