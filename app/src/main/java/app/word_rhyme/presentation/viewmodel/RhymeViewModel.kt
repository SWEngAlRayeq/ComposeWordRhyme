package app.word_rhyme.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.word_rhyme.domain.model.RhymeWord
import app.word_rhyme.domain.usecase.GetRhymesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RhymeViewModel @Inject constructor(
    private val getRhymesUseCase: GetRhymesUseCase
): ViewModel() {

    var word by mutableStateOf("")
    var rhymes by mutableStateOf<List<RhymeWord>>(emptyList())
    var isLoading by mutableStateOf(false)

    fun fetchRhymes() {
        if (word.isBlank()) return
        viewModelScope.launch {
            isLoading = true
            rhymes = getRhymesUseCase(word)
            isLoading = false
        }
    }
}