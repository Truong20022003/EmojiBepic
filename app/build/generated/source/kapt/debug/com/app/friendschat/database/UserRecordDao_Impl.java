package com.app.friendschat.database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.app.friendschat.data.model.TagModel;
import com.app.friendschat.data.model.UserRecordModel;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserRecordDao_Impl implements UserRecordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserRecordModel> __insertionAdapterOfUserRecordModel;

  private final DataConverter __dataConverter = new DataConverter();

  private final EntityDeletionOrUpdateAdapter<UserRecordModel> __updateAdapterOfUserRecordModel;

  private final SharedSQLiteStatement __preparedStmtOfDeleteRecord;

  public UserRecordDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserRecordModel = new EntityInsertionAdapter<UserRecordModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Table_User_Record` (`id`,`SYSTOLIC`,`DIASTOLIC`,`PULSE`,`COLOR_INFO`,`KEY_TYPE`,`RECORD_YEAR`,`RECORD_DATE`,`RECORD_TIME`,`DATE_CREATED`,`TYPE_NOTE`,`TAG_NOTE`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserRecordModel value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getSystolic());
        stmt.bindLong(3, value.getDiastolic());
        stmt.bindLong(4, value.getPulse());
        if (value.getColorInfo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getColorInfo());
        }
        stmt.bindLong(6, value.getKeyType());
        if (value.getRecordYear() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRecordYear());
        }
        if (value.getRecordDate() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getRecordDate());
        }
        if (value.getRecordTime() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRecordTime());
        }
        stmt.bindLong(10, value.getDateCreate());
        if (value.getTypeNote() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTypeNote());
        }
        final String _tmp;
        _tmp = __dataConverter.fromArrayList(value.getTagNote());
        if (_tmp == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, _tmp);
        }
      }
    };
    this.__updateAdapterOfUserRecordModel = new EntityDeletionOrUpdateAdapter<UserRecordModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Table_User_Record` SET `id` = ?,`SYSTOLIC` = ?,`DIASTOLIC` = ?,`PULSE` = ?,`COLOR_INFO` = ?,`KEY_TYPE` = ?,`RECORD_YEAR` = ?,`RECORD_DATE` = ?,`RECORD_TIME` = ?,`DATE_CREATED` = ?,`TYPE_NOTE` = ?,`TAG_NOTE` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserRecordModel value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getSystolic());
        stmt.bindLong(3, value.getDiastolic());
        stmt.bindLong(4, value.getPulse());
        if (value.getColorInfo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getColorInfo());
        }
        stmt.bindLong(6, value.getKeyType());
        if (value.getRecordYear() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRecordYear());
        }
        if (value.getRecordDate() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getRecordDate());
        }
        if (value.getRecordTime() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRecordTime());
        }
        stmt.bindLong(10, value.getDateCreate());
        if (value.getTypeNote() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTypeNote());
        }
        final String _tmp;
        _tmp = __dataConverter.fromArrayList(value.getTagNote());
        if (_tmp == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, _tmp);
        }
        stmt.bindLong(13, value.getId());
      }
    };
    this.__preparedStmtOfDeleteRecord = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Table_User_Record WHERE id =?";
        return _query;
      }
    };
  }

  @Override
  public void insertRecord(final UserRecordModel userRecordModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUserRecordModel.insert(userRecordModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateRecord(final UserRecordModel userRecordModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUserRecordModel.handle(userRecordModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteRecord(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteRecord.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteRecord.release(_stmt);
    }
  }

  @Override
  public List<UserRecordModel> getListRecord() {
    final String _sql = "SELECT * FROM Table_User_Record ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSystolic = CursorUtil.getColumnIndexOrThrow(_cursor, "SYSTOLIC");
      final int _cursorIndexOfDiastolic = CursorUtil.getColumnIndexOrThrow(_cursor, "DIASTOLIC");
      final int _cursorIndexOfPulse = CursorUtil.getColumnIndexOrThrow(_cursor, "PULSE");
      final int _cursorIndexOfColorInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "COLOR_INFO");
      final int _cursorIndexOfKeyType = CursorUtil.getColumnIndexOrThrow(_cursor, "KEY_TYPE");
      final int _cursorIndexOfRecordYear = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_YEAR");
      final int _cursorIndexOfRecordDate = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_DATE");
      final int _cursorIndexOfRecordTime = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_TIME");
      final int _cursorIndexOfDateCreate = CursorUtil.getColumnIndexOrThrow(_cursor, "DATE_CREATED");
      final int _cursorIndexOfTypeNote = CursorUtil.getColumnIndexOrThrow(_cursor, "TYPE_NOTE");
      final int _cursorIndexOfTagNote = CursorUtil.getColumnIndexOrThrow(_cursor, "TAG_NOTE");
      final List<UserRecordModel> _result = new ArrayList<UserRecordModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserRecordModel _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpSystolic;
        _tmpSystolic = _cursor.getInt(_cursorIndexOfSystolic);
        final int _tmpDiastolic;
        _tmpDiastolic = _cursor.getInt(_cursorIndexOfDiastolic);
        final int _tmpPulse;
        _tmpPulse = _cursor.getInt(_cursorIndexOfPulse);
        final String _tmpColorInfo;
        _tmpColorInfo = _cursor.getString(_cursorIndexOfColorInfo);
        final int _tmpKeyType;
        _tmpKeyType = _cursor.getInt(_cursorIndexOfKeyType);
        final String _tmpRecordYear;
        _tmpRecordYear = _cursor.getString(_cursorIndexOfRecordYear);
        final String _tmpRecordDate;
        _tmpRecordDate = _cursor.getString(_cursorIndexOfRecordDate);
        final String _tmpRecordTime;
        _tmpRecordTime = _cursor.getString(_cursorIndexOfRecordTime);
        final long _tmpDateCreate;
        _tmpDateCreate = _cursor.getLong(_cursorIndexOfDateCreate);
        final String _tmpTypeNote;
        _tmpTypeNote = _cursor.getString(_cursorIndexOfTypeNote);
        final ArrayList<TagModel> _tmpTagNote;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfTagNote);
        _tmpTagNote = __dataConverter.fromString(_tmp);
        _item = new UserRecordModel(_tmpId,_tmpSystolic,_tmpDiastolic,_tmpPulse,_tmpColorInfo,_tmpKeyType,_tmpRecordYear,_tmpRecordDate,_tmpRecordTime,_tmpDateCreate,_tmpTypeNote,_tmpTagNote);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserRecordModel> getListRecordNot() {
    final String _sql = "SELECT * FROM Table_User_Record ORDER BY DATE_CREATED ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSystolic = CursorUtil.getColumnIndexOrThrow(_cursor, "SYSTOLIC");
      final int _cursorIndexOfDiastolic = CursorUtil.getColumnIndexOrThrow(_cursor, "DIASTOLIC");
      final int _cursorIndexOfPulse = CursorUtil.getColumnIndexOrThrow(_cursor, "PULSE");
      final int _cursorIndexOfColorInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "COLOR_INFO");
      final int _cursorIndexOfKeyType = CursorUtil.getColumnIndexOrThrow(_cursor, "KEY_TYPE");
      final int _cursorIndexOfRecordYear = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_YEAR");
      final int _cursorIndexOfRecordDate = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_DATE");
      final int _cursorIndexOfRecordTime = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_TIME");
      final int _cursorIndexOfDateCreate = CursorUtil.getColumnIndexOrThrow(_cursor, "DATE_CREATED");
      final int _cursorIndexOfTypeNote = CursorUtil.getColumnIndexOrThrow(_cursor, "TYPE_NOTE");
      final int _cursorIndexOfTagNote = CursorUtil.getColumnIndexOrThrow(_cursor, "TAG_NOTE");
      final List<UserRecordModel> _result = new ArrayList<UserRecordModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserRecordModel _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpSystolic;
        _tmpSystolic = _cursor.getInt(_cursorIndexOfSystolic);
        final int _tmpDiastolic;
        _tmpDiastolic = _cursor.getInt(_cursorIndexOfDiastolic);
        final int _tmpPulse;
        _tmpPulse = _cursor.getInt(_cursorIndexOfPulse);
        final String _tmpColorInfo;
        _tmpColorInfo = _cursor.getString(_cursorIndexOfColorInfo);
        final int _tmpKeyType;
        _tmpKeyType = _cursor.getInt(_cursorIndexOfKeyType);
        final String _tmpRecordYear;
        _tmpRecordYear = _cursor.getString(_cursorIndexOfRecordYear);
        final String _tmpRecordDate;
        _tmpRecordDate = _cursor.getString(_cursorIndexOfRecordDate);
        final String _tmpRecordTime;
        _tmpRecordTime = _cursor.getString(_cursorIndexOfRecordTime);
        final long _tmpDateCreate;
        _tmpDateCreate = _cursor.getLong(_cursorIndexOfDateCreate);
        final String _tmpTypeNote;
        _tmpTypeNote = _cursor.getString(_cursorIndexOfTypeNote);
        final ArrayList<TagModel> _tmpTagNote;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfTagNote);
        _tmpTagNote = __dataConverter.fromString(_tmp);
        _item = new UserRecordModel(_tmpId,_tmpSystolic,_tmpDiastolic,_tmpPulse,_tmpColorInfo,_tmpKeyType,_tmpRecordYear,_tmpRecordDate,_tmpRecordTime,_tmpDateCreate,_tmpTypeNote,_tmpTagNote);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int averageSYS() {
    final String _sql = "SELECT AVG(SYSTOLIC) FROM Table_User_Record";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int averageDIA() {
    final String _sql = "SELECT AVG(DIASTOLIC) FROM Table_User_Record";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int averagePUL() {
    final String _sql = "SELECT AVG(PULSE) FROM Table_User_Record";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserRecordModel> getTop3Record() {
    final String _sql = "SELECT * FROM Table_User_Record ORDER BY id DESC LIMIT 3";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSystolic = CursorUtil.getColumnIndexOrThrow(_cursor, "SYSTOLIC");
      final int _cursorIndexOfDiastolic = CursorUtil.getColumnIndexOrThrow(_cursor, "DIASTOLIC");
      final int _cursorIndexOfPulse = CursorUtil.getColumnIndexOrThrow(_cursor, "PULSE");
      final int _cursorIndexOfColorInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "COLOR_INFO");
      final int _cursorIndexOfKeyType = CursorUtil.getColumnIndexOrThrow(_cursor, "KEY_TYPE");
      final int _cursorIndexOfRecordYear = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_YEAR");
      final int _cursorIndexOfRecordDate = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_DATE");
      final int _cursorIndexOfRecordTime = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_TIME");
      final int _cursorIndexOfDateCreate = CursorUtil.getColumnIndexOrThrow(_cursor, "DATE_CREATED");
      final int _cursorIndexOfTypeNote = CursorUtil.getColumnIndexOrThrow(_cursor, "TYPE_NOTE");
      final int _cursorIndexOfTagNote = CursorUtil.getColumnIndexOrThrow(_cursor, "TAG_NOTE");
      final List<UserRecordModel> _result = new ArrayList<UserRecordModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserRecordModel _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpSystolic;
        _tmpSystolic = _cursor.getInt(_cursorIndexOfSystolic);
        final int _tmpDiastolic;
        _tmpDiastolic = _cursor.getInt(_cursorIndexOfDiastolic);
        final int _tmpPulse;
        _tmpPulse = _cursor.getInt(_cursorIndexOfPulse);
        final String _tmpColorInfo;
        _tmpColorInfo = _cursor.getString(_cursorIndexOfColorInfo);
        final int _tmpKeyType;
        _tmpKeyType = _cursor.getInt(_cursorIndexOfKeyType);
        final String _tmpRecordYear;
        _tmpRecordYear = _cursor.getString(_cursorIndexOfRecordYear);
        final String _tmpRecordDate;
        _tmpRecordDate = _cursor.getString(_cursorIndexOfRecordDate);
        final String _tmpRecordTime;
        _tmpRecordTime = _cursor.getString(_cursorIndexOfRecordTime);
        final long _tmpDateCreate;
        _tmpDateCreate = _cursor.getLong(_cursorIndexOfDateCreate);
        final String _tmpTypeNote;
        _tmpTypeNote = _cursor.getString(_cursorIndexOfTypeNote);
        final ArrayList<TagModel> _tmpTagNote;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfTagNote);
        _tmpTagNote = __dataConverter.fromString(_tmp);
        _item = new UserRecordModel(_tmpId,_tmpSystolic,_tmpDiastolic,_tmpPulse,_tmpColorInfo,_tmpKeyType,_tmpRecordYear,_tmpRecordDate,_tmpRecordTime,_tmpDateCreate,_tmpTypeNote,_tmpTagNote);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getCountRecord() {
    final String _sql = "SELECT COUNT(*) FROM Table_User_Record";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> getDateRecord() {
    final String _sql = "SELECT DISTINCT RECORD_DATE FROM Table_User_Record";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        _item = _cursor.getString(0);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> getDateRecordNotDistinct() {
    final String _sql = "SELECT RECORD_DATE FROM Table_User_Record";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        _item = _cursor.getString(0);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> getYearRecord() {
    final String _sql = "SELECT DISTINCT RECORD_YEAR FROM Table_User_Record";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        _item = _cursor.getString(0);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserRecordModel> getRecordForDate(final String recordDate) {
    final String _sql = "SELECT * FROM Table_User_Record WHERE RECORD_DATE =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (recordDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, recordDate);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSystolic = CursorUtil.getColumnIndexOrThrow(_cursor, "SYSTOLIC");
      final int _cursorIndexOfDiastolic = CursorUtil.getColumnIndexOrThrow(_cursor, "DIASTOLIC");
      final int _cursorIndexOfPulse = CursorUtil.getColumnIndexOrThrow(_cursor, "PULSE");
      final int _cursorIndexOfColorInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "COLOR_INFO");
      final int _cursorIndexOfKeyType = CursorUtil.getColumnIndexOrThrow(_cursor, "KEY_TYPE");
      final int _cursorIndexOfRecordYear = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_YEAR");
      final int _cursorIndexOfRecordDate = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_DATE");
      final int _cursorIndexOfRecordTime = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_TIME");
      final int _cursorIndexOfDateCreate = CursorUtil.getColumnIndexOrThrow(_cursor, "DATE_CREATED");
      final int _cursorIndexOfTypeNote = CursorUtil.getColumnIndexOrThrow(_cursor, "TYPE_NOTE");
      final int _cursorIndexOfTagNote = CursorUtil.getColumnIndexOrThrow(_cursor, "TAG_NOTE");
      final List<UserRecordModel> _result = new ArrayList<UserRecordModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserRecordModel _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpSystolic;
        _tmpSystolic = _cursor.getInt(_cursorIndexOfSystolic);
        final int _tmpDiastolic;
        _tmpDiastolic = _cursor.getInt(_cursorIndexOfDiastolic);
        final int _tmpPulse;
        _tmpPulse = _cursor.getInt(_cursorIndexOfPulse);
        final String _tmpColorInfo;
        _tmpColorInfo = _cursor.getString(_cursorIndexOfColorInfo);
        final int _tmpKeyType;
        _tmpKeyType = _cursor.getInt(_cursorIndexOfKeyType);
        final String _tmpRecordYear;
        _tmpRecordYear = _cursor.getString(_cursorIndexOfRecordYear);
        final String _tmpRecordDate;
        _tmpRecordDate = _cursor.getString(_cursorIndexOfRecordDate);
        final String _tmpRecordTime;
        _tmpRecordTime = _cursor.getString(_cursorIndexOfRecordTime);
        final long _tmpDateCreate;
        _tmpDateCreate = _cursor.getLong(_cursorIndexOfDateCreate);
        final String _tmpTypeNote;
        _tmpTypeNote = _cursor.getString(_cursorIndexOfTypeNote);
        final ArrayList<TagModel> _tmpTagNote;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfTagNote);
        _tmpTagNote = __dataConverter.fromString(_tmp);
        _item = new UserRecordModel(_tmpId,_tmpSystolic,_tmpDiastolic,_tmpPulse,_tmpColorInfo,_tmpKeyType,_tmpRecordYear,_tmpRecordDate,_tmpRecordTime,_tmpDateCreate,_tmpTypeNote,_tmpTagNote);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserRecordModel> getRecordForLikeYear(final String year) {
    final String _sql = "SELECT * FROM Table_User_Record WHERE RECORD_DATE LIKE '%' || ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (year == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, year);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSystolic = CursorUtil.getColumnIndexOrThrow(_cursor, "SYSTOLIC");
      final int _cursorIndexOfDiastolic = CursorUtil.getColumnIndexOrThrow(_cursor, "DIASTOLIC");
      final int _cursorIndexOfPulse = CursorUtil.getColumnIndexOrThrow(_cursor, "PULSE");
      final int _cursorIndexOfColorInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "COLOR_INFO");
      final int _cursorIndexOfKeyType = CursorUtil.getColumnIndexOrThrow(_cursor, "KEY_TYPE");
      final int _cursorIndexOfRecordYear = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_YEAR");
      final int _cursorIndexOfRecordDate = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_DATE");
      final int _cursorIndexOfRecordTime = CursorUtil.getColumnIndexOrThrow(_cursor, "RECORD_TIME");
      final int _cursorIndexOfDateCreate = CursorUtil.getColumnIndexOrThrow(_cursor, "DATE_CREATED");
      final int _cursorIndexOfTypeNote = CursorUtil.getColumnIndexOrThrow(_cursor, "TYPE_NOTE");
      final int _cursorIndexOfTagNote = CursorUtil.getColumnIndexOrThrow(_cursor, "TAG_NOTE");
      final List<UserRecordModel> _result = new ArrayList<UserRecordModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UserRecordModel _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpSystolic;
        _tmpSystolic = _cursor.getInt(_cursorIndexOfSystolic);
        final int _tmpDiastolic;
        _tmpDiastolic = _cursor.getInt(_cursorIndexOfDiastolic);
        final int _tmpPulse;
        _tmpPulse = _cursor.getInt(_cursorIndexOfPulse);
        final String _tmpColorInfo;
        _tmpColorInfo = _cursor.getString(_cursorIndexOfColorInfo);
        final int _tmpKeyType;
        _tmpKeyType = _cursor.getInt(_cursorIndexOfKeyType);
        final String _tmpRecordYear;
        _tmpRecordYear = _cursor.getString(_cursorIndexOfRecordYear);
        final String _tmpRecordDate;
        _tmpRecordDate = _cursor.getString(_cursorIndexOfRecordDate);
        final String _tmpRecordTime;
        _tmpRecordTime = _cursor.getString(_cursorIndexOfRecordTime);
        final long _tmpDateCreate;
        _tmpDateCreate = _cursor.getLong(_cursorIndexOfDateCreate);
        final String _tmpTypeNote;
        _tmpTypeNote = _cursor.getString(_cursorIndexOfTypeNote);
        final ArrayList<TagModel> _tmpTagNote;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfTagNote);
        _tmpTagNote = __dataConverter.fromString(_tmp);
        _item = new UserRecordModel(_tmpId,_tmpSystolic,_tmpDiastolic,_tmpPulse,_tmpColorInfo,_tmpKeyType,_tmpRecordYear,_tmpRecordDate,_tmpRecordTime,_tmpDateCreate,_tmpTypeNote,_tmpTagNote);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> getDateRecordForLikeYear(final String year) {
    final String _sql = "SELECT DISTINCT RECORD_DATE FROM Table_User_Record Where RECORD_YEAR =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (year == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, year);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        _item = _cursor.getString(0);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> getDateRecordForLikeYearNotDistinct() {
    final String _sql = "SELECT RECORD_DATE FROM Table_User_Record ORDER BY DATE_CREATED ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        _item = _cursor.getString(0);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
