package sg.edu.rp.c346.id20039202.democontextmenutranslation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvTranslatedText, tvTranslatedText2;
    String wordClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedViewText);
        registerForContextMenu(tvTranslatedText);
        tvTranslatedText2 = findViewById(R.id.textViewTranslatedViewText2);
        registerForContextMenu(tvTranslatedText2);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //menu.add(0, 0, 0, "English");
        //menu.add(0, 1, 1, "Italian");

        getMenuInflater().inflate(R.menu.menu_main, menu);



        if(v == tvTranslatedText){
            wordClicked = "hello";
        }
        else if(v == tvTranslatedText2) {
            wordClicked = "bye";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.englishSelection) {
            Toast.makeText(MainActivity.this, "English Selected", Toast.LENGTH_LONG).show();
            if(wordClicked.equalsIgnoreCase("hello")) {
                tvTranslatedText.setText("Hello");

            }
            else if(wordClicked.equalsIgnoreCase("bye")) {
                tvTranslatedText2.setText("Bye");
            }

            return true;
        }
        else if(item.getItemId() == R.id.italianSelection) {
            Toast.makeText(MainActivity.this, "Italian Selected", Toast.LENGTH_LONG).show();
            if(wordClicked.equalsIgnoreCase("hello")){
                tvTranslatedText.setText("Ciao");
            }
            else if(wordClicked.equalsIgnoreCase("bye")){
                tvTranslatedText2.setText("Addio");
            }


            return true;
        }
        return super.onContextItemSelected(item);
    }
}