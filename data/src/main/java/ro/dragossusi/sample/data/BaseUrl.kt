package ro.dragossusi.sample.data

import javax.inject.Qualifier

/**
 *
 * @author Dragos
 * @since 10.11.2020
 */
@Target(
    AnnotationTarget.PROPERTY, AnnotationTarget.FIELD,
    AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER
)
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class BaseUrl