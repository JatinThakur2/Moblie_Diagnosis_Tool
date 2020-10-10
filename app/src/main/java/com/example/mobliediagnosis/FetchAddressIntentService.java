package com.example.mobliediagnosis;

import android.app.IntentService;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class FetchAddressIntentService extends IntentService {
    private ResultReceiver resultReceiver;



    public FetchAddressIntentService() {
        super("FetchAddressIntentService");
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if(intent != null){
            String errorMassage = "";
            resultReceiver = intent.getParcelableExtra(Constants.RECEIVER);
            Location location = intent.getParcelableExtra(Constants.LOCATION_DATA_KEY);
            if(location == null) {
                return;
            }
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = null;
            try {
                addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(),1);
            }catch (Exception exception){
                errorMassage = exception.getMessage();
            }
            if (addresses == null ||addresses.isEmpty()) {
                deliverResultToRecevier(Constants.FAILURE_RESULT, errorMassage);
            }else {
                Address address = addresses.get(0);
                ArrayList<String> addressFragments = new ArrayList<>();
                for (int i = 0; i <= address.getMaxAddressLineIndex(); i++){
                    addressFragments.add(address.getAddressLine(i));
                }
                deliverResultToRecevier(
                        Constants.SUCCESS_RESULT,
                        TextUtils.join(
                                Objects.requireNonNull(System.getProperty("line.separator")),
                                addressFragments
                        )

                );
            }
        }
    }
    private void deliverResultToRecevier(int resultcode, String addressMassage){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.RESULT_DATA_KEY, addressMassage);
        resultReceiver.send(resultcode, bundle);
    }
}
