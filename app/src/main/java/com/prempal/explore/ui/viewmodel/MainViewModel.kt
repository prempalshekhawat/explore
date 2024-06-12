package com.prempal.explore.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prempal.explore.data.DummyResponse
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _statusWordCount = MutableLiveData<Int?>()
    val statusWordCount: LiveData<Int?> get() = _statusWordCount

    //region dummy data for selecting status from spinner
    val dummyAvailabilityOptionitems = listOf("Select a Status","Available! Hey let us connect.", "Busy! Can't connect now.", "Hey I'm Online", "Only Text! No calls please.")

    private val _selectedStatusOptionPosition = MutableLiveData<Int>()
    val selectedStatusOptionPosition: LiveData<Int> get() = _selectedStatusOptionPosition

    private val _selectedStatusOptionText = MutableLiveData<String>()
    val selectedStatusOptionText: LiveData<String> get() = _selectedStatusOptionText
    //endregion

    //region dummy data to populate views
    private val _purposeList = MutableLiveData<List<String>>(listOf("Coffee", "Business", "Hobbies", "Friendship", "Movies", "Dining", "Dating", "Matrimony"))
    val purposeList: LiveData<List<String>> get() = _purposeList

    //dummy data for Explore Personal fragment
    private val _personalDummyResponse = MutableLiveData<List<DummyResponse>>(listOf(
        DummyResponse("https://picsum.photos/id/237/200/300", "Rohit Sharma", "Jaipur", "Within 2km",60,"Captain of Indian Cricket Team",
            "Hey! I am going to win world cup 2024", "Cricket", "Batsman", "Coffee,Business"),
        DummyResponse("https://picsum.photos/200/300?grayscale", "Virat Kohli", "Jaipur", "Within 200-240m",90,"Batsman of Indian Cricket Team",
            "Hey! I am going to win world cup 2024", "Cricket", "Batsman", "Coffee,Hobbies,Business"),
        DummyResponse("https://picsum.photos/seed/picsum/200/300", "Sanju Samson", "Jaipur", "Within 20-20m",75,"Wicket keeper of ICIndian Cricket TeamT",
            "Hey! I am going to win world cup 2024", "Cricket", "Batsman", "Matrimony,Business"),
        DummyResponse("https://picsum.photos/200/300/?blur", "Surya Kumar", "Jaipur", "Within 200-300",80,"Batsman of Indian Cricket Team",
            "Hey! I am going to win world cup 2024", "Cricket", "Batsman", "Matrimony,Friendship,Dating"),
        DummyResponse("https://picsum.photos/id/870/200/300?grayscale&blur=2", "Jasprit Bumrah", "Jaipur", "Within 100-150m", 95,"Bowler of ICIndian Cricket TeamT",
            "Hey! I am going to win world cup 2024", "Cricket", "Bowler", "Friendship,Movies,Dining,Dating,Coffee"),
        DummyResponse("https://picsum.photos/id/237/200/300", "Rishab Pant", "Jaipur", "Within 2-3km", 70,"Wicket keeper of Indian Cricket Team",
            "Hey! I am going to win world cup 2024", "Cricket", "Batsman", "Dining,Dating,Coffee,Friendship"),
    ))
    val personalDummyResponse: LiveData<List<DummyResponse>> get() = _personalDummyResponse

    //dummy data for Explore Businesses fragment
    private val _businessesDummyResponse = MutableLiveData<List<DummyResponse>>(listOf(
        DummyResponse("https://picsum.photos/id/237/200/300", "Smart Printers", "Jaipur", "Within 2km", 71,"",
            "Hi! this is one stop for all printing needs.", "Printing", "Shop",""),
        DummyResponse("https://picsum.photos/200/300?grayscale", "Gagan Photostate", "Jaipur", "Within 20km", 63,"",
            "Hi! all your needs for zerox are completed here.", "Computer", "Printers",""),
        DummyResponse("https://picsum.photos/seed/picsum/200/300", "Saras Dairy", "Jaipur", "Within 200m", 52,"",
            "Official shop for all Saras dairy products.", "Food", "Milk",""),
        DummyResponse("https://picsum.photos/200/300/?blur", "Raj Associates", "Jaipur", "Within 100-150m",75,"",
            "All property related businesses.", "Property", "Shop",""),
        DummyResponse("https://picsum.photos/id/870/200/300?grayscale&blur=2", "Asian Paints", "Jaipur","Within 20-50m", 60,"",
            "Official shop for all Asian paints products.", "Shop", "Supplier",""),
        DummyResponse("https://picsum.photos/id/237/200/300", "Sia Sationary", "Jaipur", "Within 2-2.5km",68,"",
            "Hi! all types of stationary products are available here.", "Shop", "Shop",""),
    ))
    val businessesDummyResponse: LiveData<List<DummyResponse>> get() = _businessesDummyResponse

    //dummy data for Explore Services fragment
    private val _servicesDummyResponse = MutableLiveData<List<DummyResponse>>(listOf(
        DummyResponse("https://picsum.photos/id/237/200/300", "Kuldeep yadav", "Jaipur", "Within 2-3km",75,"Android developer, 2 years of experience",
            "Hi community! I'm available at your service.", "Android", "Software",""),
        DummyResponse("https://picsum.photos/200/300?grayscale", "Ramesh Chahal", "Jaipur", "Within 2km",70,"Electrician | 15 years experience",
            "Hi community! I'm available at your service.", "Electrician", "Electricity",""),
        DummyResponse("https://picsum.photos/seed/picsum/200/300", "Avesh Khan", "Jaipur", "Within 200-300m",65,"Social Worker | 5 years experience",
            "Hi community! I'm available at your service.", "Activist", "Environment",""),
        DummyResponse("https://picsum.photos/200/300/?blur", "Raghu Jaiswal", "Jaipur", "Within 100-120m",65,"Sales Executive | 10 years experience",
            "Hi community! I'm available at your service.", "Salesman", "Sales",""),
        DummyResponse("https://picsum.photos/id/870/200/300?grayscale&blur=2", "Sahayak Dubey","Jaipur", "Within 300-350m", 55,"Plumber | 5 years",
            "Hi community! I'm available at your service.", "Plumber", "Plumber",""),
        DummyResponse("https://picsum.photos/id/237/200/300", "Sandeep sharma", "Jaipur", "Within 30-35m",75,"Mathematics Tutor | 11 years experience",
            "Hi community! I'm available at your service.", "Teaching", "Education",""),
    ))
    val servicesDummyResponse: LiveData<List<DummyResponse>> get() = _servicesDummyResponse

    //endregion

    //region initializing values
    init {
        _statusWordCount.value = 0
        _selectedStatusOptionPosition.value = 0
        _selectedStatusOptionText.value = dummyAvailabilityOptionitems[0]
    }
    //endregion

    //region Updating status character count
    fun checkForStatus(input: String) {
        viewModelScope.launch {
            val count = input.count()
            updateStatusWordCount(count)
        }
    }

    private fun updateStatusWordCount(count: Int?) {
        _statusWordCount.value = count
    }
    //endregion

    //region Selecting the selected option from status spinner
    fun onStatusOptionItemSelected(position: Int) {
        _selectedStatusOptionPosition.value = position
        _selectedStatusOptionText.value = dummyAvailabilityOptionitems[position]
    }
    //endregion

}