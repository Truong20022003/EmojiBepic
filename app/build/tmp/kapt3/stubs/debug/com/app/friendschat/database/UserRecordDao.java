package com.app.friendschat.database;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\b\u0010\u0004\u001a\u00020\u0003H\'J\b\u0010\u0005\u001a\u00020\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\'J\b\u0010\t\u001a\u00020\u0003H\'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\'J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\fH\'J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\'J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\'J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bH\'J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bH\'J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\u0015\u001a\u00020\fH\'J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\u000e\u001a\u00020\fH\'J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bH\'J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\'J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0012H\'J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0012H\'\u00a8\u0006\u001c"}, d2 = {"Lcom/app/friendschat/database/UserRecordDao;", "", "averageDIA", "", "averagePUL", "averageSYS", "deleteRecord", "", "id", "getCountRecord", "getDateRecord", "", "", "getDateRecordForLikeYear", "year", "getDateRecordForLikeYearNotDistinct", "getDateRecordNotDistinct", "getListRecord", "Lcom/app/friendschat/data/model/UserRecordModel;", "getListRecordNot", "getRecordForDate", "recordDate", "getRecordForLikeYear", "getTop3Record", "getYearRecord", "insertRecord", "userRecordModel", "updateRecord", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public abstract interface UserRecordDao {
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM Table_User_Record ORDER BY id DESC")
    public abstract java.util.List<com.app.friendschat.data.model.UserRecordModel> getListRecord();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM Table_User_Record ORDER BY DATE_CREATED ASC")
    public abstract java.util.List<com.app.friendschat.data.model.UserRecordModel> getListRecordNot();
    
    @androidx.room.Insert
    public abstract void insertRecord(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.UserRecordModel userRecordModel);
    
    @androidx.room.Update
    public abstract void updateRecord(@org.jetbrains.annotations.NotNull
    com.app.friendschat.data.model.UserRecordModel userRecordModel);
    
    @androidx.room.Query(value = "DELETE FROM Table_User_Record WHERE id =:id")
    public abstract void deleteRecord(int id);
    
    @androidx.room.Query(value = "SELECT AVG(SYSTOLIC) FROM Table_User_Record")
    public abstract int averageSYS();
    
    @androidx.room.Query(value = "SELECT AVG(DIASTOLIC) FROM Table_User_Record")
    public abstract int averageDIA();
    
    @androidx.room.Query(value = "SELECT AVG(PULSE) FROM Table_User_Record")
    public abstract int averagePUL();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM Table_User_Record ORDER BY id DESC LIMIT 3")
    public abstract java.util.List<com.app.friendschat.data.model.UserRecordModel> getTop3Record();
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM Table_User_Record")
    public abstract int getCountRecord();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT DISTINCT RECORD_DATE FROM Table_User_Record")
    public abstract java.util.List<java.lang.String> getDateRecord();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT RECORD_DATE FROM Table_User_Record")
    public abstract java.util.List<java.lang.String> getDateRecordNotDistinct();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT DISTINCT RECORD_YEAR FROM Table_User_Record")
    public abstract java.util.List<java.lang.String> getYearRecord();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM Table_User_Record WHERE RECORD_DATE =:recordDate")
    public abstract java.util.List<com.app.friendschat.data.model.UserRecordModel> getRecordForDate(@org.jetbrains.annotations.NotNull
    java.lang.String recordDate);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM Table_User_Record WHERE RECORD_DATE LIKE \'%\' || :year")
    public abstract java.util.List<com.app.friendschat.data.model.UserRecordModel> getRecordForLikeYear(@org.jetbrains.annotations.NotNull
    java.lang.String year);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT DISTINCT RECORD_DATE FROM Table_User_Record Where RECORD_YEAR =:year")
    public abstract java.util.List<java.lang.String> getDateRecordForLikeYear(@org.jetbrains.annotations.NotNull
    java.lang.String year);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT RECORD_DATE FROM Table_User_Record ORDER BY DATE_CREATED ASC")
    public abstract java.util.List<java.lang.String> getDateRecordForLikeYearNotDistinct();
}