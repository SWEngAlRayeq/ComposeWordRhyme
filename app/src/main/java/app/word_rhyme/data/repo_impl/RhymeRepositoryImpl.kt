package app.word_rhyme.data.repo_impl

import app.word_rhyme.data.remote.RhymeApi
import app.word_rhyme.domain.model.RhymeWord
import app.word_rhyme.domain.repo.RhymeRepository
import javax.inject.Inject
import kotlin.collections.map

class RhymeRepositoryImpl @Inject constructor(
    private val api: RhymeApi
) : RhymeRepository {
    override suspend fun getRhymes(word: String): List<RhymeWord> {
        return api.getRhymes(word).map { it.toDomain() }
    }
}