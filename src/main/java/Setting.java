import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Setting extends JFrame implements ActionListener {
    JButton cancel;
    JButton Exit;
    Setting(){
        super("Setting");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(305,320);

        setLocationRelativeTo(null);

        setResizable(false);



        setLayout(null);


        addComponents();




        setVisible(true);
    }

    private void addComponents() {

        JLabel Text = new JLabel("<html>Terms And Conditions :" +
                "<br> 1.Plase always turn your Internet Before Opening the app<br>" +
                "2.Weather Gui function is made for" +
                " UserInterface <br> In Graphical way<br>" +
                "3.Weather Status function is made for Showing<br>" +
                "Data of Weather<br>" +
                "4.Setting function is  provided for Terms and <br>" +
                "conditions about the app and Also for the Exit <br>" +
                "Button <br>" +
                "5.DefaultTime function is made for Checking the <br>" +
                "time According to your Purpose " +
                "</html>");
         Text.setBounds(10,0,300,200);
         add(Text);

          cancel = new JButton("Cancel");
         cancel.setBounds(20,230,80,20);
         cancel.setFont(new Font("Times New Roman",Font.BOLD,12));
         cancel.addActionListener(this);
         add(cancel);


         Exit = new JButton("Exit");
        Exit.setBounds(170,230,80,20);
        Exit.setFont(new Font("Times New Roman",Font.BOLD,12));
        Exit.addActionListener(this);
        add(Exit);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancel){
            setVisible(false);
            new Main();
        }else if(e.getSource()==Exit){
            setVisible(false);
        }
    }


    public static void main(String[]args){
        Setting s = new Setting();

    }
}
