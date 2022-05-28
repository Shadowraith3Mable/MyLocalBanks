package sg.edu.rp.c346.id21022328.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.DeniedByServerException;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button DBS;
    Button OCBC;
    Button UOB;
    String bank_holder ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBS = findViewById(R.id.DBS);
        OCBC = findViewById(R.id.OCBC);
        UOB = findViewById(R.id.UOB);

        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        for(int i =0; i<menu.size(); i++){
            MenuItem menuItem = menu.getItem(i);
            SpannableString spannable = new SpannableString(menu.getItem(i).getTitle().toString());
            spannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0,spannable.length(),0);
            menuItem.setTitle(spannable);
        }
        return true;

    }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            getMenuInflater().inflate(R.menu.menu_main2, menu);
            if (v == DBS) {
                bank_holder = "DBS";
            }else if (v == OCBC){
                bank_holder = "OCBC";
            }else{
                bank_holder = "UOB";
            }


            Toast.makeText(MainActivity.this, bank_holder, Toast.LENGTH_SHORT).show();
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            DBS.setText("DBS");
            OCBC.setText("OCBC");
            UOB.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            DBS.setText("星展银行");
            OCBC.setText("华侨银行");
            UOB.setText("大华银行");
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id2 = item.getItemId();

        if (id2 == R.id.websiteSelection && bank_holder.equalsIgnoreCase("DBS")) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
            startActivity(intent);
            return true;
        } else if (id2 == R.id.websiteSelection && bank_holder.equalsIgnoreCase("OCBC")) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
            startActivity(intent);
            return true;
        } else if (id2 == R.id.websiteSelection && bank_holder.equalsIgnoreCase("UOB")) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
            startActivity(intent);
            return true;

        }
        if (id2 == R.id.contactthebankSelection && bank_holder.equalsIgnoreCase("DBS")) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(String.format("tel:+%s", "+18001111111")));
            startActivity((intentCall));
            return true;
        } else if (id2 == R.id.contactthebankSelection && bank_holder.equalsIgnoreCase("OCBC")) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(String.format("tel:+%s", "+18003633333")));
            startActivity((intentCall));
            return true;
        } else if (id2 == R.id.contactthebankSelection && bank_holder.equalsIgnoreCase("UOB")) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(String.format("tel:+%s", "+18002222121")));
            startActivity((intentCall));
            return true;

        }
        if (id2 == R.id.favouriteSelection && bank_holder.equalsIgnoreCase("DBS")) {
            DBS.setTextColor(Color.RED);
            return true;

        }

        if (id2 == R.id.favouriteSelection && bank_holder.equalsIgnoreCase("OCBC")){
            OCBC.setTextColor(Color.RED);
            return true;
        
        }

        if (id2 == R.id.favouriteSelection && bank_holder.equalsIgnoreCase("UOB")) {
            UOB.setTextColor(Color.RED);
            return true;
        }




        return super.onContextItemSelected(item);
    }

}