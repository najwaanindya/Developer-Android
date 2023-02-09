package id.ac.poliban.mi.wawa.homework_053;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private final LinkedList<String> mWordList;
    private final LayoutInflater mInflater;

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final TextView wordItemView;
        final WordListAdapter mAdapter;

        // in this constructor viewHolder has to inflate layout, set adapter and set onClick listener if applicable
        WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String element = mWordList.get(mPosition);
            mWordList.set(mPosition, "Clicked! " + element);
            mAdapter.notifyDataSetChanged();
        }
    }

    // get inflater from current context and data in this constructor
    // constructor needed to initialize word list from data; also need to inflate layout from XML file
    WordListAdapter(Context context, LinkedList<String> wordList){
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate view wordList_item (made for 1 item in the recycler view)
        View mItemView = mInflater.inflate(R.layout.worldlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    // return the total number of items held in the data set by the adapter
    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
