package com.app.friendschat.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.app.friendschat.data.model.EmojiModel;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EmojiDao_Impl implements EmojiDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EmojiModel> __insertionAdapterOfEmojiModel;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUnLockShowAds;

  public EmojiDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEmojiModel = new EntityInsertionAdapter<EmojiModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `EmojiModel` (`path`,`folder_name`,`position`,`is_show_ads`,`id`) VALUES (?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EmojiModel value) {
        if (value.getPath() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPath());
        }
        if (value.getFolderName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFolderName());
        }
        stmt.bindLong(3, value.getPosition());
        final int _tmp;
        _tmp = value.getIShowAds() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        stmt.bindLong(5, value.getId());
      }
    };
    this.__preparedStmtOfUpdateUnLockShowAds = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE EmojiModel set is_show_ads = 0 WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertEmoji(final EmojiModel emojiModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEmojiModel.insert(emojiModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUnLockShowAds(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUnLockShowAds.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateUnLockShowAds.release(_stmt);
    }
  }

  @Override
  public Object getAllEmoji(final Continuation<? super List<EmojiModel>> continuation) {
    final String _sql = "SELECT * FROM EmojiModel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<EmojiModel>>() {
      @Override
      public List<EmojiModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "path");
          final int _cursorIndexOfFolderName = CursorUtil.getColumnIndexOrThrow(_cursor, "folder_name");
          final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "position");
          final int _cursorIndexOfIShowAds = CursorUtil.getColumnIndexOrThrow(_cursor, "is_show_ads");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<EmojiModel> _result = new ArrayList<EmojiModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EmojiModel _item;
            final String _tmpPath;
            _tmpPath = _cursor.getString(_cursorIndexOfPath);
            final String _tmpFolderName;
            _tmpFolderName = _cursor.getString(_cursorIndexOfFolderName);
            final int _tmpPosition;
            _tmpPosition = _cursor.getInt(_cursorIndexOfPosition);
            final boolean _tmpIShowAds;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIShowAds);
            _tmpIShowAds = _tmp != 0;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new EmojiModel(_tmpPath,_tmpFolderName,_tmpPosition,_tmpIShowAds,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object isEmojiExisted(final Continuation<? super Boolean> continuation) {
    return EmojiDao.DefaultImpls.isEmojiExisted(EmojiDao_Impl.this, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
