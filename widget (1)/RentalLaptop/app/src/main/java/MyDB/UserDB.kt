package MyDB

import android.provider.BaseColumns

object userDB {
    class userTable: BaseColumns {
        companion object {
            val TABLE_USER = "tbl_User"
            val COLUMN_ID: String = "User_id"
            val COLUMN_NAME: String = "User_nama"
            val COLUMN_EMAIL: String = "User_email"
            val COLUMN_PHONE: String = "User_phone"
        }
    }
}
