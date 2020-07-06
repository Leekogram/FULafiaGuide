package Adaptors;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.leedroids.fulafiaguide.R;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by HP-USER on 19-Jul-19.
 */

public class SliderAdapter extends PagerAdapter {
    private Context context;
    int[] images;




    public SliderAdapter(Context context,int[] images){
        this.context = context;


        this.images = images;

    }
    @Override
    public int getCount(){
        return
                images.length;

    }

    @Override
    public  boolean isViewFromObject(View view, Object object){

        return view == object;
    }

    @Override
    public  Object instantiateItem(ViewGroup container, int position){

        ImageView image;
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.slider_item, null);



        // get reference to imageView in pager_item layout
        image = (ImageView) view.findViewById(R.id.sliderImage);
// Set an image to the ImageView
        image.setImageResource(images[position]);
// Add pager_item layout as the current page to the ViewPager
        ((ViewPager) container).addView(view,0);
        return view;
    }
    @Override
    public  void destroyItem(ViewGroup container, int position, Object object){


        // Remove pager_item layout from ViewPager
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}
