package homework_1.messenger.servlets.ui;

import homework_1.messenger.service.StatisticService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminStatisticServlet", urlPatterns = "/ui/admin/statistics")
public class AdminStatisticServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("messages", StatisticService.getInstance().getSentMessages());
        req.setAttribute("loggedUsers", StatisticService.getInstance().getLoggedUsers());
        req.setAttribute("allUsers", StatisticService.getInstance().getAllUsers());

        req.getRequestDispatcher("/jsp/Statistic.jsp").forward(req, resp);
    }
}
