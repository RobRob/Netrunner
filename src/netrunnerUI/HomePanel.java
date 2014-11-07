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

public class HomePanel extends JPanel {
	public HomePanel(LayoutManager l) {
		super(l);
		try {
		BufferedImage backgroundFile = ImageIO.read(new File("res/netrunnerBackground.jpg"));
		JLabel nRBackground = new JLabel(new ImageIcon(backgroundFile));
		this.add(nRBackground, BorderLayout.CENTER);
		} catch (IOException e) {
			
		}
	}
	
	public HomePanel() {
		this(new BorderLayout());
	}
}
