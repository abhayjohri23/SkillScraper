package com.SkillScraper;

import javax.swing.*;
import java.awt.*;

public final class Window {
    private static Window appWindow;
    private static JFrame frame;
    private static Image searchImage;
    private static Image nextButtonImage;
    private static Image backButtonImage;
    private static final Color blueColor=new Color(0,155,255);

    private Window()
    {
        frame=new JFrame("SkillScraper");
        frame.setPreferredSize(new Dimension(1000,500));
        frame.setLocation(100,100);
        frame.setLayout(new BorderLayout());
    }

    public static Window getWindow()
    {
        if(appWindow==null)
            appWindow=new Window();
        return appWindow;
    }

    public static void setUpWindow()
    {
        Color backColor=new Color(255,255,255);
        Container mainContainer=frame.getContentPane();
        mainContainer.setBackground(backColor);
        mainContainer.setLayout(new BorderLayout(8,6));

        ToolbarPanel.addTools();
        ContentPanel.loadPanel();
        LeftPanel.loadLeftPanel();

        mainContainer.add(ToolbarPanel.topPanel,BorderLayout.NORTH);
        mainContainer.add(LeftPanel.leftPanel,BorderLayout.WEST);
        mainContainer.add(ContentPanel.centralLabel,BorderLayout.CENTER);

        ToolbarPanel.addListenersToButtons();

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}