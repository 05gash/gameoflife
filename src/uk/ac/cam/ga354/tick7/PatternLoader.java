package uk.ac.cam.ga354.tick7;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

public class PatternLoader {
 public static List<Pattern> load(Reader r) throws IOException {
	 BufferedReader buff = new BufferedReader(r);
	 List<Pattern> resultList = new LinkedList<Pattern>();
	 
	 while(true){
		 try{
		 String s = buff.readLine();
		 if (s != null){       //while there are still lines left to read, add them to resultList, Assuming they are good patterns
			 resultList.add(new Pattern(s));
		 }
		 else return resultList; //if reader has reached EOF, return the resultList.
		
		 } catch (PatternFormatException e){
			 System.out.println("Error in one or more of the patterns:");
			 System.out.println(e.errorMessage);
		 }
	 } 
	 
 } 
 
 public static List<Pattern> loadFromURL(String url) throws IOException {
	 URL destination = new URL(url);
	 URLConnection conn = destination.openConnection();
	 return load(new InputStreamReader(conn.getInputStream()));
	}
 
 public static List<Pattern> loadFromDisk(String filename) throws IOException {
	 return load(new FileReader(filename));
	}
 

 
}
