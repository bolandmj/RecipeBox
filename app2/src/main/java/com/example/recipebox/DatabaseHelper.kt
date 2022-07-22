package com.example.recipebox

import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.content.ContentValues
import android.content.Context
import kotlin.String
import java.util.ArrayList

class DatabaseHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_CONTACTS_TABLE =
            "create table $TABLE_CONTACTS($KEY_ID INTEGER PRIMARY KEY,$KEY_NAME TEXT,$KEY_PHONE TEXT)"
        db.execSQL(CREATE_CONTACTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, i: Int, il: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CONTACTS")
        onCreate(db)
    }

    fun addContact(contact: Contact) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME, contact.name)
        values.put(KEY_PHONE, contact.phone_number)
        db.insert(TABLE_CONTACTS, null, values)
        db.close()
    }

    fun getContact(id: Int): Contact {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_CONTACTS,
            arrayOf(
                KEY_ID,
                KEY_NAME,
                KEY_PHONE
            ),
            "$KEY_ID=?",
            arrayOf(id.toString()),
            null,
            null,
            null,
            null
        )
        try {
            cursor?.moveToFirst()
            return Contact(
                cursor!!.getString(0).toInt(),
                cursor.getString(1),
                cursor.getString(2)
            )
        } finally {
            cursor.close()
        }
    }

    val allContacts: List<Contact>
        get() {
            val contactList: MutableList<Contact> = ArrayList()
            val selectQuery = "SELECT *FROM $TABLE_CONTACTS"
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)
            if (cursor.moveToFirst()) {
                do {
                    val contact = Contact()
                    contact.id = cursor.getString(0).toInt()
                    contact.name = cursor.getString(1)
                    contact.phone_number = cursor.getString(2)
                    contactList.add(contact)
                } while (cursor.moveToNext())
            }
            cursor.close()
            return contactList
        }

    fun UpdateContact(contact: Contact): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME, contact.name)
        values.put(KEY_PHONE, contact.phone_number)
        return db.update(TABLE_CONTACTS, values, "$KEY_ID=?", arrayOf(contact.id.toString()))
    }

    fun deleteContact(contact: Contact) {
        val db = this.writableDatabase
        db.delete(TABLE_CONTACTS, "$KEY_ID=?", arrayOf(contact.id.toString()))
        db.close()
    }

    val contactsCount: Int
        get() {
            val countQuery = "Select *FROM $TABLE_CONTACTS"
            val db = this.readableDatabase
            val cursor = db.rawQuery(countQuery, null)
            cursor.close()
            return cursor.count
        }

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "contactsManager"
        private const val TABLE_CONTACTS = "contacts"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_PHONE = "phone"
    }
}