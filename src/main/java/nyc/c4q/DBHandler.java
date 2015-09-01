package nyc.c4q;

/**
 * Created by Ramona Harrison
 * on 9/1/15.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class DBHandler extends SQLiteOpenHelper implements BookListener, MemberListener {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "LibraryDatabase.db";

    public static final String BOOK_TABLE_NAME = "book";
    public static final String COLUMN_NAME_ENTRY_ID = "id";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_AUTHOR = "author";
    public static final String COLUMN_NAME_ISBN = "isbn";
    public static final String COLUMN_NAME_ISBN13 = "isbn13";
    public static final String COLUMN_NAME_PUBLISHER = "publisher";
    public static final String COLUMN_NAME_PUBLISHYEAR = "publishyear";
    public static final String COLUMN_NAME_CHECKEDOUT = "checkedout";
    public static final String COLUMN_NAME_CHECKEDOUTBY = "checkedoutby";
    public static final String COLUMN_NAME_CHECKOUTDATEYEAR = "checkoutdateyear";
    public static final String COLUMN_NAME_CHECKOUTDATEMONTH = "checkoutdatemonth";
    public static final String COLUMN_NAME_CHECKOUTDATEDAY = "checkoutdateday";
    public static final String COLUMN_NAME_DUEDATEYEAR = "duedateyear";
    public static final String COLUMN_NAME_DUEDATEMONTH = "duedatemonth";
    public static final String COLUMN_NAME_DUEDATEDAY = "duedateday";

    public static final String MEMBER_TABLE_NAME = "member";
    public static final String COLUMN_NAME_MEMBER_ID = "id";
    public static final String COLUMN_NAME_MEMBER_NAME = "name";
    public static final String COLUMN_NAME_DOB_MONTH = "dobmonth";
    public static final String COLUMN_NAME_DOB_DAY = "dobday";
    public static final String COLUMN_NAME_DOB_YEAR = "dobyear";
    public static final String COLUMN_NAME_CITY = "city";
    public static final String COLUMN_NAME_STATE = "state";


    String CREATE_BOOK_TABLE = "CREATE TABLE "+BOOK_TABLE_NAME+" ("+
            COLUMN_NAME_ENTRY_ID+" INTEGER PRIMARY KEY,"+
            COLUMN_NAME_TITLE+" TEXT,"+
            COLUMN_NAME_AUTHOR+" TEXT,"+
            COLUMN_NAME_ISBN+" TEXT,"+
            COLUMN_NAME_ISBN13+" TEXT,"+
            COLUMN_NAME_PUBLISHER+" TEXT,"+
            COLUMN_NAME_PUBLISHYEAR+" TEXT,"+
            COLUMN_NAME_CHECKEDOUT+" TEXT,"+
            COLUMN_NAME_CHECKEDOUTBY+" TEXT,"+
            COLUMN_NAME_CHECKOUTDATEYEAR+" TEXT,"+
            COLUMN_NAME_CHECKOUTDATEMONTH+" TEXT,"+
            COLUMN_NAME_CHECKOUTDATEDAY+" TEXT,"+
            COLUMN_NAME_DUEDATEYEAR+" TEXT,"+
            COLUMN_NAME_DUEDATEMONTH+" TEXT,"+
            COLUMN_NAME_DUEDATEDAY+" TEXT)";
    String DROP_BOOK_TABLE = "DROP TABLE IF EXISTS "+BOOK_TABLE_NAME;

    String CREATE_MEMBER_TABLE = "CREATE TABLE "+MEMBER_TABLE_NAME+" ("+
            COLUMN_NAME_MEMBER_ID+" INTEGER PRIMARY KEY,"+
            COLUMN_NAME_MEMBER_NAME+" TEXT,"+
            COLUMN_NAME_DOB_MONTH+" TEXT,"+
            COLUMN_NAME_DOB_DAY+" TEXT,"+
            COLUMN_NAME_DOB_YEAR+" TEXT,"+
            COLUMN_NAME_CITY+" TEXT,"+
            COLUMN_NAME_STATE+" TEXT)";
    String DROP_MEMBER_TABLE = "DROP TABLE IF EXISTS "+MEMBER_TABLE_NAME;

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK_TABLE);
        db.execSQL(CREATE_MEMBER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_BOOK_TABLE);
        db.execSQL(DROP_MEMBER_TABLE);
        onCreate(db);
    }

    @Override
    public void addBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME_TITLE, book.getTitle());
            values.put(COLUMN_NAME_AUTHOR, book.getAuthor());
            values.put(COLUMN_NAME_ISBN, book.getIsbn());
            values.put(COLUMN_NAME_ISBN13, book.getIsbn13());
            values.put(COLUMN_NAME_PUBLISHER, book.getPublisher());
            values.put(COLUMN_NAME_PUBLISHYEAR, book.getPublishyear());
            values.put(COLUMN_NAME_CHECKEDOUT, book.getCheckedout());
            values.put(COLUMN_NAME_CHECKEDOUTBY, book.getCheckedoutby());
            values.put(COLUMN_NAME_CHECKOUTDATEYEAR, book.getCheckoutdateyear());
            values.put(COLUMN_NAME_CHECKOUTDATEMONTH, book.getCheckoutdatemonth());
            values.put(COLUMN_NAME_CHECKOUTDATEDAY, book.getCheckoutdateday());
            values.put(COLUMN_NAME_DUEDATEYEAR, book.getDuedateyear());
            values.put(COLUMN_NAME_DUEDATEMONTH, book.getDuedatemonth());
            values.put(COLUMN_NAME_DUEDATEDAY, book.getDuedateday());
            db.insert(BOOK_TABLE_NAME, null, values);
            db.close();
        }catch (Exception e){
            Log.e("problem",e+"");
        }
    }

    @Override
    public void addMember(Member member) {
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME_MEMBER_NAME, member.getName());
            values.put(COLUMN_NAME_DOB_MONTH, member.getDobMonth());
            values.put(COLUMN_NAME_DOB_DAY, member.getDobDay());
            values.put(COLUMN_NAME_DOB_YEAR, member.getDobYear());
            values.put(COLUMN_NAME_CITY, member.getCity());
            values.put(COLUMN_NAME_STATE, member.getState());
            db.insert(MEMBER_TABLE_NAME, null, values);
            db.close();
        }catch (Exception e){
            Log.e("problem",e+"");
        }
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Book> bookList = null;
        try{
            bookList = new ArrayList<Book>();
            String QUERY = "SELECT * FROM "+BOOK_TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            if(!cursor.isLast())
            {
                while (cursor.moveToNext())
                {
                    Book book = new Book();
                    book.setID(cursor.getString(0));
                    book.setTitle(cursor.getString(1));
                    book.setAuthor(cursor.getString(2));
                    book.setIsbn(cursor.getString(3));
                    book.setIsbn13(cursor.getString(4));
                    book.setPublisher(cursor.getString(5));
                    book.setPublishyear(cursor.getString(6));
                    book.setCheckedout(cursor.getString(7));
                    book.setCheckedoutby(cursor.getString(8));
                    book.setCheckoutdateyear(cursor.getString(9));
                    book.setCheckoutdatemonth(cursor.getString(10));
                    book.setCheckoutdateday(cursor.getString(11));
                    book.setDuedateyear(cursor.getString(12));
                    book.setDuedatemonth(cursor.getString(13));
                    book.setDuedateday(cursor.getString(14));
                    bookList.add(book);
                }
            }
            db.close();
        }catch (Exception e){
            Log.e("error",e+"");
        }
        return bookList;
    }

    @Override
    public ArrayList<Member> getAllMembers() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Member> memberList = null;
        try{
            memberList = new ArrayList<Member>();
            String QUERY = "SELECT * FROM "+BOOK_TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            if(!cursor.isLast())
            {
                while (cursor.moveToNext())
                {
                    Member member = new Member();
                    member.setID(cursor.getString(0));
                    member.setName(cursor.getString(1));
                    member.setDobMonth(cursor.getString(2));
                    member.setDobDay(cursor.getString(3));
                    member.setDobYear(cursor.getString(4));
                    member.setCity(cursor.getString(5));
                    member.setState(cursor.getString(6));
                    memberList.add(member);
                }
            }
            db.close();
        }catch (Exception e){
            Log.e("error",e+"");
        }
        return memberList;
    }

    @Override
    public int getBookCount() {
        int num = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        try{
            String QUERY = "SELECT * FROM "+BOOK_TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            num = cursor.getCount();
            db.close();
            return num;
        }catch (Exception e){
            Log.e("error",e+"");
        }
        return 0;
    }

    @Override
    public int getMemberCount() {
        int num = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        try{
            String QUERY = "SELECT * FROM "+MEMBER_TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            num = cursor.getCount();
            db.close();
            return num;
        }catch (Exception e){
            Log.e("error",e+"");
        }
        return 0;
    }
}