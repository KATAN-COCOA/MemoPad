/*
* 設定画面用クラス
 */

package org.example.MemoPad;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

public class Setting extends JFrame implements ActionListener{

    private JPanel mainP;
    private JPanel fontNameP;
    private JPanel fontStyleP;
    private JPanel fontSizeP; //メインパネル

    //設定項目
    public static String fontName; //フォントネーム
    public static int fontStyle; //フォントスタイル
    public static int fontSize; //フォントサイズ


    /*
    * コンストラクタ
     */
    public Setting()
    {
        setLocationRelativeTo(null);
        setSize(300, 480);
        setTitle("設定");

        mainP = new JPanel();
        mainP.setLayout(new GridLayout(3, 1));
        mainP.add(fontNamePanel());
        mainP.add(fontStylePanel());
        mainP.add(fontSizePanel());

        add(mainP);
        setVisible(true);
    }

    //フォントファミリーを設定するパネル
    public JPanel fontNamePanel()
    {
        JLabel fontNameL = new JLabel("選択してください");

        DefaultListModel fontNameModel = new DefaultListModel();
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
        JLabel fontStyleL = new JLabel("選択してください");

        DefaultListModel fontStyleModel = new DefaultListModel();
        fontStyleModel.addElement("BOLD");
        fontStyleModel.addElement("ITALIC");
        fontStyleModel.addElement("PLAIN");

        JList fontStyleList = new JList(fontStyleModel);

        fontStyleP = new JPanel();
        fontStyleP.setBorder(BorderFactory.createTitledBorder("フォントスタイル"));
        GroupLayout layout = new GroupLayout(fontStyleP);
        fontStyleP.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup().addComponent(fontStyleL));
        hGroup.addGroup(layout.createParallelGroup().addComponent(fontStyleList));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(fontStyleL).addComponent(fontStyleList));
        layout.setVerticalGroup(vGroup);

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

    //フォントネームを取得
    public String getFontName()
    {
        return fontName;
    }

    //フォントスタイルを取得
    public int getFontStyle()
    {
        return fontStyle;
    }

    //フォントサイズを取得
    public int getFontSize()
    {
        return fontSize;
    }

    //ボタンが押された際の動作
    @Override
    public void actionPerformed(ActionEvent event)
    {
        
    }
}