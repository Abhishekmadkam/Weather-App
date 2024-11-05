
import javax.swing.*;

public class AppLauncher {

    public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new Main();
               // System.out.println(WeatherApp.getLocationData(""));
               //System.out.println(WeatherApp.getCurrentTime());
            }
        });
    }
}
