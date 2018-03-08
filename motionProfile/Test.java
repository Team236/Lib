package lib.motionProfile;

public class Test {

	public static void main(String[] args) {
		double maxSpeed = 100;
		double accel = 200;
		double dist = 500;
		
		TrapProfile p = new TrapProfile(dist, maxSpeed, accel, 1/100.0);
		
		p.store("test");
	}
}
