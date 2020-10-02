package ro.dragossusi.sample.mvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import ro.dragossusi.observer.DataResourceObserver
import ro.dragossusi.sample.data.Issue
import ro.dragossusi.sample.mvvm.adapter.IssueAdapter
import ro.rachieru.dragos.errordata.handler.AlertErrorDataHandler
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var adapter: IssueAdapter

    private val viewModel: MainViewModel by viewModels()

    val requestObserver = object : DataResourceObserver<List<Issue>>(
        AlertErrorDataHandler(this)
    ) {

        override fun onFinished(success: Boolean) {
            super.onFinished(success)
            if (!success) viewModel.request.clear()
        }

        override fun onSuccess(data: List<Issue>?) {
            super.onSuccess(data)
            adapter.setItems(data)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        observeData()
    }

    private fun initViews() {
        recycler_issues.adapter = adapter
    }

    private fun observeData() {
        viewModel.request.observe(this, requestObserver)
        requestObserver.loadingLiveData.observe(this) {
            progress_circular.isVisible = it
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getIssues()
    }

}