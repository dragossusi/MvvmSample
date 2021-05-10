package ro.dragossusi.sample.impl

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import ro.dragossusi.sample.data.BaseUrl

/**
 *
 * @author dragos
 * @since 11/10/20
 */
@Module
@InstallIn(ApplicationComponent::class)
class BaseUrlModule {

    /**
     * TODO specify the url for cleartext traffic
     */
    @Provides
    @BaseUrl
    fun baseUrl() = "http://127.0.0.1"

}