package ro.dragossusi.sample.mock

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import ro.dragossusi.sample.repository.IssuesRepository


/**
 *
 * @since 9/23/20
 * @author dragos
 */
@InstallIn(ApplicationComponent::class)
@Module
interface MockModule {

    @Binds
    fun issuesRepository(repository: IssuesRepositoryMock): IssuesRepository

}