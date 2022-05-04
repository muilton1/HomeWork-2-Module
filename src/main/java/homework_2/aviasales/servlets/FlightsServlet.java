package homework_2.aviasales.servlets;

import homework_2.aviasales.dto.Airport;
import homework_2.aviasales.dao.AirportPoolDao;
import homework_2.aviasales.dto.Flights;
import homework_2.aviasales.service.FlightsPoolDaoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FlightsServlet", urlPatterns = "/flights")
public class FlightsServlet extends HttpServlet {
    private FlightsPoolDaoService service = new FlightsPoolDaoService();
    private AirportPoolDao dao = new AirportPoolDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Airport> airports = dao.getAll();

        req.setAttribute("airports", airports);
        req.getRequestDispatcher("/air_jsp/Flights.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int page=1;

        String fromAirport = req.getParameter("fromAirport");
        String toAirport = req.getParameter("toAirport");
        String fromDate = req.getParameter("fromDate");
        String toDate = req.getParameter("toDate");

        String fromAir = service.clean(fromAirport);
        String toAir = service.clean(toAirport);

        List<Flights> filtered = service.filterByAirportsAndDate(fromAir, toAir, fromDate, toDate);
        List<Flights> pages = service.getPage(filtered, page);

        req.setAttribute("pages",pages);
        req.setAttribute("page", page);
        req.setAttribute("filtered", filtered);

        req.getRequestDispatcher("/air_jsp/Filtered.jsp").forward(req, resp);
    }
}
