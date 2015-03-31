package uk.ac.cam.ga354.tick7;

public class PackedWorld extends WorldImpl{
	
	private long cells;
	
	public static int bitPosition (int col, int row) {
		 return row*8+col;
	}

	public static int getRow (int i) {
		return (i / 8);
	}

	public static int getCol (int i) {
		return (i % 8);
	}
	
	
	
	public boolean getCell(int col, int row) { 
		return ((col|row)<0)|((col|row)>7) ? false : PackedLong.get(cells,(bitPosition(col,row)));
		 }
	
	public void setCell(int col, int row, boolean alive) { 
		 
		cells = ((col|row)<0)|((col|row)>7) ? cells :  PackedLong.set(cells, bitPosition(col,row), alive);
	 }
	
	protected PackedWorld nextGeneration() {
		   PackedWorld world = new PackedWorld(this);
		   //TODO: Use for loops with "setCell" and "computeCell" to populate "world"
		   for (int col = 0; col < getHeight(); col++) { 
				 for (int row = 0; row < getWidth(); row++) {
				 world.setCell(col,row,computeCell(col,row));
				}
			}
		   return world;
		 }
	
	
	 public PackedWorld() {
		   super(8,8);
		   cells = 0;
		 }

		 protected PackedWorld(PackedWorld prev) {
			 super(prev);
		   cells = 0;
		 }
	
	

}
