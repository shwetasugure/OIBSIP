import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ReservationSystem {
    private static int pnrCounter = 101;
    private List<ReservationDetails> reservations;

    public ReservationSystem() {
        reservations = new ArrayList<>();
    }

    private String getPNR() {
        return "PNR" + pnrCounter++;
    }

    public void makeReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter train number: ");
        int trainNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter date of journey: ");
        String date = scanner.nextLine();
        System.out.print("Enter source: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        String pnr = getPNR();
        ReservationDetails reservation = new ReservationDetails(pnr, name, trainNo, classType, date, source, destination);
        reservations.add(reservation);

        System.out.println("\nReservation Details");
        System.out.println("PNR: " + pnr);
        System.out.println("Name: " + name);
        System.out.println("Train Number: " + trainNo);
        System.out.println("Class Type: " + classType);
        System.out.println("Date of Journey: " + date);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
    }

    public void cancelReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your PNR: ");
        String pnr = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < reservations.size(); i++) {
            ReservationDetails reservation = reservations.get(i);
            if (reservation.getPNR().equals(pnr)) {
                found = true;

                System.out.println("\nCancellation Details for PNR: " + pnr);
                System.out.println("Name: " + reservation.getName());
                System.out.println("Train Number: " + reservation.gettrainNo());
                System.out.println("Class Type: " + reservation.getClassType());
                System.out.println("Date of Journey: " + reservation.getdate());
                System.out.println("Source: " + reservation.getSource());
                System.out.println("Destination: " + reservation.getDestination());

                System.out.print("Do you want to confirm the cancellation? (Y/N): ");
                String confirmation = scanner.nextLine();

                if (confirmation.equalsIgnoreCase("Y")) {
                    reservations.remove(i);
                    System.out.println("Your reservation has been cancelled.");
                } else {
                    System.out.println("Cancellation aborted.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid PNR. No reservation found.");
        }
    }
}

class ReservationDetails {
    private String pnr;
    private String name;
    private int trainNo;
    private String classType;
    private String date;
    private String source;
    private String destination;

    public ReservationDetails(String pnr, String name, int trainNo, String classType, String date, String source, String destination) {
        this.pnr = pnr;
        this.name = name;
        this.trainNo = trainNo;
        this.classType = classType;
        this.date = date;
        this.source = source;
        this.destination = destination;
    }

    public String getPNR() {
        return pnr;
    }

    public String getName() {
        return name;
    }

    public int gettrainNo() {
        return trainNo;
    }

    public String getClassType() {
        return classType;
    }

    public String getdate() {
        return date;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        System.out.print("Enter your login id: ");
        String loginId = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (authenticate(loginId, password)) {
            System.out.println("\nWelcome to the Online Reservation System!");

            boolean isLoggedIn = true;
            while (isLoggedIn) {
                System.out.println();
                System.out.println("1. Make a reservation");
                System.out.println("2. Cancel a reservation");
                System.out.println("3. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        reservationSystem.makeReservation();
                        break;
                    case 2:
                        reservationSystem.cancelReservation();
                        break;
                    case 3:
                        isLoggedIn = false;
                        System.out.println("Logged out successfully.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Invalid login credentials. Access denied.");
        }
    }

    private static boolean authenticate(String loginId, String password) {
        return loginId.equals("user") && password.equals("pass123");
    }
}