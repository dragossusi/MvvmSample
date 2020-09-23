package ro.dragossusi.sample.mvvm.app

import android.app.Activity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


/**
 *
 * @since 9/23/20
 * @author dragos
 */
@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

    @Provides
    fun layoutInflater(activity: Activity) = activity.layoutInflater

}