/*
java code to generate music xml files. this class specificly handles the pitch section of the xml
*/


public class Pitch
{
   private String step; // pitch where 0 = c
   private int alter; // this will shift the pitch by a half step
   private int octave; // 4 is middle octave 
   
   public Pitch() 
   {
      step = "C";
      alter = 0;
      octave = 4;
   }
   
   public Pitch(String s, int o)
   {
      
      if(s.charAt(s.length() - 1) == 'b')
      {
         alter = -1;
      }
      
      else if(s.charAt(s.length() - 1) == '#')
      {
         alter = 1;
      } 
      
      else
      {
         alter = 0;
      }
      
      s += " ";
      step = s.substring(0,1);
      octave = o;
   }
   
   public Pitch(String s, int a, int o)
   {
      step = s;
      alter = a;
      octave = o;
   }
   
   public void setStep(String s)
   {
      if(s.charAt(s.length() - 1) == 'b')
      {
         alter = -1;
      }
      
      else if(s.charAt(s.length() - 1) == '#')
      {
         alter = 1;
      } 
      
      else
      {
         alter = 0;
      }
      
      s += " ";
      step = s.substring(0,1);
   }
   
   public void setOctave(int o)
   {
      octave = o;
   }
   
   public String getStep()
   {
      return step;
   }
   
   public int getOctave()
   {
      return octave;
   }
   
   public int getAlter()
   {
      return alter;
   }
   
   public static String convertInt(int i) //change an integer 0 - 11 into a pitch string
   {
      switch(i)
      {
         case 0:
            return "C";
            
         case 1:
            return "Db";
            
         case 2:
            return "D";
         
         case 3:
            return "Eb";
            
         case 4:
            return "E";
            
         case 5:
            return "F";
            
         case 6:
            return "Gb";
            
         case 7:
            return "G";
            
         case 8:
            return "Ab";
            
         case 9:
            return "A";
            
         case 10:
            return "Bb";
            
         case 11:
            return "B";
            
         default:
            return "Error";
      }
   
         
   }
   
   public String toString() // toString outputs xml for pitch in musescore 3.1
   {
      return "<pitch>\n\t<step>"+ step +"</step>\n\t<alter>"+ alter +"</alter>\n\t<octave>"+ octave +"</octave>\n\t</pitch>";
   }
   
}
