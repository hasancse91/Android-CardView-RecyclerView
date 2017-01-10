
package co.megaminds.CardViewRecyclerViewPicasso.Model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paginator implements Parcelable
{

    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("per_page")
    @Expose
    private int perPage;
    @SerializedName("limit")
    @Expose
    private int limit;
    public final static Parcelable.Creator<Paginator> CREATOR = new Creator<Paginator>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Paginator createFromParcel(Parcel in) {
            Paginator instance = new Paginator();
            instance.total = ((int) in.readValue((int.class.getClassLoader())));
            instance.perPage = ((int) in.readValue((int.class.getClassLoader())));
            instance.limit = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public Paginator[] newArray(int size) {
            return (new Paginator[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The total
     */
    public int getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The perPage
     */
    public int getPerPage() {
        return perPage;
    }

    /**
     * 
     * @param perPage
     *     The per_page
     */
    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    /**
     * 
     * @return
     *     The limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * 
     * @param limit
     *     The limit
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(total);
        dest.writeValue(perPage);
        dest.writeValue(limit);
    }

    public int describeContents() {
        return  0;
    }

}
