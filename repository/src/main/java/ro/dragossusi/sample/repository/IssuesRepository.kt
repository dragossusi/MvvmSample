package ro.dragossusi.sample.repository

import ro.dragossusi.resource.DataResource
import ro.dragossusi.sample.data.Issue


/**
 *
 * @since 9/23/20
 * @author dragos
 */
interface IssuesRepository {
    suspend fun getIssues(): DataResource<List<Issue>>
}