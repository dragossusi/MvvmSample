package ro.dragossusi.sample.mvvm

import androidx.hilt.lifecycle.ViewModelInject
import ro.dragossusi.sample.data.Issue
import ro.dragossusi.sample.datasource.IssuesDataSource
import ro.dragossusi.viewmodel.BaseViewModel


/**
 *
 * @since 9/23/20
 * @author dragos
 */
class MainViewModel @ViewModelInject constructor(
    private val issuesDataSource: IssuesDataSource
) : BaseViewModel() {

    val request = observableData<List<Issue>>()

    fun getIssues() {
        request.setSource(
            issuesDataSource.getIssues()
        )
    }

}