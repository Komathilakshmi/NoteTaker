import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
/* <applet code="NoteTaker" width="800" height="300">
</applet> */

public class NoteTaker extends Applet implements ActionListener, ItemListener {
    
    Label titleLabel = new Label("Note Taker");
    TextArea noteArea = new TextArea(10, 40);
    Checkbox boldCheckbox = new Checkbox("Bold");
    Checkbox italicCheckbox = new Checkbox("Italic");
    Button addButton = new Button("add");
    Choice colorChoice = new Choice();
    
    public void init() {
        setBackground(Color.PINK);
        setLayout(new FlowLayout());
        
        
        colorChoice.add("Black");
        colorChoice.add("Red");
        colorChoice.add("Blue");
        colorChoice.add("Green");
        colorChoice.addItemListener(this);
        
        
        add(titleLabel);
        add(noteArea);
        add(boldCheckbox);
        add(italicCheckbox);
        add(colorChoice);
        add(addButton);
        
        
        boldCheckbox.addItemListener(this);
        italicCheckbox.addItemListener(this);
        addButton.addActionListener(this);
    }
    
    public void paint(Graphics g)
    {
     
     showStatus("Notetaker created successfully");
    }
   public void actionPerformed(ActionEvent e) {
    if (e.getSource() == addButton) {
        String newText = "New Note: ";
        
        String oldText = noteArea.getText();
        
        noteArea.setText(oldText + newText + "\n");
    }
}
    
    public void itemStateChanged(ItemEvent e) {
        Font font = new Font("Arial", Font.PLAIN, 12);
        
        if (boldCheckbox.getState()) {
            font = font.deriveFont(Font.BOLD);
        }
        if (italicCheckbox.getState()) {
            font = font.deriveFont(Font.ITALIC);
        }
        
        String selectedColor = colorChoice.getSelectedItem();
        Color color = Color.BLACK; 
        
        if (selectedColor.equals("Red")) {
            color = Color.RED;
        } else if (selectedColor.equals("Blue")) {
            color = Color.BLUE;
        } else if (selectedColor.equals("Green")) {
            color = Color.GREEN;
        }
         
        
        noteArea.setFont(font);
        noteArea.setForeground(color);
    }
}