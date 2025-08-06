package app.word_rhyme.domain.usecase

import app.word_rhyme.domain.repo.RhymeRepository
import javax.inject.Inject

class GetRhymesUseCase @Inject constructor(
    private val repository: RhymeRepository
) {
    suspend operator fun invoke(word: String) = repository.getRhymes(word)
}