package com.app.friendschat.database;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.app.friendschat.data.model.TagModel;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TagDao_Impl implements TagDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TagModel> __insertionAdapterOfTagModel;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTag;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public TagDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTagModel = new EntityInsertionAdapter<TagModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Table_Tag` (`TAG`,`id`) VALUES (?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TagModel value) {
        if (value.getTag() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTag());
        }
        stmt.bindLong(2, value.getId());
      }
    };
    this.__preparedStmtOfDeleteTag = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Table_Tag WHERE tag =?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Table_Tag";
        return _query;
      }
    };
  }

  @Override
  public void insertTag(final TagModel tagModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTagModel.insert(tagModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteTag(final String tag) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTag.acquire();
    int _argIndex = 1;
    if (tag == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, tag);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteTag.release(_stmt);
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<TagModel> getListTag() {
    final String _sql = "SELECT * FROM Table_Tag ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTag = CursorUtil.getColumnIndexOrThrow(_cursor, "TAG");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<TagModel> _result = new ArrayList<TagModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TagModel _item;
        final String _tmpTag;
        _tmpTag = _cursor.getString(_cursorIndexOfTag);
        _item = new TagModel(_tmpTag);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
