/**
 * 
 */
'use strict';
var empty = [];
var primes = [2,3,5,7];
var misc = [1.1, true, "a"];
var a1 = new Array();
var a2 = new Array(1,2,3);
var a3 = new Array(10)
document.writeln(a3)

var numbers = [100,200,300];
numbers[0] = 'c';
document.writeln(numbers[0]);

var arrays = [["a", "b", "c"], [11,12,13,14]];
var arrayValue=arrays[0][1];
document.writeln(arrayValue);

console.log([].length)
console.log([1,2,3].length)

var myArray = [];
myArray[0] = "cat";
myArray[1] = "dog";
delete myArray[0];
console.log(myArray);
