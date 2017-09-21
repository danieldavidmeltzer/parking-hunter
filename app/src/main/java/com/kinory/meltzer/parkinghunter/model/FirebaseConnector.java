package com.kinory.meltzer.parkinghunter.model;

import com.google.android.gms.tasks.OnCompleteListener;

/**
 * Created by meltzer on 21/09/2017.
 *  This interface is used to connect model classes to Firebase service in real time
 */
public interface FirebaseConnector<T extends OnCompleteListener> {
     void savingToFirebase(T listener);
     void syncToFirebase(T listener);
}
