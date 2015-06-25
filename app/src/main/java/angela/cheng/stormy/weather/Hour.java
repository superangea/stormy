package angela.cheng.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by angela on 6/21/15.
 */
public class Hour implements Parcelable{
    private long mTime;
    private String mSummary;
    private double mTemperature;
    private String mIcon;
    private String mTimeZone;

    public Hour() {}
    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getHour() {
        SimpleDateFormat formatter = new SimpleDateFormat("h a");
        Date dateHour = new Date(getTime()*1000);
        return formatter.format(dateHour);
    }

    public int getIconId() {
        return Forecast.getIconId(getIcon());
    }


    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public int getTemperature() {
        return (int) Math.round(mTemperature);
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }


    @Override
    public int describeContents() {
        return 0; // not used
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(getTime());
        dest.writeString(getSummary());
        dest.writeDouble(mTemperature);
        dest.writeString(getIcon());
        dest.writeString(getTimeZone());
    }
    private Hour(Parcel in) {
        setTime(in.readLong());
        setSummary(in.readString());
        setTemperature(in.readDouble());
        setIcon(in.readString());
        setTimeZone(in.readString());
    }
    public static final Creator<Hour> CREATOR = new Creator<Hour>() {
        @Override
        public Hour createFromParcel(Parcel source) {
            return new Hour(source);
        }

        @Override
        public Hour[] newArray(int size) {
            return new Hour[size];
        }
    };
}
