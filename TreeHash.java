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

    // I could potentially get rid of the "size" variable, but for now it stays.
    private int size;
//    private String[] key = new String[1];
 //   private String[] value = new String[1];
    private DataSet ds;
    private static final int defaultSize = 36; // This is set to 37 for A-Z, then 0-9.


    // Key --> Value

    public TreeHash(int dataSize, boolean caseStatement){ // Constructor
        this.ds = new DataSet(dataSize);
        this.size = dataSize;
    //    setNewArraySize();
        this.caseSensitivity = caseStatement;
    }

    public TreeHash(int dataSize){
        this.size = dataSize;
      //  setNewArraySize();
        this.caseSensitivity = false;
    }

    public TreeHash(){ // Default constructor
        this.ds = new DataSet(this.defaultSize);
    //    setNewArraySize();
        this.caseSensitivity = false;
    }

 /*   public void setNewArraySize(){
        this.key = Arrays.copyOf(this.key, this.size);
        this.value = Arrays.copyOf(this.value, this.size);
    }*/

    public void setKey(){
        for(int i = 0; i < standardAlphaNumeric.length; i++){
            this.key[i] = standardAlphaNumeric[i];
            if(i == this.size){
                break;
            }
        }
    }

    public void setKey(int cipherLength){
        for(int a = 0; a <= cipherLength - 1; a++){
            this.key[a] = standardAlphaNumeric[a];
            if(a == this.size){
                break;
            }
        }
    }

 /*   public void setKey(int position, char userKey){
        this.key[position] = "" + userKey;
    }*/

 /*   public void setKey(int position, String userKey){
        this.key[position] = userKey;
    }*/

    public void setKey(char userKey, String userValue){
        for(int i = 0; i < getKeySize(); i++){
            if(userValue.contains(this.value[i]) ){
                this.key[i] = "" + userKey;
            }
        }
    }

   /* public void setKey(String[] userDefinedKeys){
        for(int i = 0; i < userDefinedKeys.length; i++){
            this.key[i] = userDefinedKeys[i];
        }
    }

    public void setKey(char[] userKeySet){
        for(int i = 0; i < userKeySet.length; i++){
            this.key[i] = "" + userKeySet[i];
        }
    }*/

    /*public void setKey(int startingPosition, char[] userKeySet){
        for(int i = 0; i < userKeySet.length; i++){
            this.key[i + startingPosition] = "" + userKeySet[i];
        }
    }

    public void setKey(int startingPosition, String[] userStringSet){
        for(int i = 0; i < userStringSet.length; i++){
            this.key[i + startingPosition] = userStringSet[i];
        }
    }*/

    public void setValue(){
        for(int i = 0; i < standardAlphaNumeric.length; i++){
            this.value[i] = standardAlphaNumeric[i];
        }
    }

    public void setValue(int valueLength){
        for(int a = 0; a <= valueLength - 1; a++){
            this.key[a] = standardAlphaNumeric[a];
        }
    }

    public void setValue(int position, char userValue){
        this.value[position] = "" + userValue;
    }

    // This generic really breaks stuff.
  /*public static < E > void setValue(E[] userValue){
    for(int i = 0; i < userValue.length; i++){
      this.value[i] = userValue[i];
  }*/

  /*  public void setValue(char[] userValue){
        for(int i = 0; i < userValue.length; i++){
            this.value[i] = "" + userValue[i];
        }
    }

    public void setValue(String[] userValue){
        for(int i = 0; i < userValue.length; i++){
            this.value[i] = userValue[i];
        }
    }*/

    /*public void setValue(int position, String userValue){
        this.value[position] = userValue;
    }*/

    public void setValuefromKeyMatch(char userKey, String userValue){
        String stringUserKey = "" + userKey;
        for(int i = 0; i < getKeySize(); i++){
            if(this.key[i].contains(stringUserKey) ){
                this.value[i] = userValue;
            }
        }
    }

    public void setKeyAndValue(){
        for(int i = 0; i < this.key.length; i++){
            this.key[i] = standardAlphaNumeric[i];
            this.value[i] = standardAlphaNumeric[i];
        }
    }

    public void setKeyAndValue(char[] userKey, String[] userValue){
        for(int i = 0; i < userValue.length; i++){
            this.key[i] = "" + userKey[i];
            this.value[i] = userValue[i];
        }
    }

    public void setKeyAndValue(String[] userKey, String[] userValue){
        for(int i = 0; i < userValue.length; i++){
            this.key[i] = userKey[i];
            this.value[i] = userValue[i];
        }
    }

    public void rotateKey(int rotateBy){
        int counter = 0;
        do {
            rotateKey();
            counter++;
        }while(rotateBy != counter);
    }

    public void rotateKey(){
        String firstValue = this.key[0];
        for(int i = 0; i < this.key.length; i++){
            if(i == this.key.length - 1){
                this.key[i] = firstValue;
            } else{
                this.key[i] = this.key[i + 1];
            }
        }
    }

    public void rotateKeyBackwards(){
        String lastValue = this.key[this.key.length -1];
        for(int i = this.key.length - 1; i >= 0; i--){
            if(i == 0){
                this.key[i] = lastValue;
            } else {
                this.key[i] = this.key[i - 1];
            }
        }
    }

    public void rotateValue(int rotateBy){
        int counter = 0;
        do {
            rotateValue();
            counter++;
        }while(rotateBy != counter);
    }

    public void rotateValue(){
        String firstValue = this.value[0];
        for(int i = 0; i < this.value.length; i++){
            if(i == this.value.length - 1){
                this.value[i] = firstValue;
            } else{
                this.value[i] = this.value[i + 1];
            }
        }
    }

    public String getKeyFromPosition(int position){
        return this.key[position];
    }

    public String getKeyFromValueSearch(String userValue){
        for(int i = 0; i < this.key.length; i++){
            if(userValue.equals(this.value[i])){
                return this.key[i];
            }
        }
        return defaultReturnCharacter;
    }

    public String getKeyFromValueSearch(char userValue){
        String userValueToString = "" + Character.toUpperCase(userValue);
        for(int i = 0; i < this.key.length; i++){
            if(userValueToString.equals(this.value[i])){
                return this.key[i];
            }
        }
        return defaultReturnCharacter;
    }

    public String getKeyAndValueOutput(int position){
        return this.key[position] + " -- " + this.value[position];
    }

    public void getKeyAndValueOutput(){
        for(int i = 0; i < this.key.length; i++){
            System.out.println(this.key[i] + " -- " + this.value[i]);
        }
    }

    public void getKeyAndValueFormattedOutput(){
        int width = 0;
        for(int i = 0; i < getHashSize(); i++){
            width++;
            if(getKeyFromPosition(i) == null || getValueFromPosition(i) == null){
                ; // This is blank so you don't see null lines.
            } else{
                System.out.print("| " + getKeyFromPosition(i) + " -- " + getValueFromPosition(i) + " ");
            }
            if(width == 5){
                System.out.print("| \n");
                width = 0;
            }
        }
    }

 /*   public int getKeySize(){
        return this.key.length;
    }*/

    /*public int getValueSize(){
        return this.value.length;
    }*/

/*    public int getHashSize(){
        return this.key.length;
    }*/

    /*public String getValueFromPosition(int position){
        return this.value[position];
    }*/

 /*   public String getValueFromKeySearch(char userKey){
        if(caseSensitivity == false){
            String userKeyToString = "" + Character.toUpperCase(userKey);
            for(int i = 0; i < getKeySize(); i++){
                if(userKeyToString.equals(this.key[i])){
                    return this.value[i];
                }
            }
        } else {
            String userKeyToString = "" + Character.toString(userKey);
            for(int i = 0; i < getKeySize(); i++){
                if(userKeyToString.equalsIgnoreCase(this.key[i])){
                    return this.value[i];
                }
            }
        }
        return defaultReturnCharacter;
    }

    public String getValueFromKeySearch(String userKey){
        if(caseSensitivity == false){
            for(int i = 0; i < getKeySize(); i++){
                if(userKey.equalsIgnoreCase(this.key[i])){
                    return this.value[i];
                }
            }
        }else{
            for(int i = 0; i < getKeySize(); i++){
                if(userKey.equals(this.key[i])){
                    return this.value[i];
                }
            }
        }
        return defaultReturnCharacter;
    }*/

/*    public void removeAllKeys(){
        for(int i = 0; i < this.key.length; i++){
            this.key[i] = " ";
        }
    }

    public void removeAllValues(){
        for(int i = 0; i < this.key.length; i++){
            this.value[i] = " ";
        }
    }*/

    public void encodeMessage(String PrivateMessage, boolean rotateWithKeys){
        if(rotateWithKeys){
            for(int i = 0; i < PrivateMessage.length(); i++){
                System.out.print(getValueFromKeySearch(PrivateMessage.charAt(i)));
                rotateValue();
            }
        } else{
            System.err.println("\n\nUse encodeMessage() function without the Boolean call.\n\n");
        }
    }

    public void encodeMessage(String PrivateMessage){
        for(int i = 0; i < PrivateMessage.length(); i++){
            System.out.print(getValueFromKeySearch(PrivateMessage.charAt(i)));
        }
    }

    public void decodeMessage(String PrivateMessage, boolean rotateWithKeys){
        if(rotateWithKeys){
            for(int i = 0; i < PrivateMessage.length(); i++){
                System.out.print(getKeyFromValueSearch(PrivateMessage.charAt(i)));
                rotateKeyBackwards();
            }
        } else{
            System.err.println("\n\nUse decodeMessage() function without the Boolean call.\n\n");
        }
    }

    public void decodeMessage(String PrivateMessage){
        for(int i = 0; i < PrivateMessage.length(); i++){
            System.out.print(getKeyFromValueSearch(PrivateMessage.charAt(i)));
        }
    }

    public void destroyKeysAndValues(){ // Pretty Self explanatory;
        this.key = null;
        this.value = null;
    }
}

class DataSet{
    private String[] key = new String[1];
    private String[] value = new String[1];
    private int size;
    private boolean caseSensitivity;
    private static final String defaultReturnCharacter = " ";
    private static final String[] standardAlphaNumeric = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};


    public DataSet(){

    }

    public DataSet(int userSize){
        this.size = userSize;
        SetNewArraySize();

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

    public int GetKeySize(){
        return this.key.length;
    }

    public int getHashSize(){
        return this.key.length;
    }

    public int GetValueSize(){
        return this.value.length;
    }

    public void SetKey(int position, Class<?> userKey){
        this.key[position] = "" + userKey;
    }

    public void SetKey(Class<?>[] userKey){
        for(int i = 0; i < userKey.length; i++){
            this.key[i] = "" + userKey[i];
        }
    }

    public void SetValue(int position, Class<?> userValue){
        this.value[position] = "" + userValue;
    }

    public void SetValue(Class<?>[] userValue){
        for(int i = 0; i < userValue.length; i++){
            this.value[i] = "" + userValue[i];
        }
    }

    public String GetValue(int position){
        return this.value[position];
    }

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

    public String getValueFromKeySearch(char userKey){
        if(!caseSensitivity){
            String userKeyToString = "" + Character.toUpperCase(userKey);
            for(int i = 0; i < GetKeySize(); i++){
                if(userKeyToString.equals(this.key[i])){
                    return this.value[i];
                }
            }
        } else {
            String userKeyToString = "" + Character.toString(userKey);
            for(int i = 0; i < GetKeySize(); i++){
                if(userKeyToString.equalsIgnoreCase(this.key[i])){
                    return this.value[i];
                }
            }
        }
        return defaultReturnCharacter;
    }

    public String getValueFromKeySearch(String userKey){
        if(!caseSensitivity){
            for(int i = 0; i < GetKeySize(); i++){
                if(userKey.equalsIgnoreCase(this.key[i])){
                    return this.value[i];
                }
            }
        }else{
            for(int i = 0; i < GetKeySize(); i++){
                if(userKey.equals(this.key[i])){
                    return this.value[i];
                }
            }
        }
        return defaultReturnCharacter;
    }

    public String GetKeyFromPosition(int position){
        return this.key[position];
    }

}