package ro.dragossusi.sample.datasource

import ro.dragossusi.DataSource
import ro.dragossusi.dataResourceLiveData
import ro.dragossusi.sample.data.Issue
import ro.dragossusi.sample.repository.IssuesRepository
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


/**
 *
 * @since 9/23/20
 * @author dragos
 */
class IssuesDataSource @Inject constructor(
    private val repository: IssuesRepository,
    override val context: CoroutineContext
) : DataSource {

    fun getIssues() = dataResourceLiveData<List<Issue>> {
        emit(repository.getIssues())
    }


}