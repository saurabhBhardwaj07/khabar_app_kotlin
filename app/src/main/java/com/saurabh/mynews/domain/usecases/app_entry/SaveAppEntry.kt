package com.saurabh.mynews.domain.usecases.app_entry

import com.saurabh.mynews.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}