# jsltdemo

let url = .url 
 
def sum(array)  
  if($array)  $array[0]+sum($array[ 1 : ]) 
  else 0 
 
{ 
//.<name>  Get value of key "<name>" inside an object 
"1":.embed.name,  
 
//.[<index>] array index 
"array_index":.array[0], 
 
//.[<from> : <to>]  array slicing 
"array_slicing":.array[ 1 : 3 ], 
 
//for loop array 
"array_forloop": [ for(.array) . + 5 ] , 
 
//for loop convert to string 
"array_forloop_string": [ for(.array) string(.) ] , 
 
//for loop embed to  
"embed":{ 
  for(.embed) 
  "freddie_" + .key : .value 
}, 
 
//use function to do array sum  
"array_sum":sum(.array), 
 
// 
"array_size":size(.array), 
 
//if (<expr>) <expr> else <expr> 
"type": if(.type=="111") "view" else .type, 
 
//use the variable which define through let 
"url": $url, 
 
 
//{ <key> : <expr>, * : . } Specify one key, copy rest of input 
* : . 
}



{ 
  "1" : "ruan", 
  "array_index" : 1, 
  "array_slicing" : [ 2, 3 ], 
  "array_forloop" : [ 6, 7, 8, 9 ], 
  "array_forloop_string" : [ "1", "2", "3", "4" ], 
  "embed" : { 
    "freddie_name" : "ruan", 
    "freddie_age" : 13 
  }, 
  "array_sum" : 10, 
  "array_size" : 4, 
  "type" : "view", 
  "url" : "http://www.aftenposten.no/", 
  "schema" : "http://schemas.schibsted.io/thing/pulse-simple.json#1.json", 
  "id" : "w23q7ca1-8729-24923-922b-1c0517ddffjf1", 
  "published" : "2017-05-04T09:13:29+02:00", 
  "environmentId" : "urn:schibsted.com:environment:uuid", 
  "array" : [ 1, 2, 3, 4 ] 
}



{ 
  "schema" : "http://schemas.schibsted.io/thing/pulse-simple.json#1.json", 
  "id" : "w23q7ca1-8729-24923-922b-1c0517ddffjf1", 
  "published" : "2017-05-04T09:13:29+02:00", 
  "type" : "111", 
  "environmentId" : "urn:schibsted.com:environment:uuid", 
  "url" : "http://www.aftenposten.no/", 
  "embed":{ 
     "name":"ruan", 
     "age":13 
   }, 
   "array":[1,2,3,4] 
}
