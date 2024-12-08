/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function (arr, fn) {
    const solution = []
    for (i = 0; i < arr.length; i++) {
        if(fn(arr[i],i)){
            solution.push(arr[i])
        }
    }
    return solution
};