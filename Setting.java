/*
* 設定画面用クラス
 */

package org.example.MemoPad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Setting extends JFrame implements ActionListener{

    private JPanel mainP;
    private JPanel fontNameP;
    private JPanel fontStyleP;
    private JPanel fontSizeP;
    private JPanel buttonP;

    private JButton decideB;

    private JList fontNameList;
    private JList fontStyleList;
    private JSpinner spinner;
    private SpinnerModel model;
    private DefaultListModel fontNameModel;
    private DefaultListModel fontStyleModel;

    public static String fontName = ""; //getValues用
    public static int fontStyle = 0; //getValues用
    public static int fontSize = 0; //getValues用


    /*
    * メイン画面表示
    */
    public void mainFrame()
    {
        setLocation(200, 100);
        setSize(300, 600);
        setLocationRelativeTo(null);
        setTitle("設定");

        mainP = new JPanel();
        GridLayout layout = new GridLayout(4, 1);
        mainP.setLayout(layout);
        mainP.add(fontNamePanel());
        mainP.add(fontStylePanel());
        mainP.add(fontSizePanel());
        mainP.add(buttonPanel());

        add(mainP);
        setVisible(true);
    }

    //フォントファミリーを設定するパネル
    public JPanel fontNamePanel()
    {
        JLabel fontNameL = new JLabel("選択してください");

        fontNameModel = new DefaultListModel();
        fontNameModel.addElement("DIALOG");
        fontNameModel.addElement("DIALOG_INPUT");
        fontNameModel.addElement("MONOSPACED");
        fontNameModel.addElement("SANS_SERIF");
        fontNameModel.addElement("SERIF");

        fontNameList = new JList(fontNameModel);

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

        fontStyleModel = new DefaultListModel();
        fontStyleModel.addElement("BOLD");
        fontStyleModel.addElement("ITALIC");
        fontStyleModel.addElement("PLAIN");

        fontStyleList = new JList(fontStyleModel);

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
        model = new SpinnerNumberModel(0, null, null, 1);
        spinner = new JSpinner(model);
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

    //決定ボタンパネル
    public JPanel buttonPanel()
    {
        buttonP = new JPanel();
        buttonP.setLayout(new FlowLayout(FlowLayout.RIGHT));
        decideB = new JButton("反映");
        decideB.addActionListener(this);
        buttonP.add(decideB);
        return buttonP;
    }

    public String getFontName()
    {
        return fontName;
    }

    public int getFontStyle()
    {
        return fontStyle;
    }

    public int getFontSize()
    {
        return fontSize;
    }

    //ボタンが押された際の動作
    @Override
    public void actionPerformed(ActionEvent event)
    {
        //フォントネームを決定
        int index = fontNameList.getSelectedIndex();
        if (index == 0) {
            fontName = fontNameModel.getElementAt(0).toString();
        } else if (index == 1) {
            fontName = fontNameModel.getElementAt(1).toString();
        } else if (index == 2) {
            fontName = fontNameModel.getElementAt(2).toString();
        } else if (index == 3) {
            fontName = fontNameModel.getElementAt(3).toString();
        } else if (index == 4) {
            fontName = fontNameModel.getElementAt(4).toString();
        }

        //フォントスタイルを決定
        index = fontStyleList.getSelectedIndex();
        if (index == 0) {
            fontStyle = 1;
        } else if (index == 1) {
            fontStyle = 2;
        } else if (index == 2) {
            fontStyle = 0;
        }

        //フォントサイズを決定
        Integer size = (Integer) model.getValue();
        fontSize = size;

        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}