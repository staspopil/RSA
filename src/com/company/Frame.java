package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {

    JFrame a = new JFrame("Cezar");
    JButton Button = new JButton("Encrypt");
    JTextField message = new JTextField("Write Message");
    JTextField SecondSN = new JTextField("Write SecondKey");
    JTextField EncryptedMessage = new JTextField("Message");
    JTextField PKey = new JTextField("-");
    JTextField SKey = new JTextField("-");
    JTextField Module = new JTextField("-");
    ButtonGroup group = new ButtonGroup();
    JTextField FirstSN = new JTextField("Write FirstKey");
    JRadioButton smallButton = new JRadioButton("Encrypt", true);
    JRadioButton mediumButton = new JRadioButton("Decrypt", false);
    Algoritms alg = new Algoritms();
    public void CreateFrame(){
        group.add(smallButton);
        group.add(mediumButton);
        Module.setBounds(145,150,200,20);
        PKey.setBounds(145,100,200,20);
        SKey.setBounds(145,125,200,20);
        FirstSN.setBounds(145,24,200,20);
        message.setBounds(145,70,200,20);
        message.setHorizontalAlignment(JTextField.CENTER);
        Button.setBounds(200,260,85,20);
        EncryptedMessage.setBounds(145,225,200,20);
        //EncryptedMessage.setHorizontalAlignment(JTextField.CENTER);
        smallButton.setBounds(145,200,100,20);
        mediumButton.setBounds(275,200,100,20);
        SecondSN.setBounds(145,48,200,20);
        FirstSN.setHorizontalAlignment(JTextField.CENTER);
        SecondSN.setHorizontalAlignment(JTextField.CENTER);
        JLabel note = new JLabel("First Simple Number:");
        JLabel note1 = new JLabel("Second Simple Number:");
        JLabel note2 = new JLabel("Message:");
        JLabel note3 = new JLabel("Processed message:");
        JLabel note4 = new JLabel("Generated Public Exp:");
        JLabel note5 = new JLabel("Generated Secret Exp:");
        JLabel note6 = new JLabel("Generated Module:");
        note.setBounds(10,24,200,20);
        note1.setBounds(10,48,200,20);
        note2.setBounds(10,72,200,20);
        note3.setBounds(5,225,200,20);
        note4.setBounds(5,100,200,20);
        note5.setBounds(5,125,200,20);
        note6.setBounds(5,150,200,20);
        a.add(note);
        a.add(note1);
        a.add(note2);
        a.add(note3);
        a.add(note4);
        a.add(note5);
        a.add(note6);
        a.add(Module);
        a.add(PKey);
        a.add(SKey);
        a.add(SecondSN);
        a.add(Button);
        a.add(message);
        a.add(EncryptedMessage);
        a.add(FirstSN);
        a.add(smallButton);
        a.add(mediumButton);
        a.setSize(400,350);
        a.setLayout(null);
        a.setLocationRelativeTo(null);
        a.setVisible(true);

    }

    public void Button(){
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alg.e.clear();
                alg.list.clear();
                alg.mes.clear();
            int p = Integer.valueOf(FirstSN.getText());
            int q = Integer.valueOf(SecondSN.getText());
                int f = (p-1)*(q-1);
//                Module.setText(String.valueOf(p*q));
//                 int n  = Integer.valueOf(Module.getText());
//                alg.EvclidToArray(f);
//                PKey.setText(String.valueOf(alg.getRandomPublicExp(alg.e)));
//                int pExp = Integer.valueOf(PKey.getText());
//                SKey.setText(String.valueOf(alg.getPriaveteExp(f,pExp)));
//                int sExp = Integer.valueOf(SKey.getText());
//                System.out.println("Public Key = ("+pExp+","+n+")");
//                System.out.println("Secret Key = ("+sExp+","+n+")");
            alg.getMessage(message.getText());
            if(smallButton.isSelected()) {
                Module.setText(String.valueOf(p*q));
                int n  = Integer.valueOf(Module.getText());
                alg.EvclidToArray(f);
                PKey.setText(String.valueOf(alg.getRandomPublicExp(alg.e)));
                int pExp = Integer.valueOf(PKey.getText());
                SKey.setText(String.valueOf(alg.getPriaveteExp(f,pExp)));
                int sExp = Integer.valueOf(SKey.getText());
                alg.EncryptedMes.clear();
                alg.toEncryptMessage(pExp,n);
                EncryptedMessage.setText(alg.EncryptedMes.toString());
            }
            else {
                alg.DecryptedMes.clear();
                int sExp = Integer.valueOf(SKey.getText());
                int n  = Integer.valueOf(Module.getText());
                alg.toDecryptMessage(sExp,n);
                EncryptedMessage.setText(alg.DecryptedMes.toString());
            }
            }
        });
    }
}
