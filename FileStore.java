package org.example.MemoPad;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.nio.file.Files;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileStore implements ActionListener{

    private JFrame mainFrame;
    
    private JPanel mainP;
    private JPanel filePathEnterP;
    private JPanel fileNameEnterP;
    private JPanel selectButtonsP;
    
    private JButton storeB;
    private JButton cancelB;
    
    private JLabel filePathEnterL;
    private JLabel fileNameEnterL;
    private JLabel storeButtonL;
    private JLabel cancelButtonL;
    
    private JTextField enterFileNameFi;
    private JTextField enterFilePathFi;
    
    /*
    * コンストラクタ
    */
    public FileStore()
    {
        mainFrame = new JFrame("名前を付けて保存");
        mainFrame.setSize(700, 200);
        mainFrame.setLocationRelativeTo(null);
        fileStore();
        mainFrame.setVisible(true);
    }
    
    /*
    * 保存画面を表示
    */
    public void fileStore()
    {
        mainP = new JPanel();
        mainP.setLayout(new GridLayout(3, 1));
        
        fileNameEnterP = new JPanel();
        fileNameEnterP.setLayout(new FlowLayout(FlowLayout.CENTER));
        fileNameEnterL = new JLabel("ファイル名");
        fileNameEnterL.setFont(new Font("Monospaced", Font.PLAIN, 15));
        enterFileNameFi = new JTextField(50);
        fileNameEnterP.add(fileNameEnterL);
        fileNameEnterP.add(enterFileNameFi);
        
        filePathEnterP = new JPanel();
        filePathEnterP.setLayout(new FlowLayout(FlowLayout.CENTER));
        filePathEnterL = new JLabel("ファイルパス");
        filePathEnterL.setFont(new Font("Monospaced", Font.PLAIN, 15));
        enterFilePathFi = new JTextField(50);
        filePathEnterP.add(filePathEnterL);
        filePathEnterP.add(enterFilePathFi);
        
        selectButtonsP = new JPanel();
        selectButtonsP.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        storeB = new JButton();
        storeButtonL = new JLabel("保存");
        storeButtonL.setFont(new Font("Monospaced", Font.PLAIN, 15));
        storeB.add(storeButtonL);
        storeB.addActionListener(this);
        
        cancelB = new JButton();
        cancelButtonL = new JLabel("キャンセル");
        cancelButtonL.setFont(new Font("Monospaced", Font.PLAIN, 15));
        cancelB.add(cancelButtonL);
        cancelB.addActionListener(this);
        
        selectButtonsP.add(cancelB);
        selectButtonsP.add(storeB);
        
        mainP.add(fileNameEnterP);
        mainP.add(filePathEnterP);
        mainP.add(selectButtonsP);

        mainFrame.add(mainP);
    }
    
    //テキストを読み込む->テキストファイルを生成する
    public void fileStore(String name, String path)
    {
        File file1 = new File(path + name);
        File file2 = new File(file1.getParentFile(), name);
        try{
            Files.createFile(file2.toPath());
            System.out.println(file2.toPath());
        }catch(IOException error){
            error.printStackTrace();
        }

        Bace b = new Bace();
        String text = b.getTextArea();

        try{
            FileWriter fw = new FileWriter(file2);
            fw.write(text);
            fw.close();
        }catch(IOException error){
            error.printStackTrace();
        }
    }

    public JFrame createCaoutionFrames(String message)
    {
        JFrame frame = new JFrame();
        JLabel messageL = new JLabel(message);
        JOptionPane.showMessageDialog(frame, messageL);
        return frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == cancelB){
            mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
        }else if(event.getSource() == storeB){
            if((enterFilePathFi.getText().equals("")) || (enterFileNameFi.getText().equals(""))){
                JFrame cautionNamePathF = createCaoutionFrames("ファイル名もしくはファイルパスが入力されていません");
                cautionNamePathF.setVisible(true);
            }else{
                String fileName = enterFileNameFi.getText();
                String filePath = enterFilePathFi.getText();
                fileStore(fileName, filePath);
            }
        }
    }
}