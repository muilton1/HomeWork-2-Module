package homework_2.aviasales.servlets;

import homework_2.aviasales.dao.AirportPoolDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AirServlet", urlPatterns = "/airports")
public class AirServlet extends HttpServlet {
    private AirportPoolDao dao = new AirportPoolDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("airports", dao.getAll());
        req.getRequestDispatcher("/air_jsp/Airports.jsp").forward(req, resp);
    }
}
