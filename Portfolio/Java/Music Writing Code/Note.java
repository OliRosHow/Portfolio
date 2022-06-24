public class Note
{
   private Pitch pitch;
   private int duration;
   private int voice;
   private String type;
   private boolean dot;
   
   public Note() // to create a C note of eigthnote value
   {
      pitch = new Pitch();
      duration = 1;
      type = "eighth";
      voice = 1;
      dot = false;  
   }
   
   public Note(String t) // to create rests 
   {
      pitch = null;
      duration = 1;
      type = t;
      voice = 1;
      dot = false;
   }
   
   public Note(String t, boolean d) // to create rests with dots
   {
      pitch = null;
      duration = 1;
      type = t;
      voice = 1;
      dot = d;
   }
   
   public Note(Pitch p, String t) // to create note
   {
      pitch = p;
      duration = 1;
      type = t;
      voice = 1;
      dot = false;  
   }
   
   public Note(Pitch p, int v)
   {
      pitch = p;
      duration = 1;
      type = "eighth";
      voice = v;
      dot = false;
   }
   
   public Note(Pitch p, String t, boolean d) // to create note with dot
   {
      pitch = p;
      duration = 1;
      type = t;
      voice = 1;
      dot = d; 
   }
   
   public Note(int v, String t) // create rest in a certain voice
   {
      pitch = null;
      duration = 1;
      voice = v;
      type = t;
      dot = false;
   }
   
   public Note(int v, String t, boolean d) // create a dotted rest in a certain voice
   {
      pitch = null;
      duration = 1;
      voice = v;
      type = t;
      dot = d;
   }
   
   public Note(Pitch p, int v, String t) // create a note in a certain voice
   {
      pitch = p;
      duration = 1;
      type = t;
      voice = v;
      dot = false;
   }
   
   public Note(Pitch p, int v, String t, boolean d) // create a dotted note of a certain voice
   {
      pitch = p;
      duration = 1;
      voice = v;
      type = t;
      dot = d;
   }
   
   public void setPitch(Pitch p)
   {
      pitch = p;
   }
   
   public void setVoice(int v)
   {
      voice = v;
   }
   
   public void setType(String t)
   {
      type = t;
   }
   
   public void setDot(boolean d)
   {
      dot = d;
   }
   
   public Pitch getPitch()
   {
      return pitch;
   }
   
   public int getVoice()
   {
      return voice;
   }
   
   public String getType()
   {
      return type;
   }
   
   public boolean getDot()
   {
      return dot;
   }
   
   public String toString() // outputs xml for musescore 3.1
   {
      if(dot && pitch != null) // for dotted notes
      {
         return "<note>\n"+ pitch +"\n<duration>1</duration>\n<voice>"+ voice + "</voice>\n<type>"+ type +"</type>\n<dot/>\n</note>";
      }
      else if (pitch == null && dot) //for dotted rest
      {
         return "<note>\n<rest/>\n<duration>1</duration>\n<voice>"+ voice + "</voice>\n<type>"+ type +"</type>\n<dot/>\n</note>";
      }
      else if(pitch == null)// for rest
      {
        return "<note>\n<rest/>\n<duration>1</duration>\n<voice>"+ voice + "</voice>\n<type>"+ type +"</type>\n</note>"; 
      }
      else // for note
      {
         return "<note>\n"+ pitch +"\n<duration>1</duration>\n<voice>"+ voice + "</voice>\n<type>"+ type +"</type>\n</note>";
      }
   }
}