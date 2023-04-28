import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main {
    
    public static void main(String[] args) {

        //Soft grey RGB: 54, 59, 64

        ImageIcon logo = new ImageIcon(new ImageIcon("BlackJack Logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);

        JLabel label = new JLabel();
        label.setText("Hello!");
        label.setIcon(logo);
        label.setHorizontalTextPosition(JLabel.CENTER);     //* Set text LEFT, CENTER, or RIGHT of imageicon */
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setForeground(new Color(0, 255, 0));    //* Set text color */
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setIconTextGap(5);
        label.setBackground(new Color(54, 59, 64));
        label.setOpaque(true);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0, 0, 150, 150);

        

        JFrame frame = new JFrame();
        frame.setTitle("BlackJack Game");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(78, 126, 84));
        frame.setIconImage(logo.getImage());
        frame.setLayout(null);
        frame.add(label);
        

        
        frame.setVisible(true);
        
        



    }
}
