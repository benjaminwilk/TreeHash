Class TreeHash

To call this library: 
Insert in your folders, and call with import: TreeHash.java

The TreeHash class is a hash class.  It allows the user to iterate through the keys, or values.  

The TreeHash class also allows the easy placement of large amounts of data points.  

The TreeHash class includes methods of changing a specific data point, or removing them all.  

Both Key and Value are defined as strings, so you can either use a single character, or a line of characters.


Constructor Summary
+-----------------------------------------------------------------------------------+
|Constructor and Description                                                        |
+-----------------------------------------------------------------------------------+
|TreeHash()                                                                         |
|Initializes a newly created TreeHash object, defaults to 36 keys and values.  All  |
|data points are empty.                                                             |
|-----------------------------------------------------------------------------------|
|TreeHash(int value)                                                                |
|Constructs a new TreeHash ojbect with the amount of keys and values set to the     |
|value defined.                                                                     |
+-----------------------------------------------------------------------------------+

Method Summary
+-------------------------------+---------------------------------------------------+
|Modifier and Type              |Method and Description                             |
+-------------------------------+---------------------------------------------------+
|void                           |setKey()                                           |
|                               |Sets the keys, starting from 0 with the standard   |
|                               |alphabet and 0-9.                                  |
+-------------------------------+---------------------------------------------------+
|void                           |setKey(int TopValue)                               |
|                               |Sets the keys, starting from 0 with the standard   |
|                               |alphabet, but will only go as far as the TopValue  |
|                               |is defined.                                        |
+-------------------------------+---------------------------------------------------+
|void                           |setKey(int index, char c)                          |
|                               |Sets the key at the defined index with the passed  |
|                               |character.  Note: this character is converted in to|
|                               |a String when placed.                              |
+-------------------------------+---------------------------------------------------+
|void                           |setKey(char c, String StringValue)                 |
|                               |Iterates through every Value, comparing the        |
|                               |String value to the TreeHash Values,               |
|                               |a match, it replaces the key with character c.     |
+-------------------------------+---------------------------------------------------+
|void                           |setKey(String[] setOfData)                         |
|                               |Starts at zero, and iterates through the keys,     |
|                               |placing the setOfData in the keys.                 |
+-------------------------------+---------------------------------------------------+
|void                           |setKey(char[] setOfData)                           |
|                               |Starts at zero, iterates through the keys, placing |
|                               |the setOfData in the keys. Converts to Strings     |
|                               |while doing so.                                    |
+-------------------------------+---------------------------------------------------+
|void                           |setKey(int startPoint, char[] setOfData)           |
|                               |Starts at the user defined startPoint, and iterates|
|                               |up from there. Make sure there are enough keys, and|
|                               |you don't break the TreeHash Key set. Also, this   |
|                               |converts the characters to Strings.                |
+-------------------------------+---------------------------------------------------+
|void                           |setKey(int startPoint, String[] setOfStrings)      |
|                               |Starts at the user defined startPoint, and iterates|
|                               |up from there. Make sure there are enough keys, so |
|                               |you don't break the TreeHash Key set.              |
+-------------------------------+---------------------------------------------------+
|void							|setValue())                                        |
|								|Sets the values, starting at 0, with the standard  |
|								|English alphanumeric characters.                   |
+-------------------------------+---------------------------------------------------+
|void							|setValue(int TopValue)                             |
|								|Sets the keys, starting from 0 with the standard	|
|								|alphabet, but will only go as far as the TopValue  |
|								|is defined.										|
+-------------------------------+---------------------------------------------------+
|void							|setValue(int position, char c)						|
|								|Locates the position in value, and sets it to the	|
|								|defined char.  Char is converted to String when set|
+-------------------------------+---------------------------------------------------+
|void							|setValue(char[] setOfData)							|
|								|Starts from 0, and iterates through the TreeHash	|
|								|setting the values to the setOfData.  Make sure 	|
|								|the TreeHash can contain the amount of data points.|
+-------------------------------+---------------------------------------------------+
|void							|setValue(String[] setOfData)						|
|								|Starts from 0, and iterates through the TreeHash	|
|								|setting the values to the setOfData.  Make sure 	|
|								|the TreeHash can contain the amount of data points.|
+-------------------------------+---------------------------------------------------+
|void							|setValue(int position, String stringValue)			|
|								|Locates the position in the values, and sets it to	|
|								|the defined stringValue.							|
+-------------------------------+---------------------------------------------------+
|void							|setValueFromKeyMatch(char c, String stringValue)	|
|								|Iterates through the TreeHash of Keys, and compares|
|								|c to the keys, once a match has been found, the 	|
|								|corresponding value is replaced with stringValue.  |
+-------------------------------+---------------------------------------------------+
|void                           |setKeyAndValue()                                   |
|                               |Allows you to set both Key and Value to the        |
|                               |standard alphanumeric values.  Once set, you can   |
|                               |rotate the values, or replace them.                |
+-------------------------------+---------------------------------------------------+
|void							|setKeyAndValue(char[] userChar,String[] userString)|
|								|Starts from 0, and sets both the keys and values	|
|								|to the data in the arrays.							|
+-------------------------------+---------------------------------------------------+
|void							|setKeyAndValue(String[] userString,Stng[] usrStng) |
|								|Starts from 0, and sets both the keys and values	|
|								|to the data in the arrays.							|
+-------------------------------+---------------------------------------------------+
|void							|rotateKey(int Index)								|
|								|Allows the user to rotate the keys from the Index. |
|								|Meaning: 1 -> A, 2 -> B becomes 1 -> B, 2 -> C		|
+-------------------------------+---------------------------------------------------+
|void							|rotateKey()										|
|								|Same as the example above, but only rotates one set|
|								|when called, rather than user-defined.				|
+-------------------------------+---------------------------------------------------+
|void							|rotateKeyBackwards()								|
|								|Allows the user to rotate the keys backwards.		|
|								|Example: 1 -> A, 2 -> B, becomes, 1 -> Z, 2 -> A	|
+-------------------------------+---------------------------------------------------+
|void							|rotateValue(int rotateBy)							|
|								|Does the same thing as above, but rotates the value|
|								|as defined by the rotateBy integer.				|
+-------------------------------+---------------------------------------------------+
|String							|getKey(int position)								|
|								|Returns the key in TreeHash, as requested by the	|
|								|passed integer position.							|
+-------------------------------+---------------------------------------------------+
|String							|getKey(String userString)							|
|								|Iterates through the values, attempting to match 	|
|								|the userString to a value, and when tue, will		|
|								|return the associated key.	If no match is found,	|
|								|then the character "N" will be returned.			|
+-------------------------------+---------------------------------------------------+
|void							|getKeyAndValue()									|
|								|Iterates through the entire key and value set, and |
|								|returns the keys and values in a clear and easily	|
|								|read method.										|
+-------------------------------+---------------------------------------------------+
|int							|getKeySize()										|
|								|Returns the length of the Key portion of the 		|
|								|TreeHash.											|
+-------------------------------+---------------------------------------------------+
|int							|getValueSize()										|
|								|Returns the length of the Key portion of the 		|
|								|TreeHash.											|
+-------------------------------+---------------------------------------------------+
|int 							|getHashSize()										|
|								|Returns the size of TreeHash.  Is really just 		|
|								|checking the size of the key length.				|
+-------------------------------+---------------------------------------------------+
|String							|getValue(int position)								|
|								|Returns the value, placed at the specified position|
+-------------------------------+---------------------------------------------------+
|String							|getValue(String userKey)							|
|								|Iterates through the keys, comparing userKey to 	|
|								|the key values, and when a match is found, the 	|
|								|corresponding value will be returned.  If none is  |
|								|found, "Not Found" will be returned.				|
+-------------------------------+---------------------------------------------------+
|void							|removeAllKeys()									|
|								|Iterates through every key, replacing them with	|
|								|blank space.										|
+-------------------------------+---------------------------------------------------+
|void							|removeAllValues()									|
|								|Same thing as removeAllKeys(), iterates through 	|
|								|every value, and replaces it with blank space.		|
+-------------------------------+---------------------------------------------------+
|void							|destroyKeysAndValues()								|
|								|Replaces the key and Value TreeHash with null.		|
+-------------------------------+---------------------------------------------------+

Last Updated: 12.6.17
