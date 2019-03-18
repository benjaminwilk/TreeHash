Class TreeHash

To call this library: 
Insert in your folders, and call with import: TreeHash.java

The TreeHash class is a hash class.  It allows the user to iterate through the keys, or values.  

The TreeHash class also allows the easy placement of large amounts of data points.  

The TreeHash class includes methods of changing a specific data point, or removing them all.  

Both Key and Value are defined as strings, so you can either use a single character, or a line of characters.

Constructor Summary
+-----------------------------------------------------+
|Constructor and Description                          |
+-----------------------------------------------------+
|TreeHash(int dataSize, boolean userCase)             |
|                                                     |
|                                                     |
+-----------------------------------------------------+
|TreeHash(int dataSize)                               |
|                                                     |
|                                                     |
+-----------------------------------------------------+
|TreeHash(){ // Default constructor                   |
|                                                     |
|                                                     |
+-----------------------------------------------------+
 
 
 Method Summary
+--------------------+--------------------------------------------------------------------+
|Modifier and Type   |Method and Description                                              |
+--------------------+--------------------------------------------------------------------+
|void                |SetKey(Object[] KeySet)                                             |
|                    |Sets the key values to your object array.                           |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|void                |SetValue(Object[] ValueSet)                                         |
|                    |Sets the value set to your object array.                            |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|void                |SetDefaultKeyAndValue()                                             |
|                    |Sets the keys and values to default values.                         |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|void                |SetKeyAndValue(Object[] userKey, Object[] userValue)                |
|                    |Sets the key and value groups to user defined Keys and values.      |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|Object              |GetValueFromInteger(int passedInteger)                              |
|                    |This is a renamed version of "return value"; user puts in an        |
|                    | integer, and it returns the value from that location.              |
+--------------------+--------------------------------------------------------------------+
|Object              |GetKeyFromInteger(int passedInteger)                                |
|                    | This is a renamed version of "return key"; user puts in an         |
|                    | integer, and it returns the key from that location.                |
+--------------------+--------------------------------------------------------------------+
|Object              |GetValueFromKeySearch(Object searchValue)                           |
|                    |User puts in a search value, it searches the keys, once it          |
|                    |is true, it returns the corresponding value.                        |
+--------------------+--------------------------------------------------------------------+
|Object              |GetKeyFromValueSearch(Object searchValue)                           |
|                    |User puts in a search value, it searches the values, once it        |
|                    |is true, it returns the corresponding key.                          |
+--------------------+--------------------------------------------------------------------+
|void                |ReplaceValuefromKeyMatch(Object searchKey, Object replacementValue) |
|                    |Replace the value, by matching with the key.                        |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|void                |ReplaceKeyfromValueMatch(Object replacementKey, Object searchValue) |
|                    |Replace the key, by matching with the value.                        |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|void                |RotateKey(int rotationValue)                                        |
|                    | Rotate the key values by your chosen integer count.                |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|void                |RotateKey()                                                         |
|                    |Rotate the key values by one.  Orig: A -> 1 New: A -> 2             |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|void                |RotateKeyBackwards()                                                |
|                    |Rotate the key backwards.                                           |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|void                |RotateValue(int rotationValue)                                      |
|                    |Rotate the Values by passed integer.                                |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|void                |RotateValue()                                                       |
|                    |Rotate the values by one.                                           |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|Object              |ReturnKey(int position)                                             |
|                    |Returns the key value, from the position value.                     |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|Object              |ReturnValue(int position)                                           |
|                    |Returns the corresponding value, based off the position value.      |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|String              |ReturnKeyAndValue(int position)                                     |
|                    |Returns both key and value in a formatted fashion.                  |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|void                |ReturnKeyAndValueRows()                                             |
|                    |Returns all key and value sets.                                     |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|void                |DestroyKeysAndValues()                                              |
|                    |Destroys the treehash object; nullifies both keys and values.       |
|                    |                                                                    |
+--------------------+--------------------------------------------------------------------+
|void                |RemoveAllKeys()                                                     |
|                    |Goes through and replaces all key values with your                  |
|                    |defaultReturnCharacter -- Currently set to " ".                     |
+--------------------+--------------------------------------------------------------------+
|void                |RemoveAllValues()                                                   |
|                    |Goes through and replaces all values with your|                     |
|                    |defaultReturnCharacter -- Currently set to " ".                     |
+--------------------+--------------------------------------------------------------------+

Last Updated: 3.18.19
