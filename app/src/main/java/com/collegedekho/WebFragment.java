package com.collegedekho;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link WebFragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link WebFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class WebFragment extends Fragment{

    View view;
    ProgressDialog pdGlobal;
    private WebView mStockWebView;
    private String userRole, URL_DEFAULT = "http://www.educationinireland.com/en/How-Do-I-Apply-/";
    //private String userRole, URL_DEFAULT = "https://www.google.com";
    private Context mContext;

    public WebFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_web_view, container, false);
        init();
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        return view;
    }


    public void init() {
        mStockWebView = view.findViewById(R.id.webview);
        loadUrl();
    }

    private void loadUrl() {
        cancelProgressDialog(pdGlobal);
        pdGlobal = new ProgressDialog(mContext);
        mStockWebView.setWebViewClient(new AppWebViewClients(pdGlobal));
        mStockWebView.setWebChromeClient(new AppWebChromeClient());
        WebSettings webSettings = mStockWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mStockWebView.clearHistory();
        mStockWebView.clearFormData();
        mStockWebView.clearCache(true);
        mStockWebView.loadUrl(URL_DEFAULT);
        Log.v("karan", "karan URL_DEFAULT" + URL_DEFAULT);
    }


    private void cancelProgressDialog(ProgressDialog pdGlobal) {
        if (pdGlobal != null && pdGlobal.isShowing())
            pdGlobal.dismiss();
    }

    public class AppWebViewClients extends WebViewClient {
        private ProgressDialog pd;
        public AppWebViewClients(ProgressDialog progressDialog) {
            this.pd = progressDialog;
            pd.setTitle("");
            pd.setMessage("please wait..");
            pd.setCancelable(true);
            pd.show();
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            cancelProgressDialog(pd);
        }
    }

    class AppWebChromeClient extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return super.onJsAlert(view, url, message, result);
        }
    }
}
