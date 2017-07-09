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
import java.sql.*;

/**
 * Created by guillaumebelouin on 09/07/2017.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:h2:~/sys");
            Statement stmt = con.createStatement();

            // Create the query
            String getUser = "SELECT * FROM "+User.TABLE_NAME+" WHERE "+User.SURNAME+"=? AND " + User.PASSWORD + "=?";
            PreparedStatement pstmt = con.prepareStatement(getUser);
            pstmt.setString(1, req.getParameter("inputUsername"));
            pstmt.setString(2, req.getParameter("inputPassword"));

            // Get the user
            ResultSet resultSet = pstmt.executeQuery();
            User user = new User();
            while (resultSet.next()) {
                user.setSurname(resultSet.getString(User.SURNAME));
            }

            // We check if we get the user, else bad username or password
            if(user.getSurname() != null && user.getSurname() != "") {
                // Add the username in the session
                HttpSession session = req.getSession();
                session.setAttribute("username", req.getParameter("inputUsername"));

                // Redirect to the home page
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
                requestDispatcher.forward(req, resp);
            }
        } catch (SQLException e) {
            System.out.println("error : "+e);
            e.printStackTrace();
        }
    }
}
