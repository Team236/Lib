package lib.commands;

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
	protected void initialize() {
		i = 0;
	}

	@Override
	protected void execute() {
		i++;
	}

	@Override
	protected boolean isFinished() {
		return (i / 50.0) > waitTime;
	}

	@Override
	protected void end() {
	}
}
