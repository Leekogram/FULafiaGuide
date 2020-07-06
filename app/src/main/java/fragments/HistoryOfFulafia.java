package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leedroids.fulafiaguide.R;

import androidx.fragment.app.Fragment;

public class HistoryOfFulafia extends Fragment {

    public HistoryOfFulafia(){
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate
                (R.layout.fragment_fulafiahistory, container, false);






        return view;

    }
}
