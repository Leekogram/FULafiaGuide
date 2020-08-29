package Adaptors;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.FontsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.leedroids.fulafiaguide.R;

import java.util.ArrayList;

import model.ChannelModel;

public class OnlineChannelAdapter extends RecyclerView.Adapter<OnlineChannelAdapter.ChannelViewholder> {
    private ArrayList<ChannelModel> data;
    private Context context;

    public OnlineChannelAdapter(Context context,ArrayList<ChannelModel> data){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ChannelViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.channel_view,parent,false);
        return new ChannelViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelViewholder holder, int position) {
        ChannelModel item = data.get(position);
        holder.channelName.setText(item.getChannelName());
        holder.icon.setImageResource(item.getIcon());
        holder.channel.setTag(item.getUrl());
        holder.channel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = (String)view.getTag();
                Toast.makeText(context,"Loading ...",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
                context.startActivity(intent);
            }
        });

        Animation animation = AnimationUtils.loadAnimation(context,android.R.anim.fade_out);
        holder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ChannelViewholder extends RecyclerView.ViewHolder{
        AppCompatImageView icon;
        CardView channel;
        TextView channelName;

        public ChannelViewholder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.channelIcon);
            channel = itemView.findViewById(R.id.channel);
            channelName= itemView.findViewById(R.id.channelName);
        }
    }
}
