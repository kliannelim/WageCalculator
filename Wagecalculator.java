import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WageCalculatorActivity extends AppCompatActivity {

    private EditText hourlyRateInput, hoursWorkedInput, deductionsInput;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wage_calculator);

        hourlyRateInput = findViewById(R.id.hourly_rate_input);
        hoursWorkedInput = findViewById(R.id.hours_worked_input);
        deductionsInput = findViewById(R.id.deductions_input);
        calculateButton = findViewById(R.id.calculate_button);
        resultText = findViewById(R.id.result_text);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateWage();
            }
        });
    }

    private void calculateWage() {
        try {
            double hourlyRate = Double.parseDouble(hourlyRateInput.getText().toString());
            double hoursWorked = Double.parseDouble(hoursWorkedInput.getText().toString());
            double deductions = Double.parseDouble(deductionsInput.getText().toString());

            double grossWage = hourlyRate * hoursWorked;
            double netWage = grossWage - deductions;

            String result = "Gross Wage: $" + grossWage + "\nNet Wage: $" + netWage;
            resultText.setText(result);
        } catch (NumberFormatException e) {
            resultText.setText("Please enter valid numbers.");
        }
    }
}
