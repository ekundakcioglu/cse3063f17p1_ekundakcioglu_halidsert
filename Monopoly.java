import java.util.Scanner;

public class Monopoly {
	public static void main(String[] args) {
	
		Square[] board = new Square[40];
		for(int i = 0 ;i<40;i++){
			board[i] = new Square("Square " + (i + 1), i);
		}
		
		int totalPlayer = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many players will be playing: ");
		totalPlayer = scanner.nextInt();
		Player[] players = new Player[totalPlayer];
		
		for(int i = 0;i < players.length;i++){
			players[i] = new Player("Player " + (i + 1), 0, 2000);
		}
		
		
			
		for(int j=0; j<10; j++) {
			System.out.println("lap "+(j+1));
			for(int i = 0; i<totalPlayer; i++) {
				players[i].movePlayer();
				System.out.println(players[i].getName() + " moved to the "+ players[i].getLocation() + "th square.");
			}
		}
	}
}
