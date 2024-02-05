import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;

public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        Date startTime = (Date) session.getAttribute("startTime");

        // Calculate duration of usage
        long duration = System.currentTimeMillis() - startTime.getTime();

        // Display logout page
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Logout</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Thank You " + name + "</h1>");
        out.println("<p>Duration of Usage: " + (duration / 1000) + " seconds</p>");
        out.println("</body>");
        out.println("</html>");

        // Invalidate session
        session.invalidate();
    }
}
