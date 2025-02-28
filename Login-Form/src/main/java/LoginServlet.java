import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        // Get the stored user data from RegisterServlet
        HashMap<String, String> users = RegisterServlet.getUsers();

        if (users.containsKey(user) && users.get(user).equals(pwd)) {
            // Successful login
            request.setAttribute("user", user);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            // Failed login
            request.setAttribute("error", "Invalid username or password.");
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.forward(request, response);
        }
    }
}
