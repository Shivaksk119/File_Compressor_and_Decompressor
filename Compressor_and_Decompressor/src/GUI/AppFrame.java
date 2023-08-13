package GUI;

import Comp_deComp.Compressor;
import Comp_deComp.deCompressor;

import javax.swing.*;
import java.io.File;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame extends JFrame implements ActionListener { //ActionListener-> tracks the clicks of the button
    JButton compressButton;
    JButton decompressButton;

    public AppFrame() { // constructor
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton = new JButton("Select File to Compress");// input text wi;ll appear ont the Button
        compressButton.setBounds(200, 160, 200, 30);
        //compressButton.setVisible(true);
        compressButton.addActionListener(this);


        decompressButton = new JButton("Select File to deCompress");// input text wi;ll appear ont the Button
        decompressButton.setBounds(200, 200, 200, 30);
        //decompressButton.setVisible(true);
        decompressButton.addActionListener(this);

        this.setSize(1000, 500);// sets the size of the JFrame window

        this.add(compressButton);
        this.add(decompressButton);

        this.getContentPane().setBackground(Color.CYAN);
        this.setVisible(true);//JFrame window will visible


    }

    @Override
    public void actionPerformed(ActionEvent e) { // overrides action listener
        if(e.getSource()==compressButton) {// if we click Compress button
            JFileChooser fileChooser =  new JFileChooser();//creates file chooser object;
            int response = fileChooser.showSaveDialog(null);//pops up the save file dialog window
            if(response==JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Compressor.method(file);//compress the file
                }
                catch (Exception eve){
                    JOptionPane.showMessageDialog(null, eve.toString());
                }
            }
        }

        if(e.getSource()==decompressButton) {// if we click Compress button
            JFileChooser fileChooser =  new JFileChooser();//creates file chooser object;
            int response = fileChooser.showSaveDialog(null);//pops up the save file dialog window
            if(response==JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    deCompressor.method(null);// deCompress the file
                }
                catch (Exception eve){
                    JOptionPane.showMessageDialog(null, eve.toString());
                }
            }
        }
    }
}
