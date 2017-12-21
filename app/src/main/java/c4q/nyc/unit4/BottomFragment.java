package c4q.nyc.unit4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import c4q.nyc.unit4.model.Book;

/**
 * Created by c4q on 12/20/17.
 */

public class BottomFragment extends Fragment {

    // json objects:
    private JSONObject initialJson;
    private JSONArray booksJsonArray;
    private JSONObject singleBookDetails;

    // list of book objects:
    private List<Book> bookList;

    // declare static final :
    private static final String TAG = "JSON: ";

    private String jsonBooks = "{\n" +
            "  \"books\": [\n" +
            "    {\n" +
            "      \"title\": \"Northanger Abbey\",\n" +
            "      \"author\": \"Austen, Jane\",\n" +
            "      \"year\": 1814\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"War and Peace\",\n" +
            "      \"author\": \"Tolstoy, Leo\",\n" +
            "      \"year\": 1865\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Anna Karenina\",\n" +
            "      \"author\": \"Tolstoy, Leo\",\n" +
            "      \"year\": 1875\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Mrs. Dalloway\",\n" +
            "      \"author\": \"Woolf, Virginia\",\n" +
            "      \"year\": 1925\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"The Hours\",\n" +
            "      \"author\": \"Cunnningham, Michael\",\n" +
            "      \"year\": 1999\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Huckleberry Finn\",\n" +
            "      \"author\": \"Twain, Mark\",\n" +
            "      \"year\": 1865\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Bleak House\",\n" +
            "      \"author\": \"Dickens, Charles\",\n" +
            "      \"year\": 1870\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Tom Sawyer\",\n" +
            "      \"author\": \"Twain, Mark\",\n" +
            "      \"year\": 1862\n" +
            "    }\n" +
            "  ]\n" +
            "}\n";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createJsonObjects();
        createRecyclerView();
    }

    /**
     * createJsonObjects():
     */
    public void createJsonObjects(){


        try {
            // access the initial json string:
            initialJson = new JSONObject(jsonBooks);

            // get the Json books array:
            booksJsonArray = new JSONArray(initialJson.getJSONArray("books"));

            Log.d(TAG, "booksJsonArray " + booksJsonArray.toString());

            // instantiate the bookList class:
            bookList = new ArrayList<>();

            // now for every key value pair of the bookjson array;
            // create a new Book object and pass the json objects stored in each object
            for( int i = 0 ; i < booksJsonArray.length(); i++){

                // instantiate a book object:
                Book book = new Book();

                // this accesses a specific book object:
                JSONObject bookObject = booksJsonArray.getJSONObject(i);

                // access the variables in the json array:
                // get the title + author + year :
                String bookTitle = bookObject.getString("title");
                String bookAuthor = bookObject.getString("author");
                int bookYear = bookObject.getInt("year");

                // add these components to the Book object ^ ^ ^
                book.setTitle(bookTitle);
                book.setAuthor(bookAuthor);
                book.setYear(bookYear);

                // add the book to the book list !!
                bookList.add(book);
            }

            // Logs all the book objects to the console:
            Log.d(TAG, bookList.toString());


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * createRecyclerView():
     */
    public void createRecyclerView(){

    }



}
