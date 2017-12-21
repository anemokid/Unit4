package c4q.nyc.unit4;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by c4q on 12/20/17.
 */

/**
 * A placeholder fragment containing a simple view
 */

public class MainFragment extends Fragment implements View.OnClickListener {

    // button:
    private Button mainFragmentButton;

    /**
     * Constructur
     */
    public MainFragment(){


    }

    /**
     * - oncreate()
     * this method is called when the fragment is created by the android system.
     * - use this to initialize necessary components of the fragment that you want to keep
     *   when the fragment is paused/ stoped
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startDisplayFragment();
    }

    /**
     * This method is called when the user interface for the fragment needs
     * to be drawn for the first time. This method returns a view.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        /**
         * the container view group is the one that will host the fragment
         */
        // inflates the main fragment layout
        //return inflater.inflate(R.layout.fragment_main, container, false);

        View view = inflater.inflate(R.layout.fragment_main, container, false );

        mainFragmentButton = (Button)view.findViewById(R.id.main_fragment_button);

        return view;

    }


    /**
     * onclick that sends the user to the display fragment activity:
     */
    public void startDisplayFragment(){

        mainFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // create display fragment + transaction:
                DisplayFragment displayFragment = new DisplayFragment();

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                // replace whatevers in the main fragment view with
                // the display fragment view and add the transaction to the backstack
                fragmentTransaction.replace(R.id.first_fragment, displayFragment);
                fragmentTransaction.addToBackStack(null);

                // commit the transaction :
                fragmentTransaction.commit();
            }
        });
    }

    /**
     * - onPause():
     *   this method is called when the users leaving the fragment
     */
    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View view) {

    }
}
