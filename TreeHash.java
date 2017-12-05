/*Name: TreeHash
* Description: I couldn't find the functions I wanted in Array, Treemap, hash, or others, so I created my own.  
* It is two Arrays joined together, that you can iterate through the keys or the values, 
* Date: 12.5.17
* Author: Ben Wilk
* Version: 1.0
* Notes: Initial creation, and upload.  Fixed the formatting for easier reading.  
*/
package src.main.java.utility;

import java.util.Arrays;

public class TreeHash{

	// I could potentially get rid of the "size" variable, but for now it stays.  
	private int size;
	private String[] key = new String[1];
	private String[] value = new String[1];
	// Key --> Value

	public TreeHash(int dataSize){
		this.size = dataSize;
		setNewArraySize();
	}
  
	public TreeHash(){
		this.size = 36;
		setNewArraySize();
	}

	public void setNewArraySize(){
		this.key = Arrays.copyOf(this.key, this.size);
		this.value = Arrays.copyOf(this.value, this.size);
	}

	public void setKey(){
		for(int i = 0; i < utility.getLettersAndNumbersLength(); i++){
			this.key[i] = utility.getLettersAndNumbers(i);
		}
	}

	public void setKey(int cipherLength){
		for(int a = 0; a <= cipherLength - 1; a++){
			this.key[a] = utility.getLettersAndNumbers(a);
		}
	}

	public void setKey(int position, char userKey){
		this.key[position] = userKey;
	}

	public void setKey(char userKey, String userValue){
		for(int i = 0; i < getKeySize(); i++){
			if(userValue.contains(this.value[i]) ){
				this.key[i] = userKey;
			}
		}
	}

	public void setKey(String[] userDefinedKeys){
		for(int i = 0; i < userDefinedKeys.length; i++){
			this.key[i] = userDefinedKeys[i];
		}
	}
	
	public void setKey(char[] userKeySet){
		for(int i = 0; i < userKeySet.length; i++){
			this.key[i] = "" + userKeySet[i];
		}
	}
	
	public void setKey(int startingPosition, char[] userKeySet){
		for(int i = 0; i < userKeySet.length; i++){
			this.key[i + startingPosition] = "" + userKeySet[i];
		}
	}

	public void setValue(){
		for(int i = 0; i < utility.getLettersAndNumbersLength(); i++){
			this.value[i] = utility.getLettersAndNumbers(i);
		}
	}
	
	public void setValue(int valueLength){
		for(int a = 0; a <= valueLength - 1; a++){
			this.key[a] = utility.getLettersAndNumbers(a);
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

	public void setValue(char[] userValue){
		for(int i = 0; i < userValue.length; i++){
			this.value[i] = "" + userValue[i];
		}
	}

	public void setValue(String[] userValue){
		for(int i = 0; i < userValue.length; i++){
			this.value[i] = userValue[i];
		}
	}

	public void setValue(int position, String userValue){
		this.value[position] = userValue;
	}

	public void setValuefromKeyMatch(char userKey, String userValue){
		for(int i = 0; i < getKeySize(); i++){
			if(this.key[i] == userKey){
				this.value[i] = userValue;
			}
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
		char firstValue = this.key[0];
		for(int i = 0; i < this.key.length; i++){
			if(i == this.key.length - 1){
				this.key[i] = firstValue;
			} else{
				this.key[i] = this.key[i + 1];
			}
		}
	}

	public void rotateKeyBackwards(){
		char lastValue = this.key[this.key.length -1];
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

	public String getKey(int position){
		return this.key[position];
	}

	public String getKey(String userValue){
		for(int i = 0; i < this.key.length; i++){
			if(userValue.contains(this.value[i])){
				return this.key[i];
			}
		}
    return 'N';
	}

	public void getKeyAndValue(){
		for(int i = 0; i < 26; i++){
			System.out.println(this.key[i] + " -- " + this.value[i]);
		}
	}

	public int getKeySize(){
		return this.key.length;
	}

	public int getValueSize(){
		return this.value.length;
	}

	public int getHashSize(){
		return this.key.length;
	}

	public String getValue(int position){
		return this.value[position];
	}

	public String getValue(char userKey){
		for(int i = 0; i < getKeySize(); i++){
			if(userKey == this.key[i]){
				return this.value[i];
			}
		}
    return "Not Found";
	}

	public void removeAllKeys(){
		for(int i = 0; i < this.key.length; i++){
			this.key[i] = " ";
		}
	}

	public void removeAllValues(){
		for(int i = 0; i < this.key.length; i++){
			this.value[i] = " ";
		}
	}
	
	public void destroyKeysAndValues(){
		//for(int i = 0; i < this.key.length; i++){
			this.key = null;
			this.value = null;
		//}
	}
}
