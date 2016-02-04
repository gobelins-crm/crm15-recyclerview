package fr.louisbl.remember.notes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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


    public ListNotes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_notes, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_notes);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        List<Note> notes = new ArrayList<>();
        notes.add(new Note("1", "Title", "Description"));

        recyclerView.setAdapter(new NotesAdapter(notes));

        return view;
    }

}
