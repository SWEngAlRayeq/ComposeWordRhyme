package app.word_rhyme.data.model

import app.word_rhyme.domain.model.RhymeWord

data class RhymeDto(
    val word: String,
    val score: Int?
) {
    fun toDomain(): RhymeWord = RhymeWord(word, score ?: 0)
}