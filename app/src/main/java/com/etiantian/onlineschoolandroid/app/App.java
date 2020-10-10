package com.etiantian.onlineschoolandroid.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import androidx.annotation.Nullable;

import com.etiantian.onlineschoolandroid.modules.common_tools.GSYExoHttpDataSourceFactory;
import com.etiantian.onlineschoolandroid.tools.PackageInfoManager;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.shuyu.gsyvideoplayer.player.PlayerFactory;

import java.io.File;

import tv.danmaku.ijk.media.exo2.Exo2PlayerManager;
import tv.danmaku.ijk.media.exo2.ExoMediaSourceInterceptListener;
import tv.danmaku.ijk.media.exo2.ExoSourceManager;

public class App extends Application {
    @SuppressLint("StaticFieldLeak")
    static private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        //LeakCanary.install(this);

        //GSYVideoType.enableMediaCodec();
        //GSYVideoType.enableMediaCodecTexture();

        PlayerFactory.setPlayManager(Exo2PlayerManager.class);//EXO模式
        ExoSourceManager.setSkipSSLChain(true);


        //PlayerFactory.setPlayManager(SystemPlayerManager.class);//系统模式
        //PlayerFactory.setPlayManager(IjkPlayerManager.class);//ijk模式

        //CacheFactory.setCacheManager(ExoPlayerCacheManager.class);//exo缓存模式，支持m3u8，只支持exo
        //CacheFactory.setCacheManager(ProxyCacheManager.class);//代理缓存模式，支持所有模式，不支持m3u8等

        //GSYVideoType.setShowType(GSYVideoType.SCREEN_MATCH_FULL);
        //GSYVideoType.setShowType(GSYVideoType.SCREEN_TYPE_FULL);
        //GSYVideoType.setShowType(GSYVideoType.SCREEN_MATCH_FULL);

        //GSYVideoType.setShowType(GSYVideoType.SCREEN_TYPE_CUSTOM);
        //GSYVideoType.setScreenScaleRatio(9.0f/16);

        //GSYVideoType.setRenderType(GSYVideoType.SUFRACE);
        //GSYVideoType.setRenderType(GSYVideoType.GLSURFACE);

        //IjkPlayerManager.setLogLevel(IjkMediaPlayer.IJK_LOG_SILENT);

        ExoSourceManager.setExoMediaSourceInterceptListener(new ExoMediaSourceInterceptListener() {
            @Override
            public MediaSource getMediaSource(String dataSource, boolean preview, boolean cacheEnable, boolean isLooping, File cacheDir) {
                //如果返回 null，就使用默认的
                return null;
            }

            /**
             * 通过自定义的 HttpDataSource ，可以设置自签证书或者忽略证书
             * demo 里的 GSYExoHttpDataSourceFactory 使用的是忽略证书
             * */
            @Override
            public HttpDataSource.BaseFactory getHttpDataSourceFactory(String userAgent, @Nullable TransferListener listener, int connectTimeoutMillis, int readTimeoutMillis, boolean allowCrossProtocolRedirects) {
                //如果返回 null，就使用默认的
                return new GSYExoHttpDataSourceFactory(userAgent, listener,
                        connectTimeoutMillis,
                        readTimeoutMillis, allowCrossProtocolRedirects);
            }
        });

        /*GSYVideoManager.instance().setPlayerInitSuccessListener(new IPlayerInitSuccessListener() {
            ///播放器初始化成果回调
            @Override
            public void onPlayerInitSuccess(IMediaPlayer player, GSYModel model) {
                if (player instanceof IjkExo2MediaPlayer) {
                    ((IjkExo2MediaPlayer) player).setTrackSelector(new DefaultTrackSelector());
                    ((IjkExo2MediaPlayer) player).setLoadControl(new DefaultLoadControl());
                }
            }
        });*/
    }

    public static Context getContext() {
        return mContext;
    }
    
    ///
    /// @description 是否debug 模式
    /// @param 
    /// @return 
    /// @author waitwalker
    /// @time 2020/9/2 4:54 PM
    ///
    public static boolean DEBUG() {
        return PackageInfoManager.isDebug(mContext);
    }
}
