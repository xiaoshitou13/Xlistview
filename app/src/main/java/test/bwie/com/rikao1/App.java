package test.bwie.com.rikao1;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * Created by 白玉春 on 2017/9/26.
 */

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        initLoader();
        initxUtils();
    }
    private void initxUtils() {
    		x.Ext.init(this);//必须的
    		x.Ext.setDebug(BuildConfig.DEBUG); // 可选的，是否输出debug日志, 开启debug会影响性能.
    	}

    public void initLoader() {

        // 图片显示参数设置
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)// 内存缓存
                .cacheOnDisk(true)// 缓存磁盘
                .showImageOnLoading(R.mipmap.ic_launcher)// 加载中
                .showImageOnFail(R.mipmap.ic_launcher)// 错误
                .showImageForEmptyUri(R.mipmap.ic_launcher)// URI错误
                .build();

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(
                this).defaultDisplayImageOptions(options).build();
        ImageLoader.getInstance().init(configuration);

    }
}
