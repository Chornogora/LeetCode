/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    let dictionary = [
        [], ["a", "b", "c"], ["d", "e", "f"],
        ["g", "h", "i"], ["j", "k", "l"], ["m", "n", "o"],
        ["p", "q", "r", "s"], ["t", "u", "v"], ["w", "x", "y", "z"]
    ];
    
    const appendVariants = (results, i) => {
        if (i === digits.length) {
            return results;
        }
        let index = parseInt(digits[i]) - 1;
        let appendedResults = [];
        if (results.length === 0) {
            dictionary[index].forEach(s => appendedResults.push(s));
        } else {
            results.forEach(res => {
                dictionary[index].forEach(s => appendedResults.push(res + s));
            })
        }
        return appendVariants(appendedResults, ++i);
    }
    
    return appendVariants([], 0);
};

console.log(letterCombinations("23"));
console.log(letterCombinations("2"));
console.log(letterCombinations(""));