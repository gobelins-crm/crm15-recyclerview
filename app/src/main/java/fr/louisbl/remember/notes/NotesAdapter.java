package fr.louisbl.remember.notes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.louisbl.remember.R;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
