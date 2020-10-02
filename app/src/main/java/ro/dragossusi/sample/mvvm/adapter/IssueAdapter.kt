package ro.dragossusi.sample.mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ro.dragossusi.sample.data.Issue
import ro.dragossusi.sample.mvvm.R
import javax.inject.Inject


/**
 *
 * @since 9/23/20
 * @author dragos
 */
class IssueAdapter @Inject constructor(
    private val layoutInflater: LayoutInflater
) : RecyclerView.Adapter<IssueHolder>() {

    private val _items = mutableListOf<Issue>()

    fun setItems(items: Collection<Issue>?) {
        _items.clear()
        items?.let(_items::addAll)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueHolder {
        return IssueHolder(
            layoutInflater.inflate(R.layout.item_issue, parent, false)
        )
    }

    override fun onBindViewHolder(holder: IssueHolder, position: Int) {
        holder.bind(_items[position])
    }

    override fun getItemCount(): Int {
        return _items.size
    }
}