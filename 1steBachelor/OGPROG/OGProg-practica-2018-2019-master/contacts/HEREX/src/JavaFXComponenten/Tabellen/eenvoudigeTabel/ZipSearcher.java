package JavaFXComponenten.Tabellen.eenvoudigeTabel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZipSearcher {
    private static final String JDBC_URL = "jdbc:sqlite::resource:zipcodes.sqlite";

    public Iterable<ZipInfo> find(String prefix) {
        System.out.println("opgeroepen");
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT zip,name FROM town WHERE " +
                             "name LIKE ? || '%' OR " +
                             "zip LIKE ? || '%'"
             )) {
            preparedStatement.setString(1, prefix);
            preparedStatement.setString(2, prefix);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<ZipInfo> output = new ArrayList<>();
                while (resultSet.next()) {
                    output.add(new ZipInfo(
                            resultSet.getString("zip"),
                            resultSet.getString("name")
                    ));
                }
                return output;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException( "zoekopdracht heeft gefaald", e);
        }
    }
}
