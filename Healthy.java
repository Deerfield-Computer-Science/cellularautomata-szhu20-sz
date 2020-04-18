

import java.awt.Color;

public class Healthy extends Human {

	public Healthy(Location loc, World w) {
		super(loc, w);
		myColor = Color.green;
	}
	
	public Healthy(int myLifeSpan, Location myLocation, Color myColor, World myWorld) {
		super(myLifeSpan, myLocation, myColor, myWorld);
	}
		
	public void checkInfection() {
		
	}
	
	public void move () {
        int newX = this.getMyLocation().getX() + rgen.nextInt(-2,2);
        int newY = this.getMyLocation().getY() +  rgen.nextInt(-2,2);
        if (newX >= 0 && newX < 100 && newY >= 0 && newY < 100) {
              validPosition = true;
              for (LifeForm c: myWorld.getCreatureList()){
                    if (c.getMyLocation().getX() == newX && c.getMyLocation().getY() == newY) {
                             validPosition = false;
                     }
                }
          }
         
       if (validPosition = true) {
   			myLocation.setX(newX);
   			myLocation.setY(newY);
        }
     }  
	
	public void infect () {
		int myX = myLocation.getX();
		int myY = myLocation.getY();
		int myAge = this.getAge();
		for (LifeForm c: myWorld.getCreatureList()){
			if (Math.abs(c.getMyLocation().getX() - myX)<=2 && Math.abs(c.getMyLocation().getY() - myY)<=2) {
				if (c.getClass().getName().equals("InfectedSymptomatic") || c.getClass().getName().equals("InfectedSymptomatic")) {
					//if (rgen.nextInt(1,100) > 30) {
						myWorld.getCreatureList().remove(this);
						if (rgen.nextInt(1,100) <50) {
							myWorld.getCreatureList().add(new InfectedSymptomatic (80-myAge, new Location (myX,myY), Color.RED, myWorld));
						}
						if (rgen.nextInt(1,100)>50) {
							myWorld.getCreatureList().add(new InfectedAsymptomatic (80-myAge, new Location (myX,myY), Color.yellow, myWorld));
						}
					}
				}
			//}
		}
	}
	
}

