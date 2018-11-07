package turingmachine.gui;

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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JOptionPane;

public class VersionChecker extends Thread {
	private String version;
	private String applicationName;
	private String versionFileUrl;

	public VersionChecker(String version, String applicationName,
			String versionFileUrl) {
		this.version = version;
		this.applicationName = applicationName;
		this.versionFileUrl = versionFileUrl;
	}

	public void run() {
		try {
			// String source =
			URL webPage = new URL(this.versionFileUrl);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					webPage.openStream()));
			String inputLine, newVersion = in.readLine();
			StringBuffer info = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				info.append("\n");
				info.append(inputLine);
			}
			if (!newVersion.equals(this.version)) {
				JOptionPane
						.showMessageDialog(
								null,
								"Your outdated  version for "
										+ this.applicationName
										+ " is "
										+ this.version
										+ "\nGet latest version from Help->Get Latest Release"
										+ info.toString(), "Version "
										+ newVersion + " is released!",
								JOptionPane.WARNING_MESSAGE);
			}
			in.close();
		} catch (Exception ex) {
			System.out.println("Version checker failed:" + ex.getMessage());
		}
	}

}
