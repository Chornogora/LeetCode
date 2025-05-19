var longestPalindrome = function (s) {
    let longestPalindrome = s[0];
    for (let i = 1; i < s.length; ++i) {
        if (i > 1 && s[i] === s[i - 2]) {
            let palindromeSize = 3;
            for (let j = 3; i - j >= 0; ++j) {
                if (s[i - j] === s[i + j - 2]) {
                    palindromeSize += 2;
                } else {
                    break;
                }
            }
            if (palindromeSize > longestPalindrome.length) {
                longestPalindrome = s.substring(i - palindromeSize / 2 - 0.5, i + palindromeSize / 2 - 0.5);
            }
        }
        if (s[i] === s[i - 1]) {
            let palindromeSize = 2;
            for (let j = 2; i - j >= 0; ++j) {
                if (s[i - j] === s[i + j - 1]) {
                    palindromeSize += 2;
                } else {
                    break;
                }
            }
            if (palindromeSize > longestPalindrome.length) {
                longestPalindrome = s.substring(i - palindromeSize / 2, i + palindromeSize / 2);
            }
        }
    }
    return longestPalindrome;
};

//console.log(longestPalindrome("babad"));
//console.log(longestPalindrome("cbbd"));
console.log(longestPalindrome("ccc"));
console.log(longestPalindrome("aaaa"));
console.log(longestPalindrome("corocbaraddarab"));
console.log(longestPalindrome("corocbaraddarab"));
