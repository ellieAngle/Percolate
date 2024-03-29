import java.util.*;
public class PercolationBFS extends PercolationDFSFast {
	/*
	 * @param n: integer representing the number of rows and columns in grid
	 * Initializes variables from PercolationDFS using super(n)
	 */
	public PercolationBFS(int n) {
		super(n);
	}
	/*
	 * @param row: integer representing selected row of opened cell
	 * @param col: integer representing selected column of opened cell
	 * Uses a queue to determine which cells need to be full
	 * full cells are queued then dequeued, and their neighboring cells are checked
	 * The method stops once there are no more cells needing filling
	 *
	 */
	@Override
	protected void dfs(int row, int col) {
		Queue<Integer> que = new LinkedList<Integer>();
		myGrid[row][col] = FULL;
		int putIn = helperGetInt(row, col);
		que.add(putIn);
		while (que.size() > 0) {
			int cell = que.remove();
			int r = cell/myGrid.length;
			int c = cell % myGrid.length;
			if (inBounds(r+1, c) && isOpen(r+1, c) && ! isFull(r+1,c)) {
				myGrid[r+1][c] = FULL;
				int p = helperGetInt(r +1, c);
				que.add(p);
				
			}
			if (inBounds(r-1, c) && isOpen(r-1, c) && ! isFull(r-1,c)) {
				myGrid[r-1][c] = FULL;
				int t = helperGetInt(r-1, c);
				que.add(t);
			}
			if (inBounds(r, c+1) && isOpen(r, c+1) && ! isFull(r,c+1)) {
				myGrid[r][c+1] = FULL;
				int n = helperGetInt(r, c+1);
				que.add(n);
			}
			if (inBounds(r, c-1) && isOpen(r, c-1) && ! isFull(r,c-1)) {
				myGrid[r][c-1] = FULL;
				int y = helperGetInt(r, c-1);
				que.add(y);
			}
		}
			
		
	}	
	public int helperGetInt(int row, int col) {
		int totSize = myGrid.length;
		return (row*totSize) + col;
	}
}
	
