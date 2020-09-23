package ro.dragossusi.sample.mvvm.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_issue.view.*
import ro.dragossusi.sample.data.Issue


/**
 *
 * @since 9/23/20
 * @author dragos
 */
class IssueHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title = itemView.text_title
    val subtitle = itemView.text_subtitle

    fun bind(issue: Issue) {
        title.text = issue.title
        subtitle.text = issue.subtitle
    }

}