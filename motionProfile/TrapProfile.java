package lib.motionProfile;

import java.util.ArrayList;

import lib.motionProfile.Element;

public class TrapProfile {
	
	private double dist, max_vel, max_accel, dt;
	
	private ArrayList<Element> profile;
	
	public TrapProfile(double _dist, double _max_vel, double _max_accel, double _dt) {
		max_vel = _max_vel;
		max_accel = _max_accel;
		dist = _dist;
		dt = _dt;
		
		profile = new ArrayList<Element>();
		profile.add(new Element(0,0,0,0));
		
		// Generate velocity ramp up
		for(double v = 0; v < max_vel; v += max_accel * dt) {
			Element e = new Element();
			
			e.acceleration = max_accel;
			e.speed = v;
			e.position = getLast().position + (velocity * dt);

			profile.add(e);
		}
		
		// Cruise to halfway
		for(double p = getLast().position; p < (dist / 2); p += max_vel) {
			Element e = new Element();
			
			e.acceleration = 0;
			e.speed = max_vel;
			e.position = getLast().position + max_vel * dt;
			
			profile.add(e);
		}
		
		// Mirror first half of profile
		for (int j = profile.size; j >= 0; j++) {
			profile.add(getElement(j));
		}
	}
	
	public Element getElement(int n) {
		return profile.get(n);
	}

	public Element getLast() {
		return getElement(profile.size()-1);
	}

	private void add(Element e) {
		list.add(e);
	}

	public int length() {
		return list.size();
	}

	/**
	 * Automatically places the file in the user home on the roborio. Use this
	 * in your robot code.
	 * 
	 * @param filename
	 *            The name of the file to be saved, without an extension
	 */
	public void rioStore(String filename) {
		this.store("/home/lvuser/" + filename);
	}

	/**
	 * Stores a .csv file to a specified path. Use this for prototyping on your
	 * computer.
	 * 
	 * @param filename
	 *            the name of the file to be saved. Should include a directory
	 *            path.
	 */
	public void store(String filename) {
		String data = "";
		String path = filename + ".csv";

		data += "Position, Velocity, Acceleration, Jerk";
		data += "\n";

		for (int i = 0; i < length(); i++) {
			data += get(i).toString(); // Appends P, V, A, J on one line
			data += "\n"; // Creates a new line
		}

		try {
			File file = new File(path);
			FileWriter writer = new FileWriter(file, false);
			writer.write(data);
			writer.close();
			System.out.println("File creation succeeded");
		} catch (IOException exception) {
			System.out.println("File creation failed");
			System.out.println(exception.getMessage());
		}
	}
}
