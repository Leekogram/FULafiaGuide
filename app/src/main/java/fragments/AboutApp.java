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

public class AboutApp extends Fragment {
    CardView anthonyCard, tundeCard, aliyuCard, tasiuCard;
    public AboutApp(){
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about_app, container, false);

        anthonyCard = view.findViewById(R.id.anthony_details);
        tundeCard = view.findViewById(R.id.tunde_details);
        aliyuCard = view.findViewById(R.id.aliyu_details);
        tasiuCard = view.findViewById(R.id.tk_details);

        anthonyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.linkedin.com/mwlite/in/anthony-ameh-b3b8aa1a6"));
                startActivity(i);
            }
        });
        tundeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://wwww.twitter.com/RedEye_Tech"));
                startActivity(i);
            }
        });
        aliyuCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.twitter.com/Iam_Leeko"));
                startActivity(i);
            }
        });
        tasiuCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.twitter.com/tasiukwaplong"));
                startActivity(i);
            }
        });
        return view;
    }
}
