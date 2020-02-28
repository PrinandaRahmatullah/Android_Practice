package id.ac.unsyiah.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String namaGambar = "uskbw";
    int listGambar = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGanti = findViewById(R.id.btn_ganti);
        btnGanti.setOnClickListener(this);
        getSupportActionBar().setTitle("Yoga Bucin");

    }

    public void gambarAset(View view) {
        String gambarAset = "mosa.jpg";

        ImageView iv = findViewById(R.id.ImageIcon);

        try {
            InputStream stream = getAssets().open(gambarAset);
            Drawable drawable = Drawable.createFromStream(stream, null);
            iv.setImageDrawable(drawable);

        } catch (Exception e){
            Log.e("Gambar error", e.getMessage());
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_ganti) {
            if(listGambar == 1){
                int res = getResources().getIdentifier(namaGambar, "drawable", getPackageName());

                ImageView iv = findViewById(R.id.ImageIcon);
                iv.setImageResource(res);
                this.namaGambar = "usk";
                this.listGambar = 0;
            } else {
                int res = getResources().getIdentifier(namaGambar, "drawable", getPackageName());

                ImageView iv = findViewById(R.id.ImageIcon);
                iv.setImageResource(res);
                this.namaGambar = "uskbw";
                this.listGambar = 1;
            }

        }
    }
}
