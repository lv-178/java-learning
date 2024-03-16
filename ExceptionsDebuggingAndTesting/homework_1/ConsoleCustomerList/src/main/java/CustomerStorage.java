import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;
    public static final String addLog = "Called ADD command with wrong number of arguments";
    public static final String addErrorMessage = "Wrong number of arguments, must be 4";
    public static final String removeLog = "Called REMOVE command with wrong number of arguments";
    public static final String removeErrorMessage = "Wrong number of arguments, must be 2";
    private static final Logger logger = LogManager.getLogger(CustomerStorage.class);

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws FormatException, ArgumentsException {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        String emailRegex = "[a-zA-Z][a-zA-Z0-9]*@[a-z]+.[a-z]+";
        String phoneRegex = "[+]7[0-9]{10}";

        String[] components = data.split("\\s+");
        if (components.length == 4) {
            if ((components[2].matches(emailRegex)) & (components[3].matches(phoneRegex))) {
                String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
                storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
                logger.info("Added one customer");
            } else {
                logger.error("Called ADD command with wrong email or phone format");
                logger.info("Tried to add a customer - FAILED");
                throw new FormatException("");
            }
        } else {
            logger.error(addLog);
            logger.info("Tried to add a customer - FAILED");
            throw new ArgumentsException("");
        }
    }

    public void listCustomers() {
        logger.info("Request for the list of all customers");
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) throws ArgumentsException {
        String[] components = name.split("\\s+");
        if (components.length == 2) {
            storage.remove(name);
            logger.info("One customer removed");
        } else {
            logger.error(removeLog);
            logger.info("Tried to remove a customer - FAILED");
            throw new ArgumentsException("");
        }
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        logger.info("Request for the number of customers");
        return storage.size();
    }
}