package alexa.spartahack.com.helpalexa;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by jeffrey on 2/28/16.
 */

public class FireBaseHelper {
    ArrayList<PatientRequests> mArrayList = new ArrayList<PatientRequests>();
    Firebase firebaseRef;
    public FireBaseHelper(Context c) {
        Log.v("TAG", "start of Firebase Helper");
        Firebase.setAndroidContext(c);
        firebaseRef = new Firebase("https://alexahelp.firebaseio.com/");
        PatientRequests patientRequests = new PatientRequests();
        firebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");
                int i = 0;
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {

                    PatientRequests mPatientRequests = postSnapshot.getValue(PatientRequests.class);
                    mArrayList.add(mPatientRequests);


                }
            }
            @Override public void onCancelled(FirebaseError error) {
                Log.v("TAG","Firebase is c ancelled.");

            }
        });
    }


}
