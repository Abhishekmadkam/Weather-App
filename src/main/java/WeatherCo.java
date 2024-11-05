import org.json.simple.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherCo extends JFrame implements ActionListener{
    JButton cancel;
    JButton Exit;
    private JSONObject weatherData;

    public WeatherCo(){
        // setup our gui and add a title
        super("Weather App");

        // configure gui to end the program's process once it has been closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set the size of our gui (in pixels)
        setSize(450, 650);

        // load our gui at the center of the screen
        setLocationRelativeTo(null);

        // make our layout manager null to manually position our components within the gui
        setLayout(null);

        // prevent any resize of our gui
        setResizable(false);

        addGuiComponents();
        setVisible(true);
    }

    private void addGuiComponents(){
        // search field
        JTextField searchTextField = new JTextField();

        // set the location and size of our component
        searchTextField.setBounds(15, 15, 351, 45);

        // change the font style and size
        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(searchTextField);

        JTextField Wc = new JTextField();
        Wc.setBounds(15,250,400,35);
        Wc.setFont(new Font("Times new Roman",Font.BOLD,15));
        add(Wc);


        JLabel windspeedImage = new JLabel(loadImage("src/assets/windspeed.png"));
        windspeedImage.setBounds(220, 450, 74, 66);
        add(windspeedImage);

        // windspeed text
        JLabel windspeedText = new JLabel("<html><b>Windspeed</b> 15km/h</html>");
        windspeedText.setBounds(310, 450, 85, 55);
        windspeedText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(windspeedText);

        // humidity image
        JLabel humidityImage = new JLabel(loadImage("src/assets/humidity.png"));
        humidityImage.setBounds(15, 450, 74, 66);
        add(humidityImage);

        // humidity text
        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(90, 450, 85, 55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);

        cancel = new JButton("Cancel");
        cancel.setBounds(50,550,80,20);
        cancel.setFont(new Font("Times New Roman",Font.BOLD,12));
        cancel.addActionListener(this);
        add(cancel);


        Exit = new JButton("Exit");
        Exit.setBounds(300,550,80,20);
        Exit.setFont(new Font("Times New Roman",Font.BOLD,12));
        Exit.addActionListener(this);
        add(Exit);

        // search button
        JButton searchButton = new JButton(loadImage("src/assets/search.png"));

        // change the cursor to a hand cursor when hovering over this button
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375, 13, 47, 45);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get location from user
                String userInput = searchTextField.getText();

                // validate input - remove whitespace to ensure non-empty text
                if (userInput.replaceAll("\\s", "").length() <= 0) {
                    WeatherApp.getLocationData("");
                    return;
                }

                // retrieve weather data
                weatherData = WeatherApp.getWeatherData(userInput);

                // update gui

                // update weather image
                String weatherCondition = (String) weatherData.get("weather_condition");

//                // depending on the condition, we will update the weather image that corresponds with the condition
//                switch(weatherCondition){
//                    case "Clear":
//                        weatherConditionImage.setIcon(loadImage("src/assets/clear.png"));
//                        break;
//                    case "Cloudy":
//                        weatherConditionImage.setIcon(loadImage("src/assets/cloudy.png"));
//                        break;
//                    case "Rain":
//                        weatherConditionImage.setIcon(loadImage("src/assets/rain.png"));
//                        break;
//                    case "Snow":
//                        weatherConditionImage.setIcon(loadImage("src/assets/snow.pngImage"));
//                        break;
//                }
//
//                // update temperature text
//                double temperature = (double) weatherData.get("temperature");
//                temperatureText.setText(temperature + " C");
//
//                // update weather condition text
//                weatherConditionDesc.setText(weatherCondition);
//
//                // update humidity text
//                long humidity = (long) weatherData.get("humidity");
//                humidityText.setText("<html><b>Humidity</b> " + humidity + "%</html>");
//
//                // update windspeed text
//                double windspeed = (double) weatherData.get("windspeed");
//                windspeedText.setText("<html><b>Windspeed</b> " + windspeed + "km/h</html>");

             Wc.setText(weatherCondition);

                double windspeed = (double) weatherData.get("windspeed");
                windspeedText.setText("<html><b>Windspeed</b> " + windspeed + "km/h</html>");

                // update humidity text
                long humidity = (long) weatherData.get("humidity");
                humidityText.setText("<html><b>Humidity</b> " + humidity + "%</html>");

            }
        });
        add(searchButton);
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

    // used to create images in our gui components
    private ImageIcon loadImage(String resourcePath){
        try{
            // read the image file from the path given
            BufferedImage image = ImageIO.read(new File(resourcePath));

            // returns an image icon so that our component can render it
            return new ImageIcon(image);
        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("Could not find resource");
        return null;
    }
}

