import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
    
    public static void main(String[] args)
    {
        //Creating a simple frame
        JFrame frame = new JFrame();
        frame.setLocation(200, 200);
        

        //Create a panel
        JPanel p = new JPanel();
        frame.add(p);

        //Creaing a label
        JLabel label = new JLabel("My Label");
        p.add(label);

        //Create a text field
        JTextField field = new JTextField(200);
        String s = field.getText();
        field.setText("Hello Field");

        frame.setVisible(true);
    }

    
}

