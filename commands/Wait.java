package commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Wait extends Command {
	double waitTime;
	int i = 0;

	public Wait(double seconds) {
		this.waitTime = seconds;
	}

	@Override
	protected void execute() {
		i++;
	}

	@Override
	protected boolean isFinished() {
		return (i / 50) > waitTime;
	}
}
