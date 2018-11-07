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
import java.util.Hashtable;
import java.util.List;

public class Configuration {

	private String blankSymbol;
	private Hashtable<String, State> stateDiagram;
	private String initialStateName;

	public Configuration(String blankSymbol, List<State> states)
			throws Exception {
		this.blankSymbol = blankSymbol;
		if (states == null || states.isEmpty()) {
			throw new Exception(
					"According to definition state diagram must be finite not empty set");
		}
		this.stateDiagram = new Hashtable<String, State>();
		this.initialStateName = states.get(0).getName();
		for (State state : states) {
			stateDiagram.put(state.getKey(), state);
		}
	}

	public String getBlankSymbol() {
		return blankSymbol;
	}

	public State getState(String name, String readValue) {
		State state = stateDiagram.get(State.generateKey(name, readValue));
		return state;
	}

	public String getInitialStateName() {
		return initialStateName;
	}

}
