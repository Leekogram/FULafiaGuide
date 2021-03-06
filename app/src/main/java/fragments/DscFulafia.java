package fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.leedroids.fulafiaguide.R;

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
                i.setData(Uri.parse("https://dsc.community.dev/federal-university-lafia/"));
                startActivity(i);
            }
        });
        return view;
    }
}
