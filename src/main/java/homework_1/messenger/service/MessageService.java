package homework_1.messenger.service;

import homework_1.messenger.core.dto.MessageDto;
import homework_1.messenger.core.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageService {
    private static final MessageService instance = new MessageService();
    private final Map<UserDto, List<MessageDto>> messages;

    UserService service = UserService.getInstance();

    public static MessageService getInstance() {
        return instance;
    }

    private MessageService() {
        this.messages = new ConcurrentHashMap<>();
    }

    public MessageDto create(UserDto fromWho, UserDto toWho, String message) {
        return new MessageDto(fromWho, toWho, message);
    }

    public void send(String fromTo, String toWho, String text) {
        UserDto toUser = service.getUser(toWho);
        UserDto fromUser = service.getUser(fromTo);
        if (service.getUsers().contains(fromUser)) {
            MessageDto message = create(fromUser, toUser, text);
            List<MessageDto> messageDtoList;

            if (messages.containsKey(toUser)) {
                messageDtoList = messages.get(toUser);
            } else {
                messageDtoList = new ArrayList<>();
            }

            messageDtoList.add(message);
            StatisticService.getInstance().incSentMessages();
            messages.put(toUser, messageDtoList);
        }
    }

    public List<MessageDto> getMessages(String toWho) {
        UserDto toUser = service.getUser(toWho);
        return messages.get(toUser);
    }
}
