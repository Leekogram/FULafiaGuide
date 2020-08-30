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
import model.DepartmentModel;
import model.PrincipalOfficersModel;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.MyViewHolder> {

    private List<DepartmentModel> departmentModels;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView department_name;

        public MyViewHolder(View view) {
            super(view);
            department_name = (TextView)view.findViewById(R.id.DepartmentName);
        }
    }

    public DepartmentAdapter(Context context, List<DepartmentModel> departmentModels) {
        this.context = context;
        this.departmentModels = departmentModels;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.department, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DepartmentModel Item = departmentModels.get(position);

        holder.department_name.setText(Item.getDepartmentName());

        Animation animation = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return departmentModels.size();
    }
}
