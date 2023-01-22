/*
* 設定画面用クラス
 */

package org.example.MemoPad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Setting extends JFrame implements ActionListener{

    private JPanel mainSettingP;
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


    /*
    * メイン画面表示
    */
    public void mainFrame()
    {
        setLocation(200, 100);
        setSize(300, 600);
        setLocationRelativeTo(null);
        setTitle("設定");

        mainSettingP = new JPanel();
        GridLayout layout = new GridLayout(4, 1);
        mainSettingP.setLayout(layout);
        mainSettingP.add(fontNamePanel());
        mainSettingP.add(fontStylePanel());
        mainSettingP.add(fontSizePanel());
        mainSettingP.add(buttonPanel());

        add(mainSettingP);
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

    //ボタンが押された際の動作
    @Override
    public void actionPerformed(ActionEvent event)
    {
        Bace b = new Bace();
        //フォントネームを決定
        int index = fontNameList.getSelectedIndex();
        if (index == 0) {
            b.fontName = fontNameModel.getElementAt(0).toString();
        } else if (index == 1) {
            b.fontName = fontNameModel.getElementAt(1).toString();
        } else if (index == 2) {
            b.fontName = fontNameModel.getElementAt(2).toString();
        } else if (index == 3) {
            b.fontName = fontNameModel.getElementAt(3).toString();
        } else if (index == 4) {
            b.fontName = fontNameModel.getElementAt(4).toString();
        }

        //フォントスタイルを決定
        index = fontStyleList.getSelectedIndex();
        if (index == 0) {
            b.fontStyle = 1;
        } else if (index == 1) {
            b.fontStyle = 2;
        } else if (index == 2) {
            b.fontStyle = 0;
        }

        //フォントサイズを決定
        Integer size = (Integer) model.getValue();
        b.fontSize = size;

        b.mainP.removeAll();
        b.setText(b.textArea.getText());
        b.mainPanel();
        b.mainF.add(b.mainP);
        b.mainF.setVisible(true);

        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}