package app.word_rhyme.domain.repo

import app.word_rhyme.domain.model.RhymeWord

interface RhymeRepository {
    suspend fun getRhymes(word: String): List<RhymeWord>
}