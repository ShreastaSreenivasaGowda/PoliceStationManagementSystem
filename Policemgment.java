
import java.util.ArrayList;
import java.util.Scanner;

public class PoliceManagementSystem {

    static Scanner scan = new Scanner(System.in);

    static class Criminal {
        private int id;
        private String name;
        private int age;
        private String crime;

        public Criminal(int id, String name, int age, String crime) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.crime = crime;
        }

        @Override
        public String toString() {
            
            System.out.println("----------------------------------------------");
            return String.format("|%-5d |%-11s |%-9d |%-13s| %n", id, name, age, crime);
        }
    }

    static class PoliceStation {

        private ArrayList<Criminal> criminals;
        private int nextId;

        public PoliceStation() {
            this.criminals = new ArrayList<>();
            this.nextId = 1;
        }

        public void addCriminal(Criminal criminal) {
            criminal.id = nextId++;
            criminals.add(criminal);
            System.out.println("Criminal added successfully.");
        }

        public void displayCriminals() {
            if (criminals.isEmpty()) {
                System.out.println("No criminals in the database.");
            } 
            else {
                System.out.println("LIST OF CRIMINALS:");
                System.out.println();
                System.out.printf(" %-5s  %-11s  %-9s  %-13s  %n", "Id", "Name", "Age", "Crime ");
                for (Criminal criminal : criminals) {
                    System.out.println(criminal);
                }
            }
            System.out.println("----------------------------------------------");
        }
        
        public void modify(int id) {
            int indexToModify = -1;
            for (int i = 0; i < criminals.size(); i++) {
                if (criminals.get(i).id == id) {
                    indexToModify = i;
                    break;
                }
            }

            if (indexToModify != -1) {
                System.out.println("Enter new details for Criminal with ID " + id + ":");
                scan.nextLine(); 

                System.out.print("Enter new name: ");
                String newName = scan.nextLine();
                System.out.print("Enter new age: ");
                int newAge = scan.nextInt();
                scan.nextLine(); 

                System.out.print("Enter new crime: ");
                String newCrime = scan.nextLine();

                Criminal modifiedCriminal = criminals.get(indexToModify);
                modifiedCriminal.name = newName;
                modifiedCriminal.age = newAge;
                modifiedCriminal.crime = newCrime;

                System.out.println("Criminal with ID " + id + " modified successfully.");
            } 
            else 
            {
                System.out.println("Invalid ID. No criminal found with ID " + id);
            }
        }



        public void remove(int id) {
            Criminal cid = null;

            for (Criminal criminal : criminals) {
                if (criminal.id == id) {
                    cid = criminal;
                    break;
                }
            }

            if (cid != null) {
                criminals.remove(cid);
                System.out.println("Criminal with ID " + cid + " removed successfully.");
            } else {
                System.out.println("Invalid ID. No criminal found with ID " + cid);
            }
        }
    }

    public static void main(String[] args) {
        PoliceStation policeStation = new PoliceStation();

        while (true) {
            System.out.println("\nPolice Station Management System");
            System.out.println("1. Add Criminal");
            System.out.println("2. Display Criminals");
            System.out.println("3. Remove");
            System.out.println("4. Modify");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            

            int choice = scan.nextInt();
            scan.nextLine(); 
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter criminal name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter criminal age: ");
                    int age = scan.nextInt();
                    scan.nextLine(); 
                    System.out.print("Enter crime: ");
                    String crime = scan.nextLine();

                    Criminal newCriminal = new Criminal(0, name, age, crime);
                    policeStation.addCriminal(newCriminal);
                    break;

                case 2:
                    policeStation.displayCriminals();
                    break;

                case 3:
                    System.out.println("Enter the id to be deleted");
                    int id = scan.nextInt();
                    policeStation.remove(id);
                    break;
                    
                case 4:
                	System.out.println("Enter the id that has to be modify");
                	int cid=scan.nextInt();
                	policeStation.modify(cid);
                	break;
                	
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
           
        }
    }
}
