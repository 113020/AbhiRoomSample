package com.example.abhiroomsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can whoosh a  and makes a call to the
 * specified {@link WaterListFragment.OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class WaterListAdapter extends RecyclerView.Adapter<WaterListAdapter.WaterViewHolder> {

    private final LayoutInflater mInflater;
    private List<Water> mSplashes; // Cached copy of splashes

    public class WaterViewHolder extends RecyclerView.ViewHolder{
        private final TextView waterItemView;

        private WaterViewHolder(View itemView) {
            super(itemView);
            waterItemView = itemView.findViewById(R.id.textView);
        }
    }

    public WaterListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public WaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_water_item, parent, false);
        return new WaterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WaterViewHolder holder, int position) {
        if (mSplashes != null) {
            Water current = mSplashes.get(position);
            holder.waterItemView.setText(current.getDate()); // Date of water use
            /*holder.waterItemView.setText(current.getTime()); // Time of water use
            holder.waterItemView.setText(current.getFixture()); // Fixture used
            holder.waterItemView.setText(Double.toString(current.getWaterSpeed())); // Detected water speed from sensor
            holder.waterItemView.setText(Double.toString(current.getWaterExtent())); // How long a fixture is used when turned on
            holder.waterItemView.setText(current.getTimeInterval()); // Time interval: hourly, daily, weekly, monthly, or yearly
            holder.waterItemView.setText(Integer.toString(current.getHourlyFrequency())); // Number of times fixture turns on each hour
            holder.waterItemView.setText(Integer.toString(current.getDailyFrequency())); // Number of times fixture turns on each day
            holder.waterItemView.setText(Integer.toString(current.getWeeklyFrequency())); // Number of times fixture turns on each week
            holder.waterItemView.setText(Integer.toString(current.getMonthlyFrequency())); // Number of times fixture turns on each month
            holder.waterItemView.setText(Integer.toString(current.getYearlyFrequency())); // Number of times fixture turns on each month
            holder.waterItemView.setText(Integer.toString(current.getLeakFrequency())); // Number of times water leaks within the given time interval
            holder.waterItemView.setText(current.getBillMethod()); // Method of calculating bill
            holder.waterItemView.setText(Double.toString(current.getWaterBill())); // Total calculated water bill
//            holder.waterItemView.setText(current.getWaterFact()); // Water fact - based on fixture*/
        } else {
            // Covers the case of data not being ready yet.
            holder.waterItemView.setText("No Splash");
        }
    }

    public void setSplashes(List<Water> splashes){
        mSplashes = splashes;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mSplashes != null)
            return mSplashes.size();
        else return 0;
    }
}
