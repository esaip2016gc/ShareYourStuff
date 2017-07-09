package auth;

import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by guillaumebelouin on 28/06/2017.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/register.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:h2:~/sys");
            Statement stmt = con.createStatement();

            String insertUser = "INSERT INTO "+ User.TABLE_NAME+"("+ User.FIRSTNAME+", "+ User.LASTNAME+
                    ", "+ User.SURNAME+", "+ User.AGE+", "+ User.TEL+", "+ User.MAIL+", "+ User.PASSWORD+")"
                    + " VALUES('"+req.getParameter("inputFirstname")+"', '"+req.getParameter("inputLastname")+"'" +
                    ", '"+req.getParameter("inputUsername")+"', "+req.getParameter("inputAge")+"" +
                    ", '"+req.getParameter("inputTel")+"', '"+req.getParameter("inputMail")+"' " +
                    ", '"+req.getParameter("inputPassword")+"' )";

            stmt.executeUpdate(insertUser);

            // Add the username in the session
            HttpSession session = req.getSession();
            session.setAttribute("username", req.getParameter("inputUsername"));

            // Redirect to the home page
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
            requestDispatcher.forward(req, resp);
        } catch (SQLException e) {
            System.out.println("error : "+e);
            e.printStackTrace();
        }
    }
}
