package Databanken.Basis;


import java.sql.*;

public class Main{
    private final static String USER_ID = "prog2";
    private final static String PASSWD = "sesamopenu";
    private final static String JDBC_URL = "jdbc:derby://localhost:45270/prog2";
    public static void main(String[] args){
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER_ID, PASSWD);
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM student WHERE last_name like '%i%'")){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("last_name") + "\t" + resultSet.getString("first_name"));
            }
        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
