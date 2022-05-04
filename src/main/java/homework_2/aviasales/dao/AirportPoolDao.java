package homework_2.aviasales.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import homework_2.aviasales.dto.Airport;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportPoolDao {
    private DataSource ds;
    public AirportPoolDao() {
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

    public List<Airport> getAll(){
        List<Airport> airports = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT\n" +
                             "    airport_code,\n" +
                             "    airport_name,\n" +
                             "    city,\n" +
                             "    coordinates,\n" +
                             "    timezone\n" +
                             "FROM\n" +
                             "    bookings.airports_data\n" +
                             "ORDER BY\n" +
                             "    airport_name;"
             );
        ) {
            while (resultSet.next()){
                airports.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return airports;
    }

    private Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

    private Airport map(ResultSet rs) throws SQLException {
        return new Airport(
                rs.getString("airport_code"),
                rs.getString("airport_name"),
                rs.getString("city"),
                rs.getString("coordinates"),
                rs.getString("timezone")
        );
    }

    public void close() throws Exception {
        DataSources.destroy(this.ds);
    }
}
