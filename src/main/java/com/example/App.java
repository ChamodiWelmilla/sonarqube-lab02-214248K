package main.java.com.example;

import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args) throws Exception {
        
        Calculator calc = new Calculator();
        if (logger.isLoggable(Level.INFO)) {
            logger.info(() -> String.format("Result: %s", calc.calculate(10, 5, "add-again")));
        }        
        UserService service = new UserService();
        
        try {
            service.findUser("admin");
            logger.info("User found successfully.");

            service.deleteUser("admin"); 
            logger.info("User deleted successfully.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Database error occurred", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An unexpected error occurred", e);
        }
    }

}

