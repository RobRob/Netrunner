package netrunnerUI;

import netrunnerCode.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class IntroWindow extends JFrame {
	
	Container introContainer;
	String windowName;
	WindowManager windowManager;
	
	public IntroWindow(String name, WindowManager wM) throws IOException {
		windowName = name;
		windowManager = wM;
		
		setTitle("Netrunner App");
			
		setLocation(new Point(Netrunner.screenDimensions.width/4, Netrunner.screenDimensions.height/4));
		
		// Sets the container to a BorderLayout
	    introContainer = getContentPane();
		introContainer.setLayout(new BorderLayout());
		
		// Add a header to intro window
		JLabel introHeader = new JLabel("Welcome to the netrunner app");
		introHeader.setHorizontalAlignment(JLabel.CENTER);
		introContainer.add(introHeader, BorderLayout.PAGE_START);
		
		// Add an image to the intro window
		BufferedImage pictureFile = ImageIO.read(new File("res/netrunnerBanner.jpg"));
		JLabel nRBanner = new JLabel(new ImageIcon(pictureFile));
		introContainer.add(nRBanner, BorderLayout.CENTER);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowManager.displayWindow("main");
			}
		});
		buttonPane.add(enterButton);
		introContainer.add(buttonPane, BorderLayout.PAGE_END);
		
		// Scale window size to that of content
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String getName() {
		return windowName;
	}
}
