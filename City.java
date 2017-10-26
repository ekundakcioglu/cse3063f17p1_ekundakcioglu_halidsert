
public class City extends Square{
	int cost;
	public City(String name, int location, int cost) {
		super(name, location);
		this.cost = cost;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLocation() {
		return location;
	}
	
	public int getValue() {
		return cost;
	}

}
