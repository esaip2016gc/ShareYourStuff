package sell;

import entity.Ad;
import entity.Object;
import entity.TypeObject;
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
 * Created by guillaumebelouin on 16/07/2017.
 */
@WebServlet("/sell")
public class SellServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/sell.jsp");


        req.setAttribute("objectTypeList", TypeObject.getAll());
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:h2:~/sys");
            Statement stmt = con.createStatement();

            // Insert the object
            String insertObject = "INSERT INTO "+ Object.TABLE_NAME+"("+ Object.NAME+", "+Object.ID_TYPE+")"
                    + " VALUES('"+req.getParameter("inputName")+"', "+req.getParameter("inputProductType")+")";

            stmt.executeUpdate(insertObject);

            // Redirect to the home page
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
            requestDispatcher.forward(req, resp);
        } catch (SQLException e) {
            System.out.println("error : "+e);
            e.printStackTrace();
        }
    }
}
