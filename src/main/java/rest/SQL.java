package rest;

import java.sql.*;
import java.time.Instant;

public class SQL {
    String Brugernavn;

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
    static String Schema = "laegedatabasen";
    static String url = "jdbc:mysql://localhost:3306/" + Schema;


    public void getSQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            if (connection != null) {
                System.out.println("Connected to MYSQL Schema:" + Schema);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
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
    public String getEKGDataFromTable(int ID) {
        getSQLConnection();
        String query1 = "SELECT * FROM laegedatabasen.brugerliste where ID=" + ID + ";";
        try {
            resultSet = statement.executeQuery(query1);
            resultSet.next();
                Brugernavn = resultSet.getString("fullname");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Brugernavn;
    }


    public void getTimeStamp(Timestamp lol) {


    }


    public void findEKGMeasureFromPatient(int ID) { //bliver brugt til at finde data.
        System.out.println("1");
        try {
            System.out.println("2");
            String SQL1 = "SELECT * FROM lægedatabase.brugerliste where fullname=" + ID + ";";
            //statement = connection.createStatement();
            System.out.println("3");
            ResultSet Result = statement.executeQuery(SQL1);

           // resultSet = statement.executeQuery(SQL);
            System.out.println("4");
            while (resultSet.next()) {
                System.out.println("5");
                System.out.println(
                        "ID: " + resultSet.getInt(1) + "\n" +
                                "EKGMaaling:" + resultSet.getInt("fullname") + "\n"
                );

                 String a=resultSet.getString("fullname") ;
                System.out.println(a);


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



}
