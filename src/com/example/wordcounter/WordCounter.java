package com.example.wordcounter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.*;


class MyFrame extends JFrame implements ActionListener {
        JLabel label;
        JButton button;
        JPanel bottomPanel;
        JScrollPane scrollPane;
        JTextArea textArea;
    MyFrame(){


        button = new JButton();
        button.setText("Count Words");
        button.addActionListener(this);


        textArea = new JTextArea();
        textArea.setRows(10);
        textArea.setColumns(30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);


        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 200));

        label = new JLabel();
        label.setText("Word Count : 0");
        add(label, JLabel.CENTER);

        setLayout(new BorderLayout());

        add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);


        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottomPanel.add(button);
        bottomPanel.add(Box.createRigidArea(new Dimension(10, 20)));
        bottomPanel.add(label);
        add(bottomPanel, BorderLayout.SOUTH);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        countWords();
        }

    private void countWords() {
        String text = textArea.getText().trim();
        if (text.isEmpty()) {
            label.setText("Word count: 0");
        } else {
            String[] words = text.split("\\s+");
            label.setText("Word count: " + words.length);
        }
    }

    }


class WordCounter {

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();

        frame.setTitle("Word Counter");
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(WHITE);

    }
}
