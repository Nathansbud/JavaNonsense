package com.nathansbud.Graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TemperatureConverter {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Temperature Converter");
        JLabel word_l = new JLabel("Enter a Temperature");
        JButton fahrenheit_b = new JButton("Convert to Celsius");
        JButton celsius_b = new JButton("Convert to Celsius");
        JTextField textField_tf = new JTextField();

        word_l.setBounds(150, 0, 200, 20);
        fahrenheit_b.setBounds(25, 100, 200, 20);
        celsius_b.setBounds(250, 100, 200, 20);
        textField_tf.setBounds(150, 50, 200, 20);

        fahrenheit_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, (int)Math.round((Double.parseDouble(textField_tf.getText())-32)*5.0/9.0*100)/100.0f);
                } catch(NumberFormatException ex) {
                    System.out.println("Exception LUL");
                }
            }
        });

        celsius_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null, (int)Math.round((Double.parseDouble(textField_tf.getText())+32)*9.0/5.0*100)/100.0f);
                } catch(NumberFormatException ex) {
                    System.out.println("Exception LUL");
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);



        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyChar() == 27) {
                    System.exit(0);
                }
            }
        });




        frame.add(word_l);
        frame.add(textField_tf);
        frame.add(fahrenheit_b);
        frame.add(celsius_b);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}

