import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.text.SimpleDateFormat;

public class greet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve name from request parameter
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        // Retrieve session, or create new session if it doesn't exist
        HttpSession session = request.getSession();
        
        // If name is provided, store it in session along with start time
        if (name != null && !name.isEmpty()) {
            session.setAttribute("name", name);
            session.setAttribute("startTime", new Date());
            session.setAttribute("age", age);
        }

        // Get name and start time from session
        name = (String) session.getAttribute("name");
        Date startTime = (Date) session.getAttribute("startTime");
        age = (int) session.getAttribute("age");

        // Display greeting page with name and start time
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello " + name + "</title>");
        out.println("</head>");
        out.println("<body>");
        if(age<18){
            out.println("<h1>Hello " + name + ", you are not authorized to vist this website</h1>");
        }
        else{
            out.println("<h1>Welcom " + name + ", to this website</h1>");
        }
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
