package homework_1.messenger.servlets.ui;

import homework_1.messenger.core.dto.MessageDto;
import homework_1.messenger.core.dto.UserDto;
import homework_1.messenger.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChatsServlet", urlPatterns = "/ui/user/chats")
public class ChatsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto toUser = (UserDto) req.getSession().getAttribute("user");
        List<MessageDto> messageDtoList = MessageService.getInstance().getMessages(toUser.getLogin());
        req.setAttribute("message", messageDtoList);

        req.getRequestDispatcher("/jsp/Chats.jsp").forward(req, resp);
    }
}
