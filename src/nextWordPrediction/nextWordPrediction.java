package nextWordPrediction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class nextWordPrediction extends JFrame {
    private Map<Character, ArrayList<String>> suggestions;
    JLabel titleLabel;
    JLabel wordLabel;
    JTextField wordField;
    JButton suggestButton;
    JButton clearButton;
    JLabel suggestionLabel;

    public nextWordPrediction() {
        suggestions = createSuggestionMap();

        // Create GUI components
        titleLabel = new JLabel("Word Prediction");
        titleLabel.setBounds(280, 50, 500, 60);
        titleLabel.setFont(new Font("System", Font.BOLD, 50));
        titleLabel.setForeground(Color.blue);

        wordLabel = new JLabel("Enter a word:-");
        wordLabel.setBounds(100, 180, 290, 50);
        wordLabel.setFont(new Font("System", Font.BOLD, 40));

        wordField = new JTextField();
        wordField.setBounds(400, 180, 350, 50);
        wordField.setFont(new Font("System", Font.BOLD, 30));

        suggestButton = new JButton("PREDICT");
        suggestButton.setFont(new Font("System", Font.BOLD, 28));
        suggestButton.setForeground(Color.blue);
        suggestButton.setBounds(245, 310, 160, 70);

        clearButton = new JButton("Clear");
        clearButton.setForeground(Color.blue);
        clearButton.setBounds(580, 310, 160, 70);
        clearButton.setFont(new Font("System", Font.BOLD, 30));
        //titleLabel.setForeground(Color.blue);

        suggestionLabel = new JLabel();
        suggestionLabel.setBounds(250, 400, 450, 50);
        suggestionLabel.setForeground(Color.blue);
        suggestionLabel.setFont(new Font("System", Font.BOLD, 30));

        // Set layout manager for the frame
        setLayout(null);

        // Add components to the frame
        add(titleLabel);
        add(wordLabel);
        add(wordField);
        add(suggestButton);
        add(clearButton);
        add(suggestionLabel);

        // Configure frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setTitle("Word Suggestions");
        getContentPane().setBackground(Color.LIGHT_GRAY);

        // Add action listener to the suggest button
        suggestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = wordField.getText().trim();

                if (word.length() > 0) {
                    char lastLetter = Character.toLowerCase(word.charAt(word.length() - 1));
                    List<String> words = suggestions.get(lastLetter);

                    if (words != null && !words.isEmpty()) {
                        Random random = new Random();
                        String suggestion = words.get(random.nextInt(words.size()));
                        suggestionLabel.setText("Suggested word: " + suggestion);
                    } else {
                        suggestionLabel.setText("No suggestion found for the last letter.");
                    }
                } else {
                    suggestionLabel.setText("No word entered.");
                }
            }
        });

        // Add action listener to the clear button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wordField.setText("");
                suggestionLabel.setText("");
            }
        });
    }

    private Map<Character, ArrayList<String>> createSuggestionMap() {
        Map<Character, ArrayList<String>> suggestions = new HashMap<>();

        suggestions.put('a', new ArrayList<>(Arrays.asList("apple", "app", "almond")));
        suggestions.put('b', new ArrayList<>(Arrays.asList("banana", "blueberry", "broccoli")));
        suggestions.put('c', new ArrayList<>(Arrays.asList("carrot", "coconut", "calorie")));
        suggestions.put('d', new ArrayList<>(Arrays.asList("durian", "date", "dragonfruit")));
        suggestions.put('e', new ArrayList<>(Arrays.asList("elephant", "egg", "end")));
        suggestions.put('f', new ArrayList<>(Arrays.asList("fig", "funnel", "flex")));
        suggestions.put('g', new ArrayList<>(Arrays.asList("grape", "guava", "ginger")));
        suggestions.put('h', new ArrayList<>(Arrays.asList("honeydew", "horn", "horse")));
        suggestions.put('i', new ArrayList<>(Arrays.asList("indianbread", "ice", "igloo")));
        suggestions.put('j', new ArrayList<>(Arrays.asList("jackfruit", "jack", "jill")));
        suggestions.put('k', new ArrayList<>(Arrays.asList("kiwi", "kate", "kardishian")));
        suggestions.put('l', new ArrayList<>(Arrays.asList("lemon", "lime", "leak")));
        suggestions.put('m', new ArrayList<>(Arrays.asList("melon", "mango", "mushroom")));
        suggestions.put('n', new ArrayList<>(Arrays.asList("necotine", "norway", "nest")));
        suggestions.put('o', new ArrayList<>(Arrays.asList("orange", "olive", "okay")));
        suggestions.put('p', new ArrayList<>(Arrays.asList("peach", "pear", "pineapple")));
        suggestions.put('q', new ArrayList<>(Arrays.asList("queue", "quick", "quack")));
        suggestions.put('r', new ArrayList<>(Arrays.asList("raspberry", "rose", "radish")));
        suggestions.put('s', new ArrayList<>(Arrays.asList("strawberry", "spinach", "squash")));
        suggestions.put('t', new ArrayList<>(Arrays.asList("toe", "tomato", "turnip")));
        suggestions.put('u', new ArrayList<>(Arrays.asList("ugly", "udaan", "universe")));
        suggestions.put('v', new ArrayList<>(Arrays.asList("vanilla", "vinegar", "vegetable")));
        suggestions.put('w', new ArrayList<>(Arrays.asList("watermelon", "walt", "water")));
        suggestions.put('x', new ArrayList<>(Arrays.asList("xerox", "x-mas", "xuan")));
        suggestions.put('y', new ArrayList<>(Arrays.asList("yam", "yuzu", "yummy")));
        suggestions.put('z', new ArrayList<>(Arrays.asList("zoo", "zebra", "zuan")));

        return suggestions;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new nextWordPrediction().setVisible(true);
            }
        });
    }
}

