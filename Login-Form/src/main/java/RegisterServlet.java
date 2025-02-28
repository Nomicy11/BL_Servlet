import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Store user credentials in a static HashMap
    private static final HashMap<String, String> users = new HashMap<>();

    private static final String NAME_PATTERN = "^[A-Z][a-zA-Z]{2,}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).{8,}$";

    // Public method to access user data
    public static HashMap<String, String> getUsers() {
        return users;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        if (!Pattern.matches(NAME_PATTERN, user)) {
            request.setAttribute("error", "Invalid name! Name must start with a capital letter and be at least 3 characters long.");
            RequestDispatcher rd = request.getRequestDispatcher("register.html");
            rd.forward(request, response);
            return;
        }

        if (!Pattern.matches(PASSWORD_PATTERN, pwd)) {
            request.setAttribute("error", "Invalid password! Must be at least 8 characters, have 1 uppercase letter, 1 digit, and at least 1 special character.");
            RequestDispatcher rd = request.getRequestDispatcher("register.html");
            rd.forward(request, response);
            return;
        }

        if (users.containsKey(user)) {
            request.setAttribute("error", "Username already exists. Please choose a different one.");
            RequestDispatcher rd = request.getRequestDispatcher("register.html");
            rd.forward(request, response);
            return;
        }

        users.put(user, pwd); // Store user credentials in HashMap

        request.setAttribute("success", "Registration successful! You can now log in.");
        RequestDispatcher rd = request.getRequestDispatcher("login.html");
        rd.forward(request, response);
    }
}
