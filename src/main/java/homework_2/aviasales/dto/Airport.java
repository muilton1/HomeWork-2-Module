package homework_2.aviasales.dto;

public class Airport {
    private String code;
    private String name;
    private String city;
    private String coordinates;
    private String timezone;

    public Airport(String code, String name, String city, String coordinates, String timezone) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.coordinates = coordinates;
        this.timezone = timezone;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " :Код:'" + code + '\'' +
                ", Название: " + name + '\'' +
                ", Город: " + city + '\'' +
                ", Координаты: " + coordinates + '\'' +
                ", Часовой пояс:" + timezone + '\'';
    }
}
