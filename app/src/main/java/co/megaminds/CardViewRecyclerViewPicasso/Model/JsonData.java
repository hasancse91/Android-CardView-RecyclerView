
package co.megaminds.CardViewRecyclerViewPicasso.Model;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonData implements Parcelable
{

    @SerializedName("popular")
    @Expose
    private List<Popular> popular = new ArrayList<Popular>();
    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("paginator")
    @Expose
    private Paginator paginator;
    public final static Parcelable.Creator<JsonData> CREATOR = new Creator<JsonData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JsonData createFromParcel(Parcel in) {
            JsonData instance = new JsonData();
            in.readList(instance.popular, (co.megaminds.CardViewRecyclerViewPicasso.Model.Popular.class.getClassLoader()));
            in.readList(instance.data, (co.megaminds.CardViewRecyclerViewPicasso.Model.Datum.class.getClassLoader()));
            instance.status = ((int) in.readValue((int.class.getClassLoader())));
            instance.paginator = ((Paginator) in.readValue((Paginator.class.getClassLoader())));
            return instance;
        }

        public JsonData[] newArray(int size) {
            return (new JsonData[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The popular
     */
    public List<Popular> getPopular() {
        return popular;
    }

    /**
     * 
     * @param popular
     *     The popular
     */
    public void setPopular(List<Popular> popular) {
        this.popular = popular;
    }

    /**
     * 
     * @return
     *     The data
     */
    public List<Datum> getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(List<Datum> data) {
        this.data = data;
    }

    /**
     * 
     * @return
     *     The status
     */
    public int getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The paginator
     */
    public Paginator getPaginator() {
        return paginator;
    }

    /**
     * 
     * @param paginator
     *     The paginator
     */
    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(popular);
        dest.writeList(data);
        dest.writeValue(status);
        dest.writeValue(paginator);
    }

    public int describeContents() {
        return  0;
    }

}
