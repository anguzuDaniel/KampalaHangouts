package com.example.kampalahangouts.data

import com.example.kampalahangouts.R
import com.example.kampalahangouts.data.local.Category
import com.example.kampalahangouts.data.local.Hangout
import com.example.kampalahangouts.utils.CategoryType


object DataSource {

//    fun getCategories(): List<Category> {
//        return listOf(
//            Category(
//                id = 1,
//                name = R.string.category_attractions,
//                description = R.string.category_attractions_description,
//                icon = 0
//            ),
//            Category(
//                id = 2,
//                name = R.string.category_events,
//                description = R.string.category_events_description,
//                icon = 0
//            ),
//            Category(
//                id = 3,
//                name = R.string.category_hotels,
//                description = R.string.category_hotels_description,
//                icon = 0
//            ),
//            Category(
//                id = 4,
//                name = R.string.category_restaurants,
//                description = R.string.category_restaurants_description,
//                icon = 0
//            ),
//            Category(
//                id = 5,
//                name = R.string.category_parks,
//                description = R.string.category_parks_description,
//                icon = 0
//            ),
//        )
//    }

    fun getHangouts(): List<Hangout> {
        return listOf(
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
        )
    }
}