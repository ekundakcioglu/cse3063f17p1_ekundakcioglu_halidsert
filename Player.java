
public class Player {
	String name;
	int location,money;
	
	public Player(String playerName, int location, int money) {
		name = playerName;	
		this.location = location;
		this.money = money;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLocation() {
		return location;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int increaseMoney(int amount) {
		money = money + amount;
		return money;
	}
	
	public int decreaseMoney(int amount) {
		money = money - amount;
		return money;
	}
	public int movePlayer(int dicevalue1, int dicevalue2) {
		location = (location + dicevalue1 + dicevalue2) % 40;
		return location;
	}
}