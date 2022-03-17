package com.example.memorynotescleanarch.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.data.Note
import com.example.memorynotescleanarch.databinding.ItemNoteBinding
import java.text.SimpleDateFormat
import java.util.*

class NotesListAdapter (var notes : ArrayList<Note>, val listener: ListAction) : RecyclerView.Adapter<NotesListAdapter.NoteViewHolder>(){

    fun updateNotes(newNotes : List<Note>){
        notes.clear()
        notes.addAll(newNotes)
        notifyDataSetChanged()
    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder (binding.root) {
        fun bind(note : Note){
            with(binding){
                title.text = note.title
                content.text = note.content

                val sdf = SimpleDateFormat("MMM-dd HH:mm")
                val resultDate = Date(note.updateTime)
                date.text = "Last updated: ${sdf.format(resultDate)}"
                root.setOnClickListener {
                    listener.onItemClicked(note.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount(): Int = notes.size
}