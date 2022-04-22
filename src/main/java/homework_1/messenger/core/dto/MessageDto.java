package homework_1.messenger.core.dto;


import java.time.LocalDateTime;

public class MessageDto {
    private LocalDateTime sendTime;
    private UserDto fromUser;
    private UserDto toUser;
    private String message;

    public MessageDto(UserDto fromUser, UserDto toUser, String message) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.message = message;
        this.sendTime = LocalDateTime.now();
    }

    private MessageDto(){

    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

    public UserDto getFromUser() {
        return fromUser;
    }

    public void setFromUser(UserDto fromUser) {
        this.fromUser = fromUser;
    }

    public UserDto getToUser() {
        return toUser;
    }

    public void setToUser(UserDto toUser) {
        this.toUser = toUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("От пользователя: ").append("(").append(getFromUser()).append(")")
                .append("Текст сообщения:").append("(").append(getMessage()).append(")")
                .append(" в ").append("[").append(getSendTime()).append("]");
        return builder.toString();
    }
}
