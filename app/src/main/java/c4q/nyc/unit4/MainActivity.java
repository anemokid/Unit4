package c4q.nyc.unit4;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // fragments:
    // Fragment initialFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * in order to have a fragments view displayed inside an activity, you must
         * add the fragmnet to an activity:
         */
        if(savedInstanceState == null){
            getFragmentManager()
                    .beginTransaction()
                    /**
                     * you can now add, replace, or remove fragments to the activity
                     */
                    .add(R.id.first_fragment, new MainFragment())
                    /**
                     * when youre done adding, replacing or removing fragments
                     * you must commit the FragmentTransaction
                     */
                    .commit();
        }
    } // ends on create


} // ends main activity
