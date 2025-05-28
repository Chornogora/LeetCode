var romanToInt = function (s) {
    let dictionary = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    };

    let result = 0;
    for (let i = 0; i < s.length; ++i) {
        if (i < s.length - 1 && dictionary[s[i + 1]] > dictionary[s[i]]) {
            result += dictionary[s[i + 1]] - dictionary[s[i]];
            ++i;
        } else {
            result += dictionary[s[i]]
        }
    }
    return result;
};

console.log(romanToInt("III"));
console.log(romanToInt("IV"));
console.log(romanToInt("IX"));
console.log(romanToInt("XIV"));
console.log(romanToInt("XXI"));