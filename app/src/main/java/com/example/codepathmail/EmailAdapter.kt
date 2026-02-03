package com.example.codepathmail
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class EmailAdapter(private val emails: List<Email>): RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val context = parent.context
        val inflator = LayoutInflater.from(context)

        val contactView = inflator.inflate(R.layout.email_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val email = emails.get(position)
        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary
    }

    override fun getItemCount(): Int {
        return emails.size
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView: TextView

        init {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            senderTextView = itemView.findViewById(R.id.senderTv)
            titleTextView = itemView.findViewById(R.id.titleTv)
            summaryTextView = itemView.findViewById(R.id.summaryTv)
        }

    }
}