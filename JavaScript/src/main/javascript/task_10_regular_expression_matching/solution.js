var isMatch = function (s, p) {
    const splitPatternToTokens = (pattern) => {
        let tokens = [];
        for (let i = 0; i < pattern.length; ++i) {
            if (pattern[i] === '.' && i !== pattern.length - 1 && pattern[i + 1] === '*') {
                for (let n = tokens.length - 1; n >= 0; --n) {
                    if (tokens[n].length === 2) {
                        tokens.pop();
                    } else {
                        break;
                    }
                }
                tokens.push(".*");
                ++i;
            } else if (pattern[i] === '.') {
                tokens.push(".");
            } else if (i !== pattern.length - 1 && pattern[i + 1] === '*') {
                if (tokens.length === 0 || (tokens[tokens.length - 1] !== pattern[i] + "*" && tokens[tokens.length - 1] !== ".*")) {
                    tokens.push(pattern[i] + "*");
                }
                ++i;
            } else {
                tokens.push(pattern[i]);
            }
        }
        return tokens;
    }

    const stringMatchesTokens = (s, tokens) => {
        let sIndex = 0;
        for (let i = 0; i < tokens.length; ++i) {
            if (tokens[i] === ".*") {
                const otherTokens = tokens.slice(i + 1);
                if (otherTokens.length === 0) {
                    return true;
                }
                for (let n = sIndex; n < s.length; ++n) {
                    if (stringMatchesTokens(s.substring(n), otherTokens)) {
                        return true;
                    }
                }
                return false;
            } else if (tokens[i].length === 2) {
                const otherTokens = tokens.slice(i + 1);
                if (otherTokens.length === 0) {
                    for (let n = sIndex; n < s.length; ++n) {
                        if (s[n] !== tokens[i][0]) {
                            return false;
                        }
                    }
                    return true;
                }

                for (let n = sIndex; n <= s.length && (n === sIndex || (n > 0 && s[n-1] === tokens[i][0])); ++n) {
                    if (stringMatchesTokens(s.substring(n), otherTokens)) {
                        return true;
                    }
                }
                return false;
            } else if (tokens[i] === '.' && sIndex < s.length) {
                ++sIndex;
            } else if (sIndex < s.length && tokens[i] === s[sIndex]) {
                ++sIndex;
            } else {
                return false;
            }
        }
        return sIndex === s.length;
    }

    const tokens = splitPatternToTokens(p);
    return stringMatchesTokens(s, tokens);
};

console.log(isMatch("aa", "a") === false);
console.log(isMatch("aa", "a*") === true);
console.log(isMatch("ab", ".*") === true);
console.log(isMatch("ab", ".*..") === true);
console.log(isMatch("abb", "ab*") === true);
console.log(isMatch("abba", "ab*b*") === false);
console.log(isMatch("ababa", "aba*") === false);
console.log(isMatch("aaron", "b*aaron") === true);
console.log(isMatch("aaron", "a*ron") === true);
console.log(isMatch("aaroron", "a.*ron") === true);
console.log(isMatch("mississippi", "mis*is*p*.") === false);
console.log(isMatch("aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*") === true);
console.log(isMatch("cbaacacaaccbaabcb", "c*b*b*.*ac*.*bc*a*") === true);
console.log(isMatch("abcbccbcbaabbcbb", "c*a.*ab*.*ab*a*..b*") === true);