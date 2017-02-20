
package co.megaminds.CardViewRecyclerViewPicasso.Model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Popular implements Parcelable
{

    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_image")
    @Expose
    private String nameImage;
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("type")
    @Expose
    private String type;
    public final static Parcelable.Creator<Popular> CREATOR = new Creator<Popular>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Popular createFromParcel(Parcel in) {
            Popular instance = new Popular();
            instance.image = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.nameImage = ((String) in.readValue((String.class.getClassLoader())));
            instance.count = ((int) in.readValue((int.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Popular[] newArray(int size) {
            return (new Popular[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The image
     */
    public String getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The nameImage
     */
    public String getNameImage() {
        return nameImage;
    }

    /**
     * 
     * @param nameImage
     *     The name_image
     */
    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    /**
     * 
     * @return
     *     The count
     */
    public int getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(image);
        dest.writeValue(name);
        dest.writeValue(nameImage);
        dest.writeValue(count);
        dest.writeValue(type);
    }

    public int describeContents() {
        return  0;
    }

}
