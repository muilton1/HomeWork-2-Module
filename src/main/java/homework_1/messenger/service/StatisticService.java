package homework_1.messenger.service;

public class StatisticService {
    private static final StatisticService instance = new StatisticService();

    private int loggedUsers;
    private int sentMessages;
    private int allUsers = 1;

    private StatisticService() {

    }

    public static StatisticService getInstance() {
        return instance;
    }

    public void incLoggedUsers() {
        loggedUsers++;
    }

    public void decLoggedUsers() {
        loggedUsers--;
    }

    public void incSentMessages() {
        sentMessages++;
    }

    public void incAllUsers() {
        this.allUsers++;
    }

    public int getSentMessages() {
        return sentMessages;
    }

    public int getAllUsers() {
        return allUsers;
    }

    public int getLoggedUsers() {
        return loggedUsers;
    }
}
