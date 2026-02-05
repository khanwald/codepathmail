package com.example.codepathmail

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var emails: List<Email>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.emailsRv)
        emails = EmailFetcher.getEmails()

        val adapter = EmailAdapter(emails)

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)

        val button = findViewById<Button>(R.id.button3)


        button.setOnClickListener {
            (emails as MutableList<Email>).addAll(EmailFetcher.getNext5Emails())
            val index= adapter.itemCount
            adapter.notifyItemInserted(index)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}