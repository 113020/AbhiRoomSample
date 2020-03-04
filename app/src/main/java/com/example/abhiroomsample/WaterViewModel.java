package com.example.abhiroomsample;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WaterViewModel extends AndroidViewModel {

    private WaterRepository mRepository;

    private LiveData<List<Water>> mAllSplashes;

    public WaterViewModel (Application application) {
        super(application);
        mRepository = new WaterRepository(application);
        mAllSplashes = mRepository.getAllSplashes();
    }

    public void insert(Water water) { mRepository.insert(water); }

    public void update(Water water) { mRepository.update(water); }

    public void delete(Water water) { mRepository.delete(water); }

    public LiveData<List<Water>> getAllSplashes() { return mAllSplashes; }

    LiveData<List<Water>> getByFixture(String fixture) { return mRepository.getByFixture(fixture); }

    LiveData<List<Water>> getByTimeInterval(String interval) { return mRepository.getByFixture(interval); }

    LiveData<List<Water>> getByBillMethod(String method) { return mRepository.getByFixture(method); }

}
