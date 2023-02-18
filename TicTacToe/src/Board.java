
import java.util.Random;
public class Board {
	
	private int[][]board=new int[3][3];
	public void instructionBoard()
	{
		System.out.println("| - | - | - |");
		System.out.println("| 1 | 2 | 3 |");
		System.out.println("| - | - | - |");
		System.out.println("| 4 | 5 | 6 |");
		System.out.println("| - | - | - |");
		System.out.println("| 7 | 8 | 9 |");
		System.out.println("| - | - | - |");
	}
	
	public void displayBoard()
	{
		System.out.println("| - | - | - |");
		System.out.println(printRow(0));
		System.out.println("| - | - | - |");
		System.out.println(printRow(1));
		System.out.println("| - | - | - |");
		System.out.println(printRow(2));
	}
	
	private String printRow(int row)
	{
		StringBuilder rowBuider = new StringBuilder("| ");
		for(int i=0;i<board[0].length;i++)
		{
			if(board[row][i]==0) rowBuider.append(" ");
			if(board[row][i]==1) rowBuider.append("X");
			if(board[row][i]==2) rowBuider.append("0");
			rowBuider.append(" | ");
		}
		rowBuider.deleteCharAt(rowBuider.lastIndexOf(" "));
		return rowBuider.toString();
	}
	
	
	public boolean placePiece(int position,String pieceType) {
		int row=(position-1)/3;
		int col=(position-(row*3))-1;
		if(board[row][col]==0)
		{
			if(pieceType.equals("X"))board[row][col]=1;
			if(pieceType.equals("X"))board[row][col]=2;
			return true;
		}
	   return false;
	}
	
	public boolean placePieceRandomly(String pieceType) {
		int row = new Random().nextInt(3);
		int col = new Random().nextInt(3);
		boolean wasPiecePlace=false;
		while(!wasPiecePlace && !isFull()) {
			if(board[row][col]==0)
			{
				wasPiecePlace=true;
				if(pieceType.equals("X"))board[row][col]=1;
				if(pieceType.equals("X"))board[row][col]=2;
				return true;
			}else {
				 row = new Random().nextInt(3);
				 col = new Random().nextInt(3);
			}
		}
		return wasPiecePlace;
		
	}
	
	public boolean isFull() {
		for(int row=0; row<board.length;row++) {
			for(int col=0;col<board[0].length;col++) {
				if(board[row][col]==0)return false;
			}
		}
		return true;
	}
	
	public int[][] getBoard(){
        return board;
    }

    public static class Cell{
        public int row;
        public int col;

        public Cell(int row, int col){
            this.row = row;
            this.col = col;
        }

}
}

