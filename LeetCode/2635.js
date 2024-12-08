/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const solution = []
    for (i = 0; i < arr.length; i++) {
            solution.push(fn(arr[i],i))
    }
    return solution
};