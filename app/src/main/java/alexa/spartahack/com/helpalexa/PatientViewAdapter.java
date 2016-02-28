package alexa.spartahack.com.helpalexa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jeffrey on 2/27/16.
 */
public class PatientViewAdapter extends RecyclerView.Adapter<PatientViewAdapter.PatientViewHolder> {
    public static class PatientViewHolder extends RecyclerView.ViewHolder {
        protected TextView vName;
        protected TextView vDate;
        protected TextView vTask;

        public PatientViewHolder(View v) {
            super(v);
            vName = (TextView) v.findViewById(R.id.patient_name);
            vTask = (TextView) v.findViewById(R.id.task);
            vDate = (TextView) v.findViewById(R.id.date_and_time);
            Log.v("TAG", "start of ViewHolder");

        }
    }

    PatientViewHolder mPatientViewHolder;
    ArrayList<PatientRequests> mPatientArrayList;

    public PatientViewAdapter(ArrayList<PatientRequests> PatientArrayList) {
        mPatientArrayList = PatientArrayList;
    }


    @Override
    public PatientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        mPatientViewHolder = new PatientViewHolder(v);
        return mPatientViewHolder;


    }

    @Override
    public void onBindViewHolder(PatientViewHolder holder, int position) {
        updateListItem(holder, position);

    }

    @Override
    public int getItemCount() {
        return mPatientArrayList.size();
    }


    public void updateListItem(PatientViewHolder holder, int position) {

        PatientRequests mPatientRequests = mPatientArrayList.get(position);
        holder.vName.setText(mPatientRequests.getName());
        holder.vDate.setText(mPatientRequests.getDate().toString());
        holder.vTask.setText(mPatientRequests.getTask());

    }
}