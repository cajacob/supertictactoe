package projectpage;


public class ComplexBoard {
	
	//Board where:
	//0 = Empty
	//1 = X
	//2 = O
	private int [][] board;
	private int [] claimedBoards;
	
	public ComplexBoard() {
		//Make the board empty by default
		board = new int[9][9];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				board[i][j] = 0;
			}			
		}
		
		//No one starts off owning any boards
		claimedBoards = new int [9];
		for(int k=0; k<claimedBoards.length; k++) {
			claimedBoards[k] = 0;
		}
	}
	
	public int getPosition(int boardIndex, int index) {
		return board[boardIndex][index];
	}
	
	//Returns true if the move is valid and makes the move
	//Also checks if the move claimed a board and updates claimed boards
	public boolean setPosition(int boardIndex, int index, int value) {
		if(board[boardIndex][index] == 0) {
			board[boardIndex][index] = value;
			//Check if this move claimed the given board and update claimedBoards if needed
			if(claimedBoards[boardIndex] == 0) {
				if(checkBoardForWin(boardIndex, value)) 
					claimedBoards[boardIndex] = value;
			}
			return true;
		}
		return false;
	}
	
	public int[] getBoard(int index) {
		return board[index];
	}
	
	public boolean checkBoardForWin(int boardIndex, int team) {
		int [] simpleBoard = getBoard(boardIndex);
		
		//Check vertical options
		if(simpleBoard[0]==team && simpleBoard[3]==team && simpleBoard[6]==team)
			return true;
		if(simpleBoard[1]==team && simpleBoard[4]==team && simpleBoard[7]==team)
			return true;
		if(simpleBoard[2]==team && simpleBoard[5]==team && simpleBoard[8]==team)
			return true;
		
		//Check horizontal options
		if(simpleBoard[0]==team && simpleBoard[1]==team && simpleBoard[2]==team)
			return true;
		if(simpleBoard[3]==team && simpleBoard[4]==team && simpleBoard[5]==team)
			return true;
		if(simpleBoard[6]==team && simpleBoard[7]==team && simpleBoard[8]==team)
			return true;
		
		//Check diagonal options
		if(simpleBoard[0]==team && simpleBoard[4]==team && simpleBoard[8]==team)
			return true;
		if(simpleBoard[2]==team && simpleBoard[4]==team && simpleBoard[6]==team)
			return true;
		
		return false;
	}
	
	public boolean boardIsClaimed(int index) {
		if(claimedBoards[index] != 0) {
			return true;
		}
		else
			return false;
	}
	
	public boolean checkOverallWin(int team) {
		//Check vertical options
		if(claimedBoards[0]==team && claimedBoards[3]==team && claimedBoards[6]==team)
			return true;
		if(claimedBoards[1]==team && claimedBoards[4]==team && claimedBoards[7]==team)
			return true;
		if(claimedBoards[2]==team && claimedBoards[5]==team && claimedBoards[8]==team)
			return true;
		
		//Check horizontal options
		if(claimedBoards[0]==team && claimedBoards[1]==team && claimedBoards[2]==team)
			return true;
		if(claimedBoards[3]==team && claimedBoards[4]==team && claimedBoards[5]==team)
			return true;
		if(claimedBoards[6]==team && claimedBoards[7]==team && claimedBoards[8]==team)
			return true;
		
		//Check diagonal options
		if(claimedBoards[0]==team && claimedBoards[4]==team && claimedBoards[8]==team)
			return true;
		if(claimedBoards[2]==team && claimedBoards[4]==team && claimedBoards[6]==team)
			return true;
		
		return false;
	}
	
	public void reset() {
		//Set state back to initial state
		board = new int[9][9];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				board[i][j] = 0;
			}			
		}

		claimedBoards = new int [9];
		for(int k=0; k<claimedBoards.length; k++) {
			claimedBoards[k] = 0;
		}
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				builder.append(board[i][j]);
				builder.append(' ');
			}
		}
		String out = builder.toString();
		return out;
	}
	
	public String claimedBoardsString(){
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < 9; i++){
			builder.append(claimedBoards[i]);
			builder.append(' ');
		}
		return builder.toString();
	}

}
