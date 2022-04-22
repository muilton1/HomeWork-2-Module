package homework_1.messenger.servlets.api;

import homework_1.messenger.core.dto.UserDto;
import homework_1.messenger.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {
    private final UserService service;
    private static final String CHECK_LOGIN = "login";
    private static final String CHECK_PASSWORD = "password";
    private static final String USER = "user";

    public LoginServlet() {
        this.service = UserService.getInstance();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String login = req.getParameter(CHECK_LOGIN);
        String password = req.getParameter(CHECK_PASSWORD);

        boolean flag = service.isUserExist(login, password);

        if (flag) {
            UserDto user = service.getUser(login);
            HttpSession session = req.getSession();
            session.setAttribute(USER, user);
            resp.sendRedirect(req.getContextPath() + "/ui/user/message");
        } else {
            resp.sendRedirect(req.getContextPath() + "/answer?answer=Wrong login or password!");
        }
    }
}

