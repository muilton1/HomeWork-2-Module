package homework_1.messenger.servlets.api;

import homework_1.messenger.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "UserServlet", urlPatterns = "/api/user")
public class UserServlet extends HttpServlet {
    private final UserService service;
    private static final String REQUEST_LOGIN = "login";
    private static final String REQUEST_PASSWORD = "password";
    private static final String REQUEST_NAME = "name";
    private static final String REQUEST_BIRTHDAY = "birthday";

    public UserServlet() {
        this.service = UserService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String login = req.getParameter(REQUEST_LOGIN);
        String password = req.getParameter(REQUEST_PASSWORD);
        String name = req.getParameter(REQUEST_NAME);
        String birthday = req.getParameter((REQUEST_BIRTHDAY));

        boolean flag=service.isUserExist(login,password);

        if(!flag){
            service.register(login, password, name, birthday);
            resp.sendRedirect(req.getContextPath() + "/answer?answer=U are registered!");
        }else{
            resp.sendRedirect(req.getContextPath()+"/answer?answer=Login already exist!Try again");
        }
    }
}
