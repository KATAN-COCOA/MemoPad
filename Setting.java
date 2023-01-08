package org.example.MemoPad;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.*;

public class Setting extends JFrame implements ActionListener{
    
    //設定用
    public static int fontSize;
    
    private JPanel mainP; //メインパネル
    
    
    public Setting()
    {
        setBounds(300, 200, 300, 400);
        setTitle("設定");
        add(mainPanel());
        setVisible(true);
    }
    
    public JPanel mainPanel()
    {
        mainP = new JPanel();
        mainP.setLayout(new GridLayout(3, 1));
        
        //
        return mainP;
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        
    }
}