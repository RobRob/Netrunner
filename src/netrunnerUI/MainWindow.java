package netrunnerUI;
import netrunnerCode.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	
	WindowManager windowManager;
	String windowName;
	SearchForm search;
	
	public MainWindow(String name, WindowManager wM) throws IOException {
		windowName = name;
		windowManager = wM;
		search = new SearchForm();
		
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
		JPanel homePanel = new JPanel();
		buildHomePanel(homePanel);
		
		// Search section
		JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buildSearchPanel(searchPanel);
		
		// Card display section
		JPanel cataloguePanel = new JPanel();
		buildCataloguePanel(cataloguePanel);
		
		// Deck section
		JPanel deckPanel = new JPanel();
		buildDeckPanel(deckPanel);
		
		JTabbedPane tabbedPane = new JTabbedPane();
        
		tabbedPane.addTab("Home", homePanel);
        tabbedPane.addTab("Search", searchPanel);
        tabbedPane.addTab("Display Cards", cataloguePanel);
        tabbedPane.addTab("Deckbuilder", deckPanel);
        add(tabbedPane);
		
		pack();
	}
	
	public void buildHomePanel(JPanel homeP) throws IOException {
		BufferedImage backgroundFile = ImageIO.read(new File("res/netrunnerBackground.jpg"));
		JLabel nRBackground = new JLabel(new ImageIcon(backgroundFile));
		homeP.add(nRBackground, BorderLayout.CENTER);
	}
	
	public void buildSearchPanel(JPanel searchP) {
		
		Container searchBar = new Container();
		searchBar.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.NONE;
		
		
		JLabel searchBarHeaderL = new JLabel("SEARCH BAR");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		searchBar.add(searchBarHeaderL, c);
		
		JLabel cardTitleL = new JLabel("Card Title: ");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		searchBar.add(cardTitleL, c);
		
		final JTextField cardTitleTF = new JTextField(20);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		searchBar.add(cardTitleTF, c);
		
				
		// Card Text Body
		JLabel cardTextL = new JLabel("Card Text: ");
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 3;
		searchBar.add(cardTextL, c);
		
		final JTextField cardTextTF = new JTextField(20);
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		searchBar.add(cardTextTF, c);
		
		
		// Card Flavour Text
		JLabel cardFlavourTextL = new JLabel("Card Flavour Text: ");
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 3;
		searchBar.add(cardFlavourTextL, c);
		
		final JTextField cardFlavourTextTF = new JTextField(20);
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 3;
		searchBar.add(cardFlavourTextTF, c);
		
		
		// Card Side (Corporation/Runner)
		JLabel sideL = new JLabel("Side: ");
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 3;
		searchBar.add(sideL, c);
				
				// Collected group of the radio buttons
				ButtonGroup sideRadio = new ButtonGroup();
				
				final JRadioButton eitherRB = new JRadioButton("Either");
				sideRadio.add(eitherRB);
				c.gridx = 0;
				c.gridy = 8;
				c.gridwidth = 1;
				searchBar.add(eitherRB, c);
				
				final JRadioButton corpRB = new JRadioButton("Corp");
				sideRadio.add(corpRB);
				c.gridx = 1;
				c.gridy = 8;
				c.gridwidth = 1;
				searchBar.add(corpRB, c);
				
				final JRadioButton runnerRB = new JRadioButton("Runner");
				sideRadio.add(runnerRB);
				c.gridx = 2;
				c.gridy = 8;
				c.gridwidth = 1;
				searchBar.add(runnerRB, c);
				
				// End of this group of radio buttons
		
				
		// Card Faction Association		
		JLabel factionL = new JLabel("Faction: ");
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 3;
		searchBar.add(factionL, c);
		
		final JCheckBox anarchCB = new JCheckBox("Anarch");
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 1;
		searchBar.add(anarchCB, c);
		
		final JCheckBox criminalCB = new JCheckBox("Criminal");
		c.gridx = 1;
		c.gridy = 10;
		c.gridwidth = 1;
		searchBar.add(criminalCB, c);
		
		final JCheckBox shaperCB = new JCheckBox("Shaper");
		c.gridx = 2;
		c.gridy = 10;
		c.gridwidth = 1;
		searchBar.add(shaperCB, c);
		
		final JCheckBox haasbioroidCB = new JCheckBox("Haas-Bioroid");
		c.gridx = 0;
		c.gridy = 11;
		c.gridwidth = 1;
		searchBar.add(haasbioroidCB, c);
		
		final JCheckBox jintekiCB = new JCheckBox("Jinteki");
		c.gridx = 1;
		c.gridy = 11;
		c.gridwidth = 1;
		searchBar.add(jintekiCB, c);
		
		final JCheckBox nbnCB = new JCheckBox("NBN");
		c.gridx = 2;
		c.gridy = 11;
		c.gridwidth = 1;
		searchBar.add(nbnCB, c);
		
		final JCheckBox weylandCB = new JCheckBox("Weyland");
		c.gridx = 0;
		c.gridy = 12;
		c.gridwidth = 1;
		searchBar.add(weylandCB, c);
		
		final JCheckBox neutralCB = new JCheckBox("Neutral");
		c.gridx = 1;
		c.gridy = 12;
		c.gridwidth = 1;
		searchBar.add(neutralCB, c);
		
				// Nested Container for Card Set Association (Core/Data Pack/Deluxe Expansion)
		
				Container cardSetContainer = new Container();
				cardSetContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
				
				JLabel setL = new JLabel("Set: ");
				cardSetContainer.add(setL);
	
				final JComboBox<String> setDB = new JComboBox<String>();
				for (String setName : Netrunner.sets) {setDB.addItem(setName);}
				cardSetContainer.add(setDB);
				c.gridx = 0;
				c.gridy = 13;
				c.gridwidth = 3;
				c.anchor = GridBagConstraints.CENTER;
				searchBar.add(cardSetContainer, c);
				
				
				// Nested Container for Type Keywords
				
				Container typeContainer = new Container();
				typeContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
				
				JLabel typeL = new JLabel("Type: ");
				typeContainer.add(typeL);
	
				final JComboBox<String> typeDB = new JComboBox<String>();
				for (String typeName : Netrunner.types) {typeDB.addItem(typeName);
				typeContainer.add(typeDB);
				
				c.gridx = 0;
				c.gridy = 14;
				c.gridwidth = 3;
				c.anchor = GridBagConstraints.CENTER;
				searchBar.add(typeContainer, c);
				
				
				// Nested container for Subtype Keywords
				
				Container subtypeContainer = new Container();
				subtypeContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
			
				JLabel subtypeL = new JLabel("Subtype: ");
				subtypeContainer.add(subtypeL);
	
				final JComboBox<String> subtypeDB = new JComboBox<String>();
				for (String subtypeName : Netrunner.subtypes) {subtypeDB.addItem(subtypeName);}
				subtypeContainer.add(subtypeDB);
				
				c.gridx = 0;
				c.gridy = 15;
				c.gridwidth = 3;
				c.anchor = GridBagConstraints.CENTER;
				searchBar.add(subtypeContainer, c);
	
				
	// Card Uniqueness
	JLabel uniqueL = new JLabel("Unique: ");
	c.gridx = 0;
	c.gridy = 16;
	c.gridwidth = 3;
	searchBar.add(uniqueL, c);
			
			// Group for uniqueness radio buttons
			ButtonGroup uniqueRadio = new ButtonGroup();
			
			final JRadioButton uniqueEitherRB = new JRadioButton("Either");
			uniqueRadio.add(uniqueEitherRB);
			c.gridx = 0;
			c.gridy = 17;
			c.gridwidth = 1;
			searchBar.add(uniqueEitherRB, c);
			
			final JRadioButton uniqueYesRB = new JRadioButton("Yes");
			uniqueRadio.add(uniqueYesRB);
			c.gridx = 1;
			c.gridy = 17;
			c.gridwidth = 1;
			searchBar.add(uniqueYesRB, c);
			
			final JRadioButton uniqueNoRB = new JRadioButton("No");
			uniqueRadio.add(uniqueNoRB);
			c.gridx = 2;
			c.gridy = 17;
			c.gridwidth = 1;
			searchBar.add(uniqueNoRB, c);
	
			
	// Card Cost
	JLabel costL = new JLabel("Cost: ");
	c.gridx = 0;
	c.gridy = 18;
	c.gridwidth = 1;
	searchBar.add(costL, c);
			
			// Nested container for cost input and comparator
			Container costContainer = new Container();
			costContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			final JComboBox<String> costComparatorDB = new JComboBox<String>();
			costComparatorDB.addItem("=");
			costComparatorDB.addItem(">");
			costComparatorDB.addItem("<");
			costContainer.add(costComparatorDB);
			
			final JTextField costTF = new JTextField(10);
			costContainer.add(costTF);
			
			c.gridx = 1;
			c.gridy = 18;
			c.gridwidth = 2;
			searchBar.add(costContainer, c);
			
	JLabel influenceL = new JLabel("Influence: ");
	c.gridx = 0;
	c.gridy = 19;
	c.gridwidth = 1;
	searchBar.add(influenceL, c);
			
			Container influenceContainer = new Container();
			influenceContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			final JComboBox<String> influenceComparatorDB = new JComboBox<String>();
			influenceComparatorDB.addItem("=");
			influenceComparatorDB.addItem(">");
			influenceComparatorDB.addItem("<");
			influenceContainer.add(influenceComparatorDB);
			
			final JTextField influenceTF = new JTextField(10);
			influenceContainer.add(influenceTF);
			
			c.gridx = 1;
			c.gridy = 19;
			c.gridwidth = 2;
			searchBar.add(influenceContainer, c);
			
			Container sortByContainer = new Container();
			sortByContainer.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			JLabel sortByL = new JLabel("Sort by: ");
			sortByContainer.add(sortByL);
	
			final JComboBox<String> sortByDB = new JComboBox<String>();
			sortByDB.addItem("Name");
			sortByDB.addItem("Set");
			sortByDB.addItem("Faction");
			sortByDB.addItem("Type");
			sortByDB.addItem("Cost");
			sortByContainer.add(sortByDB);
			
			c.gridx = 0;
			c.gridy = 20;
			c.gridwidth = 3;
			searchBar.add(sortByContainer, c);
			
	JButton searchButton = new JButton("Search");
	c.gridx = 0;
	c.gridy = 21;
	c.gridwidth = 3;
	searchBar.add(searchButton, c);
	
	searchButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			search.setTitle(cardTitleTF.getText());
			search.setText(cardTextTF.getText());
			search.setFlavourText(cardFlavourTextTF.getText());
			
			if (eitherRB.isSelected()) {search.setSide(netrunnerEnums.Side.EITHER);}
			else if (corpRB.isSelected()) {search.setSide(netrunnerEnums.Side.CORP);}
			else if (runnerRB.isSelected()) {search.setSide(netrunnerEnums.Side.RUNNER);}
			
			if (anarchCB.isSelected()) {search.setFaction(0);}
			else {search.removeFaction(0);}
			if (criminalCB.isSelected()) {search.setFaction(1);}
			else {search.removeFaction(1);}
			if (shaperCB.isSelected()) {search.setFaction(2);}
			else {search.removeFaction(2);}
			if (haasbioroidCB.isSelected()) {search.setFaction(3);}
			else {search.removeFaction(3);}
			if (jintekiCB.isSelected()) {search.setFaction(4);}
			else {search.removeFaction(4);}
			if (nbnCB.isSelected()) {search.setFaction(5);}
			else {search.removeFaction(5);}
			if (weylandCB.isSelected()) {search.setFaction(6);}
			else {search.removeFaction(6);}
			if (neutralCB.isSelected()) {search.setFaction(7);}
			else {search.removeFaction(7);}
			
			search.setSet((String)setDB.getSelectedItem());
			search.setType(typeDB.getSelectedItem());
			search.setSubType(subtypeDB.getSelectedItem());
			
			if (uniqueEitherRB.isSelected()) {search.setUnique(netrunnerEnums.Unique.ANY);}
			else if (uniqueYesRB.isSelected()) {search.setUnique(netrunnerEnums.Unique.YES);}
			else if (uniqueNoRB.isSelected()) {search.setUnique(netrunnerEnums.Unique.NO);}
			
			search.setCostComparator(costComparatorDB.getSelectedItem());
			
			if (!costTF.getText().equals("")) {
				search.setCost(Integer.parseInt(costTF.getText()));
			}
			
			
			search.setInfluenceComparator(influenceComparatorDB.getSelectedItem());
			
			if (!influenceTF.getText().equals("")) {
				search.setInfluence(Integer.parseInt(influenceTF.getText()));
			}
			
			search.setSortBy(sortByDB.getSelectedItem());
			
			search.getResults();
			
		}
	});
	
	}
			
	searchP.add(searchBar);
	}
	
	public void buildCataloguePanel(JPanel catP) {
		
	}
	
	public void buildDeckPanel(JPanel deckP) {
		
	}
	
	public String getName() {
		return windowName;
	}
}
