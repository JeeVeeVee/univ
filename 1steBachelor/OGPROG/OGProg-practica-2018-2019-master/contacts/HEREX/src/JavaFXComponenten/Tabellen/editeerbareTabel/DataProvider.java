package JavaFXComponenten.Tabellen.editeerbareTabel;

import JavaFXComponenten.Tabellen.editeerbareTabel.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private final static String USER_ID = "prog2";
    private final static String PASSWD = "sesamopenu";
    private final static String JDBC_URL = "jdbc:derby://localhost:45270/prog2";
    private Connection connection;

    public DataProvider(){
        try {
            connection = DriverManager.getConnection(JDBC_URL, USER_ID, PASSWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Iterable<Student> getStudents(int courseID){
        try (PreparedStatement ps = connection.prepareStatement(
                "SELECT student_id, course_id,last_name, first_name, value "
                        + "FROM student,mark WHERE student_id=id AND course_id = ? "
                        + "ORDER BY last_name, first_name")) {
            ps.setInt(1, courseID);
            try (ResultSet resultSet = ps.executeQuery()){
                List<Student> output = new ArrayList<>();
                while (resultSet.next()){
                    output.add(new Student(resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getInt("value")));
                }
                return output;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getCourseName(int courseID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT title FROM course WHERE id = ?");
        ){
            preparedStatement.setInt(1, courseID);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    return resultSet.getString("title");
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
