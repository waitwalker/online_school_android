package com.etiantian.onlineschoolandroid.modules.common_tools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.etiantian.onlineschoolandroid.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadSampleListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.util.FileDownloadUtils;
import com.shockwave.pdfium.PdfDocument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class PDFReaderActivity extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener,
        OnPageErrorListener {

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reader);

        initView();
        Intent intent = getIntent();
        if (intent != null) {
            final String pafURL = intent.getStringExtra("url");
            final String title = intent.getStringExtra("title");
            download(pafURL, title);

        }
    }

    //下载具体操作
    private void download(String pafURL, String title) {
        try {

            //final String filePath = getExternalFilesDir("").getPath() + File.separator + "pdf" + File.separator + title + ".pdf";

            final String filePath = FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "pdf" + File.separator + title + ".pdf";

            File file1 = new File(filePath);
            if (file1.exists()) {
                loadPDF(filePath);
            } else {
                BaseDownloadTask task = FileDownloader.getImpl().create(pafURL)
                        .setPath(filePath, false)
                        .setCallbackProgressTimes(300)
                        .setMinIntervalUpdateSpeed(400)
                        .setListener(new FileDownloadSampleListener() {

                            @Override
                            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                                super.pending(task, soFarBytes, totalBytes);
                            }

                            @Override
                            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                                super.progress(task, soFarBytes, totalBytes);
                            }

                            @Override
                            protected void error(BaseDownloadTask task, Throwable e) {
                                super.error(task, e);
                            }

                            @Override
                            protected void connected(BaseDownloadTask task, String etag, boolean isContinue, int soFarBytes, int totalBytes) {
                                super.connected(task, etag, isContinue, soFarBytes, totalBytes);
                            }

                            @Override
                            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                                super.paused(task, soFarBytes, totalBytes);
                            }

                            @Override
                            protected void completed(BaseDownloadTask task) {
                                super.completed(task);
                                loadPDF(filePath);
                            }

                            @Override
                            protected void warn(BaseDownloadTask task) {
                                super.warn(task);
                            }
                        });
                task.start();
            }
            //loadPDF(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadPDF(String filePath) {
        pdfView.fromFile(new File(filePath))
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .load();
    }


    private void initView() {
        pdfView = findViewById(R.id.pdfView);
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        //pageNumber = page;
        setTitle(String.format("%s %s / %s", "pdfFileName", page + 1, pageCount));
    }

    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        Log.e("TAG", "title = " + meta.getTitle());
        Log.e("TAG", "author = " + meta.getAuthor());
        Log.e("TAG", "subject = " + meta.getSubject());
        Log.e("TAG", "keywords = " + meta.getKeywords());
        Log.e("TAG", "creator = " + meta.getCreator());
        Log.e("TAG", "producer = " + meta.getProducer());
        Log.e("TAG", "creationDate = " + meta.getCreationDate());
        Log.e("TAG", "modDate = " + meta.getModDate());

    }

    @Override
    public void onPageError(int page, Throwable t) {
        Log.e("TAG", "Cannot load page " + page);
    }
}