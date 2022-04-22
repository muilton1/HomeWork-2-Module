package homework_1.messenger.servlets.listeners;

import homework_1.messenger.service.StatisticService;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Objects;

@WebListener
public class StatisticListener implements HttpSessionAttributeListener {
    private final StatisticService service;
    private static final String USER = "user";

    public StatisticListener() {
        service = StatisticService.getInstance();
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        String user = httpSessionBindingEvent.getName();
        if (Objects.equals(user, USER)) {
            service.incLoggedUsers();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        String user = httpSessionBindingEvent.getName();
        if (Objects.equals(user, USER)) {
            service.decLoggedUsers();
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}

