package com.example.news_24.app.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.NavArgsLazy
import androidx.navigation.fragment.navArgs
import com.example.news_24.R
import com.example.news_24.app.ui.MainActivity
import com.example.news_24.app.ui.NewsViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment() {

    private val args: ArticleFragmentArgs by navArgs()

    lateinit var viewModel: NewsViewModel
    lateinit var webView: WebView
    lateinit var fab: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        val article = args.article
        webView = view.findViewById(R.id.webView)
        fab = view.findViewById(R.id.fab)

        webView.apply {
            webViewClient = WebViewClient()
            loadUrl((article.url))
        }

        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article saved successfully !", Snackbar.LENGTH_SHORT).show()
        }
    }
}