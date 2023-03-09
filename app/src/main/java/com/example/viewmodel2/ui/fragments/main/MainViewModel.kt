package com.example.viewmodel2.ui.fragments.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodel2.utils.model.MainModel

class MainViewModel: ViewModel() {

    private var listTwo: MutableLiveData<ArrayList<MainModel>> = MutableLiveData()

    fun getModelList(): MutableLiveData<ArrayList<MainModel>> {
         val modelList: ArrayList<MainModel> = ArrayList()
        modelList.clear()
        modelList.add(
            MainModel(
                "https://m.media-amazon.com/images/M/MV5BMzFkM2YwOTQtYzk2" +
                        "Mi00N2VlLWE3NTItN2YwNDg1YmY0ZDNmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg",
                "Home Alone"
            )
        )
        modelList.add(
                MainModel("https://lumiere-a.akamaihd.net/v1/images/au_poster_movies_" +
                        "20cs_avatar2_wayofwater_teaser_cc6f7f91.jpeg?region=0,0,540,800&width=480",
                "Avatar"
        )
        )
        modelList.add(
            MainModel(
                "https://lumiere-a.akamaihd.net/v1/images/p_cruella_21672_" +
                        "ba40c762.jpeg?region=0%2C0%2C540%2C810", "Cruella"
            )
        )
        modelList.add(
            MainModel(
                "https://api.time.com/wp-content/uploads/2014/07/301386_full1.jpg",
                "Harry Potter"
            )
        )
        modelList.add(
            MainModel(
                "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl" +
                        "5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_FMjpg_UX1000_.jpg", "Avengers"
            )
        )
        modelList.add(
            MainModel(
                "https://lumiere-a.akamaihd.net/v1/images/p_blackpanther_" +
                        "19754_4ac13f07.jpeg?region=0%2C0%2C540%2C810", "black panther"
            )
        )
        modelList.add(
            MainModel(
                "https://www.ixbt.com/img/n1/news/2022/5/5/0c3c20a8d851" +
                        "4501524a0859461f391572ea6e61_large.jpg", "Spider Man"
            )
        )
        listTwo.value = modelList
        return listTwo
    }
}