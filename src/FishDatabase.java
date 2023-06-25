import java.sql.*;
public class FishDatabase {
    private Connection connection;

    public FishDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:fish.db");
            dropTable();
            createTable();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    private void dropTable() {
        String query = "DROP TABLE IF EXISTS Fish";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("Error drop table: " + e.getMessage());
        }
    }
    private void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS Fish (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "SPECIES TEXT NOT NULL, " +
                "NAME TEXT NOT NULL, " +
                "TANK_SIZE INTEGER NOT NULL," +
                "MIN_PH INTEGER NOT NULL," +
                "MAX_PH INTEGER NOT NULL" +
                ")";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }
    public void addFish(Fish fish) {
        String query = "INSERT INTO Fish (SPECIES, NAME, TANK_SIZE, MIN_PH, MAX_PH) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, fish.getSpecies());
            statement.setString(2, fish.getName());
            statement.setInt(3, fish.getTankSize());
            statement.setInt(4, fish.getMinPh());
            statement.setInt(5, fish.getMaxPh());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding fish: " + e.getMessage());
        }
    }
    public boolean deleteFish(int id) {
        String query = "DELETE FROM Fish WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting fish: " + e.getMessage());
            return false;
        }
    }
}
