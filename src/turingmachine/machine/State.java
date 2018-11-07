package turingmachine.machine;

/**
 * Copyright 2015 Kutay Bezci This file is part of Turing Machine Simulation
 * 
 * Turing machine simulation is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Turing machine simulation is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * Turing machine simulation. If not, see <http://www.gnu.org/licenses/>.
 */
public class State {
	public enum TapeOperation {
		L, R, N
	};

	private String name;
	private String readValue;
	private String printValue;
	private TapeOperation tapeOperation;
	private String nextState;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReadValue() {
		return readValue;
	}

	public void setReadValue(String readValue) {
		this.readValue = readValue;
	}

	public String getPrintValue() {
		return printValue;
	}

	public void setPrintValue(String printValue) {
		this.printValue = printValue;
	}

	public TapeOperation getTapeOperation() {
		return tapeOperation;
	}

	public void setTapeOperation(TapeOperation tapeOperation) {
		this.tapeOperation = tapeOperation;
	}

	public String getNextState() {
		return nextState;
	}

	public void setNextState(String nextState) {
		this.nextState = nextState;
	}

	public String getKey() {
		return generateKey(name, readValue);
	}

	public static String generateKey(String name, String readValue) {
		return name + "," + readValue;
	}
}
