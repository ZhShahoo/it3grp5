package rest;

import java.sql.*;
import java.time.Instant;

public class SQL {
    String Brugernavn;
    String Adgangskode;
    String CPR;
    String dato;
    String startTidspunkt;
    String slutTidspunkt;
    String sundhedsPersonale;
    String aftalePerson;
    String  notat;



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
                Adgangskode = resultSet.getString("password");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Brugernavn;
    }

    public String retrieveAftale(int ID) {
        getSQLConnection();
        String query1 = "SELECT * FROM laegedatabasen.patient where ID=" + ID + ";";
        try {
            resultSet = statement.executeQuery(query1);
            resultSet.next();
            System.out.println(
            CPR = resultSet.getString("CPR"));
            dato = resultSet.getString("dato");
            startTidspunkt = resultSet.getString("starttid");
            slutTidspunkt = resultSet.getString("sluttid");
            sundhedsPersonale = resultSet.getString("sundhedspersonale");
            aftalePerson = resultSet.getString("aftaleperson");
            notat= resultSet.getString("notater");



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return query1;
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
