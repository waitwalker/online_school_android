package com.etiantian.onlineschoolandroid.modules.common_tools;

import androidx.annotation.Nullable;

import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;

public final class GSYExoHttpDataSourceFactory extends HttpDataSource.BaseFactory {

    private final String userAgent;
    private final @Nullable
    TransferListener listener;
    private final int connectTimeoutMillis;
    private final int readTimeoutMillis;
    private final boolean allowCrossProtocolRedirects;

    /**
     Constructs a GSYExoHttpDataSourceFactory. Sets {@link
    GSYDefaultHttpDataSource#DEFAULT_CONNECT_TIMEOUT_MILLIS} as the connection timeout, {@link
    GSYDefaultHttpDataSource#DEFAULT_READ_TIMEOUT_MILLIS} as the read timeout and disables
     cross-protocol redirects.

     @param userAgent The User-Agent string that should be used.
     */
    public GSYExoHttpDataSourceFactory(String userAgent) {
        this(userAgent, null);
    }

    /**
     Constructs a GSYExoHttpDataSourceFactory. Sets {@link
    GSYDefaultHttpDataSource#DEFAULT_CONNECT_TIMEOUT_MILLIS} as the connection timeout, {@link
    GSYDefaultHttpDataSource#DEFAULT_READ_TIMEOUT_MILLIS} as the read timeout and disables
     cross-protocol redirects.

     @param userAgent The User-Agent string that should be used.
     @param listener  An optional listener.
     @see #GSYExoHttpDataSourceFactory(String, TransferListener, int, int, boolean)
     */
    public GSYExoHttpDataSourceFactory(String userAgent, @Nullable TransferListener listener) {
        this(userAgent, listener, GSYDefaultHttpDataSource.DEFAULT_CONNECT_TIMEOUT_MILLIS,
                GSYDefaultHttpDataSource.DEFAULT_READ_TIMEOUT_MILLIS, false);
    }

    /**
     @param userAgent                   The User-Agent string that should be used.
     @param connectTimeoutMillis        The connection timeout that should be used when requesting remote
     data, in milliseconds. A timeout of zero is interpreted as an infinite timeout.
     @param readTimeoutMillis           The read timeout that should be used when requesting remote data, in
     milliseconds. A timeout of zero is interpreted as an infinite timeout.
     @param allowCrossProtocolRedirects Whether cross-protocol redirects (i.e. redirects from HTTP
     to HTTPS and vice versa) are enabled.
     */
    public GSYExoHttpDataSourceFactory(
            String userAgent,
            int connectTimeoutMillis,
            int readTimeoutMillis,
            boolean allowCrossProtocolRedirects) {
        this(
                userAgent,
                /* listener= */ null,
                connectTimeoutMillis,
                readTimeoutMillis,
                allowCrossProtocolRedirects);
    }

    /**
     @param userAgent                   The User-Agent string that should be used.
     @param listener                    An optional listener.
     @param connectTimeoutMillis        The connection timeout that should be used when requesting remote
     data, in milliseconds. A timeout of zero is interpreted as an infinite timeout.
     @param readTimeoutMillis           The read timeout that should be used when requesting remote data, in
     milliseconds. A timeout of zero is interpreted as an infinite timeout.
     @param allowCrossProtocolRedirects Whether cross-protocol redirects (i.e. redirects from HTTP
     to HTTPS and vice versa) are enabled.
     */
    public GSYExoHttpDataSourceFactory(
            String userAgent,
            @Nullable TransferListener listener,
            int connectTimeoutMillis,
            int readTimeoutMillis,
            boolean allowCrossProtocolRedirects) {
        this.userAgent = userAgent;
        this.listener = listener;
        this.connectTimeoutMillis = connectTimeoutMillis;
        this.readTimeoutMillis = readTimeoutMillis;
        this.allowCrossProtocolRedirects = allowCrossProtocolRedirects;
    }

    @Override
    protected GSYDefaultHttpDataSource createDataSourceInternal(
            HttpDataSource.RequestProperties defaultRequestProperties) {
        GSYDefaultHttpDataSource dataSource =
                new GSYDefaultHttpDataSource(
                        userAgent,
                        connectTimeoutMillis,
                        readTimeoutMillis,
                        allowCrossProtocolRedirects,
                        defaultRequestProperties);
        if (listener != null) {
            dataSource.addTransferListener(listener);
        }
        return dataSource;
    }
}
