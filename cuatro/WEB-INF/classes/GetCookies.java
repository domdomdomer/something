import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getcookies")
public class GetCookies extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get all cookies from the request
        Cookie[] cookies = request.getCookies();
        
        // Set response content type
        response.setContentType("text/html");
        
        // Get PrintWriter object
        PrintWriter out = response.getWriter();
        
        // Write HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>List Cookies</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>List of Cookies</h1>");
        if (cookies != null) {
            out.println("<ul>");
            for (Cookie cookie : cookies) {
                out.println("<li>" + cookie.getName() + " : " + cookie.getValue() + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>No cookies found!</p>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
