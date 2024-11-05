import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DefaultTime extends JFrame implements ActionListener {

   JButton cancel;

    DefaultTime() {
        super("Default Time");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(300, 130);
        setLocation(850, 120);
        setLayout(null);

        JLabel timeLabel = new JLabel();
        timeLabel.setBounds(110, 15, 60, 25);
        add(timeLabel);

        Timer timer = new Timer(1000, e -> updateTime(timeLabel));
        timer.start();

        addComponents();
        setVisible(true);


    }

    private void addComponents() {
        cancel = new JButton("Cancel");
        cancel.setBounds(90,50,90,20);
        cancel.addActionListener(this);
        add(cancel);


    }






    public static void main(String[] args) {
        DefaultTime dt = new DefaultTime();
    }

    private static void updateTime(JLabel timeLabel) {
        Date currentTime = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = sdf.format(currentTime);

        timeLabel.setText(formattedTime);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==cancel){
          setVisible(false);
          new Main();
      }
    }


}


