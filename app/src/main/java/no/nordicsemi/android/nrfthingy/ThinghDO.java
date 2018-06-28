package no.nordicsemi.android.nrfthingy;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@DynamoDBTable(tableName = "thingy-mobilehub-1127598956-Thingh")

public class ThinghDO {
    private String _userId;
    private String _deviceName;
    private String _placeName;
    private String _userAge;
    private String _userGender;
    private String _userName;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return _userId;
    }

    public void setUserId(final String _userId) {
        this._userId = _userId;
    }
    @DynamoDBAttribute(attributeName = "DeviceName")
    public String getDeviceName() {
        return _deviceName;
    }

    public void setDeviceName(final String _deviceName) {
        this._deviceName = _deviceName;
    }
    @DynamoDBAttribute(attributeName = "PlaceName")
    public String getPlaceName() {
        return _placeName;
    }

    public void setPlaceName(final String _placeName) {
        this._placeName = _placeName;
    }
    @DynamoDBAttribute(attributeName = "UserAge")
    public String getUserAge() {
        return _userAge;
    }

    public void setUserAge(final String _userAge) {
        this._userAge = _userAge;
    }
    @DynamoDBAttribute(attributeName = "UserGender")
    public String getUserGender() {
        return _userGender;
    }

    public void setUserGender(final String _userGender) {
        this._userGender = _userGender;
    }
    @DynamoDBAttribute(attributeName = "UserName")
    public String getUserName() {
        return _userName;
    }

    public void setUserName(final String _userName) {
        this._userName = _userName;
    }

}
