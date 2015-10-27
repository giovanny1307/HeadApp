package headapp.digitalexperiences.com.headapp.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

/**
 * Created by Giovanny on 10/26/2015.
 */
public class TaskProvider  extends ContentProvider {

    public static final String COL_ID = "_id";
    public static final String COL_MSG = "mensajeuser";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "base_de_datos.db";
    public static final String DATABASE_TABLE = "mensajes";

    SQLiteDatabase db;

    @Override
    public boolean onCreate() {
        db = new DatabaseHelper(getContext()).getWritableDatabase();
        return true;
    }

    public static final String AUTHORITY
            = "headapp.digitalexperiences.com.headapp.provider.mensajesprovider";
    public static final Uri CONTENT_URI
            = Uri.parse("content://" + AUTHORITY + "/mensajes");

    private static final String TASKS_MIME_TYPE
            = ContentResolver.CURSOR_DIR_BASE_TYPE
            + "/vnd.headapp.digitalexperiences.com.headapp.mensajes";

    private static final String TASK_MIME_TYPE
            = ContentResolver.CURSOR_ITEM_BASE_TYPE
            + "/vnd.headapp.digitalexperiences.com.headapp.mensajes";

    private static final int LIST_MENSAJES = 0;
    private static final int ITEM_MENSAJES = 1;
    private static final UriMatcher URI_MATCHER = buildUriMatcher();

    private static UriMatcher buildUriMatcher() {

        UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(AUTHORITY, "mensajes", LIST_MENSAJES);
        matcher.addURI(AUTHORITY, "mensajes/#", ITEM_MENSAJES);
        return matcher;

    }

    @Override
    public String getType(Uri uri) {
        switch (URI_MATCHER.match(uri)) {
            case LIST_MENSAJES:
                return TASKS_MIME_TYPE;
            case ITEM_MENSAJES:
                return TASK_MIME_TYPE;
            default:
                throw new IllegalArgumentException("Unknown Uri: " + uri);
        }
    }

    @Override

    public Cursor query(Uri uri, String[] ingnored1, String selection,
                        String [] selectionArgs, String sortOrder ) {
        String[] projection = new String[]{
                COL_ID,
                COL_MSG};

        Cursor c;
        switch (URI_MATCHER.match(uri)) {

            case LIST_MENSAJES:
                c = db.query(DATABASE_TABLE,
                        projection, selection, selectionArgs, null, null, COL_ID+" DESC");

                break;

            case ITEM_MENSAJES:
                c = db.query(DATABASE_TABLE, projection,
                        COL_ID + "=?",
                        new String[]{Long.toString(ContentUris.parseId(uri))}, null, null, null, null);
                if (c.getCount() > 0) {
                    c.moveToLast(); //COMET//
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown Uri: " + uri);
        }

        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;

    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if( values.containsKey(COL_ID))
            throw new UnsupportedOperationException();

        long id = db.insertOrThrow(DATABASE_TABLE, null, values);

        getContext().getContentResolver().notifyChange(uri, null);
        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = db.delete(
                DATABASE_TABLE,
                COL_ID + "=?",
                new String[]{Long.toString(ContentUris.parseId(uri))});
        if (count > 0)
            getContext().getContentResolver().notifyChange(uri, null);
        return  count;


    }


    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;

    }

    public static class DatabaseHelper extends SQLiteOpenHelper {


        static final String  DATABASE_CREATE =
                "create table " + DATABASE_TABLE + " (" +
                        COL_ID + " integer primary key autoincrement, " +
                        COL_MSG + " text not null);";

        public DatabaseHelper (Context contexto){
            super(contexto, DATABASE_NAME, null, DATABASE_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(DATABASE_CREATE);

        }



        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            throw new UnsupportedOperationException();

        }
    }
}
