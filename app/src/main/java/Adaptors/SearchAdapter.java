package Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.leedroids.fulafiaguide.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import model.SearchModel;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder>{
    private Context context;
    private List<SearchModel> searchModelList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView faculty_name;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            faculty_name= view.findViewById(R.id.FacultyName);
            thumbnail = view.findViewById(R.id.Image);

        }
    }

    public SearchAdapter(Context context, List<SearchModel> searchModelList) {
        this.context = context;
        this.searchModelList = searchModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.searchsingleitem, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.faculty_name.setText(searchModelList.get(position).getFaculty_Name());
        holder.thumbnail.setImageResource(searchModelList.get(position).getFaculty_Image());
    }


    @Override
    public int getItemCount() {
        return searchModelList.size();
    }
}
