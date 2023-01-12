package com.example.appwithbaha

import androidx.lifecycle.MutableLiveData

class Repository {

    private var liveData = MutableLiveData<CounterModel>()

    companion object{
        private var repo: Repository? = null

        fun getInstance() : Repository{
            if(repo == null){
                repo = Repository()
            }
            return repo as Repository
        }
    }

    fun initializeData(): MutableLiveData<CounterModel>{
        liveData.value = CounterModel()
        return liveData
    }
}