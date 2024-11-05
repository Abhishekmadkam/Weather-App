import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener{
    JPanel p;
    JButton WeatherGui;
    JButton cancel;
    JButton DefaultTime ;

    JButton WeatherCoordinates;

    JButton Setting;


     Main(){
         super("WeatherApp");

         setDefaultCloseOperation(EXIT_ON_CLOSE);


         setSize(235,320);
         setLocationRelativeTo(null);
         setResizable(false);
         setLayout(null);
         setVisible(true);




         addComponents();
     }



    private void addComponents() {
        WeatherGui = new JButton("WeatherGui");
        WeatherGui.setBounds(25,50,170,24);
        WeatherGui.setFont(new Font("Times new roman",Font.BOLD,15));
        WeatherGui.addActionListener(this);
        add(WeatherGui);


        WeatherCoordinates = new JButton("WeatherStatus");
        WeatherCoordinates.setBounds(21,100,180,24);
        WeatherCoordinates.setFont(new Font("Times new roman",Font.BOLD,15));
        WeatherCoordinates.addActionListener(this);
        add(WeatherCoordinates);


        cancel = new JButton("Cancel");
        cancel.setBounds(55,190,100,24);
        cancel.setFont(new Font("Times new roman",Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);

        DefaultTime = new JButton("DefaultTime");
        DefaultTime.setBounds(25,140,170,24);
        DefaultTime.setFont(new Font("Times new Roman",Font.BOLD,15));
        DefaultTime.addActionListener(this);
        add(DefaultTime);

        Setting = new JButton("....");
        Setting.setBounds(190,10,20,10);
        Setting.addActionListener(this);
        add(Setting);



        p = new JPanel();
        p.setSize(340,340);
        p.setBounds(10,10,200,250);
        p.setBackground(new Color(54,45,65));
        add(p);





    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == WeatherGui) {
            try {
                Thread.sleep(2000);
                setVisible(false);
                new WeatherAppGui();


            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

        } else if (e.getSource() == WeatherCoordinates) {
            try {
                Thread.sleep(2000);
                setVisible(false);
                new WeatherCo();


            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);

            }


        } else if (e.getSource() == DefaultTime) {
            try {
                Thread.sleep(2000);
                setVisible(false);
                new DefaultTime();


            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);

            }

        } else if(e.getSource()==Setting){
            try{
                Thread.sleep(2000);
                setVisible(false);
                new Setting();
            }catch(InterruptedException ex){
                throw new RuntimeException(ex);
            }

        }else if (e.getSource() == cancel) {
            setVisible(false);

        }




    }





    public static void main(String[]args) {
        Main m = new Main();


    }
}