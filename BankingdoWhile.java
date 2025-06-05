import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    String name;
    boolean hasPassbook;

    public Account(String name, boolean hasPassbook) {
        this.name = name;
        this.hasPassbook = hasPassbook;
    }
}

public class CheckPassbook {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Alice", true));
        accounts.add(new Account("Bob", false));
        accounts.add(new Account("Charlie", true));
        accounts.add(new Account("Diana", false));

        Scanner scanner = new Scanner(System.in);
        int index = 0;
        String input;

        do {
            Account acc = accounts.get(index);
            System.out.println("Checking passbook for: " + acc.name);

            if (acc.hasPassbook) {
                System.out.println("✅ Passbook issued.");
            } else {
                System.out.println("❌ Passbook not issued.");
            }

            index++;

            if (index < accounts.size()) {
                System.out.print("\nCheck next account? (y/n): ");
                input = scanner.nextLine().trim().toLowerCase();
            } else {
                input = "n"; // end loop if all accounts checked
            }

        } while (input.equals("y"));

        System.out.println("\nAll done. Exiting.");
        scanner.close();
    }
}