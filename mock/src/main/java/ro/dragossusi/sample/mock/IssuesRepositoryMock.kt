package ro.dragossusi.sample.mock

import kotlinx.coroutines.delay
import ro.dragossusi.livedata.resource.DataResource
import ro.dragossusi.sample.data.Issue
import ro.dragossusi.sample.repository.IssuesRepository
import javax.inject.Inject


/**
 *
 * @since 9/23/20
 * @author dragos
 */
class IssuesRepositoryMock @Inject constructor() : IssuesRepository {

    override suspend fun getIssues(): DataResource<List<Issue>> {
        delay(2000L)
        return DataResource.success(
            listOf(
                Issue(
                    "Bug",
                    "Not working"
                )
            )
        )
    }
}