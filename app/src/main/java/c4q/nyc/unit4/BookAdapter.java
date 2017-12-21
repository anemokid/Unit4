package c4q.nyc.unit4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import c4q.nyc.unit4.model.Book;

/**
 * Created by c4q on 12/20/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>  {

    // this is the list of books:
    private List<Book> books;


    /**
     * VIEW HOLDER INNER CLASS:
     */
    public class BookViewHolder extends RecyclerView.ViewHolder {

        public TextView title, author, year;

        public BookViewHolder(View itemView) {

            super(itemView);
            title = (TextView)itemView.findViewById(R.id.book_title_text_view);
            author = (TextView)itemView.findViewById(R.id.book_author_text_view);
            year = (TextView)itemView.findViewById(R.id.book_year_text_view);

        }
    }

    /**
     * BookAdapter constructer:
     *
     */
    public BookAdapter(List<Book> booksList){
        this.books = booksList;
    }


    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.book_list_row, parent, false);

        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = books.get(position);

        // using holder access the title + author + year of a book:
        holder.title.setText(book.getTitle());
        holder.author.setText(book.getAuthor());
        holder.year.setText(book.getYear());

    }


    @Override
    public int getItemCount() {
        return books.size();
    }
}
