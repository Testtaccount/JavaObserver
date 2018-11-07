package turingmachine.machine;

/**
 Copyright 2015 Kutay Bezci 
 This file is part of Turing Machine Simulation

 Turing machine simulation is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 Turing machine simulation is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with  Turing machine simulation.  If not, see <http://www.gnu.org/licenses/>.
 */
import turingmachine.machine.State.TapeOperation;

import java.util.List;


public class TuringMachine {
	private Configuration configuration;
	private InfiniteTape infiniteTape;

	public class TuringMachineResponse {
		private List<String> output;
		private String log;

		public List<String> getOutput() {
			return output;
		}

		public void setOutput(List<String> output) {
			this.output = output;
		}

		public String getLog() {
			return log;
		}

		public void setLog(String log) {
			this.log = log;
		}
	}

	public TuringMachine(Configuration configuration) {
		this.configuration = configuration;
	}

	private void execute(String stateName) throws Exception {
		String readValue = infiniteTape.read();
		State state = configuration.getState(stateName, readValue);
		System.out.println("Executing state(" + stateName + "," + readValue
				+ "):");
		System.out.println("WithTape:" + this.infiniteTape.printTapeAsString());
		if (state == null) {
			throw new Exception("State not found read:(" + readValue
					+ ") state:(" + stateName + ")");
		}
		if (state.getPrintValue() != null) {
			infiniteTape.print(state.getPrintValue());
		}
		if (TapeOperation.L == state.getTapeOperation()) {
			infiniteTape.left();
		} else if (TapeOperation.R == state.getTapeOperation()) {
			infiniteTape.right();
		}
		if (state.getNextState() != null && !"".equals(state.getNextState())) {
			execute(state.getNextState());
		}
	}

	public String run(List<String> inputs) throws Exception {
		this.infiniteTape = new InfiniteTape(
				this.configuration.getBlankSymbol());
		if (inputs != null && !inputs.isEmpty()) {
			infiniteTape.writeInput(inputs);
		}
		System.out.println("Initial tape:+"
				+ this.infiniteTape.printTapeAsString());
		execute(configuration.getInitialStateName());
		System.out.println("Finally:" + this.infiniteTape.printTapeAsString());
		return this.infiniteTape.printTapeAsString();

	}
}
