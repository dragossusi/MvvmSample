package ro.dragossusi.sample.mvvm

import dagger.hilt.android.lifecycle.HiltViewModel
import ro.dragossusi.sample.data.Issue
import ro.dragossusi.sample.datasource.IssuesDataSource
import ro.dragossusi.viewmodel.BaseViewModel
import javax.inject.Inject

/**
 *
 * @since 9/23/20
 * @author dragos
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val issuesDataSource: IssuesDataSource
) : BaseViewModel() {

    val request = observableData<List<Issue>>()

    fun getIssues() {
        request.setSource(
            issuesDataSource.getIssues()
        )
    }

}