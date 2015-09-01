package nyc.c4q;

import android.provider.BaseColumns;

/**
 * Created by Ramona Harrison
 * on 9/1/15.
 */
public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "book";
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

    }
}
