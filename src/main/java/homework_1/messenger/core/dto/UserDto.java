package homework_1.messenger.core.dto;

import homework_1.messenger.core.ERole;

import java.time.LocalDateTime;

public class UserDto {
    private String login;
    private String password;
    private String name;
    private String birthday;
    private LocalDateTime time;
    private ERole role;

    public UserDto(String login, String password, String name, String birthday) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.role = ERole.USER;
        this.time = LocalDateTime.now();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Логин: ")
                .append(getLogin())
                .append(" ,")
                .append("Имя: ")
                .append(getName())
                .append(" ");
        return builder.toString();
    }
}
