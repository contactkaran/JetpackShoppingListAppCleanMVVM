package com.contactkaran.jetpackecommerceappcleanmvvm.data.local_room.converters

import androidx.room.TypeConverter
import java.util.Date

open class DateConverter {
    //two methods

    @TypeConverter
    fun toDate(date: Long?): Date? { //transformation
        return date?.let{Date(it)}
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

}