package com.example.nikitaverma.recyclerviewexample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.nikitaverma.recyclerviewexample.model.GetData;
import com.example.nikitaverma.recyclerviewexample.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Adapter class to map data for GET Response
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private final List<GetData> mBookList;
    private final Context mContext;

    public BookAdapter(List<GetData> bookList, Context context) {
        this.mBookList = bookList;
        this.mContext = context;
    }

    /**
     * Inflate xml file to java
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list_row, parent, false);

        return new BookViewHolder(itemView);
    }

    /**
     * Bind each data to view
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final BookViewHolder holder, int position) {
        holder.firstName.setText(mBookList.get(position).getFirstName());
        holder.lastName.setText(""+ mBookList.get(position).getLastName());
        holder.age.setText(""+ mBookList.get(position).getAge());

        Picasso.with(mContext).load(mBookList.get(position).getAvatar())
                .placeholder(R.drawable.ic_launcher_foreground)
                .noFade().resize(200, 200)
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onError() {
                      //  holder.imageView.setImageDrawable(ic_launcher_foreground);
                        holder.progressBar.setVisibility(View.GONE);
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onSuccess() {
                        // TODO Auto-generated method stub
                        holder.progressBar.setVisibility(View.GONE);
                    }

                });
    }

    /**
     *
     * @return size of listView
     */
    @Override
    public int getItemCount() {
        return mBookList.size();
    }

    /**
     * holder to each object in view
     */
    public class BookViewHolder extends RecyclerView.ViewHolder {
        private TextView firstName;
        private TextView lastName;
        private TextView age;
        private ImageView imageView;
        private ProgressBar progressBar;

         BookViewHolder(View view) {
            super(view);
            firstName = view.findViewById(R.id.first_name);
            lastName = view.findViewById(R.id.last_name);
            age = view.findViewById(R.id.age);
            imageView = view.findViewById(R.id.image_view);
            progressBar = view.findViewById(R.id.progressbar);
        }
    }
}