import java.util.Scanner;

public class Monopoly {
	public static void main(String[] args) {
		
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		
		Square[] board = new Square[40];
		for(int i = 0 ;i<40;i++){
			board[i] = new Square("Square " + (i + 1), i);
		}
		GoSquare gos = new GoSquare("Go", 1);
		FreeParkingSquare fps = new FreeParkingSquare("Free Parking", 20);
		IncomeTaxSquare its = new IncomeTaxSquare("Income Tax", 15);
		LuxuryTaxSquare lts = new LuxuryTaxSquare("Luxury Tax", 35);
		board[0] = gos;
		board[19] = fps;
		board[14] = its;
		board[34] = lts;
		
		
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
			players[i] = new Player(scanner.next(), 0, 200);
		}
		int d1=0,d2=0;
		for(int j=1; j<11; j++) {
			System.out.println("turn "+j);
			for(int i = 0; i<totalPlayer; i++) {
				System.out.println(players[i].getName() + " is at " + board[players[i].getLocation()].getName());
				d1 = dice1.roll();
				d2 = dice2.roll();
				System.out.println("Dice face values are "+d1+" and "+d2);
				System.out.println("Dice totals: " + (d1+d2));
				players[i].movePlayer(d1, d2);
				System.out.println(players[i].getName() + " moved to "+ board[players[i].getLocation()].getName());
				if(players[i].getLocation() == 1) {
					players[i].increaseMoney(200);
				}
				else if(players[i].getLocation() == 15) {
					players[i].increaseMoney(players[i].getMoney()/10);
				}
				else if(players[i].getLocation() == 35) {
					players[i].decreaseMoney(75);
				}
				System.out.println(players[i].getName() + " has  $" + players[i].getMoney()+"\n");
			}
		}
	}
}
