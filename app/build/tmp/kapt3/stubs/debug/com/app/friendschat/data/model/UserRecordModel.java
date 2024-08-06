package com.app.friendschat.data.model;

import java.lang.System;

@androidx.room.Entity(tableName = "Table_User_Record")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0007Bw\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015\u00a2\u0006\u0002\u0010\u0016J\t\u00107\u001a\u00020\u0004H\u00c6\u0003J\t\u00108\u001a\u00020\u0010H\u00c6\u0003J\t\u00109\u001a\u00020\nH\u00c6\u0003J\u0019\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015H\u00c6\u0003J\t\u0010;\u001a\u00020\u0004H\u00c6\u0003J\t\u0010<\u001a\u00020\u0004H\u00c6\u0003J\t\u0010=\u001a\u00020\u0004H\u00c6\u0003J\t\u0010>\u001a\u00020\nH\u00c6\u0003J\t\u0010?\u001a\u00020\u0004H\u00c6\u0003J\t\u0010@\u001a\u00020\nH\u00c6\u0003J\t\u0010A\u001a\u00020\nH\u00c6\u0003J\t\u0010B\u001a\u00020\nH\u00c6\u0003J\u0091\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\n2\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015H\u00c6\u0001J\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GH\u00d6\u0003J\t\u0010H\u001a\u00020\u0004H\u00d6\u0001J\t\u0010I\u001a\u00020\nH\u00d6\u0001R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001e\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001e\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010 \"\u0004\b(\u0010\"R\u001e\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001e\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR\u001e\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R.\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001a\u00a8\u0006J"}, d2 = {"Lcom/app/friendschat/data/model/UserRecordModel;", "Ljava/io/Serializable;", "()V", "systolic", "", "diastolic", "pulse", "(III)V", "id", "colorInfo", "", "keyType", "recordYear", "recordDate", "recordTime", "dateCreate", "", "typeNote", "tagNote", "Ljava/util/ArrayList;", "Lcom/app/friendschat/data/model/TagModel;", "Lkotlin/collections/ArrayList;", "(IIIILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/util/ArrayList;)V", "getColorInfo", "()Ljava/lang/String;", "setColorInfo", "(Ljava/lang/String;)V", "getDateCreate", "()J", "setDateCreate", "(J)V", "getDiastolic", "()I", "setDiastolic", "(I)V", "getId", "setId", "getKeyType", "setKeyType", "getPulse", "setPulse", "getRecordDate", "setRecordDate", "getRecordTime", "setRecordTime", "getRecordYear", "setRecordYear", "getSystolic", "setSystolic", "getTagNote", "()Ljava/util/ArrayList;", "setTagNote", "(Ljava/util/ArrayList;)V", "getTypeNote", "setTypeNote", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "Emoji_Maker_v1.0.0_08.06.2024_debug"})
public final class UserRecordModel implements java.io.Serializable {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id;
    @androidx.room.ColumnInfo(name = "SYSTOLIC")
    private int systolic;
    @androidx.room.ColumnInfo(name = "DIASTOLIC")
    private int diastolic;
    @androidx.room.ColumnInfo(name = "PULSE")
    private int pulse;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "COLOR_INFO")
    private java.lang.String colorInfo;
    @androidx.room.ColumnInfo(name = "KEY_TYPE")
    private int keyType;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "RECORD_YEAR")
    private java.lang.String recordYear;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "RECORD_DATE")
    private java.lang.String recordDate;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "RECORD_TIME")
    private java.lang.String recordTime;
    @androidx.room.ColumnInfo(name = "DATE_CREATED")
    private long dateCreate;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "TYPE_NOTE")
    private java.lang.String typeNote;
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "TAG_NOTE")
    private java.util.ArrayList<com.app.friendschat.data.model.TagModel> tagNote;
    
    @org.jetbrains.annotations.NotNull
    public final com.app.friendschat.data.model.UserRecordModel copy(int id, int systolic, int diastolic, int pulse, @org.jetbrains.annotations.NotNull
    java.lang.String colorInfo, int keyType, @org.jetbrains.annotations.NotNull
    java.lang.String recordYear, @org.jetbrains.annotations.NotNull
    java.lang.String recordDate, @org.jetbrains.annotations.NotNull
    java.lang.String recordTime, long dateCreate, @org.jetbrains.annotations.NotNull
    java.lang.String typeNote, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.app.friendschat.data.model.TagModel> tagNote) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public UserRecordModel(int id, int systolic, int diastolic, int pulse, @org.jetbrains.annotations.NotNull
    java.lang.String colorInfo, int keyType, @org.jetbrains.annotations.NotNull
    java.lang.String recordYear, @org.jetbrains.annotations.NotNull
    java.lang.String recordDate, @org.jetbrains.annotations.NotNull
    java.lang.String recordTime, long dateCreate, @org.jetbrains.annotations.NotNull
    java.lang.String typeNote, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.app.friendschat.data.model.TagModel> tagNote) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getSystolic() {
        return 0;
    }
    
    public final void setSystolic(int p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getDiastolic() {
        return 0;
    }
    
    public final void setDiastolic(int p0) {
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getPulse() {
        return 0;
    }
    
    public final void setPulse(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getColorInfo() {
        return null;
    }
    
    public final void setColorInfo(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getKeyType() {
        return 0;
    }
    
    public final void setKeyType(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRecordYear() {
        return null;
    }
    
    public final void setRecordYear(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRecordDate() {
        return null;
    }
    
    public final void setRecordDate(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRecordTime() {
        return null;
    }
    
    public final void setRecordTime(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final long component10() {
        return 0L;
    }
    
    public final long getDateCreate() {
        return 0L;
    }
    
    public final void setDateCreate(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTypeNote() {
        return null;
    }
    
    public final void setTypeNote(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.app.friendschat.data.model.TagModel> component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.app.friendschat.data.model.TagModel> getTagNote() {
        return null;
    }
    
    public final void setTagNote(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.app.friendschat.data.model.TagModel> p0) {
    }
    
    public UserRecordModel() {
        super();
    }
    
    public UserRecordModel(int systolic, int diastolic, int pulse) {
        super();
    }
}