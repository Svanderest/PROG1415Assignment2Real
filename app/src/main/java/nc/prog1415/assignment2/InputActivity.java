package nc.prog1415.assignment2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
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
                        Toast.makeText(InputActivity.this, ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
                    else
                        ((TextView)view).setText("");
            }
        });

        final CheckBox cb = (CheckBox)this.findViewById(R.id.checkBox);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                inputData.checkState = b;
                cb.setText(b ? R.string.checkedYes : R.string.checkedNo);
            }
        });

        final SeekBar sb = (SeekBar)this.findViewById(R.id.seekBar);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                String displayText = String.format(getResources().getString(R.string.startSlide),seekBar.getProgress());
                Toast.makeText(InputActivity.this, displayText, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String displayText = String.format(getResources().getString(R.string.endSlide),seekBar.getProgress());
                Toast.makeText(InputActivity.this, displayText, Toast.LENGTH_SHORT).show();
                inputData.sliderPosition = seekBar.getProgress();
            }
        });

        //This control is an intetionally useless take on Xeno's paradox
        SeekBar xeno = (SeekBar)this.findViewById(R.id.xenoSeekBar);
        xeno.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int max = seekBar.getMax();
                if(seekBar.getProgress() == max) {
                    seekBar.setMax(max * 2);
                    inputData.xeno = seekBar.getMax();
                    String displayText = getResources().getString(R.string.Xeno);
                    Toast.makeText(InputActivity.this, displayText, Toast.LENGTH_SHORT).show();
                }
            }
        });

        final RatingBar rb = (RatingBar)this.findViewById(R.id.ratingBar);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                inputData.stars = v;
                Toast.makeText(InputActivity.this, String.format(getResources().getString(R.string.Stars),v), Toast.LENGTH_SHORT).show();
            }
        });

        final Button btn = (Button)this.findViewById(R.id.counterButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputData.clickCounter++;
                String displayText = String.format(getResources().getString(R.string.ButtonTemplate),inputData.clickCounter);
                Toast.makeText(InputActivity.this, displayText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}