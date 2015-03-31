package uk.ac.cam.ga354.tick7; 
		
public class PackedLong {
			
 /*
  * Unpack and return the nth bit from the packed number at index position;
  * position counts from zero (representing the least significant bit)
  * up to 63 (representing the most significant bit).
  */
 public static boolean get(long packed, int position) {
  long check = 0;
  if ((packed>>position) % 2 == 0) check =0;
		else check = 1;
  return (check==1);
  
 }

 /*
  * Set the nth bit in the packed number to the value given
  * and return the new packed number
  */
 public static long set(long packed, int position, boolean value) {
  if (value) { 
		long x = 1;
		x = x<<position;
		packed = packed|(x);

  }
  else { 
		long x = 1; 
		x = ~(x<<position);
		packed =  packed&(x);
  }
  return packed;
 }
}


