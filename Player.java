
public class Player {
	String name;
	int location,money,amount;
	
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
	
	public int increaseMoney() {
		return money+amount;
	}
	
	public int decreaseMoney() {
		return money-amount;
	}
	public int movePlayer() {
		location = (location + 2 + (int)(Math.random()*10)) % 40;
		return location;
	}
}