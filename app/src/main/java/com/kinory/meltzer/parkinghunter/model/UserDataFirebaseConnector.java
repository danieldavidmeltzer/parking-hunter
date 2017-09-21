package com.kinory.meltzer.parkinghunter.model;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by meltzer on 21/09/2017.
 */

public class UserDataFirebaseConnector {


    private final static UserDataFirebaseConnector userDataFirebaseConnectorSharedInstance = new UserDataFirebaseConnector();


    //region singleton
    interface UserDataFireBaseConnectorSyncingInterface{
        void userDataUpdated(UserData userData,DatabaseError databaseError);
    }

    private UserDataFirebaseConnector(){}

    public static UserDataFirebaseConnector getSharedInstance(){
        return  userDataFirebaseConnectorSharedInstance;
    }
    //endregion


    //region constants
    public static final String USERS = "Users";
    //endregion


    //region variables
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    private DatabaseReference usersDataRef = database.getReference(USERS);

    private Map<String,ValueEventListener> databaseReferenceMap = new HashMap<String,ValueEventListener>();
    //endregion

    /**
     * sync userData
     * @param key the key of the user
     * @param SyncingConnector the syncing connector mechanism used in order to make the user data
     *                         up to date, passes error if something went wrong
     */
    public  void syncUserData(String key,UserDataFireBaseConnectorSyncingInterface SyncingConnector){
        DatabaseReference syncedUserDataRef = usersDataRef.child(key);
        databaseReferenceMap.put(key,
        syncedUserDataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserData userData = dataSnapshot.getValue(UserData.class);
                SyncingConnector.userDataUpdated(userData,null);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                SyncingConnector.userDataUpdated(null,databaseError);
            }
        }));
    }

    /**
     * write new user to fire base
     * @param userData the user data
     */
    public  void writeNewUserToFirebase(UserData userData){
        DatabaseReference userRef = usersDataRef.push();
        userData.setUniqueId(userRef.getKey());
        userRef.setValue(userData);

    }

    /***
     * update user data
     * @param userData the userData to update
     */
    public void updateUserData(UserData userData)
    {
        DatabaseReference userRef = usersDataRef.child(userData.getUniqueId());
        userRef.setValue(userData);
    }

    /**
     * unsync  the user data with firebase
     * @param userDataUniqueID the unique id of the user data
     */
    public void unSyncUserData(String userDataUniqueID)
    {
        usersDataRef.child(userDataUniqueID).removeEventListener(databaseReferenceMap.get(userDataUniqueID));
    }
}
