package homework_1.messenger.servlets.api;

import homework_1.messenger.core.dto.MessageDto;
import homework_1.messenger.core.dto.UserDto;
import homework_1.messenger.service.MessageService;
import homework_1.messenger.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {
    private final MessageService service;
    private static final String USER = "user";
    private static final String SEND_TO = "toUser";
    private static final String MESSAGE = "message";

    public MessageServlet() {
        service = MessageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        UserDto toUser = (UserDto) req.getSession().getAttribute(USER);

        for (MessageDto messageDto : service.getMessages(toUser.getLogin())) {
            writer.write("<p>" + messageDto + "</p>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String toUser = req.getParameter(SEND_TO);
        String message = req.getParameter(MESSAGE);

        UserDto fromUser = (UserDto) req.getSession().getAttribute(USER);

        boolean flag = UserService.getInstance().isUserExist(fromUser.getLogin(), fromUser.getPassword());

        if (flag) {
            service.send(fromUser.getLogin(), toUser, message);
            resp.sendRedirect(req.getContextPath() + "/answer?answer=Your message delivered!");
        } else {
            resp.sendRedirect(req.getContextPath() + "/answer?answer=Your message was not delivered!");
        }
    }
}
