package rest;

import java.sql.*;
import java.time.Instant;

public class SQL {


    static private final SQL sqlOBJ = new SQL();

    static public SQL getSqlOBJ() {
        return sqlOBJ;
    }


    private static Connection connection;
    static Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    // indstillinger, valg af database
    static String username = "bruger1";
    static String password = "kode1";
    static String Schema = "lægedatabase";
    static String url = "jdbc:mysql://localhost:3306/" + Schema;


    public void getSQLConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            if (connection != null) {
                System.out.println("Connected to MYSQL Schema:" + Schema);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // metode til at lave en ny patient
    public void createNewPatient(String CPR) {
        String write_to_database1 = "INSERT INTO patienter (ID, CPR, Name) values(?,?,?);";
        try {
            preparedStatement = connection.prepareStatement(write_to_database1);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, CPR);
            preparedStatement.setString(3, CPR);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            System.out.println("CPR eksisterer allerede i systemet.");
        }
    }


    // metode til at skrive data i databsen
    public void insertIntoTable(String CPR, double EKGdata) {
        Timestamp tid = Timestamp.from(Instant.now());

        //læg data i skema
        String SQL = "insert into maalinger (CPR,EKGMeasure,Time) values(?,?,?);";
        try {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, CPR);
            preparedStatement.setDouble(2, EKGdata);
            preparedStatement.setTimestamp(3, tid);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // metode til at hente EKG data fra tabel
    public void getEKGDataFromTable(String CPR, double[] arkiv) {
        String query1 = "SELECT * FROM lægedatabase.patient where CPR=" + CPR + ";";
        int i = 0;
        try {
            resultSet = statement.executeQuery(query1);
            while (resultSet.next() && i < 500) {
                arkiv[i] = resultSet.getDouble("CPR");
                i++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getTimeStamp(Timestamp lol) {


    }


    public void findEKGMeasureFromPatient(int ID) { //bliver brugt til at finde data.
        String SQL = "SELECT * FROM semesterprojekt2.maalinger where CPR=" + ID + ";";
        try {
            //statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                System.out.println(
                        "ID: " + resultSet.getInt(1) + "\n" +
                                "EKGMaaling:" + resultSet.getInt("EKGMeasure") + "\n" +
                                "CPR:" + resultSet.getInt("CPR") + "\n" +
                                "time:" + resultSet.getTimestamp("time") + "\n"

                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    // stop forbindelsen til databasen
    public void stopSQLConnection() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String hentLogin(String s) throws SQLException {
        SQL.getSqlOBJ().getSQLConnection();
        PreparedStatement pp = connection.prepareStatement("SELECT * FROM lægedatabase.brugerliste WHERE USERNAME = ?;");
        pp.setString(1, s);
        String svar = "";
        try {
            ResultSet rs = pp.executeQuery();
            while (rs.next()) {
                svar = svar + rs.getString(1);
                svar = svar + "A" + rs.getString(2);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        SQL.getSqlOBJ().stopSQLConnection();
        return svar;

    }


}
