package uk.ac.cam.ga354.tick7;

import uk.ac.cam.acr31.life.World;


public class Pattern {

	 private String name;
	 private String author;
	 private int width;
	 private int height;
	 private int startCol;
	 private int startRow;
	 private String cells;

	 public String getName() {
	  return name;
	 }
	 
	 public String getAuthor() {
		  return author;
		 }
	 
	 public int getWidth() {
		  return width;
		 }
	 
	 public int getHeight() {
		  return height;
		 }
	 
	 public int getStartCol() {
		  return startCol;
		 }
	 
	 public int getStartRow() {
		  return startRow;
		 }
	 
	 public String getCells(){
		 return cells;
	 }
	 
	 

	 public Pattern(String format) throws PatternFormatException{
		 

	 		String[] arguments = format.split(":");
			if (arguments.length !=7){
				throw new PatternFormatException("Wrong Number of Arguments, should be of the form name:authorc:width:heigh:startcolumn:startrow:data");
			}
	 		
			name = arguments[0];
			author = arguments[1];
			try{
			width = Integer.parseInt(arguments[2]);
	 		height = Integer.parseInt(arguments[3]);
	 		startCol = Integer.parseInt(arguments[4]);
	 		startRow = Integer.parseInt(arguments[5]);
		}
		catch (NumberFormatException error)
		{
			throw new PatternFormatException("Error in arguments, should be of the form name:authorc:width:heigh:startcolumn:startrow:data");
		}
	 		cells = arguments[6];
	
	 }

	 public void initialise(World world) throws PatternFormatException{
		 String[] startData = cells.split(" ");
		 char[][] usableData = new char[startData.length] [startData[0].length()];
	 		
	 		for (int i = 0; i<startData.length; i++){
	 			usableData[i] = startData[i].toCharArray();
	 		}
	 		
	 		for(int j = 0; j<usableData.length; j++){
	 			for (int i = 0; i<usableData[0].length; i++){
	 							
	 				if(usableData[j][i] == '1'){
	 					world.setCell(i+startCol,j+startRow, true);
	 				}else if (usableData[j][i] == '0'){
	 					
	 				}
	 				else throw new PatternFormatException("Data must be only 1s or 0s");
	 			}
	 		}
	 }
}

