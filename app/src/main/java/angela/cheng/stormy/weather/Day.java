package angela.cheng.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by angela on 6/21/15.
 */
public class Day implements Parcelable {
    private long mTime;
    private String mSummary;
    private double mTemperatureMax;
    private String mIcon;
    private String mTimeZone;

    public Day() {

    }
    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public int getTemperatureMax() {

        return (int) Math.round(mTemperatureMax);
    }

    public void setTemperatureMax(double temperatureMax) {
        mTemperatureMax = temperatureMax;
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
    public int getIconId() {
        return Forecast.getIconId(getIcon());
    }
    public String getDayOfTheWeek() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        formatter.setTimeZone(TimeZone.getTimeZone(getTimeZone()));
        Date dateTime = new Date(getTime()*1000);
        return formatter.format(dateTime);
    }

    @Override
    public int describeContents() {
        return 0; // not used
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(getTime());
        dest.writeString(getIcon());
        dest.writeDouble(getTemperatureMax());
        dest.writeString(getSummary());
        dest.writeString(getTimeZone());

    }
    private Day(Parcel in) {
        setTime(in.readLong());
        setIcon(in.readString());
        setTemperatureMax(in.readDouble());
        setSummary(in.readString());
        setTimeZone(in.readString());
    }
    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel source) {
            return new Day(source);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };
}
