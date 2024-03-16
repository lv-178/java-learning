import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);

            if (tokens[0].equals("add")) {
                try {
                    if (tokens.length == 2) {
                        executor.addCustomer(tokens[1]);
                    } else {
                        logger.error(CustomerStorage.addLog);
                        logger.info("Tried to add a customer - FAILED");
                        throw new ArgumentsException("");
                    }
                } catch (ArgumentsException e) {
                    System.out.println(CustomerStorage.addErrorMessage);
                } catch (FormatException e) {
                    System.out.println("Wrong email or phone format");
                }
            } else if (tokens[0].equals("list")) {
                executor.listCustomers();
            } else if (tokens[0].equals("remove")) {
                try {
                    if (tokens.length == 2) {
                        executor.removeCustomer(tokens[1]);
                    } else {
                        logger.error(CustomerStorage.removeLog);
                        logger.info("Tried to remove a customer - FAILED");
                        throw new ArgumentsException("");
                    }
                } catch (ArgumentsException e) {
                    System.out.println(CustomerStorage.removeErrorMessage);
                }
            } else if (tokens[0].equals("count")) {
                System.out.println("There are " + executor.getCount() + " customers");
            } else if (tokens[0].equals("help")) {
                logger.info("Request for help");
                System.out.println(helpText);
            } else {
                logger.info("Unknown command");
                System.out.println(COMMAND_ERROR);
            }
        }
    }
}
