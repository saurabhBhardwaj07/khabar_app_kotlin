package com.saurabh.mynews.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saurabh.mynews.domain.usecases.app_entry.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val appEntryUseCases: AppEntryUseCases) :
    ViewModel() {

        fun onEvent(event : OnBoardingEvent){
            when(event){
                is OnBoardingEvent.SaveAppEntry ->{
                    saveUserEntry()
                }
            }
        }

    private fun saveUserEntry() {
       viewModelScope.launch {
           appEntryUseCases.saveAppEntry()
       }
    }
}