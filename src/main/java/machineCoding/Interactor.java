package machineCoding;

import java.util.Scanner;

public class Interactor {
    private final Scanner scanner;

    public Interactor(final String mode) {
        this.scanner = new Scanner(System.in);
    }

    public int getNoOfPlayers() {
        System.out.println("Enter no. of players : ");
        return scanner.nextInt();
    }

    public String getNextPlayerName() {
        System.out.println("Enter next player");
        return scanner.next();
    }

    public void waitForUserEntry(final String message) {
        //Rolling for current player
        System.out.print("\n" + message);
        scanner.next();
    }

    public void close() {
        scanner.close();
    }
}
