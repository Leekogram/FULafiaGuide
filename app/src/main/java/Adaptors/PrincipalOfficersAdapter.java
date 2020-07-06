package Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.leedroids.fulafiaguide.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import model.PrincipalOfficersModel;

public class PrincipalOfficersAdapter extends RecyclerView.Adapter<PrincipalOfficersAdapter.MyViewHolder> {

    private List<PrincipalOfficersModel> principalOfficersModels;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;

        TextView name;
        TextView post;



        public MyViewHolder(View view) {
            super(view);
            photo = (ImageView)view.findViewById(R.id.picture);

            name = (TextView)view.findViewById(R.id.name);
            post = (TextView)view.findViewById(R.id.post);




        }
    }

    public PrincipalOfficersAdapter(Context context, List<PrincipalOfficersModel> principalOfficersModels) {
        this.context = context;
        this.principalOfficersModels = principalOfficersModels;

    }

    @Override
    public PrincipalOfficersAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singlephoto, parent, false);

        return new PrincipalOfficersAdapter.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(PrincipalOfficersAdapter.MyViewHolder holder, int position) {
        PrincipalOfficersModel Item = principalOfficersModels.get(position);


        holder.photo.setImageResource(Item.getPhotoid());
        holder.name.setText(Item.getName());
        holder.post.setText(Item.getPost());







        Animation animation = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return principalOfficersModels.size();
    }

}
