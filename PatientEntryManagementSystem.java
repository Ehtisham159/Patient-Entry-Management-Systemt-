// Below Submit Button Code
JButton viewBtn = new JButton("View All Patients");
viewBtn.setBounds(100, 180, 150, 30);
viewBtn.setBackground(new Color(40, 167, 69));
viewBtn.setForeground(Color.WHITE);

// Add view button to frame
frame.add(viewBtn);

// Action to view all patient data
viewBtn.addActionListener(e -> {
    try (BufferedReader reader = new BufferedReader(new FileReader("patients.txt"))) {
        StringBuilder allPatients = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            allPatients.append(line).append("\n");
        }
        JOptionPane.showMessageDialog(frame, allPatients.toString(), "All Patients", JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(frame, "No patients found or file error.", "Read Error", JOptionPane.ERROR_MESSAGE);
    }
});
