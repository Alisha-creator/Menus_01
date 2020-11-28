package alisha.digipodium.menus_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class AboutActitvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_actitvity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aboutmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_visit:
                Intent visit =new Intent(Intent.ACTION_VIEW, Uri.parse("https://meet.google.com/axv-ibsa-bjq"));
                startActivity(visit);
                break;
            case R.id.action_donate:
                Toast.makeText(this, "not available in your country", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_feedback:
                Toast.makeText(this,"are you a developer",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_rate:
                Toast.makeText(this,"Not availble on playstore",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}