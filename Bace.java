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

public class Bace implements ActionListener{

    //フレーム
    public static JFrame mainF;

    //パネル
    public static JPanel mainP;
    
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

    //テキストエリアの中身
    private String text;

    /*
    * メイン画面を表示
     */
    public void mainFrame()
    {
        //フレーム全体の設定
        mainF = new JFrame();
        mainF.setSize(1000, 500);
        mainF.setLocationRelativeTo(null);
        mainF.setTitle("メモ帳");
        mainF.setDefaultCloseOperation(mainF.EXIT_ON_CLOSE);
        
        //メインパネルの設定
        mainP = new JPanel();
        mainP.setLayout(new BorderLayout());

        //初期設定
        fontName = "Monospaced";
        fontStyle = Font.PLAIN;
        fontSize = 11;
        text = "";
        
        //フレームの中身の設定
        mainF.setLayout(new BorderLayout());
        mainPanel();
        mainF.add(mainP);
        
        //フレームを有効化
        mainF.setVisible(true);
    }

    /*
    * メインのパネルを表示
    */
    public void mainPanel()
    {
        System.out.println(fontName);
        System.out.println(fontStyle);
        System.out.println(fontSize);
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

        mainF.setJMenuBar(menuBar);

        textArea = new JTextArea();
        if(text.equals("")){
            textArea.setFont(new Font(fontName, fontStyle, fontSize));
        }else{
            textArea.append(text);
            textArea.setFont(new Font(fontName, fontStyle, fontSize));
        }
        scrollpane = new JScrollPane(textArea);
        mainF.add(scrollpane);
        
        mainP.add(scrollpane, BorderLayout.CENTER);
        System.out.println(textArea);
    }

    public void setText(String tmpText)
    {
        text = tmpText;
    }

    //テキストを与える
    public String getTextArea()
    {
        text = textArea.getText();
        return text;
    }
    
    //ボタンが押された際の動作
    @Override
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == itemOfNew){
            mainP.removeAll();
            mainPanel();
            mainF.add(mainP);
            mainF.setVisible(true);
        }else if(event.getSource() == itemOfSetting){
            Setting s = new Setting();
            s.mainFrame();
        }else if(event.getSource() == itemOfStore){

        }else if(event.getSource() == itemOfStoreWithName){
            new FileStore();
        }else if(event.getSource() == itemOfExit){
            mainF.dispatchEvent(new WindowEvent(mainF, WindowEvent.WINDOW_CLOSING));
        }
    }
}
