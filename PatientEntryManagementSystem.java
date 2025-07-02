// Search Label and Field
JLabel searchLabel = new JLabel("Search by Name:");
searchLabel.setBounds(20, 220, 120, 25);
JTextField searchField = new JTextField();
searchField.setBounds(140, 220, 120, 25);
JButton searchBtn = new JButton("Search");
searchBtn.setBounds(100, 260, 100, 30);
searchBtn.setBackground(new Color(255, 193, 7));
searchBtn.setForeground(Color.BLACK);

// Add to frame
frame.add(searchLabel);
frame.add(searchField);
frame.add(searchBtn);

// Action for Search
searchBtn.addActionListener(e -> {
    String searchName = searchField.getText().trim();
    if (searchName.isEmpty()) {
        JOptionPane.showMessageDialog(frame, "Enter a name to search.", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try (BufferedReader reader = new BufferedReader(new FileReader("patients.txt"))) {
        StringBuilder results = new StringBuilder();
        String line;
        boolean found = false;
        while ((line = reader.readLine()) != null) {
            if (line.toLowerCase().contains(searchName.toLowerCase())) {
                results.append(line).append("\n");
                found = true;
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(frame, results.toString(), "Search Results", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "No patient found with name: " + searchName, "Not Found", JOptionPane.WARNING_MESSAGE);
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(frame, "Error reading file.", "File Error", JOptionPane.ERROR_MESSAGE);
    }
});
