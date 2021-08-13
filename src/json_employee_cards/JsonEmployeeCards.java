package json_employee_cards;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class JsonEmployeeCards {

    @SerializedName("Card")
    private List<Card> card;

    @SerializedName("Language")
    private String language;

    @SerializedName("NextToken")
    private long nextToken;

    @SerializedName("UserSID")
    private long userSid;

    public List<Card> getCard() {
        return card;
    }

    public String getLanguage() {
        return language;
    }

    public long getNextToken() {
        return nextToken;
    }

    public long getUserSid() {
        return userSid;
    }
}