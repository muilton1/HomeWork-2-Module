package homework_2.aviasales.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import homework_2.aviasales.dto.Flights;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FlightsPoolDao {
    private DataSource ds;
    public FlightsPoolDao() {
        ComboPooledDataSource pool = new ComboPooledDataSource();
        try {
            pool.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Проверь имя драйвера!!!!", e);
        }
        pool.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        pool.setUser("postgres");
        pool.setPassword("postgres");

        this.ds = pool;
    }

    public List<Flights> getAll() {
        List<Flights> flights = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT\n" +
                             "    flight_id,\n" +
                             "    flight_no,\n" +
                             "    scheduled_departure,\n" +
                             "    scheduled_arrival,\n" +
                             "    departure_airport,\n" +
                             "    arrival_airport,\n" +
                             "    status,\n" +
                             "    aircraft_code,\n" +
                             "    actual_departure,\n" +
                             "    actual_arrival\n" +
                             "FROM\n" +
                             "    bookings.flights;"
             );
        ) {
            while (resultSet.next()) {
                flights.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flights;
    }

    private Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

    private Flights map(ResultSet rs) throws SQLException {
        return new Flights(
                rs.getString("flight_id"),
                rs.getString("flight_no"),
                rs.getString("scheduled_departure"),
                rs.getString("scheduled_arrival"),
                rs.getString("departure_airport"),
                rs.getString("arrival_airport"),
                rs.getString("status"),
                rs.getString("aircraft_code"),
                rs.getString("actual_departure"),
                rs.getString("actual_arrival")
        );
    }

    public void close() throws Exception {
        DataSources.destroy(this.ds);
    }
}
