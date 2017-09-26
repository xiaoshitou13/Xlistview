package test.bwie.com.rikao1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 白玉春 on 2017/9/26.
 */

public class Myadater extends BaseAdapter {

    Context context;
    List<Mydata.DataBean> list;

    public Myadater(Context context) {
        this.context = context;
        this.list=  new ArrayList<>();
    }



    public void Add(List<Mydata.DataBean> newadd, int page){
        if(page==1){
            this.list.clear();
        }
        this.list.addAll(newadd);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Viewholder viewholder = null;

        if(view == null){
            view  = View.inflate(context,R.layout.item,null);
            viewholder  = new Viewholder();
            viewholder.im = view.findViewById(R.id.image);
            viewholder.t = view.findViewById(R.id.tv);
            view.setTag(viewholder);
        }else{
            viewholder = (Viewholder) view.getTag();
        }
        ImageLoader.getInstance().displayImage(list.get(i).getPic_url(),viewholder.im);
        viewholder.t.setText(list.get(i).getNews_title());
        return view;
    }


    class Viewholder{
        ImageView im;
        TextView t;
    }
}
