/*
* 初期画面用クラス
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

public class Bace extends JFrame implements ActionListener{

    //パネル
    private JPanel mainP;
    
    //メニューボタン
    private JMenuItem itemOfNew;
    private JMenuItem itemOfSetting;
    private JMenuItem itemOfStore;
    private JMenuItem itemOfStoreWithName;
    private JMenuItem itemOfExit;

    //設定項目
    public static String fontName; //フォントネーム
    public static int fontStyle; //フォントスタイル
    public static int fontSize; //フォントサイズ
    
    //テキストエリア
    public static JTextArea textArea; //書き込む部分

    //スクロール
    private JScrollPane scrollpane;

    /*
    * メイン画面を表示
     */
    public void mainFrame()
    {
        //フレーム全体の設定
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setTitle("メモ帳");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //メインパネルの設定
        mainP = new JPanel();
        mainP.setLayout(new BorderLayout());

        //初期設定
        fontName = "Monospaced";
        fontStyle = Font.PLAIN;
        fontSize = 11;
        
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

        itemOfSetting = new JMenuItem("設定");
        itemOfSetting.addActionListener(this);

        itemOfStore = new JMenuItem("保存");
        itemOfStore.addActionListener(this);

        itemOfStoreWithName = new JMenuItem("名前を付けて保存");
        itemOfStoreWithName.addActionListener(this);

        itemOfExit = new JMenuItem("終了");
        itemOfExit.addActionListener(this);

        menu.add(itemOfNew);
        menu.add(itemOfSetting);
        menu.add(itemOfStore);
        menu.add(itemOfStoreWithName);
        menu.add(itemOfExit);

        setJMenuBar(menuBar);

        textArea = new JTextArea();
        textArea.setFont(new Font(fontName, fontStyle, fontSize));
        scrollpane = new JScrollPane(textArea);
        add(scrollpane);
        
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
        }else if(event.getSource() == itemOfSetting){
            mainP.removeAll();
            Setting s = new Setting();
            s.mainFrame();
            fontName = s.getFontName();
            System.out.println(fontName);
            fontStyle = s.getFontStyle();
            System.out.println(fontStyle);
            fontSize = s.getFontSize();
            System.out.println(fontSize);
            mainP.setLayout(new BorderLayout());
            add(mainPanel());
        }else if(event.getSource() == itemOfStore){

        }else if(event.getSource() == itemOfStoreWithName){
            new FileStore();
        }else if(event.getSource() == itemOfExit){
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }
}
