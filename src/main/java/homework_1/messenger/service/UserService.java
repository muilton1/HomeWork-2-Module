package homework_1.messenger.service;

import homework_1.messenger.core.ERole;
import homework_1.messenger.core.dto.UserDto;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserService {
    private static final UserService instance = new UserService();
    private final List<UserDto> users;

    public static UserService getInstance() {
        return instance;
    }

    private UserService() {
        this.users = new CopyOnWriteArrayList<>();
        UserDto admin = new UserDto("admin", "qwerty", "admin admin admin", "18.04.1997");
        admin.setRole(ERole.ADMIN);
        users.add(admin);
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public UserDto create(String login, String password, String name, String birthday) {
        UserDto user = new UserDto(login, password, name, birthday);
        user.setRole(ERole.USER);
        return user;
    }

    public void register(String login, String password, String name, String birthday) {
        UserDto user = create(login, password, name, birthday);

        for (UserDto userDto : users) {
            if (Objects.equals(userDto.getLogin(), user.getLogin())) {
                throw new IllegalArgumentException("Такой пользователь уже есть!");
            }
        }
        StatisticService.getInstance().incAllUsers();
        users.add(user);
    }

    public boolean isUserExist(String login, String password) {
        boolean result = false;

        for (UserDto userDto : users) {
            if (Objects.equals(userDto.getLogin(), login) && Objects.equals(userDto.getPassword(), password)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public UserDto getUser(String login) {
        UserDto find = null;

        for (UserDto user : users) {
            if (Objects.equals(user.getLogin(), login)) {
                find = user;
                break;
            }
        }
        return find;
    }
}

