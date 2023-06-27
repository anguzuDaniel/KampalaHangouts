package com.example.kampalahangouts.data

import com.example.kampalahangouts.R
import com.example.kampalahangouts.model.Category
import com.example.kampalahangouts.model.Hangout
import com.example.kampalahangouts.utils.CategoryType

//data class Category(
//    val id: Int,
//    val catType: CategoryType,
//    @StringRes val name: Int,
//    @StringRes val description: Int,
//    val icon: Int
//)

object DataSource {

    val defaultHangout = getHangoutData()[0]
    val defaultCategory = getCategoryData()[0]

    fun getCategoryData(): List<Category> {
        return listOf(
            Category(
                id = 1,
                categoryType = CategoryType.ATTRACTIONS,
                name = R.string.category_attractions,
                description = R.string.category_attractions_description,
                icon = 0
            ),
            Category(
                id = 2,
                categoryType = CategoryType.EVENTS,
                name = R.string.category_events,
                description = R.string.category_events_description,
                icon = 0
            ),
            Category(
                id = 3,
                categoryType = CategoryType.HOTELS,
                name = R.string.category_hotels,
                description = R.string.category_hotels_description,
                icon = 0
            ),
            Category(
                id = 4,
                categoryType = CategoryType.RESTAURANTS,
                name = R.string.category_restaurants,
                description = R.string.category_restaurants_description,
                icon = 0
            ),
            Category(
                id = 5,
                categoryType = CategoryType.PARKS,
                name = R.string.category_parks,
                description = R.string.category_parks_description,
                icon = 0
            ),
        )
    }

    fun getHangoutData(): List<Hangout> {
        return listOf(

            // Attractions
            Hangout(
                id = 1,
                name = R.string.attraction_name_1,
                category = CategoryType.ATTRACTIONS,
                description = R.string.attraction_description_1,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 2,
                name = R.string.attraction_name_2,
                category = CategoryType.ATTRACTIONS,
                description = R.string.attraction_description_2,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 3,
                name = R.string.attraction_name_3,
                category = CategoryType.ATTRACTIONS,
                description = R.string.attraction_description_3,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 4,
                name = R.string.attraction_name_4,
                category = CategoryType.ATTRACTIONS,
                description = R.string.attraction_description_4,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 5,
                name = R.string.attraction_name_5,
                category = CategoryType.ATTRACTIONS,
                description = R.string.attraction_description_5,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 6,
                name = R.string.attraction_name_6,
                category = CategoryType.ATTRACTIONS,
                description = R.string.attraction_description_6,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 7,
                name = R.string.attraction_name_7,
                category = CategoryType.ATTRACTIONS,
                description = R.string.attraction_description_7,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 8,
                name = R.string.attraction_name_8,
                category = CategoryType.ATTRACTIONS,
                description = R.string.attraction_description_8,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 9,
                name = R.string.attraction_name_9,
                category = CategoryType.ATTRACTIONS,
                description = R.string.attraction_description_9,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 10,
                name = R.string.attraction_name_10,
                category = CategoryType.ATTRACTIONS,
                description = R.string.attraction_description_10,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),


            // Events
            Hangout(
                id = 11,
                name = R.string.event_name_1,
                category = CategoryType.EVENTS,
                description = R.string.event_description_1,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 12,
                name = R.string.event_name_2,
                category = CategoryType.EVENTS,
                description = R.string.event_description_2,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 13,
                name = R.string.event_name_3,
                category = CategoryType.EVENTS,
                description = R.string.event_description_3,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 14,
                name = R.string.event_name_4,
                category = CategoryType.EVENTS,
                description = R.string.event_description_4,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 15,
                name = R.string.event_name_5,
                category = CategoryType.EVENTS,
                description = R.string.event_description_5,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 16,
                name = R.string.event_name_6,
                category = CategoryType.EVENTS,
                description = R.string.event_description_6,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 17,
                name = R.string.event_name_7,
                category = CategoryType.EVENTS,
                description = R.string.event_description_7,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 18,
                name = R.string.event_name_8,
                category = CategoryType.EVENTS,
                description = R.string.event_description_8,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 19,
                name = R.string.event_name_9,
                category = CategoryType.EVENTS,
                description = R.string.event_description_9,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 20,
                name = R.string.event_name_10,
                category = CategoryType.EVENTS,
                description = R.string.event_description_10,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),

            // Restaurants
            Hangout(
                id = 21,
                name = R.string.restaurant_name_1,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_1,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 22,
                name = R.string.restaurant_name_2,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_2,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 23,
                name = R.string.restaurant_name_3,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_3,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 24,
                name = R.string.restaurant_name_4,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_4,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 25,
                name = R.string.restaurant_name_5,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_5,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 26,
                name = R.string.restaurant_name_6,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_6,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 27,
                name = R.string.restaurant_name_7,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_7,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 28,
                name = R.string.restaurant_name_8,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_8,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 29,
                name = R.string.restaurant_name_9,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_9,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 30,
                name = R.string.restaurant_name_10,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_10,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),

            // Hotels
            Hangout(
                id = 31,
                name = R.string.hotel_name_1,
                category = CategoryType.HOTELS,
                description = R.string.hotel_description_1,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 32,
                name = R.string.hotel_name_2,
                category = CategoryType.HOTELS,
                description = R.string.hotel_description_2,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 33,
                name = R.string.hotel_name_3,
                category = CategoryType.HOTELS,
                description = R.string.hotel_description_3,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 34,
                name = R.string.hotel_name_4,
                category = CategoryType.HOTELS,
                description = R.string.hotel_description_4,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 35,
                name = R.string.hotel_name_5,
                category = CategoryType.HOTELS,
                description = R.string.hotel_description_5,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 36,
                name = R.string.hotel_name_6,
                category = CategoryType.HOTELS,
                description = R.string.hotel_description_6,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 37,
                name = R.string.hotel_name_7,
                category = CategoryType.HOTELS,
                description = R.string.hotel_description_7,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 38,
                name = R.string.hotel_name_8,
                category = CategoryType.HOTELS,
                description = R.string.hotel_description_8,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 39,
                name = R.string.hotel_name_9,
                category = CategoryType.HOTELS,
                description = R.string.hotel_description_9,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 40,
                name = R.string.hotel_name_10,
                category = CategoryType.HOTELS,
                description = R.string.hotel_description_10,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),

            // Parks
            Hangout(
                id = 41,
                name = R.string.park_name_1,
                category = CategoryType.PARKS,
                description = R.string.park_description_1,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 42,
                name = R.string.park_name_2,
                category = CategoryType.PARKS,
                description = R.string.park_description_2,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 43,
                name = R.string.park_name_3,
                category = CategoryType.PARKS,
                description = R.string.park_description_3,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 44,
                name = R.string.park_name_4,
                category = CategoryType.PARKS,
                description = R.string.park_description_4,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 45,
                name = R.string.park_name_5,
                category = CategoryType.PARKS,
                description = R.string.park_description_5,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 46,
                name = R.string.park_name_6,
                category = CategoryType.PARKS,
                description = R.string.park_description_6,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 47,
                name = R.string.park_name_7,
                category = CategoryType.PARKS,
                description = R.string.park_description_7,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 48,
                name = R.string.park_name_8,
                category = CategoryType.PARKS,
                description = R.string.park_description_8,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 49,
                name = R.string.park_name_9,
                category = CategoryType.PARKS,
                description = R.string.park_description_9,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 50,
                name = R.string.park_name_10,
                category = CategoryType.PARKS,
                description = R.string.park_description_10,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),

            // Restaurants
            Hangout(
                id = 51,
                name = R.string.restaurant_name_1,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_1,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 52,
                name = R.string.restaurant_name_2,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_2,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 53,
                name = R.string.restaurant_name_3,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_3,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 54,
                name = R.string.restaurant_name_4,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_4,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 55,
                name = R.string.restaurant_name_5,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_5,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 56,
                name = R.string.restaurant_name_6,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_6,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 57,
                name = R.string.restaurant_name_7,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_7,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 58,
                name = R.string.restaurant_name_8,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_8,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 59,
                name = R.string.restaurant_name_9,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_9,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
            Hangout(
                id = 60,
                name = R.string.restaurant_name_10,
                category = CategoryType.RESTAURANTS,
                description = R.string.restaurant_description_10,
                image = R.drawable.robin_kutesa_qcxs5cboqqu_unsplash
            ),
        )
    }
}