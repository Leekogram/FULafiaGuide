package fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leedroids.fulafiaguide.R;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class DscFulafia extends Fragment {
    private CardView aboutDsc;
    public DscFulafia(){
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dsc_fulafia, container, false);
        aboutDsc = (CardView)view.findViewById(R.id.about_dsc);
        aboutDsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://t.co/uAs3wGuRzP"));
                startActivity(i);
            }
        });
        return view;
    }
}
