package alexa.spartahack.com.helpalexa;

import java.util.Date;

/**
 * Created by jeffrey on 2/27/16.
 */
public class PatientRequests {
    private Date mDate;
    private String mName;
    private String Task;

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }
}
