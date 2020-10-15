package com.etiantian.onlineschoolandroid.modules.common_tools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.etiantian.onlineschoolandroid.R;
import com.etiantian.onlineschoolandroid.base.BaseActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.ai_test.AITestListActivity;
import com.etiantian.onlineschoolandroid.modules.mycourse.change_material.ChangeMaterialVersionActivity;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.jaeger.library.StatusBarUtil;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadSampleListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.util.FileDownloadUtils;
import com.shockwave.pdfium.PdfDocument;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import java.io.File;

public class PDFReaderActivity extends BaseActivity implements OnPageChangeListener, OnLoadCompleteListener,
        OnPageErrorListener, View.OnClickListener {

    private PDFView pdfView;
    private ViewGroup backButton;
    private ViewGroup navigationBar;
    private TextView back_button;
    private CommonTitleBar commonTitleBar;
    private Button knowledgeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reader);
        initActionBar();

        initView();
        Intent intent = getIntent();
        if (intent != null) {
            final String pafURL = intent.getStringExtra("url");
            final String title = intent.getStringExtra("title");
            download(pafURL, title);

        }
    }

    ///
    /// @description actionBar
    /// @param
    /// @return
    /// @author waitwalker
    /// @time 2020/9/29 9:09 AM
    ///
    private void initActionBar() {
        hideActionBar();
        navigationBar = findViewById(R.id.navigation_bar);
        navigationBar.setBackgroundColor(Color.parseColor("#5FACEF"));
        commonTitleBar = findViewById(R.id.actionbar);
        commonTitleBar.setBackgroundColor(Color.parseColor("#5FACEF"));
        StatusBarUtil.setColor(PDFReaderActivity.this, Color.parseColor("#5FACEF"));

        backButton = findViewById(R.id.back_container);
        backButton.setOnClickListener(this);
        back_button = findViewById(R.id.action_bar_title);

        back_button.setTextColor(Color.WHITE);
        back_button.setOnClickListener(this);

        knowledgeButton = findViewById(R.id.right_button);
        knowledgeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_container:
            case R.id.action_bar_title:
                finish();
                break;
        }
    }

    //下载具体操作
    private void download(String pafURL, String title) {
        back_button.setText(title);
        try {

            //final String filePath = getExternalFilesDir("").getPath() + File.separator + "pdf" + File.separator + title + ".pdf";

            final String filePath = FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "pdf" + File.separator + title + ".pdf";

            hud.show();
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
        hud.dismiss();
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