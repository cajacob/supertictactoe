package projectpage;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ProjectpageServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String bigboard = req.getParameter("fname");
		String smallboard = req.getParameter("lname");
		System.out.println(bigboard);
		System.out.println(smallboard);
		//doGet(req,resp);
		resp.getWriter().write(bigboard + " " + smallboard);
		
		
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write("smile");
	}
	
}
