package home;

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
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by guillaumebelouin on 28/06/2017.
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

        // Init database structure
        TypeObject.initStructure();
        Object.initStructure();
        User.initStructure();
        Ad.initStructure();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
