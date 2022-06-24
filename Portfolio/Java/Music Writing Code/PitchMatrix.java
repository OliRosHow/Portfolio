public class PitchMatrix
{
   private int[][] pitchMatrix = new int[12][12];

   
   public PitchMatrix() // create default cromatic pitch matrix
   {
      int[] primeRow = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
      
      for(int i = 0; i < primeRow.length; i++)
      {
         pitchMatrix[0][i] = primeRow[i];
      }
      
      for(int i = 1; i < primeRow.length; i++)
      {
         pitchMatrix[i][0] = ((primeRow[0] + 12) - Math.abs(primeRow[0] - primeRow[i])) % 12;
      }
      
      for(int i = 1; i < primeRow.length; i++)
      {
         for(int j = 1; j < primeRow.length; j++)
         {
            pitchMatrix[i][j] = (pitchMatrix[i][j-1] + Math.abs(primeRow[j-1] - primeRow[j])) % 12;
         }
      }
   }
   
   public PitchMatrix(int[] p) // takes a prime pitch row and generates a full matirx
   {
      int[] primeRow = p;
      
      for(int i = 0; i < primeRow.length; i++)
      {
         pitchMatrix[0][i] = primeRow[i];
      }
      
      for(int i = 1; i < primeRow.length; i++)
      {
         pitchMatrix[i][0] = (primeRow[0] + (primeRow[0] - primeRow[i])) % 12;
         
         for(int j = 1; j < primeRow.length; j++)
         {
            pitchMatrix[i][j] = (pitchMatrix[i][j-1] + Math.abs(pitchMatrix[i-1][j-1] - pitchMatrix[i-1][j] - 12)) % 12;
         }
      }
      
   }
   
   public void printIntMatrix() // prints the full matrix
   {
      for(int i = 0; i < 12; i++)
      {
         for(int j = 0; j < 12; j++)
         {
            System.out.print(pitchMatrix[i][j] + " ");
         }
         System.out.println();
      }
   }
   
   public void printToneMatrix()
   {
            for(int i = 0; i < 12; i++)
      {
         for(int j = 0; j < 12; j++)
         {
            System.out.print(Pitch.convertInt(pitchMatrix[i][j]) + " ");
         }
         System.out.println();
      }
   }
   
   public int[][] getMatrix()
   {
      return pitchMatrix;
   }
}