package fr.louisbl.remember.notes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.louisbl.remember.R;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private List<Note> mNotes;

    public NotesAdapter(List<Note> notes) {
        mNotes = notes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_note, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Note note = mNotes.get(position);
        holder.getNoteTitle().setText(note.title);
        holder.getNoteDescription().setText(note.description);
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mNoteTitle;
        private final TextView mNoteDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            mNoteTitle = (TextView) itemView.findViewById(R.id.note_title);
            mNoteDescription = (TextView) itemView.findViewById(R.id.note_description);
        }

        public TextView getNoteTitle() {
            return mNoteTitle;
        }

        public TextView getNoteDescription() {
            return mNoteDescription;
        }
    }
}
