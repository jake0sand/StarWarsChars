package com.jakey.starwarsimages.presentation.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jakey.starwarsimages.data.remote.AllCharacterDto
import com.jakey.starwarsimages.data.remote.CharacterDto
import com.jakey.starwarsimages.domain.mapper.CharacterMapper
import com.jakey.starwarsimages.domain.model.Character
import com.jakey.starwarsimages.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: Repository,
    private val characterMapper: CharacterMapper
): ViewModel() {

    private val _characterById = MutableLiveData<Character?>()
    val characterById: LiveData<Character?>
        get() = _characterById

    fun fetchCharacter(characterId: Int) = viewModelScope.launch {
        val character = repository.getCharacterById(characterId)
        _characterById.postValue(character.body()?.let(characterMapper::buildFrom))
    }

//    fun getCharacterById(id: Int) =
//
//        viewModelScope.launch {
//            repository.getCharacterById(id).let { response ->
//                if (response.isSuccessful) {
//                    _characterById.postValue(response.body()?.let {
//                        characterLiteMapper.buildFrom(it)
//                    })
//                } else {
//                    Log.d("response error", "getCharacters: ${response.code()}")
//                }
//            }
//        }

}