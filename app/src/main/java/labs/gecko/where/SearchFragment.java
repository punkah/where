package labs.gecko.where;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by punkah on 11/6/2016.
 */

public class SearchFragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void search(String searchTerm)
    {
//        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}, 1337);
//        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//        double latitude = location.getLatitude();
//        double longitude = location.getLongitude();
        final View progressBar = getActivity().findViewById(R.id.progressBar2);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });

        ArrayList<Place> places = PlacesService.search(searchTerm, -41.299280, 174.782326, 1000000);
        final ArrayAdapter<Place> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, places);
        getActivity().runOnUiThread(new Runnable() {
                          @Override
                          public void run() {
                              setListAdapter(adapter);
                              progressBar.setVisibility(View.GONE);
                          }
                      });

    }
}