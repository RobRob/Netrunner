package netrunnerCode;

import java.util.*;
import javax.swing.*;

public class WindowManager {
	ArrayList<JFrame> windowList = new ArrayList<JFrame>(0);
	public WindowManager() {
		
	}
	
	public void addWindow(JFrame window, boolean visibility) {
		window.setVisible(visibility);
		windowList.add(window);
	}
	
	public void displayWindow(String name) {
		for (JFrame jF : windowList) {
			if (jF.getName().equals(name)) {jF.setVisible(true);}
			else {jF.setVisible(false);}
		}
	}
}
