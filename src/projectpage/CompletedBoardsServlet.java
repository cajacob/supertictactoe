package projectpage;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompletedBoardsServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		String completedBoards = ProjectpageServlet.board.claimedBoardsString();
		resp.getWriter().write(completedBoards);
	}
	
}
