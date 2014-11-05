package netrunnerCode;

import netrunnerUI.*;
import netrunnerDB.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import javax.swing.*;

public class Netrunner {
	
	public static final Toolkit toolkit = Toolkit.getDefaultToolkit();
	public static final Dimension screenDimensions = toolkit.getScreenSize();
	
	public static final String[] sets = {"Any", "Core Set", "What Lies Ahead", "Trace Amount", "Cyber Exodus", "A Study In Static",
		"Humanity's Shadow", "Future Proof", "Creation And Control", "Opening Moves", "Second Thoughts", "Mala Tempora",
		"True Colors", "Fear And Loathing", "Double Time", "Honor And Profit", "Upstalk", "The Spaces Between"};
	
	public static final String[] types = {"Any", "Agenda", "Asset", "Event", "Hardware", "Ice", "Identity", "Operation",
		"Program", "Resource", "Upgrade"};
	
	public static final String[] subtypes = {"Any", "AI", "AP", "Advertisement", "Ambush", "Barrier", "Bioroid", "Black Ops",
			"Caissa", "Chip", "Clone", "Cloud", "Code Gate", "Condition", "Connection", "Console", "Current", "Cybernetic",
			"Cyborg", "Daemon", "Decoder", "Deflector", "Destroyer", "Division", "Double", "Executive", "Expansion", "Facility",
			"Fracter", "G-Mod", "Gear", "Government", "Gray Ops", "Hostile", "Icebreaker", "Illicit", "Initiative", "Job",
			"Killer", "Link", "Location", "Megacorp", "Mod", "Mythic", "NEXT", "Natural", "Observer", "Priority", "Psi",
			"Region", "Remote", "Research", "Ritzy", "Run", "Sabotage", "Security", "Seedy", "Sentry", "Stealth", "Sysop",
			"Tracer", "Transaction", "Trap", "Unorthodox", "Virtual", "Virus"};
	
	public static void main(String[] arg) throws IOException {
		
		WindowManager winMan = new WindowManager();
		
		IntroWindow iW = new IntroWindow("intro", winMan);
		winMan.addWindow(iW, true);
		
		MainWindow mW = new MainWindow("main", winMan);
		winMan.addWindow(mW, false);
	}
}
