package org.example.MemoPad;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

public class Setting extends JFrame implements ActionListener{
    
    //設定用
    public static int fontSize;

    private JPanel mainP;
    private JPanel fontNameP;
    private JPanel fontStyleP;
    private JPanel fontSizeP; //メインパネル


    /*
    * コンストラクタ
     */
    public Setting()
    {
        setLocationRelativeTo(null);
        setSize(300, 400);
        setTitle("設定");

        mainP = new JPanel();
        mainP.setLayout(new GridLayout(2, 1));
        mainP.add(fontNamePanel());
        mainP.add(fontSizePanel());

        add(mainP);
        setVisible(true);
    }

    //フォントネームを設定するパネル
    public JPanel fontNamePanel()
    {
        JLabel fontNameL = new JLabel("選択してください");

        DefaultListModel fontNameModel = new DefaultListModel();
        StringBuffer fontNameSb;

        fontNameModel.addElement("DIALOG");
        fontNameModel.addElement("DIALOG_INPUT");
        fontNameModel.addElement("MONOSPACED");
        fontNameModel.addElement("SANS_SERIF");
        fontNameModel.addElement("SERIF");

        JList fontNameList = new JList(fontNameModel);

        fontNameP = new JPanel();
        fontNameP.setBorder(BorderFactory.createTitledBorder("フォントファミリー"));
        GroupLayout layout = new GroupLayout(fontNameP);
        fontNameP.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup().addComponent(fontNameL));
        hGroup.addGroup(layout.createParallelGroup().addComponent(fontNameList));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(fontNameL).addComponent(fontNameList));
        layout.setVerticalGroup(vGroup);

        return fontNameP;
    }

    //フォントスタイルを設定するパネル
    public JPanel fontStylePanel()
    {
        JLabel fontStyleL = new JLabel("フォントスタイル");
        fontStyleP = new JPanel();



        return fontStyleP;
    }

    //フォントサイズを設定するパネル
    public JPanel fontSizePanel()
    {
        JLabel fontSizeLabel = new JLabel("整数値で入力してください");
        JSpinner spinner = new JSpinner();
        spinner.setPreferredSize(new Dimension(30, 10));

        fontSizeP = new JPanel();
        fontSizeP.setBorder(BorderFactory.createTitledBorder("フォントサイズ"));
        GroupLayout layout = new GroupLayout(fontSizeP);
        fontSizeP.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup().addComponent(fontSizeLabel));
        hGroup.addGroup(layout.createParallelGroup().addComponent(spinner));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(fontSizeLabel).addComponent(spinner));
        layout.setVerticalGroup(vGroup);

        return fontSizeP;
    }

    //ボタンが押された際の動作
    @Override
    public void actionPerformed(ActionEvent event)
    {
        
    }
}