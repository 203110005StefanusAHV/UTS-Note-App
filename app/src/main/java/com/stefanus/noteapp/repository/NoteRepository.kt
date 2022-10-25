package com.stefanus.noteapp.repository

import com.stefanus.noteapp.db.NoteDatabase
import com.stefanus.noteapp.model.Note

class NoteRepository(private val db: NoteDatabase) {

    //kode program yang dapat dimulai, dihentikan dan di jalankan lagi,
    // fungsi ini ada jika dipanggil dari coroutine
    suspend fun insertNote(note: Note) = db.getNoteDao().insertNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)
    fun getAllNotes() = db.getNoteDao().getAllNotes()
    fun searchNote(query: String?) = db.getNoteDao().searchNote(query)

}