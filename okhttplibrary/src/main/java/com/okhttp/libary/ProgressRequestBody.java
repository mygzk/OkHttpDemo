package com.okhttp.libary;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

/**
 * Created by guozhk on 16-7-28.
 */
public class ProgressRequestBody extends RequestBody {
    private MediaType mediaType;
    private File file;
    private long total;
    private long currentLong;
    private IProgressCallback callback;

    public ProgressRequestBody(MediaType mediaType, File file, long total,long currentLong, IProgressCallback callback) {
        this.mediaType = mediaType;
        this.file = file;
        this.total = total;
        this.currentLong = currentLong;
        this.callback = callback;
    }

    @Override
    public MediaType contentType() {
        return mediaType;
    }

    @Override
    public long contentLength() {
        return file.length();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        Source source;
        try {
            source = Okio.source(file);
            Buffer buf = new Buffer();
            long current = 0;
            for (long readCount; (readCount = source.read(buf, 2048)) != -1; ) {
                sink.write(buf, readCount);
                current += readCount;
                final long finalCurrent = currentLong+current;
                Platform.mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback != null) {
                            callback.progress(total, finalCurrent);
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
