package ro.dragossusi.sample.impl

import ro.dragossusi.resource.DataResource
import ro.dragossusi.sample.data.Issue
import ro.dragossusi.sample.network.ApiClient
import ro.dragossusi.sample.repository.IssuesRepository
import javax.inject.Inject


/**
 * Hardcoded date used to test without an API
 *
 * @since 9/23/20
 * @author dragos
 */
class IssuesRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient
) : IssuesRepository {

    override suspend fun getIssues(): List<Issue> {
        return apiClient.getIssues()
    }
}