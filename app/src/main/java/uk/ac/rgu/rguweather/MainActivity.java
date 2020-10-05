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
        if (view.getId() == R.id.btnGetForecast){
        }
    }
}
