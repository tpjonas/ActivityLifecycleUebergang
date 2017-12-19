package cimdata.android.dez2017.activitylifecycleuebergang;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ConstraintLayout button01;
    ConstraintLayout button02;
    ConstraintLayout button03;

    public static final String EXTRA_ACTIVITY_TYP = "cimdata.android.dez2017.activitylifecycleuebergang.extra.activity.typ";

    public static final int ACTIVITY_01 = 1;
    public static final int ACTIVITY_02 = 2;
    public static final int ACTIVITY_03 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("***AB-MainActivity***", "onCreate");

        button01 = findViewById(R.id.btn_01);
        button02 = findViewById(R.id.btn_02);
        button03 = findViewById(R.id.btn_03);

        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
    }


    @Override
    public void onClick(View view) {

        // Zuerst entscheiden wir welcher Button geklickt wurde

        switch (view.getId()) {

            case R.id.btn_01:
                loadDetailActivity(ACTIVITY_01);
                break;

            case R.id.btn_02:
                loadDetailActivity(ACTIVITY_02);
                break;

            case R.id.btn_03:
                loadDetailActivity(ACTIVITY_03);
                break;

            default:
                throw new AssertionError("Falsche ID: " + view.getId());
        }

    }

    private void loadDetailActivity(int activityType) {
        // Hier erstellen wir unser Intent, mit dem wir eine Anfrage senden
        // dass wir eine Activity öffnen wollen.
        Intent intent = new Intent(
                this,  // Der App-Kontext
                DetailActivity.class // Die Klasse der Activity, die wir anzeigen wollen
        );

        // Als zweites fügen wir Extras hinzu (Daten)

        intent.putExtra(
                EXTRA_ACTIVITY_TYP, // Wir benötigen einen Key, an dem wir das Extra beim Empfangen identifizieren können
                activityType // Als zweites übergeben wir den Wert, den wir übertragen wollen
        );

        // Wenn wir keine Daten übergeben wollen starten wir die Activity nun.
        startActivity(intent);

        // Hier überschreiben wir die Übergangsanimation
        // Die Möglichkeiten der vorgefertigten Animationen (android.R.anim)
        // sind sehr gering. Andere Animationen müssen wir selber schreiben
        overridePendingTransition(
                R.anim.slide_in_right, // die Animation für die neue Activity
                R.anim.slide_out_left // die Animation für die alte Activity
        );
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("***AB-MainActivity***", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("***AB-MainActivity***", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("***AB-MainActivity***", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("***AB-MainActivity***", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("***AB-MainActivity***", "onDestroy");
    }
}
