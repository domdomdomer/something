import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;

@WebServlet("/timestamp")
public class timestamp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Generate the current date and time
        String currentDateAndTime = new Date().toString();
        
        // Write the current date and time to the response
        response.setContentType("text/html");
        response.getWriter().println("Current Date and Time: " + currentDateAndTime);
    }
}
