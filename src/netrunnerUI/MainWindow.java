package netrunnerUI;
import netrunnerCode.*;
import netrunnerDB.CardDatabase;
import netrunnerEnums.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.util.*;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	WindowManager windowManager;
	String windowName;
	JPanel homePanel, searchPanel, cataloguePanel, deckPanel;
	
	public MainWindow(String name, WindowManager wM) throws IOException {
		windowName = name;
		windowManager = wM;
		
		setTitle("HQ");
		setLocation(new Point(Netrunner.screenDimensions.width/4, Netrunner.screenDimensions.height/4));
		
		//_____________________MENUBAR________________________
		JMenuBar mainMenuBar = new JMenuBar();
		setJMenuBar(mainMenuBar);
		
		JMenu sysMenu = new JMenu("System");
		mainMenuBar.add(sysMenu);
		
		JMenuItem quitMI = new JMenuItem("Quit");
		sysMenu.add(quitMI);
		//_______________________END OF MENU BAR_______________
		
		// Home section
		homePanel = new HomePanel();
		
		// Search section
		searchPanel = new SearchPanel(new BorderLayout());
		
		// Card display section
		cataloguePanel = new JPanel();
		buildCataloguePanel(cataloguePanel);
		
		// Deck section
		deckPanel = new JPanel();
		buildDeckPanel(deckPanel);
		
		JTabbedPane tabbedPane = new JTabbedPane();
        
		tabbedPane.addTab("Home", homePanel);
        tabbedPane.addTab("Search", searchPanel);
        tabbedPane.addTab("Display Cards", cataloguePanel);
        tabbedPane.addTab("Deckbuilder", deckPanel);
        add(tabbedPane);
		
		pack();
	}
	
	public void buildCataloguePanel(JPanel catP) {
		
	}
	
	public void buildDeckPanel(JPanel deckP) {
		
	}
	
	public String getName() {
		return windowName;
	}
}
