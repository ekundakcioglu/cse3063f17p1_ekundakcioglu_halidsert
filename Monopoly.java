import java.util.Scanner;

public class Monopoly {
	public static void main(String[] args) {
	
		Square[] board = new Square[40];
		for(int i = 0 ;i<40;i++){
			board[i] = new Square("Square " + (i + 1), i);
		}
		
		int totalPlayer = 0;
		Scanner scanner = new Scanner(System.in);
		while (totalPlayer < 2 || totalPlayer > 8) {
			try {
				System.out.println("How many people are playing?");
				System.out.print("Players (2 - 8): ");
				totalPlayer = scanner.nextInt();
			}
			catch(Exception e) {
				System.err.println("Error: Number too large.");
				continue;
			}
			if(totalPlayer > 8) {
				System.err.println("Error: Invalid player count.");
			}
		}
		
		Player[] players = new Player[totalPlayer];		
		for(int i = 0;i < players.length;i++){
			System.out.print("Please enter a player name : ");
			players[i] = new Player(scanner.next(), 0, 2000);
		}
			
		for(int j=1; j<10; j++) {
			System.out.println("turn "+j);
			for(int i = 0; i<totalPlayer; i++) {
				System.out.println(players[i].getName() + " is at the square "+players[i].getLocation());
				players[i].movePlayer();
				System.out.println(players[i].getName() + " moved to the square "+ players[i].getLocation()+"\n");
			}
		}
	}
}
