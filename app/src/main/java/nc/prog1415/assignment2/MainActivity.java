package nc.prog1415.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button optionsButton = (Button)findViewById(R.id.optionsButton);
        optionsButton.setOnClickListener(new MenuClick());

        final Button imageButton = (Button)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new MenuClick());

        final Button soundButton = (Button)findViewById(R.id.soundButton);
        soundButton.setOnClickListener(new MenuClick());
    }

    class MenuClick implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            Intent i = null;
            switch(view.getId())
            {
                case R.id.imageButton:
                    i = new Intent(MainActivity.this, SecondActivity.class);
                    break;
                case R.id.optionsButton:
                    i = new Intent(MainActivity.this, InputActivity.class);
                    break;
                case R.id.soundButton:
                    i = new Intent(MainActivity.this, ThirdActivity.class);
            }
            startActivity(i);
        }
    }
}
