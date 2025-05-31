var longestCommonPrefix = function(strs) {
    for (let i = 0; i < strs[0].length; ++i) {
        let symbol = strs[0][i];
        if (!(strs.filter(str => str[i] === symbol).length === strs.length)) {
            return (i === 0 ? "" : strs[0].substring(0, i));
        }
    }
    return strs[0];
};

console.log(longestCommonPrefix(["a"]));