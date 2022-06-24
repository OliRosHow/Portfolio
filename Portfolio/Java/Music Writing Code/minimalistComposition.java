import java.util.Scanner;
import java.io.*;

public class minimalistComposition
{
   public static void main(String[] args)throws IOException
   {
      Note[] idea = {new Note("eighth"), new Note(PreAPitch.G5, 1, "eighth"), new Note(PreAPitch.G5, 1, "eighth"), new Note(PreAPitch.G5, 1,  "eighth"), new Note(PreAPitch.Eb5, 1, "half")};
      Note[] ideax2 = {new Note("eighth"), new Note(PreAPitch.G4, 2, "eighth"), new Note(PreAPitch.G4, 2, "eighth"), new Note(PreAPitch.G4, 2, "eighth"), new Note(PreAPitch.Eb4, 2, "half")};
      Note[] ideax4 = {new Note("eighth"), new Note(PreAPitch.D5, 3, "eighth"), new Note(PreAPitch.E5, 3, "eighth"), new Note(PreAPitch.F5, 3, "eighth"), new Note(PreAPitch.C4, 3, "half")};
      Note[] ideax8 = {new Note("eighth"), new Note(PreAPitch.D5, 4, "eighth"), new Note(PreAPitch.E5, 4, "eighth"), new Note(PreAPitch.F5, 4, "eighth"), new Note(PreAPitch.C4, 4, "half")};
      Pitch[][] RegisterXidea = {{null, PreAPitch.F5, PreAPitch.F5, PreAPitch.F5, PreAPitch.D5},
                                 {null, PreAPitch.Eb5, PreAPitch.Eb5, PreAPitch.Eb5, PreAPitch.C5},
                                 {null, PreAPitch.Ab4, PreAPitch.Ab4, PreAPitch.Ab4, PreAPitch.G4},
                                 {null, PreAPitch.G4, PreAPitch.G4, PreAPitch.G4, PreAPitch.Eb4}};
      int[][] permutations = {{0,1,2,3},
                              {0,1,3,2},
                              {0,3,1,2},
                              {0,3,2,1},
                              {0,2,3,1},
                              {0,2,1,3},
                              {1,0,2,3},
                              {1,0,3,2},
                              {1,3,0,2},
                              {1,3,2,0},
                              {1,2,3,0},
                              {1,2,0,3},
                              {2,0,1,3},
                              {2,0,3,1},
                              {2,3,0,1},
                              {2,3,1,0},
                              {2,1,3,0},
                              {2,1,0,3},
                              {3,0,1,2},
                              {3,0,2,1},
                              {3,2,0,1},
                              {3,2,1,0},
                              {3,1,2,0},
                              {3,1,0,2}};
      Scanner reference = new Scanner( new File ("reference.xml"));
      PrintWriter out = new PrintWriter("MinimalistBeethoven.xml");
   
      for(int i = 0; i < 21; i++)
      {
         out.println(reference.nextLine());
      }
      
      for(int j = 0; j < permutations.length; j++)
      {
         for(int i = 0; i < idea.length; i++)
         {
            idea[i].setPitch(RegisterXidea[permutations[j][3]][i]);
            ideax2[i].setPitch(RegisterXidea[permutations[j][2]][i]);
            ideax4[i].setPitch(RegisterXidea[permutations[j][1]][i]);
            ideax8[i].setPitch(RegisterXidea[permutations[j][0]][i]);
         }
         
         for(int i = 0; i < idea.length; i++)
         {
            out.println(idea[i]);
         }
         
         for(int i = 0; i < ideax2.length; i++)
         {
            out.println(ideax2[i]);
         }
         
         for(int i = 0; i < ideax4.length; i++)
         {
            out.println(ideax4[i]);

         }
         for(int i = 0; i < ideax8.length; i++)
         {
            out.println(ideax8[i]);
         }   
      } 
   
      while(reference.hasNextLine())
      {
         out.println(reference.nextLine());
      }
      
      out.close();
      reference.close();
   
       
   }
}