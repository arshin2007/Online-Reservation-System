import java.util.*;

class User {
    String userId = "admin";
    String password = "1234";

    boolean login(String id, String pass) {
        return userId.equals(id) && password.equals(pass);
    }
}

class Reservation {
    int pnrCounter = 1000;
    Map<Integer, String> reservations = new HashMap<>();

    Scanner sc = new Scanner(System.in);

    void bookTicket() {
        System.out.println("\n--- Reservation Form ---");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Train Number: ");
        int trainNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Train Name: ");
        String trainName = sc.nextLine();

        System.out.print("Enter Class Type: ");
        String classType = sc.nextLine();

        System.out.print("Enter Journey Date: ");
        String date = sc.nextLine();

        System.out.print("From: ");
        String from = sc.nextLine();

        System.out.print("To: ");
        String to = sc.nextLine();

        int pnr = pnrCounter++;

        String details = "Name: " + name + ", Train: " + trainName +
                ", From: " + from + ", To: " + to + ", Date: " + date;

        reservations.put(pnr, details);

        System.out.println("Reservation Successful!");
        System.out.println("Your PNR Number: " + pnr);
    }

    void cancelTicket() {
        System.out.println("\n--- Cancellation Form ---");

        System.out.print("Enter PNR Number: ");
        int pnr = sc.nextInt();

        if (reservations.containsKey(pnr)) {
            System.out.println("Details: " + reservations.get(pnr));
            System.out.print("Confirm cancellation (yes/no): ");
            sc.nextLine();
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                reservations.remove(pnr);
                System.out.println("Ticket Cancelled Successfully!");
            } else {
                System.out.println("Cancellation Aborted.");
            }
        } else {
            System.out.println("Invalid PNR Number!");
        }
    }
}

public class OnResSys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        Reservation res = new Reservation();

        System.out.println("===== Online Reservation System =====");

        // Login
        System.out.print("Enter User ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (!user.login(id, pass)) {
            System.out.println("Invalid Login!");
            return;
        }

        System.out.println("Login Successful!");

        while (true) {
            System.out.println("\n1. Reservation");
            System.out.println("2. Cancellation");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    res.bookTicket();
                    break;
                case 2:
                    res.cancelTicket();
                    break;
                case 3:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}