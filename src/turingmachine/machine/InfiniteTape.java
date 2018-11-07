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
import java.util.ArrayList;
import java.util.List;

public class InfiniteTape {
	public class TapeChunk {
		private TapeChunk left;
		private TapeChunk right;
		private String value;

		public TapeChunk(String blankSymbol) {
			this.value = blankSymbol;
		}

		public TapeChunk getLeft() {
			return left;
		}

		public void setLeft(TapeChunk left) {
			this.left = left;
		}

		public TapeChunk getRight() {
			return right;
		}

		public void setRight(TapeChunk right) {
			this.right = right;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	private TapeChunk head;
	private String blankSymbol;

	public InfiniteTape(String blankSymbol) {
		this.blankSymbol = blankSymbol;
		this.head = new TapeChunk(blankSymbol);
	}

	public String read() {
		return head.getValue();
	}

	public void print(String printValue) {
		this.head.setValue(printValue);
	}

	public void erase() {
		print(this.blankSymbol);
	}

	public void left() {
		if (this.head.getLeft() == null) {
			this.head.setLeft(new TapeChunk(this.blankSymbol));
			this.head.getLeft().setRight(this.head);
		}
		this.head = head.getLeft();
	}

	public void right() {
		if (this.head.getRight() == null) {
			this.head.setRight(new TapeChunk(this.blankSymbol));
			this.head.getRight().setLeft(this.head);
		}
		this.head = head.getRight();
	}

	public List<String> printTape() {
		List<String> tapePrint = new ArrayList<String>();
		TapeChunk iterator = this.head;
		while (iterator.getLeft() != null) {
			iterator = iterator.getLeft();
		}
		while (iterator.getRight() != null) {
			tapePrint.add(iterator.getValue());
			iterator = iterator.getRight();
		}
		tapePrint.add(iterator.getValue());
		return tapePrint;
	}

	public String printTapeAsString() {
		StringBuffer sb = new StringBuffer();
		sb.append("<-...");
		List<String> chunks = printTape();
		for (String chunk : chunks) {
			sb.append(chunk);
			sb.append(",");
		}
		sb.append("...->");
		return sb.toString();
	}

	public void writeInput(List<String> inputs) {
		for (int i = 0; i < inputs.size(); i++) {
			print(inputs.get(i));
			if (i != inputs.size() - 1) {
				right();
			}
		}
		while (this.head.left != null) {
			this.head = this.head.left;
		}
	}

	public static void main(String arg[]) {
		try {
			InfiniteTape infiteTape = new InfiniteTape("0");
			List<String> inputs = new ArrayList<String>();
			inputs.add("A");
			inputs.add("B");
			infiteTape.writeInput(inputs);
			System.out.println(infiteTape.printTape().toString());

			for (int i = 1; i < 10; i++) {
				infiteTape.left();
				infiteTape.print("" + i);
			}
			System.out.println(infiteTape.printTape().toString());
			for (int i = 1; i < 10; i++) {
				infiteTape.right();
				infiteTape.print("" + i);
			}
			System.out.println(infiteTape.printTape().toString());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
