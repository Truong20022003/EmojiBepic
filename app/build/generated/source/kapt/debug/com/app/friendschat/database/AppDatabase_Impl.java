package com.app.friendschat.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserRecordDao _userRecordDao;

  private volatile TagDao _tagDao;

  private volatile PackageDao _packageDao;

  private volatile EmojiDao _emojiDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Table_User_Record` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `SYSTOLIC` INTEGER NOT NULL, `DIASTOLIC` INTEGER NOT NULL, `PULSE` INTEGER NOT NULL, `COLOR_INFO` TEXT NOT NULL, `KEY_TYPE` INTEGER NOT NULL, `RECORD_YEAR` TEXT NOT NULL, `RECORD_DATE` TEXT NOT NULL, `RECORD_TIME` TEXT NOT NULL, `DATE_CREATED` INTEGER NOT NULL, `TYPE_NOTE` TEXT NOT NULL, `TAG_NOTE` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Table_Tag` (`TAG` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PackageModel` (`package_name` TEXT NOT NULL, `sticker_urls` TEXT NOT NULL, `is_draft` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `EmojiModel` (`path` TEXT NOT NULL, `folder_name` TEXT NOT NULL, `position` INTEGER NOT NULL, `is_show_ads` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd33f31ffb265215c837439a46458cc8b')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Table_User_Record`");
        _db.execSQL("DROP TABLE IF EXISTS `Table_Tag`");
        _db.execSQL("DROP TABLE IF EXISTS `PackageModel`");
        _db.execSQL("DROP TABLE IF EXISTS `EmojiModel`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTableUserRecord = new HashMap<String, TableInfo.Column>(12);
        _columnsTableUserRecord.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTableUserRecord.put("SYSTOLIC", new TableInfo.Column("SYSTOLIC", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTableUserRecord.put("DIASTOLIC", new TableInfo.Column("DIASTOLIC", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTableUserRecord.put("PULSE", new TableInfo.Column("PULSE", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTableUserRecord.put("COLOR_INFO", new TableInfo.Column("COLOR_INFO", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTableUserRecord.put("KEY_TYPE", new TableInfo.Column("KEY_TYPE", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTableUserRecord.put("RECORD_YEAR", new TableInfo.Column("RECORD_YEAR", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTableUserRecord.put("RECORD_DATE", new TableInfo.Column("RECORD_DATE", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTableUserRecord.put("RECORD_TIME", new TableInfo.Column("RECORD_TIME", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTableUserRecord.put("DATE_CREATED", new TableInfo.Column("DATE_CREATED", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTableUserRecord.put("TYPE_NOTE", new TableInfo.Column("TYPE_NOTE", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTableUserRecord.put("TAG_NOTE", new TableInfo.Column("TAG_NOTE", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTableUserRecord = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTableUserRecord = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTableUserRecord = new TableInfo("Table_User_Record", _columnsTableUserRecord, _foreignKeysTableUserRecord, _indicesTableUserRecord);
        final TableInfo _existingTableUserRecord = TableInfo.read(_db, "Table_User_Record");
        if (! _infoTableUserRecord.equals(_existingTableUserRecord)) {
          return new RoomOpenHelper.ValidationResult(false, "Table_User_Record(com.app.friendschat.data.model.UserRecordModel).\n"
                  + " Expected:\n" + _infoTableUserRecord + "\n"
                  + " Found:\n" + _existingTableUserRecord);
        }
        final HashMap<String, TableInfo.Column> _columnsTableTag = new HashMap<String, TableInfo.Column>(2);
        _columnsTableTag.put("TAG", new TableInfo.Column("TAG", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTableTag.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTableTag = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTableTag = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTableTag = new TableInfo("Table_Tag", _columnsTableTag, _foreignKeysTableTag, _indicesTableTag);
        final TableInfo _existingTableTag = TableInfo.read(_db, "Table_Tag");
        if (! _infoTableTag.equals(_existingTableTag)) {
          return new RoomOpenHelper.ValidationResult(false, "Table_Tag(com.app.friendschat.data.model.TagModel).\n"
                  + " Expected:\n" + _infoTableTag + "\n"
                  + " Found:\n" + _existingTableTag);
        }
        final HashMap<String, TableInfo.Column> _columnsPackageModel = new HashMap<String, TableInfo.Column>(4);
        _columnsPackageModel.put("package_name", new TableInfo.Column("package_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPackageModel.put("sticker_urls", new TableInfo.Column("sticker_urls", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPackageModel.put("is_draft", new TableInfo.Column("is_draft", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPackageModel.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPackageModel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPackageModel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPackageModel = new TableInfo("PackageModel", _columnsPackageModel, _foreignKeysPackageModel, _indicesPackageModel);
        final TableInfo _existingPackageModel = TableInfo.read(_db, "PackageModel");
        if (! _infoPackageModel.equals(_existingPackageModel)) {
          return new RoomOpenHelper.ValidationResult(false, "PackageModel(com.app.friendschat.data.model.PackageModel).\n"
                  + " Expected:\n" + _infoPackageModel + "\n"
                  + " Found:\n" + _existingPackageModel);
        }
        final HashMap<String, TableInfo.Column> _columnsEmojiModel = new HashMap<String, TableInfo.Column>(5);
        _columnsEmojiModel.put("path", new TableInfo.Column("path", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmojiModel.put("folder_name", new TableInfo.Column("folder_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmojiModel.put("position", new TableInfo.Column("position", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmojiModel.put("is_show_ads", new TableInfo.Column("is_show_ads", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmojiModel.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEmojiModel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEmojiModel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEmojiModel = new TableInfo("EmojiModel", _columnsEmojiModel, _foreignKeysEmojiModel, _indicesEmojiModel);
        final TableInfo _existingEmojiModel = TableInfo.read(_db, "EmojiModel");
        if (! _infoEmojiModel.equals(_existingEmojiModel)) {
          return new RoomOpenHelper.ValidationResult(false, "EmojiModel(com.app.friendschat.data.model.EmojiModel).\n"
                  + " Expected:\n" + _infoEmojiModel + "\n"
                  + " Found:\n" + _existingEmojiModel);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "d33f31ffb265215c837439a46458cc8b", "fba922da5cbf6f43f3d079fb0160c425");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Table_User_Record","Table_Tag","PackageModel","EmojiModel");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Table_User_Record`");
      _db.execSQL("DELETE FROM `Table_Tag`");
      _db.execSQL("DELETE FROM `PackageModel`");
      _db.execSQL("DELETE FROM `EmojiModel`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserRecordDao.class, UserRecordDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TagDao.class, TagDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PackageDao.class, PackageDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(EmojiDao.class, EmojiDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public UserRecordDao userRecordDao() {
    if (_userRecordDao != null) {
      return _userRecordDao;
    } else {
      synchronized(this) {
        if(_userRecordDao == null) {
          _userRecordDao = new UserRecordDao_Impl(this);
        }
        return _userRecordDao;
      }
    }
  }

  @Override
  public TagDao tagDao() {
    if (_tagDao != null) {
      return _tagDao;
    } else {
      synchronized(this) {
        if(_tagDao == null) {
          _tagDao = new TagDao_Impl(this);
        }
        return _tagDao;
      }
    }
  }

  @Override
  public PackageDao packageNameDao() {
    if (_packageDao != null) {
      return _packageDao;
    } else {
      synchronized(this) {
        if(_packageDao == null) {
          _packageDao = new PackageDao_Impl(this);
        }
        return _packageDao;
      }
    }
  }

  @Override
  public EmojiDao emojiDao() {
    if (_emojiDao != null) {
      return _emojiDao;
    } else {
      synchronized(this) {
        if(_emojiDao == null) {
          _emojiDao = new EmojiDao_Impl(this);
        }
        return _emojiDao;
      }
    }
  }
}
