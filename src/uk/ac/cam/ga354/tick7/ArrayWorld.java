package uk.ac.cam.ga354.tick7;

public class ArrayWorld extends WorldImpl {

	 private boolean[][] cells;
	 
	 public void setCell(int col, int row, boolean alive) { 
		 if (row < 0 || row > this.getWidth()-1) return;
		 if (col < 0 || col > this.getHeight()-1) return;
		 cells[row][col] = alive;
	 }
	 
	 public boolean getCell(int col, int row) { 
		 if (row < 0 || row > this.getWidth()-1) return false;
		 if (col < 0 || col > this.getHeight()-1) return false;  //*TODO*// check to see if width/height are the right way round, if it gets weird at the edges put -1 on each.
		 return cells[row][col];
	 }
	 
	 protected ArrayWorld nextGeneration() {
		   ArrayWorld world = new ArrayWorld(this);
		   //TODO: Use for loops with "setCell" and "computeCell" to populate "world"
		   for (int col = 0; col < getHeight(); col++) { 
				 for (int row = 0; row < getWidth(); row++) {
				 world.setCell(col,row,computeCell(col,row));
				}
			}
		   return world;
		 }
	 
	 public ArrayWorld(int w, int h) {
		   super(w,h);
		   cells = new boolean[w][h];
		 }

		 protected ArrayWorld(ArrayWorld prev) {
		   super(prev);
		   cells = new boolean[getWidth()][getHeight()];
		 }
		 
	 

	 
	 
	 
	 
}
