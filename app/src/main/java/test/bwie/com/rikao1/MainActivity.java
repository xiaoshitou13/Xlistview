package test.bwie.com.rikao1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import me.maxwin.view.XListView;

public class MainActivity extends AppCompatActivity implements XListView.IXListViewListener{

    private XListView xListView;
    int page = 1;
    private String str = "http://api.expoon.com/AppNews/getNewsList/type/1/p/";
    private Myadater myadater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        xListView = (XListView) findViewById(R.id.xlistview);



        xListView.setPullRefreshEnable(true);
        xListView.setPullLoadEnable(true);
        xListView.setXListViewListener(this);


        myadater = new Myadater(MainActivity.this);
        xListView.setAdapter(myadater);

        Getsuju(page);



    }

    private void Getsuju(final int page) {


        x.http().get(new RequestParams(str + page), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Mydata m = new Gson().fromJson(result,Mydata.class);
                List<Mydata.DataBean> list = m.getData();
                myadater.Add(list,page);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                xListView.stopLoadMore();
                xListView.stopRefresh();
                xListView.setRefreshTime("刚刚");

            }
        });

    }


    @Override
    public void onRefresh() {
        page =1;
        Getsuju(page);
    }

    @Override
    public void onLoadMore() {
        page +=1;
        Getsuju(page);
    }
}
