package com.stefanus.noteapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.stefanus.noteapp.MainActivity
import com.stefanus.noteapp.R
import com.stefanus.noteapp.databinding.FragmentNewNoteBinding
import com.stefanus.noteapp.model.Note
import com.stefanus.noteapp.toast
import com.stefanus.noteapp.viewmodel.NoteViewModel
import com.google.android.material.snackbar.Snackbar


class NewNoteFragment : Fragment(R.layout.fragment_new_note) {

    private var _binding: FragmentNewNoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var mView: View

    //aktivitas baru
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    //membuat susunan tampilan yang berkaitan denngan fragmen
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNewNoteBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }


    //membuat susunan tampilan yang berkaitan denngan fragmen
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = (activity as MainActivity).noteViewModel
        mView = view
    }

    //kode untuk menampilan bahwa catatan berhasil disimpan
    private fun saveNote(view: View) {
        val noteTitle = binding.etNoteTitle.text.toString().trim()
        val noteBody = binding.etNoteBody.text.toString().trim()

        if (noteTitle.isNotEmpty()) {
            val note = Note(0, noteTitle, noteBody)

            noteViewModel.addNote(note)
            Snackbar.make(
                view, "Note saved successfully",
                Snackbar.LENGTH_SHORT
            ).show()
            view.findNavController().navigate(R.id.action_newNoteFragment_to_homeFragment)

        } else {
            activity?.toast("Please enter note title")
        }
    }


    //membuat susunan tampilan yang berkaitan denngan fragmen menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_new_note, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    //membuat susunan tampilan yang berkaitan denngan fragmen simpan
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_save -> {
                saveNote(mView)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}