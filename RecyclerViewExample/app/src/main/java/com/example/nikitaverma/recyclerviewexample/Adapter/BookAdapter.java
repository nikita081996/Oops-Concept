package com.example.nikitaverma.recyclerviewexample.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.nikitaverma.recyclerviewexample.Model.Data;
import com.example.nikitaverma.recyclerviewexample.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Adapter class to map data for GET Response
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Data> bookList ;
    private Context mContext;

    public BookAdapter(List<Data> bookList, Context context) {
        this.bookList = bookList;
        this.mContext = context;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list_row, parent, false);

        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BookViewHolder holder, int position) {
        holder.firstname.setText(bookList.get(position).getFirstname());
        holder.lastname.setText(""+bookList.get(position).getLastname());
        holder.age.setText(""+bookList.get(position).getAge());

        Picasso.with(mContext).load(bookList.get(position).getAvatar())
                .noFade().resize(200, 200)
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onError() {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onSuccess() {
                        // TODO Auto-generated method stub
                        holder.progressBar.setVisibility(View.GONE);
                    }

                });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView firstname;
        public TextView lastname;
        public TextView age;
        ImageView imageView;
        ProgressBar progressBar;

        public BookViewHolder(View view) {
            super(view);
            firstname = view.findViewById(R.id.firstname);
            lastname = view.findViewById(R.id.lastname);
            age = view.findViewById(R.id.age);
            imageView = view.findViewById(R.id.imageview);
            progressBar = view.findViewById(R.id.progressbar);
        }
    }
}