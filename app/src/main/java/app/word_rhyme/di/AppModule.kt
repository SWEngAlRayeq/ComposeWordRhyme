package app.word_rhyme.di

import app.word_rhyme.data.remote.RhymeApi
import app.word_rhyme.data.repo_impl.RhymeRepositoryImpl
import app.word_rhyme.domain.repo.RhymeRepository
import app.word_rhyme.domain.usecase.GetRhymesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = "https://api.datamuse.com/"

    @Provides
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(logging).build()

    @Provides
    fun provideRhymeApi(okHttpClient: OkHttpClient, baseUrl: String): RhymeApi =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RhymeApi::class.java)

    @Provides
    fun provideRepo(api: RhymeApi): RhymeRepository = RhymeRepositoryImpl(api)

    @Provides
    fun provideUseCase(repo: RhymeRepository): GetRhymesUseCase = GetRhymesUseCase(repo)
}
