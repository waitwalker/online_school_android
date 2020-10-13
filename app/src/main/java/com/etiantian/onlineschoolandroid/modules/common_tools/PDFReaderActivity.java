package com.etiantian.onlineschoolandroid.modules.common_tools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.etiantian.onlineschoolandroid.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.shockwave.pdfium.PdfDocument;

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
            String pafURL = intent.getStringExtra("url");
            if (pafURL != null) {
                Uri uri = Uri.parse(pafURL);
                pdfView.fromUri(uri)
                        .defaultPage(0)
                        .onPageChange(this)
                        .enableAnnotationRendering(true)
                        .onLoad(this)
                        .scrollHandle(new DefaultScrollHandle(this))
                        .spacing(10) // in dp
                        .onPageError(this)
                        .load();
            }
        }

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