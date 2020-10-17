package uk.ac.rgu.rguweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Implementation for the main activity
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // member variable for the user provided location
    private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the Get Forecast button
        Button btnGetForecast = findViewById(R.id.btnGetForecast);

        // set the click listener to the btnGetForecast Button
        btnGetForecast.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // view is the View (Button, ExitText, TextView, etc) that was clicked

        // if it was the btnGetForecast
        if (view.getId() == R.id.btnGetForecast) {
            //Get the text entered by the user in the etLocationInput
            EditText editText = findViewById(R.id.etLocationInput);
            String enteredLocation = String.valueOf(editText.getText());

            //remove all whitespaces entered by the user
            String strippedEnteredLocation = enteredLocation.replaceAll("\\s", "");

            //update the weather forecast
            TextView tvWeather = findViewById(R.id.tvWeather);
            tvWeather.setText("");

            //Assuming the user hasn't entered anything just yet.
            String msg = getString(R.string.tvLocationDisplayError);
            //check if any text was entered first.
            if (strippedEnteredLocation.length() > 0) {
                msg = getString(R.string.tvLocationDisplay, enteredLocation);

                //display the weather as provided by our random weather forecast generator
                //get the weather
                RandomWeatherForecastGetter weatherForecastGetter = new RandomWeatherForecastGetter(getApplicationContext());
                String weather = weatherForecastGetter.getWeather();


                //update the forecast
                tvWeather.setText(weather);
            }
            //append it to the text in the tvLocationDisplay
            TextView locationDisplay = findViewById(R.id.tvLocationDisplay);
            locationDisplay.setText(msg);
        }
    }
}