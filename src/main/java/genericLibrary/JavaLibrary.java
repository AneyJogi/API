package genericLibrary;

import java.util.Random;

public class JavaLibrary {
	
	 public int getRandomNum()
     {
	 Random ran= new Random();
	 int random= ran.nextInt(1000);
	 return random;
	 
     }

}
