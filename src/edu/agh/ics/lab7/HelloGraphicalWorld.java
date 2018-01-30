package edu.agh.ics.lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

public class HelloGraphicalWorld extends JFrame implements ActionListener {
    public static final String[] words = {"foo", "bar", "baz", "qux", "quux", "quuz"};
    private JTextArea textArea;
    private JButton toLowerCase;
    private JButton toUpperCase;
    private JButton generateRandomText;
    private JMenuItem openFile;

    public HelloGraphicalWorld() {
        super("Hello Graphical World");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initComponents();
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == toLowerCase) {
            System.out.println("To lower case clicked");
            textArea.setText(textArea.getText().toLowerCase());
        } else if (source == toUpperCase) {
            System.out.println("To upper case clicked");
            textArea.setText(textArea.getText().toUpperCase());
        } else if (source == generateRandomText) {
            System.out.println("Random clicked");
            Random rand = new Random();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 6; i++) {
                int idx = rand.nextInt(words.length);
                sb.append(words[idx] + " ");
                if ((i & 1) == 0) {
                    sb.append("\n");
                }
                textArea.setText(sb.toString());
            }
        }
    }

    public static void main(String[] args) {
        HelloGraphicalWorld app = new HelloGraphicalWorld();
        app.setVisible(true);
    }

    private void initComponents() {
        initMenuFile();

        JPanel textPanel = new JPanel();
        textArea = new JTextArea(15, 35);
        textArea.setText("Ala ma kota");
        textPanel.add(textArea);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        toLowerCase = new JButton("To Lower Case");
        toLowerCase.addActionListener(this);
        buttonsPanel.add(toLowerCase);
        toUpperCase = new JButton("To Upper Case");
        toUpperCase.addActionListener(this);
        buttonsPanel.add(toUpperCase);
        generateRandomText = new JButton("Generate");
        generateRandomText.addActionListener(this);
        buttonsPanel.add(generateRandomText);

        add(textPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    private void initMenuFile() {

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        openFile = new JMenuItem("Open");
        openFile.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(false);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setCurrentDirectory(new File("."));
            int returnVal = fileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Open file: " + selectedFile);
                try {
                    List<String> lines = Files.readAllLines(selectedFile.toPath());
                    StringBuilder sb = new StringBuilder();
                    for (String line : lines) {
                        sb.append(line + "\n");
                    }
                    textArea.setText(sb.toString());
                } catch (IOException e1) {
                    System.err.println("Cannot read file:" + selectedFile);
                }
            }
        });
        fileMenu.add(openFile);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }
}
