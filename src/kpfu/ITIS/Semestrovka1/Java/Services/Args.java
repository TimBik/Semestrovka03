package kpfu.ITIS.Semestrovka1.Java.Services;

public class Args {
    private static final String dbPath = "jdbc:postgresql://localhost:5432/CookYourself";
    private static final String dbUser = "postgres";
    private static final String dbPassword = "admin";
    private static final String dbDriver = "org.postgresql.Driver";

    public static String getDbDriver() {
        return dbDriver;
    }

    public static String getDbPath() {
        return dbPath;
    }

    public static String getDbUser() {
        return dbUser;
    }

    public static String getDbPassword() {
        return dbPassword;
    }
}
