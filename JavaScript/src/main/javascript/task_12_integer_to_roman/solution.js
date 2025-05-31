/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function (num) {
    let dictionary = ['I', 'V', 'X', 'L', 'C', 'D', 'M'];

    let result = '';
    for (let i = 1000; i >= 1; i /= 10) {
        let part = (num - (num % i)) / i;
        if (part > 0) {
            const level = Math.log10(i) * 2;
            if (part < 4) {
                for (let j = 0; j < part; ++j) {
                    result += dictionary[level];
                }
            } else if (part === 4) {
                result += dictionary[level] + dictionary[level + 1];
            } else if (part === 5) {
                result += dictionary[level + 1];
            } else if (part < 9) {
                result += dictionary[level + 1];
                for (let j = 5; j < part; ++j) {
                    result += dictionary[level];
                }
            } else {
                result += dictionary[level] + dictionary[level + 2];
            }
            num -= part * i;
        }
    }
    return result;
};

console.log('II' === intToRoman(2));
console.log('XI' === intToRoman(11));
console.log('XIV' === intToRoman(14));
console.log('XLIX' === intToRoman(49));
console.log('CLXXIII' === intToRoman(173));
console.log('MMMXCIX' === intToRoman(3099));