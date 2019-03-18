/*Name: TreeHash
 * Description: I couldn't find the functions I wanted in Array, Treemap, hash, or others, so I created my own.
 * It is two Arrays joined together, that you can iterate through the keys or the values,
 * Initial Release Date: 11.1.17
 * Current Release Date: 3.18.19
 * Author: Ben Wilk
 * Version: 2.00
 * Notes: Additional defaultReturnCharacter Calls and No Nulls!
 */

import java.util.Arrays;

public class TreeHash{
    private DataSet ds;
    private static final String[] defaultAlphaNumeric = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    //   private static final int defaultSize = 36; // This is set to 37 for A-Z, then 0-9.


    // Key --> Value

    public TreeHash(int dataSize, boolean userCase){ // Constructor
        this.ds = new DataSet(dataSize);
        this.ds.SetCaseSensitivity(userCase);
    }

    public TreeHash(int dataSize){
       this.ds = new DataSet(dataSize + 1);
    }

    public TreeHash(){ // Default constructor
       this.ds = new DataSet(defaultAlphaNumeric.length);
       this.ds.SetKey(defaultAlphaNumeric);
       this.ds.SetValue(defaultAlphaNumeric);
    }


    public void SetKey(Object[] KeySet){ // Sets the key values to your object array.
        this.ds.SetKey(KeySet);
    }

    public void SetValue(Object[] ValueSet){ // Sets the value set to your object array.
        this.ds.SetValue(ValueSet);
    }

    public void SetDefaultKeyAndValue(){ // Sets the keys and values to default values.
        this.ds.SetKey(defaultAlphaNumeric);
        this.ds.SetValue(defaultAlphaNumeric);
    }

    public void SetKeyAndValue(Object[] userKey, Object[] userValue){ // Sets the key and value groups to user defined Keys and values.
        this.ds.SetKey(userKey);
        this.ds.SetValue(userValue);
    }

    // ********** Return Key/Value from passed number ***** //
    public Object GetValueFromInteger(int passedInteger){ // This is a renamed version of "return value"; user puts in an integer, and it returns the value from that location.
        return ReturnValue(passedInteger);
    }

    public Object GetKeyFromInteger(int passedInteger){ // This is a renamed version of "return key"; user puts in an integer, and it returns the key from that location.
        return ReturnKey(passedInteger);
    }

    // ******** Return Key/Value from Value/Key Search ******* //
    public Object GetValueFromKeySearch(Object searchValue){ // User puts in a search value, it searches the keys, once it is true, it returns the corresponding value.
        return this.ds.GetValueFromKeySearch(searchValue);
    }

    public Object GetKeyFromValueSearch(Object searchValue){ // User puts in a search value, it searches the values, once it is true, it returns the corresponding key.
        return this.ds.GetKeyFromValueSearch(searchValue);
    }

    // *********** Return values ***************************//
    public Object ReturnKey(int position){ // Returns the key value, from the position value.
        return this.ds.GetKey(position);
    }

    public Object ReturnValue(int position){ // Returns the corresponding value, based off the position value.
        return this.ds.GetValue(position);
    }

    public String ReturnKeyAndValue(int position){ //Returns both key and value in a formatted fashion.
        return ReturnKey(position) + " -- " + ReturnValue(position);
    }

    public void ReturnKeyAndValueRows(){ // Returns all key and value sets.
        for(int i = 0; i < this.ds.GetKeySize(); i++){
            System.out.println(ReturnKeyAndValue(i));
        }
    }

    // ********* Destroy Keys/Values *********** //
    public void DestroyKeysAndValues(){ // Destroys the treehash object; nullifies both keys and values.
        this.ds.DestroyKeysAndValues();
    }

    public void RemoveAllKeys(){ // Goes through and replaces all key values with your defaultReturnCharacter -- Currently set to " ".
        this.ds.RemoveAllKeys();
    }

    public void RemoveAllValues(){ // Goes through and replaces all values with your defaultReturnCharacter -- Currently set to " ".
        this.ds.RemoveAllValues();
    }
}

class DataSet{
    private String[] key = new String[1];
    private String[] value = new String[1];
    private int size;
    private boolean caseSensitivity = false;
    private static final String defaultReturnCharacter = " ";

    public DataSet(){

    }

    public DataSet(int userSize){
        SetSize(userSize);
        SetNewArraySize();

    }

    public DataSet(boolean userCase){
        SetCaseSensitivity(userCase);

    }

    public DataSet(Object[] passedKeys){
        SetSize(passedKeys.length);
        SetNewArraySize();
        SetKey(passedKeys);
    }

    public DataSet(Object[] passedKeys, Object[] passedValues){
        SetSize(passedKeys.length);
        SetNewArraySize();
        SetKey(passedKeys);
        SetValue(passedValues);
    }


    public void SetNewArraySize(){
        this.key = Arrays.copyOf(this.key, this.size);
        this.value = Arrays.copyOf(this.value, this.size);
    }

    public int GetSize(){
        return this.size;
    }

    public void SetSize(int passedValue){
        this.size = passedValue;
    }

// ******** Set and Get Case Sensitivity ****** //
    public boolean GetCaseSensitivity(){
        return this.caseSensitivity;
    }

    public void SetCaseSensitivity(boolean userCase){
        this.caseSensitivity = userCase;
    }

// ******** Return Key and Value Sizes ******* //
    public int GetKeySize(){
        return this.key.length;
    }

    public int GetValueSize(){
        return this.value.length;
    }

// ******** Set and Get Keys and Values ********* //
    public void SetKey(int position, Object userKey){
        this.key[position] = "" + userKey;
    }

    public void SetKey(Object[] userKey){
        for(int i = 0; i < userKey.length; i++){
            this.key[i] = "" + userKey[i];
        }
    }

    public String GetKey(int position){
        return this.key[position];
    }

    public void SetValue(int position, Object userValue){
        this.value[position] = "" + userValue;
    }

    public void SetValue(Object[] userValue){
        for(int i = 0; i < userValue.length; i++){
            this.value[i] = "" + userValue[i];
        }
    }

    public String GetValue(int position){
        return this.value[position];
    }

// ********** Get Value/Key from Key/Value Search ******** //
    public String GetValueFromKeySearch(Object userKey){
        if(!caseSensitivity){
            String userKeyToString = "" + userKey;
            for(int i = 0; i < GetKeySize(); i++){
                if(userKeyToString.equals(this.key[i])){
                    return this.value[i];
                }
            }
        } else {
            String userKeyToString = "" + userKey;
            for(int i = 0; i < GetKeySize(); i++){
                if(userKeyToString.equalsIgnoreCase(this.key[i])){
                    return this.value[i];
                }
            }
        }
        return defaultReturnCharacter;
    }

    public String GetKeyFromValueSearch(Object userValue){
        String userObjectToString = "" + userValue;
        for(int i = 0; i < this.key.length; i++){
            if(userObjectToString.equals(this.value[i])){
                return this.key[i];
            }
        }
        return defaultReturnCharacter;
    }

    public void SetValuefromKeyMatch(Object userKey, Object userValue){
        String stringUserKey = "" + userKey;
        for(int i = 0; i < GetKeySize(); i++){
            if(this.key[i].contains(stringUserKey) ){
                this.value[i] = "" + userValue;
            }
        }
    }

// ******** Get Key/Value from integer ******* //
    public Object GetKeyFromInteger(int integerValue){
        return GetKey(integerValue);
    }

    public Object GetValueFromInteger(int integerValue){
        return GetValue(integerValue);
    }

// ******** Rotational Tools ********* //
    public void RotateKey(int rotateBy){
        int counter = 0;
        do {
            RotateKey();
            counter++;
        }while(rotateBy != counter);
    }

    public void RotateKey(){
        String firstValue = this.key[0];
        for(int i = 0; i < this.key.length; i++){
            if(i == this.key.length - 1){
                this.key[i] = firstValue;
            } else{
                this.key[i] = this.key[i + 1];
            }
        }
    }

    public void RotateKeyBackwards(){
        String lastValue = this.key[this.key.length -1];
        for(int i = this.key.length - 1; i >= 0; i--){
            if(i == 0){
                this.key[i] = lastValue;
            } else {
                this.key[i] = this.key[i - 1];
            }
        }
    }

    public void RotateValue(int rotateBy){
        int counter = 0;
        do {
            RotateValue();
            counter++;
        }while(rotateBy != counter);
    }

    public void RotateValue(){
        String firstValue = this.value[0];
        for(int i = 0; i < this.value.length; i++){
            if(i == this.value.length - 1){
                this.value[i] = firstValue;
            } else{
                this.value[i] = this.value[i + 1];
            }
        }
    }

// ******* Removal section ********** //
    public void RemoveAllKeys(){
        for(int i = 0; i < this.key.length; i++){
            this.key[i] = " ";
        }
    }

    public void RemoveAllValues(){
        for(int i = 0; i < this.key.length; i++){
            this.value[i] = " ";
        }
    }

    public void DestroyKeysAndValues(){ 
        this.key = null;
        this.value = null;
    }
}