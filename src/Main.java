import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Aquarium Fish Database ===");
        System.out.println();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add fish");
            System.out.println("2. Search fish by species");
            System.out.println("3. Search all fish");
            System.out.println("4. Delete fish");
            System.out.println("5. Find fish for your tank");
            System.out.println("6. Exit");
            System.out.println();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    return;
                default:
                    System.out.println("Wrong choice. Please try again.");
                    System.out.println();
            }
        }
    }
}
