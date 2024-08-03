package com.app.friendschat.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.app.friendschat.data.model.PackageModel;
import com.app.friendschat.data.model.StickerModel;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PackageDao_Impl implements PackageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PackageModel> __insertionAdapterOfPackageModel;

  private final DataConverter __dataConverter = new DataConverter();

  private final EntityDeletionOrUpdateAdapter<PackageModel> __deletionAdapterOfPackageModel;

  private final EntityDeletionOrUpdateAdapter<PackageModel> __updateAdapterOfPackageModel;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStickerList;

  public PackageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPackageModel = new EntityInsertionAdapter<PackageModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `PackageModel` (`package_name`,`sticker_urls`,`is_draft`,`id`) VALUES (?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PackageModel value) {
        if (value.getPackageName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPackageName());
        }
        final String _tmp;
        _tmp = __dataConverter.fromListString(value.getStickers());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        final int _tmp_1;
        _tmp_1 = value.isDraft() ? 1 : 0;
        stmt.bindLong(3, _tmp_1);
        stmt.bindLong(4, value.getId());
      }
    };
    this.__deletionAdapterOfPackageModel = new EntityDeletionOrUpdateAdapter<PackageModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `PackageModel` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PackageModel value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPackageModel = new EntityDeletionOrUpdateAdapter<PackageModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `PackageModel` SET `package_name` = ?,`sticker_urls` = ?,`is_draft` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PackageModel value) {
        if (value.getPackageName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPackageName());
        }
        final String _tmp;
        _tmp = __dataConverter.fromListString(value.getStickers());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        final int _tmp_1;
        _tmp_1 = value.isDraft() ? 1 : 0;
        stmt.bindLong(3, _tmp_1);
        stmt.bindLong(4, value.getId());
        stmt.bindLong(5, value.getId());
      }
    };
    this.__preparedStmtOfUpdateStickerList = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE PackageModel SET sticker_urls = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertPackage(final PackageModel packageName,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPackageModel.insert(packageName);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deletePackage(final PackageModel packageModel,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPackageModel.handle(packageModel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updatePackage(final PackageModel packageModel,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPackageModel.handle(packageModel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateStickerList(final int packageId, final List<StickerModel> stickers,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStickerList.acquire();
        int _argIndex = 1;
        final String _tmp;
        _tmp = __dataConverter.fromListString(stickers);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _tmp);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, packageId);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfUpdateStickerList.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object isPackageNameExisted(final String packageName,
      final Continuation<? super Boolean> continuation) {
    final String _sql = "SELECT COUNT(*) FROM PackageModel WHERE package_name = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (packageName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, packageName);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Boolean>() {
      @Override
      public Boolean call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Boolean _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp == null ? null : _tmp != 0;
          } else {
            _result = null;
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
  public Object getAllPackages(final Continuation<? super List<PackageModel>> continuation) {
    final String _sql = "SELECT * FROM PackageModel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PackageModel>>() {
      @Override
      public List<PackageModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPackageName = CursorUtil.getColumnIndexOrThrow(_cursor, "package_name");
          final int _cursorIndexOfStickers = CursorUtil.getColumnIndexOrThrow(_cursor, "sticker_urls");
          final int _cursorIndexOfIsDraft = CursorUtil.getColumnIndexOrThrow(_cursor, "is_draft");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<PackageModel> _result = new ArrayList<PackageModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PackageModel _item;
            final String _tmpPackageName;
            _tmpPackageName = _cursor.getString(_cursorIndexOfPackageName);
            final List<StickerModel> _tmpStickers;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfStickers);
            _tmpStickers = __dataConverter.fromStringList(_tmp);
            final boolean _tmpIsDraft;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsDraft);
            _tmpIsDraft = _tmp_1 != 0;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new PackageModel(_tmpPackageName,_tmpStickers,_tmpIsDraft,_tmpId);
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
  public Object getAllDrafts(final Continuation<? super List<PackageModel>> continuation) {
    final String _sql = "SELECT * FROM PackageModel WHERE is_draft = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<PackageModel>>() {
      @Override
      public List<PackageModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPackageName = CursorUtil.getColumnIndexOrThrow(_cursor, "package_name");
          final int _cursorIndexOfStickers = CursorUtil.getColumnIndexOrThrow(_cursor, "sticker_urls");
          final int _cursorIndexOfIsDraft = CursorUtil.getColumnIndexOrThrow(_cursor, "is_draft");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<PackageModel> _result = new ArrayList<PackageModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PackageModel _item;
            final String _tmpPackageName;
            _tmpPackageName = _cursor.getString(_cursorIndexOfPackageName);
            final List<StickerModel> _tmpStickers;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfStickers);
            _tmpStickers = __dataConverter.fromStringList(_tmp);
            final boolean _tmpIsDraft;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsDraft);
            _tmpIsDraft = _tmp_1 != 0;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new PackageModel(_tmpPackageName,_tmpStickers,_tmpIsDraft,_tmpId);
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
  public Object getPackageById(final int packageId,
      final Continuation<? super PackageModel> continuation) {
    final String _sql = "SELECT * FROM PackageModel WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, packageId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PackageModel>() {
      @Override
      public PackageModel call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPackageName = CursorUtil.getColumnIndexOrThrow(_cursor, "package_name");
          final int _cursorIndexOfStickers = CursorUtil.getColumnIndexOrThrow(_cursor, "sticker_urls");
          final int _cursorIndexOfIsDraft = CursorUtil.getColumnIndexOrThrow(_cursor, "is_draft");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final PackageModel _result;
          if(_cursor.moveToFirst()) {
            final String _tmpPackageName;
            _tmpPackageName = _cursor.getString(_cursorIndexOfPackageName);
            final List<StickerModel> _tmpStickers;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfStickers);
            _tmpStickers = __dataConverter.fromStringList(_tmp);
            final boolean _tmpIsDraft;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsDraft);
            _tmpIsDraft = _tmp_1 != 0;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _result = new PackageModel(_tmpPackageName,_tmpStickers,_tmpIsDraft,_tmpId);
          } else {
            _result = null;
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
  public Object isDraftExisted(final Continuation<? super Boolean> continuation) {
    return PackageDao.DefaultImpls.isDraftExisted(PackageDao_Impl.this, continuation);
  }

  @Override
  public Object getAllPackagesWithoutDraft(
      final Continuation<? super List<PackageModel>> continuation) {
    return PackageDao.DefaultImpls.getAllPackagesWithoutDraft(PackageDao_Impl.this, continuation);
  }

  @Override
  public Object getPackageByName(final String packageName,
      final Continuation<? super PackageModel> continuation) {
    return PackageDao.DefaultImpls.getPackageByName(PackageDao_Impl.this, packageName, continuation);
  }

  @Override
  public Object deletePackageByName(final String packageName,
      final Continuation<? super Unit> continuation) {
    return PackageDao.DefaultImpls.deletePackageByName(PackageDao_Impl.this, packageName, continuation);
  }

  @Override
  public Object getDraftPackage(final Continuation<? super PackageModel> continuation) {
    return PackageDao.DefaultImpls.getDraftPackage(PackageDao_Impl.this, continuation);
  }

  @Override
  public Object saveToDraft(final StickerModel stickerModel,
      final Continuation<? super Unit> continuation) {
    return PackageDao.DefaultImpls.saveToDraft(PackageDao_Impl.this, stickerModel, continuation);
  }

  @Override
  public Object replaceStickerInDraft(final int position, final StickerModel newSticker,
      final Continuation<? super Unit> continuation) {
    return PackageDao.DefaultImpls.replaceStickerInDraft(PackageDao_Impl.this, position, newSticker, continuation);
  }

  @Override
  public Object deleteStickerFromDraft(final int position,
      final Continuation<? super Unit> continuation) {
    return PackageDao.DefaultImpls.deleteStickerFromDraft(PackageDao_Impl.this, position, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
