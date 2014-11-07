package netrunnerCode;

import netrunnerUI.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;

public class Netrunner {
	
	public static final Toolkit toolkit = Toolkit.getDefaultToolkit();
	public static final Dimension screenDimensions = toolkit.getScreenSize();
	
	public static void main(String[] arg) throws IOException {
		
		WindowManager winMan = new WindowManager();
		IntroWindow iW = new IntroWindow("intro", winMan);
		winMan.addWindow(iW, true);
		
		MainWindow mW = new MainWindow("main", winMan);
		winMan.addWindow(mW, false);
	}
}
