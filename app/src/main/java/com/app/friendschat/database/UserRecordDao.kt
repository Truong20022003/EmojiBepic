package com.app.friendschat.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.app.friendschat.data.model.UserRecordModel

@Dao
interface UserRecordDao {
    @Query("SELECT * FROM Table_User_Record ORDER BY id DESC")
    fun getListRecord(): MutableList<UserRecordModel>

    @Query("SELECT * FROM Table_User_Record ORDER BY DATE_CREATED ASC")
    fun getListRecordNot(): MutableList<UserRecordModel>

    @Insert
    fun insertRecord(userRecordModel: UserRecordModel)

    @Update
    fun updateRecord(userRecordModel: UserRecordModel)

    @Query("DELETE FROM Table_User_Record WHERE id =:id")
    fun deleteRecord(id: Int)

    @Query("SELECT AVG(SYSTOLIC) FROM Table_User_Record")
    fun averageSYS(): Int

    @Query("SELECT AVG(DIASTOLIC) FROM Table_User_Record")
    fun averageDIA(): Int

    @Query("SELECT AVG(PULSE) FROM Table_User_Record")
    fun averagePUL(): Int

    @Query("SELECT * FROM Table_User_Record ORDER BY id DESC LIMIT 3")
    fun getTop3Record(): MutableList<UserRecordModel>

    @Query("SELECT COUNT(*) FROM Table_User_Record")
    fun getCountRecord(): Int

    @Query("SELECT DISTINCT RECORD_DATE FROM Table_User_Record")
    fun getDateRecord(): MutableList<String>

    @Query("SELECT RECORD_DATE FROM Table_User_Record")
    fun getDateRecordNotDistinct(): MutableList<String>

    @Query("SELECT DISTINCT RECORD_YEAR FROM Table_User_Record")
    fun getYearRecord(): MutableList<String>

    @Query("SELECT * FROM Table_User_Record WHERE RECORD_DATE =:recordDate")
    fun getRecordForDate(recordDate: String): MutableList<UserRecordModel>

    @Query("SELECT * FROM Table_User_Record WHERE RECORD_DATE LIKE '%' || :year")
    fun getRecordForLikeYear(year: String): MutableList<UserRecordModel>

    @Query("SELECT DISTINCT RECORD_DATE FROM Table_User_Record Where RECORD_YEAR =:year")
    fun getDateRecordForLikeYear(year: String): MutableList<String>

    @Query("SELECT RECORD_DATE FROM Table_User_Record ORDER BY DATE_CREATED ASC")
    fun getDateRecordForLikeYearNotDistinct(): MutableList<String>


}