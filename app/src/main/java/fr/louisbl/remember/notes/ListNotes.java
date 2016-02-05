package fr.louisbl.remember.notes;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.louisbl.remember.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListNotes extends Fragment {


    private static final String TAG = "ListNotes Fragment";
    private NotesAdapter mNotesAdapter;

    public ListNotes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_notes, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_notes);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        final List<Note> notes = new ArrayList<>();

        mNotesAdapter = new NotesAdapter(notes);
        mNotesAdapter.setNoteClickListener(new NotesAdapter.NoteClickListener() {
            @Override
            public void onClick(int position, View v) {
                Log.d(TAG, "clicked on: " + notes.get(position));
            }
        });

        recyclerView.setAdapter(new NotesAdapter(notes));

        loadAllNotes();

        return view;
    }

    private void loadAllNotes() {
        class LoadNotes extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... params) {
                List<Note> notes = Note.listAll(Note.class);
                mNotesAdapter.addAll(notes);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                mNotesAdapter.notifyDataSetChanged();
            }
        }

        new LoadNotes().execute();
    }
}
