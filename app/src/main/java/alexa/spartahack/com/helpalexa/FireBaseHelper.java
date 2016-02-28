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
interface AdapterListener {
    public void updateAdapter();
}
public class FireBaseHelper {
    Firebase firebaseRef;
    Map<String, String> mStringMap;
    public FireBaseHelper(Context c) {
        Log.v("TAG", "start of Firebase Helper");
        Firebase.setAndroidContext(c);
        firebaseRef = new Firebase("https://alexahelp.firebaseio.com/");
        firebaseRef.child("alexahelp").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.v("TAG", "On Data Change");
                Map<String, String> mStringMap = (Map<String, String>) snapshot.getValue();

            }
            @Override public void onCancelled(FirebaseError error) {
                Log.v("TAG","Firebase is cancelled.");

            }
        });
    }


}
