package com.example.appwithbaha

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityMainViewModel : ViewModel() {

    private var repository : Repository? = null
    private var liveData : MutableLiveData<CounterModel>? = null
    private var counter = CounterModel()
    private var incrementOrDecrement = 0

    fun init() {
        repository = Repository.getInstance()
        liveData = repository?.initializeData()
    }

    fun incrementCount() {
        val counterDecrement = liveData?.value?.getCount()
        if (counterDecrement != null) {
            incrementOrDecrement = counterDecrement
        }
        incrementOrDecrement++
        counter.setCount(incrementOrDecrement)
        liveData?.value = counter
    }

    fun decrementCount() {
        val counterDecrement = liveData?.value?.getCount()
        if (counterDecrement != null) {
            incrementOrDecrement = counterDecrement
        }
        incrementOrDecrement--
        counter.setCount(incrementOrDecrement)
        liveData?.value = counter
    }

    fun getCount(): MutableLiveData<CounterModel>? {
        return liveData
    }
}