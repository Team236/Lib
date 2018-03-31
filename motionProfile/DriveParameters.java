package lib.motionProfile;

public class DriveParameters {
	public double kP, kV, kV_l, kV_r, kA;

	public DriveParameters(double _kV_l, double _kV_r, double _kA, double _kP) {
		this.kV_l = _kV_l;
		this.kV_r = _kV_r;
		this.kA = _kA;
		this.kP = _kP;
	}
	
	public DriveParameters(double _kV, double _kA, double _kP) {
		this(_kV, _kV, _kA, _kP);
		this.kV = _kV;
	}
}
