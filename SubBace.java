/*
* 新規ウィンドウ用クラス
 */

package org.example.MemoPad;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.*;

public class SubBace extends JFrame implements ActionListener{

    //パネル
    private JPanel mainP;

    //メニューボタン
    private JMenuItem itemOfNew;
    private JMenuItem itemOfNewWindow;
    private JMenuItem itemOfSetting;
    private JMenuItem itemOfStore;
    private JMenuItem itemOfStoreWithName;
    private JMenuItem itemOfExit;

    //テキストエリア
    public static JTextArea textArea; //書き込む部分

    //設定項目
    public static int fontSize;
    public static String fontName;
    public static int fontStyle;

    /*
     * メイン画面を表示
     */
    public void mainFrame()
    {
        //フレーム全体の設定
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setTitle("メモ帳");

        //メインパネルの設定
        mainP = new JPanel();
        mainP.setLayout(new BorderLayout());

        //フレームの中身の設定
        setLayout(new BorderLayout());
        add(mainPanel());

        //フレームを有効化
        setVisible(true);
    }

    /*
     * メインのパネルを表示
     */
    public JPanel mainPanel()
    {
        //メニューバー
        JMenuBar menuBar = new JMenuBar();
        //メニューの項目を設定
        JMenu menu = new JMenu("メニュー");
        //メニューバーにメニューの項目を追加
        menuBar.add(menu);

        //メニュー項目の内容を設定
        itemOfNew = new JMenuItem("新規");
        itemOfNew.addActionListener(this);

        itemOfNewWindow = new JMenuItem("新規ウィンドウ");
        itemOfNewWindow.addActionListener(this);

        itemOfSetting = new JMenuItem("設定");
        itemOfSetting.addActionListener(this);

        itemOfStore = new JMenuItem("保存");
        itemOfStore.addActionListener(this);

        itemOfStoreWithName = new JMenuItem("名前を付けて保存");
        itemOfStoreWithName.addActionListener(this);

        itemOfExit = new JMenuItem("終了");
        itemOfExit.addActionListener(this);

        menu.add(itemOfNew);
        menu.add(itemOfNewWindow);
        menu.add(itemOfSetting);
        menu.add(itemOfStore);
        menu.add(itemOfStoreWithName);
        menu.add(itemOfExit);

        setJMenuBar(menuBar);

        textArea = new JTextArea();
        textArea.setFont(new Font(fontName, fontStyle, fontSize));
        JScrollPane scrollpane = new JScrollPane(textArea);

        mainP.add(scrollpane, BorderLayout.CENTER);

        return mainP;
    }

    //テキストを与える
    public String getTextArea()
    {
        String text = textArea.getText();
        return text;
    }

    //ボタンが押された際の動作
    @Override
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == itemOfNew){
            mainP.removeAll();
            add(mainPanel());
            setVisible(true);
        }else if(event.getSource() == itemOfNewWindow){
            SubBace s = new SubBace();
            s.mainFrame();
        }else if(event.getSource() == itemOfSetting){
            new Setting();
        }else if(event.getSource() == itemOfStore){
            
        }else if(event.getSource() == itemOfStoreWithName){
            new FileStore();
        }else if(event.getSource() == itemOfExit){
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }
}
