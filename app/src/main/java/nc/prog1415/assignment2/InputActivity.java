package nc.prog1415.assignment2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class InputActivity extends Activity {
    private Data inputData = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        final Switch s = this.findViewById(R.id.switch1);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputData.switchIsOn = !inputData.switchIsOn;
                ((Switch)view).setText(inputData.switchIsOn ? R.string.SwitchOn : R.string.SwitchOff);
            }
        });

        final RadioGroup rg = (RadioGroup)this.findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                final RadioButton rb = InputActivity.this.findViewById(radioGroup.getCheckedRadioButtonId());
                Toast.makeText(InputActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
                inputData.radioState = Integer.parseInt(rb.getText().toString());
            }
        });

        final TextView tv = (TextView)this.findViewById(R.id.editText);
        tv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                    if(!b)
                    {
                        Toast.makeText(InputActivity.this, ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
}