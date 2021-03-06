


import java.awt.Color;

public class InfectedSymptomatic extends Human {

	public InfectedSymptomatic(Location loc, World w) {
		super(loc, w);
		myColor = Color.red;
	}
	
	public InfectedSymptomatic(int myLifeSpan, Location myLocation, Color myColor, World myWorld) {
		super(myLifeSpan, myLocation, myColor, myWorld);
	}

	
	public void move () {
		 int newX = this.getMyLocation().getX() + rgen.nextInt(-2,2);
	        int newY = this.getMyLocation().getY() +  rgen.nextInt(-2,2);
	        if (newX >= 0 && newX < 20 && newY >= 0 && newY < 20) {
	              validPosition = true;
	              for (LifeForm c: myWorld.getCreatureList()){
	                    if (c.getMyLocation().getX() == newX && c.getMyLocation().getY() == newY) {
	                             validPosition = false;
	                     }
	              }
	        }
	}
	
	public void checkInfection() {
		int myX = myLocation.getX();
		int myY = myLocation.getY();
		int myAge = this.getAge();
		if (this.getAge() <= 50) {
			if (rgen.nextInt (1,100) <= 80) {
				myWorld.getCreatureList().remove(this);
				myWorld.getCreatureList().add(new Recovered(80-myAge, new Location (myX,myY), Color.orange, myWorld));
			}
		}
		if (this.getAge() > 50) {
			if (rgen.nextInt (1,100) > 80) {
				myWorld.getCreatureList().remove(this);
			}
		}
	}
	

}
