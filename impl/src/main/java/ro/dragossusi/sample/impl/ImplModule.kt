package ro.dragossusi.sample.impl

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
interface ImplModule {

    @Binds
    fun issuesRepository(repository: IssuesRepositoryImpl): IssuesRepository

}