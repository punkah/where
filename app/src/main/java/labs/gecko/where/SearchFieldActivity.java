package labs.gecko.where;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchFieldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_field);

        AutoCompleteTextView searchText = (AutoCompleteTextView) findViewById(R.id.searchText);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                handleTextChangedAction(s.toString());
            }
        });
        searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_GO) {
                    handleGoAction(v.getText().toString());
                    handled = true;
                }
                return handled;
            }
        });
    }

    private void handleTextChangedAction(String s) {
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
//                .permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.searchText);
//        ArrayList<Place> places = PlacesService.autocomplete(s);
//        final ArrayAdapter adapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_spinner_item, places);
//        textView.setAdapter(adapter);
//        String name = places.get(1).name;
//        textView.setHint(name);
    }

    private void handleGoAction(final String s) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                SearchFragment searchFragment = (SearchFragment) getFragmentManager().findFragmentById(R.id.searchFragment);
                searchFragment.search(s);
            }
        });


    }
}