package kpfu.ITIS.Semestrovka1.Java.Services;

import kpfu.ITIS.Semestrovka1.Java.Helper.Args;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class modelService<T> {
    public static Connection getConnection() {
        try {
            Class.forName(Args.getDbDriver());
            return DriverManager.getConnection(Args.getDbPath(), Args.getDbUser(), Args.getDbPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
