package cimdata.android.dez2017.activitylifecycleuebergang;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView outputText;

    // alle views erben von
    ViewGroup rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Hier aktivieren wir den Pfeil
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        outputText = findViewById(R.id.txt_output);
        rootLayout = findViewById(R.id.l_root);

        // Daten empfangen

        // Zuerst holen und speichern wir uns unseren Intent
        Intent intent = getIntent();

        if (intent == null) {
            throw new AssertionError();
        }

        // dann holen wir uns den Wert mit Hilfe des Keys aus dem Intent
        int activityType = intent.getIntExtra(MainActivity.EXTRA_ACTIVITY_TYP, 0);

        String msg = "";
        int bgColor;

        switch (activityType) {

            case MainActivity.ACTIVITY_01:
                msg = "Der erste Button";
                bgColor = getResources().getColor(android.R.color.holo_red_light);
                break;

            case MainActivity.ACTIVITY_02:
                msg = "Der zweite Button";
                bgColor = getResources().getColor(android.R.color.holo_green_light);
                break;

            case MainActivity.ACTIVITY_03:
                msg = "Der dritte Button";
                bgColor = getResources().getColor(android.R.color.holo_blue_light);
                break;

            default:
                msg = "Konnte den Button nicht finden.";
                bgColor = getResources().getColor(R.color.colorAccent);
                break;
        }

        outputText.setText(msg);
        rootLayout.setBackgroundColor(bgColor);

    }

    @Override
    protected void onPause() {
        super.onPause();

        overridePendingTransition(
                R.anim.slide_in_left,  // die Animation für die neue Activity
                R.anim.slide_out_right // die Animation für die alte Activity
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
