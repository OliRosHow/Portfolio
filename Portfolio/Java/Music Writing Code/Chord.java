public class Chord
{
   Note[] chord;
   
   public Chord()
   {
      chord = new Note[3];
      chord[0] = new Note(new Pitch("C", 4), "whole");
      chord[1] = new Note(new Pitch("E", 4), "whole");
      chord[2] = new Note(new Pitch("G", 4), "whole");
   }
   
   public Chord(Note[] array)
   {
      chord = new Note[array.length];
      
      for(int i = 0; i < chord.length; i++)
      {
         chord[i] = array[i];
      }
   }
   
   public Chord(Note[] array, int v)
   {
      chord = new Note[array.length];
      
      for(int i = 0; i < chord.length; i++)
      {
         chord[i] = array[i];
         chord[i].setVoice(v);
      }
      
      
   }
   
   public void setVoice(int v)
   {
      for(int i = 0; i < chord.length; i++)
      {
         chord[i].setVoice(v);
      }
   }
   
   public void invert(int inversion)
   {
      for(int i = 0; i < inversion; i++)
      {
         chord[i % chord.length].getPitch().setOctave(chord[i % chord.length].getPitch().getOctave() + 1);
      }
   }
   
   public void revert(int reversion)
   {
      for(int i = 0; i < reversion; i++)
      {
          chord[i % chord.length].getPitch().setOctave(chord[i % chord.length].getPitch().getOctave() - 1);  
      }
   }
   
   public String toString()
   {
      String acumulatedString = (chord[0].toString() + "\n");
      
      for(int i = 1; i < chord.length; i++)
      {
         acumulatedString += (chord[i].toString().substring(0,7) + "<chord/>\n" + chord[i].toString().substring(7));
      }
      
      return acumulatedString;
   }
}