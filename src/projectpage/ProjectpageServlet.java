package projectpage;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ProjectpageServlet extends HttpServlet {
	protected static ComplexBoard board = new ComplexBoard();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String bigboard = req.getParameter("bboard");
		String smallboard = req.getParameter("lboard");
		String user = req.getParameter("user");

		Integer bigboardNum = Integer.parseInt(bigboard);
		Integer smallboardNum = Integer.parseInt(smallboard);
		Integer userNum = Integer.parseInt(user);
		
		boolean validMove = board.setPosition(bigboardNum, smallboardNum, userNum);
		boolean winGame = false;
		int nextBoardIndex = -1;
		if(validMove){
			boolean winBoard = board.checkBoardForWin(bigboardNum, userNum);
			winGame = board.checkOverallWin(userNum);
			if(board.boardIsClaimed(smallboardNum)) {
				nextBoardIndex = 9;
			}
			else {
				nextBoardIndex = smallboardNum;
			}
		}
		//doGet(req,resp);
		resp.getWriter().write(validMove + " " + nextBoardIndex + " " + winGame);
		
		
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(board.toString());
	}
	
}
