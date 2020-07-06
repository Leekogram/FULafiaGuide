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

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> implements Filterable {
    private Context context;
    private List<SearchModel> searchModelList;
    private List<SearchModel> searchModelListFiltered;
    private SearchAdapterListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView faculty_name;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            faculty_name= view.findViewById(R.id.FacultyName);
            thumbnail = view.findViewById(R.id.Image);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected contact in callback
                    listener.onSearchSelected(searchModelListFiltered.get(getAdapterPosition()));
                }
            });
        }
    }

    public SearchAdapter(Context context, List<SearchModel> searchModelList, SearchAdapterListener listener) {
        this.context = context;
        this.listener = listener;
        this.searchModelList = searchModelList;
        this.searchModelListFiltered = searchModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.searchsingleitem, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final SearchModel searchmodel = searchModelListFiltered.get(position);
        holder.faculty_name.setText(searchmodel.getFaculty_Name());


        holder.thumbnail.setImageResource(searchmodel.getFaculty_Image());
    }


    @Override
    public int getItemCount() {
        return searchModelListFiltered.size();
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    searchModelListFiltered = searchModelList;
                } else {
                    List<SearchModel> filteredList = new ArrayList<>();
                    for (SearchModel row : searchModelList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getFaculty_Name().toLowerCase().contains(charString.toLowerCase()) ) {
                            filteredList.add(row);
                        }
                    }

                    searchModelListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = searchModelListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                searchModelListFiltered = (ArrayList<SearchModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface SearchAdapterListener {
        void onSearchSelected(SearchModel searchmodel);
    }
}
