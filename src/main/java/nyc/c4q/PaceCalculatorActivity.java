package nyc.c4q;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PaceCalculatorActivity extends FragmentActivity {

        EditText inputDistance;
        EditText inputTimeMin;
        EditText inputTimeSec;
        EditText inputPaceMin;
        EditText inputPaceSec;
        Button buttonCalculate;

    double paceInSeconds;
    double timeInSeconds;
    double distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_calculator);
        inputDistance = (EditText) findViewById(R.id.input_distance);
        inputTimeMin = (EditText) findViewById(R.id.input_time_min);
        inputTimeSec = (EditText) findViewById(R.id.input_time_sec);
        inputPaceMin = (EditText) findViewById(R.id.input_pace_min);
        inputPaceSec = (EditText) findViewById(R.id.input_pace_sec);
        buttonCalculate = (Button) findViewById(R.id.button_calculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String distanceText = inputDistance.getText().toString();
                String timeMinText = inputTimeMin.getText().toString();
                String timeSecText = inputTimeSec.getText().toString();
                String paceSecText = inputPaceSec.getText().toString();
                String paceMinText = inputPaceMin.getText().toString();

                if (isNumeric(distanceText)) {
                    distance = Double.valueOf(distanceText);
                    if ((isNumeric(timeSecText) || isNumeric(timeMinText)) && !(isNumeric(paceMinText) || isNumeric(paceSecText))) {
                        timeInSeconds = Double.valueOf(timeSecText) + (Double.valueOf(timeMinText) * 60);
                        paceInSeconds = distance / timeInSeconds;
                        inputPaceSec.setText(String.valueOf((paceInSeconds % 60) * 60));
                        inputPaceMin.setText(String.valueOf((paceInSeconds / 60)));

                    } else if (!(isNumeric(timeSecText) || isNumeric(timeMinText)) && (isNumeric(paceMinText) || isNumeric(paceSecText))) {
                        paceInSeconds = Double.valueOf(paceSecText) + (Double.valueOf(paceMinText) * 60);
                        timeInSeconds = distance * paceInSeconds;
                        inputTimeSec.setText(String.valueOf((timeInSeconds % 60)));
                        inputTimeMin.setText(String.valueOf((timeInSeconds / 60)));
                    }

                } else if ((isNumeric(timeSecText) || isNumeric(timeMinText)) && (isNumeric(paceMinText) || isNumeric(paceSecText))) {
                    timeInSeconds = Double.valueOf(timeSecText) + (Double.valueOf(timeMinText) * 60);
                    paceInSeconds = Double.valueOf(paceSecText) + (Double.valueOf(paceMinText) * 60);
                    inputDistance.setText(String.valueOf(((timeInSeconds/60) * (paceInSeconds/60))/60));
                }


            }
        });
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

}
