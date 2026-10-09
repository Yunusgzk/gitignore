package org.bbport.android;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public final class MainActivity extends Activity {

static {
    System.loadLibrary("bbport_android");
}

private native String nativeStatus();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ScrollView scroll = new ScrollView(this);

    LinearLayout layout = new LinearLayout(this);
    layout.setOrientation(LinearLayout.VERTICAL);
    layout.setGravity(Gravity.CENTER_VERTICAL);

    int pad = (int) (24 * getResources()
            .getDisplayMetrics().density);

    layout.setPadding(pad, pad, pad, pad);

    TextView title = new TextView(this);
    title.setText("Bloodborne Android ARM64");
    title.setTextSize(24);
    title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

    TextView status = new TextView(this);
    status.setTextSize(16);
    status.setText(
            "\nAndroid ARM64 başlangıç uygulaması\n\n"
            + nativeStatus()
            + "\n\nBu uygulama henüz Bloodborne oyununu çalıştırmaz. "
            + "Oyun motoru, FEXCore, grafik işleyicisi ve oyun verileri "
            + "henüz entegre edilmemiştir."
    );
    status.setTextIsSelectable(true);

    layout.addView(title);
    layout.addView(status);

    scroll.addView(layout);
    setContentView(scroll);
}

}
