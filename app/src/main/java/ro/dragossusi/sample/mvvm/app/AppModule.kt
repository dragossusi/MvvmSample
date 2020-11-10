package ro.dragossusi.sample.mvvm.app

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job


/**
 *
 * @since 9/23/20
 * @author dragos
 */
@InstallIn(ApplicationComponent::class)
@Module
class AppModule {

    @Provides
    fun coroutineContext() = Job() + Dispatchers.IO

}